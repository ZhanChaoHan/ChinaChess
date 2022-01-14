package com.jachs.chess.service;

import java.net.ServerSocket;

import com.jachs.chess.service.behavior.SocketBehavior;

/***
 * 
 * @author zhanchaohan
 *
 */
public abstract class ServerSocketBase implements SocketBehavior{
	public ServerSocket serverSocket;
	
}
