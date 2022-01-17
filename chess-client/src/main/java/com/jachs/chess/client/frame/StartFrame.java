package com.jachs.chess.client.frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.jachs.chess.client.AppConstant;
import com.jachs.chess.client.event.startframe.StartFrameClickEvent;

/**
 * 
 * @author zhanchaohan
 *
 */
public class StartFrame  extends JFrame{
	private static final long serialVersionUID = 1L;

	public StartFrame(){
		JLabel jla=new JLabel("输入名称:");
		
		AppConstant.jtf.setPreferredSize(new Dimension (100,30));
		AppConstant.jtf.setDragEnabled(true);
		JButton jb1=new JButton("确定");
		
		jb1.addMouseListener(new StartFrameClickEvent());
		this.add(jla);
		this.add(AppConstant.jtf);
		this.add(jb1);
		
		
		this.setLayout(new FlowLayout(FlowLayout.LEADING,50,20));
		this.setBounds(300,200,500,100);
		this.setVisible(true);
		this.setBackground(Color.blue);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
