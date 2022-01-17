package com.jachs.chess.server;

import java.util.Properties;

import com.jachs.chess.service.THREADTYPE;
import com.jachs.chess.service.entity.Server;
import com.jachs.chess.server.vo.JdbcVo;
/***
 * 
 * @author zhanchaohan
 *
 */
public class ServerMan {
	private static JdbcVo jVo;
	private static Server server;
	private static Server game;
	
	public static void main(String[] args) throws Exception {
		initProperties();
		//聊天
		IServerSocket iserver=new IServerSocket(THREADTYPE.Session);
		iserver.prepare(server);
		iserver.open();
		//游戏
//		IServerSocket gserver=new IServerSocket(THREADTYPE.Game);
//		gserver.prepare(game);
//		gserver.open();
	}
	//初始化配置文件
	private static void initProperties() throws Exception {
		jVo=new JdbcVo();
		Properties pro=new Properties();
		
		pro.load(ServerMan.class.getResourceAsStream("/jdbc.properties"));
		jVo.setDriver(pro.getProperty("datasource.driver-class-name"));
		jVo.setUrl(pro.getProperty("datasource.url"));
		jVo.setUsername(pro.getProperty("datasource.username"));
		jVo.setPassword(pro.getProperty("datasource.password"));
		
		pro.load(ServerMan.class.getResourceAsStream("/server.properties"));
		server=new Server(null, Integer.parseInt(pro.getProperty("server.port")));
		game=new Server(null, Integer.parseInt(pro.getProperty("game.port")));
	}
}
