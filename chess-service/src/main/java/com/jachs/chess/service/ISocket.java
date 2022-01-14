package com.jachs.chess.service;

import java.io.IOException;
import java.net.UnknownHostException;

import com.jachs.chess.service.entity.Server;

public class ISocket extends SocketBase{

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
