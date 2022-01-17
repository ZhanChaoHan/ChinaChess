package com.jachs.chess.client.event.mainframe;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.jachs.chess.client.frame.MainJFrame;

/***
 * 设置棋子鼠标划入，划出样式
 * @author zhanchaohan
 *
 */
public class MainMouseStyleEvent implements MouseListener{
	String source=MainJFrame.class.getResource("/image").getPath();
	
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
	//划入
	@Override
	public void mouseEntered(MouseEvent e) {
		JLabel label=(JLabel) e.getSource();
		String name=label.getName();
		
		Icon in =new ImageIcon(source+File.separator+name+".png");
		label.setIcon(in);
	}
	//划出
	@Override
	public void mouseExited(MouseEvent e) {
		JLabel label=(JLabel) e.getSource();
		String name=label.getName();
		
		Icon in =new ImageIcon(source+File.separator+name+".gif");
		label.setIcon(in);
	}

}
