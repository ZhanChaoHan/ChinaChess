package com.jachs.chess.service;

/***
 *多线程类型
 * @author zhanchaohan
 *
 */
public enum THREADTYPE {
	Session(1),Game(2);
	private final int code;

	private THREADTYPE(int code) {
		this.code = code;
	}
	
}
