package com.jachs.chess;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

import com.jachs.chess.vo.JdbcVo;
import com.jachs.chess.vo.ServerVo;

/***
 * 
 * @author zhanchaohan
 *
 */
public class ServerMan {
	private static ServerVo sVo;
	private static JdbcVo jVo;
	
	
	public static void main(String[] args) throws Exception {
		initProperties();
		ServerSocket serverSocket=new ServerSocket(sVo.getServer_port());
		
		Socket socket=null;
		while((socket=serverSocket.accept())!=null) {
			
		}
	}
	//初始化配置文件
	private static void initProperties() throws Exception {
		jVo=new JdbcVo();
		sVo=new ServerVo();
		
		Properties pro=new Properties();
		
		pro.load(ServerMan.class.getResourceAsStream("/jdbc.properties"));
		jVo.setDriver(pro.getProperty("datasource.driver-class-name"));
		jVo.setUrl(pro.getProperty("datasource.url"));
		jVo.setUsername(pro.getProperty("datasource.username"));
		jVo.setPassword(pro.getProperty("datasource.password"));
		
		pro.load(ServerMan.class.getResourceAsStream("/server.properties"));
		sVo.setServer_port(Integer.parseInt(pro.getProperty("server.port")));
	}
}
