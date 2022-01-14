package com.jachs.chess.service.entity;

/***
 * 
 * @author zhanchaohan
 *
 */
public class User {
	private int user_id;
	private String user_name;
	private int user_identity;
	
	
	public User() {
		super();
	}
	public User(int user_id, String user_name, int user_identity) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_identity = user_identity;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getUser_identity() {
		return user_identity;
	}
	public void setUser_identity(int user_identity) {
		this.user_identity = user_identity;
	}
	
}
