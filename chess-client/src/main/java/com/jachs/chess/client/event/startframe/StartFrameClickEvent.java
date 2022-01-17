package com.jachs.chess.client.event.startframe;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Properties;

import com.jachs.chess.client.AppConstant;
import com.jachs.chess.service.ISocket;
import com.jachs.chess.service.THREADTYPE;
import com.jachs.chess.service.entity.Server;

/***
 * 
 * @author zhanchaohan
 *
 */
public class StartFrameClickEvent implements MouseListener{

	//开始游戏
	@Override
	public void mouseClicked(MouseEvent e) {
		String user_name=AppConstant.jtf.getText();
		System.out.println(user_name);
		
		AppConstant.user_name=user_name;
		AppConstant.mainJFrame.setVisible(true);
		AppConstant.startFrame.setVisible(false);
		AppConstant.chatFrame.setVisible(true);
		
		//加载配置文件
		Properties pro=new Properties();
		Server server=new Server();
		try {
			pro.load(StartFrameClickEvent.class.getResourceAsStream("/client.properties"));
			
			server.setIp(pro.getProperty("server.ip"));
			server.setPort(Integer.parseInt(pro.getProperty("server.ip")));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//启动线程
		ISocket socket=new ISocket(THREADTYPE.Session,AppConstant.contentArea);
		socket.prepare(server);
		socket.open();
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

}
