package com.jachs.chess.service.thread.session;

import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JTextArea;

import com.jachs.chess.service.entity.Message;

/***
 * 
 * @author zhanchaohan
 *
 */
public class SocketReaderThread implements Runnable{
	private ObjectInputStream ois;
	private JTextArea ja;//聊天内容展示文本框
	
	public SocketReaderThread(ObjectInputStream ois, JTextArea ja) {
		super();
		this.ois = ois;
		this.ja = ja;
	}



	@Override
	public void run() {
		Message mess;
		try {
			while((mess=(Message) ois.readObject())!=null) {
				ja.append(mess.getMessage());
				ja.append("\n");//换行
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
