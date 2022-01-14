package com.jachs.chess;

import com.jachs.chess.frame.ChatFrame;
import com.jachs.chess.frame.MainJFrame;
import com.jachs.chess.frame.StartFrame;

/***
 * @author zhanchaohan
 */
public class ChessMain{
	public static void main(String args[]){
		AppConstant.mainJFrame=new MainJFrame("象棋");
		AppConstant.startFrame=new StartFrame();
		AppConstant.chatFrame=new ChatFrame("聊天室");
		
		AppConstant.mainJFrame.setVisible(false);
		AppConstant.startFrame.setVisible(true);
		AppConstant.chatFrame.setVisible(false);
	}
}