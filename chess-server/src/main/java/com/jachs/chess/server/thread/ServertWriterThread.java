package com.jachs.chess.server.thread;

import java.io.ObjectOutputStream;

import com.jachs.chess.service.entity.Message;

/***
 * 
 * @author zhanchaohan
 *
 */
public class ServertWriterThread implements Runnable{
	private ObjectOutputStream oos;
	

	public ServertWriterThread(ObjectOutputStream oos) {
		super();
		this.oos = oos;
	}


	@Override
	public void run() {
		Message mess;
		
	}

}
