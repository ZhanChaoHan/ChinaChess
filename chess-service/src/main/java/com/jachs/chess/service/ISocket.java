package com.jachs.chess.service;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.UnknownHostException;

import javax.swing.JTextArea;

import com.jachs.chess.service.entity.Server;
import com.jachs.chess.service.thread.session.SocketReaderThread;
import com.jachs.chess.service.thread.session.SocketWriterThread;

/***
 * 
 * @author zhanchaohan
 *
 */
public class ISocket extends SocketBase{
	private THREADTYPE type;
	private JTextArea ja;//聊天内容展示文本框
	
	public ISocket(THREADTYPE type, JTextArea ja) {
		super();
		this.type = type;
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
			new Thread(new SocketReaderThread(new ObjectInputStream(Socket.getInputStream()),ja)).start();;
			new Thread(new SocketWriterThread(new ObjectOutputStream(Socket.getOutputStream()),null)).start();;
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
