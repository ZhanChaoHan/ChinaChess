package com.jachs.chess.service.thread.session;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.jachs.chess.service.THREADTYPE;
import com.jachs.chess.service.entity.Message;

/***
 * 
 * @author zhanchaohan
 *
 */
public class ServerReaderThread implements Runnable{
	private ObjectInputStream ois;
	
	private List<ObjectOutputStream>oosList;

	public ServerReaderThread(ObjectInputStream ois, List<ObjectOutputStream> oosList) {
		super();
		this.ois = ois;
		this.oosList = oosList;
	}


	@Override
	public void run() {
		Message mess=null;
		try {
			while((mess=(Message) ois.readObject())!=null) {
				for (ObjectOutputStream objectOutputStream : oosList) {
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
