package com.jachs.chess.service.entity;

import java.io.Serializable;

/***
 * 
 * @author zhanchaohan
 *
 */
public class Message implements Serializable{
	private static final long serialVersionUID = 1L;
	private int status;
	private String user_name;
	private String message;
	
	
	public Message() {
		super();
	}
	public Message(int status, String user_name, String message) {
		super();
		this.status = status;
		this.user_name = user_name;
		this.message = message;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
