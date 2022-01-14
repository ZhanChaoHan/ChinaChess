package com.jachs.chess.service;

import java.io.IOException;
import java.net.ServerSocket;

import com.jachs.chess.service.entity.Server;

public class IServerSocket extends ServerSocketBase{

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
