package com.jachs.chess.service.entity;

/***
 * 
 * @author zhanchaohan
 *
 */
public class Server {
	private String ip;
	private int port;
	
	public Server() {
		super();
	}
	public Server(String ip, int port) {
		super();
		this.ip = ip;
		this.port = port;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
}
