package com.jachs.chess.event.startframe;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.jachs.chess.AppConstant;

/***
 * 
 * @author zhanchaohan
 *
 */
public class StartFrameClickEvent implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		String user_name=AppConstant.jtf.getText();
		System.out.println(user_name);
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
