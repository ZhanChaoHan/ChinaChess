package com.jachs.chess.vo;

/***
 * 
 * @author zhanchaohan
 *
 */
public class ServerVo {
	private int server_port;
	
	public ServerVo() {
		super();
	}
	public ServerVo(int server_port) {
		super();
		this.server_port = server_port;
	}
	public int getServer_port() {
		return server_port;
	}
	public void setServer_port(int server_port) {
		this.server_port = server_port;
	}
	
}
