package com.jachs.chess.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

import com.jachs.chess.server.thread.ServerReaderThread;
import com.jachs.chess.server.thread.ServertWriterThread;
import com.jachs.chess.service.ServerSocketBase;
import com.jachs.chess.service.THREADTYPE;
import com.jachs.chess.service.entity.Server;

/***
 * 
 * @author zhanchaohan
 *
 */
public class IServerSocket extends ServerSocketBase{
	private THREADTYPE type;
	
	public IServerSocket(THREADTYPE type) {
		super();
		this.type=type;
	}

	@Override
	public void prepare(Server server) {
		try {
			super.serverSocket=new ServerSocket(server.getPort());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void open() {
		Socket socket=null;
		try {
			while((socket=super.serverSocket.accept())!=null) {
				System.out.println("连接建立");
				synchronized (this) {
					Set<Socket> sSet=PoolConstant.clientMap.get(type);
					if(sSet==null) {
						sSet=new HashSet<Socket>();
						sSet.add(socket);
					}else {
						sSet.add(socket);
					}
					PoolConstant.clientMap.put(type, sSet);
					
					ObjectInputStream ois=new ObjectInputStream(socket.getInputStream());
					ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
					
					PoolConstant.oosList.add(oos);
					PoolConstant.oisList.add(ois);
					new Thread(new ServerReaderThread(ois)).start();
					new Thread(new ServertWriterThread(oos)).start();
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void close() {
		try {
			super.serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
