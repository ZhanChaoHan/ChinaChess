package com.jachs.chess.client.event.chatframe;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import com.jachs.chess.client.AppConstant;
import com.jachs.chess.service.StatusConstant;
import com.jachs.chess.service.entity.Message;

/***
 * 
 * @author zhanchaohan
 *
 */
public class SendButtClick implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		String txt=AppConstant.sendArea.getText();

		Message mess=new Message();
		mess.setMessage(txt);
		mess.setStatus(StatusConstant.User_01);
		mess.setUser_name(AppConstant.user_name);
		
		try {
			AppConstant.sessionOos.writeObject(mess);
			
			AppConstant.sendArea.setText(null);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
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
