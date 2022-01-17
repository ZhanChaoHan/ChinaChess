package com.jachs.chess.service.thread.session;

import java.io.IOException;
import java.io.ObjectOutputStream;

import com.jachs.chess.service.entity.Message;

/***
 * 
 * @author zhanchaohan
 *
 */
public class SocketWriterThread implements Runnable{
	private ObjectOutputStream oos;
	private Message mess;
	

	public SocketWriterThread(ObjectOutputStream oos, Message mess) {
		super();
		this.oos = oos;
		this.mess = mess;
	}

	@Override
	public void run() {
		try {
			oos.writeObject(mess);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
