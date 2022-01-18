package com.jachs.chess.server.thread;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.jachs.chess.server.PoolConstant;
import com.jachs.chess.service.entity.Message;

/***
 * 
 * @author zhanchaohan
 *
 */
public class ServerReaderThread implements Runnable{
	private ObjectInputStream ois;

	public ServerReaderThread(ObjectInputStream ois) {
		super();
		this.ois = ois;
	}

	@Override
	public void run() {
		Message mess=null;
		try {
			while((mess=(Message) ois.readObject())!=null) {
				for (ObjectOutputStream objectOutputStream : PoolConstant.oosList) {
					objectOutputStream.writeObject(mess);
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
