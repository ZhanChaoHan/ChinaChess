package com.jachs.chess.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.UnknownHostException;

import javax.swing.JTextArea;

import com.jachs.chess.client.thread.session.SocketReaderThread;
import com.jachs.chess.service.SocketBase;
import com.jachs.chess.service.entity.Server;

/***
 * 
 * @author zhanchaohan
 *
 */
public class ISocket extends SocketBase{
	private JTextArea ja;//聊天内容展示文本框
	
	public ISocket(JTextArea ja) {
		super();
		this.ja = ja;
	}

	@Override
	public void prepare(Server server) {
		try {
			super.Socket=new java.net.Socket(server.getIp(), server.getPort());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void open() {
		//启动读写线程
		try {
			AppConstant.sessionOos=new ObjectOutputStream(Socket.getOutputStream());
			new Thread(new SocketReaderThread(new ObjectInputStream(Socket.getInputStream()),ja)).start();;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void close() {
		try {
			super.Socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
