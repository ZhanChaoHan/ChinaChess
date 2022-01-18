package com.jachs.chess.client.thread.session;

import java.io.ObjectOutputStream;


/***
 * 
 * @author zhanchaohan
 *
 */
public class SocketWriterThread implements Runnable{
	private ObjectOutputStream oos;
	

	public SocketWriterThread(ObjectOutputStream oos) {
		super();
		this.oos = oos;
	}

	@Override
	public void run() {
			while(true) {
			}
	}

}
