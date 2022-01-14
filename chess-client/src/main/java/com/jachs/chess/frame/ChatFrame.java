package com.jachs.chess.frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.jachs.chess.AppConstant;
import com.jachs.chess.event.chatframe.SendButtClick;


/***
 * 聊天窗体
 * @author zhanchaohan
 *
 */
public class ChatFrame extends JFrame {
		JPanel contentPane;
	    JButton sendbutt;
		/**
		** 构造函数
		** 初始化图形用户界面
		*/
		public ChatFrame(String Title){
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			Dimension frameSize = this.getSize();
			int height=(screenSize.width - frameSize.width) / 2 - 280;
			int width=(screenSize.height - frameSize.height ) / 2 - 350;
			
			contentPane=new JPanel();
			AppConstant.sendArea=new JTextArea();
			AppConstant.contentArea=new JTextArea();
			sendbutt=new JButton("发送");
			
			sendbutt.addMouseListener(new SendButtClick());
			
			AppConstant.contentArea = new JTextArea(20, 35);
			AppConstant.contentArea.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
			AppConstant.contentArea.setLineWrap(true);
			AppConstant.contentArea.setWrapStyleWord(true);
			AppConstant.contentArea.setEditable(false);
	        
			AppConstant.sendArea = new JTextArea(10, 35);//设置发送区域几行几列
			AppConstant.sendArea.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
			AppConstant.sendArea.setLineWrap(true);
			AppConstant.sendArea.setWrapStyleWord(false);//激活断行不断字功能
		
	        JScrollPane scrollpane=new JScrollPane(AppConstant.contentArea);
			//取消显示水平滚动条
			scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			//显示垂直滚动条
			scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			
			AppConstant.sendArea.setText("AAAAAAAAAAA");
			AppConstant.sendArea.setText("BBBBBBB");
			
	        
			contentPane.add(scrollpane);
			contentPane.add(AppConstant.sendArea);
			contentPane.add(sendbutt);
	        
			this.add(contentPane);
			contentPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			
			this.setLocation(height,width);
			this.setIconImage(new ImageIcon(ChatFrame.class.getResource("/image/room/qq.png")).getImage());
			this.setTitle(Title);
			this.setSize(558,670);
			this.setVisible(true);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
		
}
