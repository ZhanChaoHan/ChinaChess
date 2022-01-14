package com.jachs.chess.service.behavior;

import com.jachs.chess.service.entity.Server;

/***
 * 
 * @author zhanchaohan
 *
 */
public interface SocketBehavior {
	public void prepare(Server server);
	public void open();
	public void close();
}
