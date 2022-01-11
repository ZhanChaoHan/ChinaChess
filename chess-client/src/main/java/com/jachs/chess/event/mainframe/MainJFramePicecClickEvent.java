package com.jachs.chess.event.mainframe;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import com.jachs.chess.AppConstant;
import com.jachs.chess.thread.MainJFrameThread;

/***
 * 
 * @author zhanchaohan
 *
 */
public class MainJFramePicecClickEvent implements MouseListener{
	/**
	** 单击棋子方法
	*/
	public void mouseClicked(MouseEvent me){
		System.out.println("Mouse");
		//当前坐标
		int Ex=0,Ey=0;
		//启动线程
		if (AppConstant.tmain == null){
			AppConstant.tmain = new Thread(new MainJFrameThread());
			AppConstant.tmain.start();
		}
		//单击棋盘(移动棋子)
		if (me.getSource().equals(AppConstant.image)){
			//该红棋走棋的时候
			if (AppConstant.chessPlayClick == 2 && AppConstant.play[AppConstant.Man].getName().charAt(1) == '2'){	
				Ex = AppConstant.play[AppConstant.Man].getX();
				Ey = AppConstant.play[AppConstant.Man].getY();
				//移动卒、兵
				if (AppConstant.Man > 15 && AppConstant.Man < 26){
					AppConstant.rule.armsRule(AppConstant.Man,AppConstant.play[AppConstant.Man],me);
				}
				//移动炮
				else if (AppConstant.Man > 25 && AppConstant.Man < 30){			
					AppConstant.rule.cannonRule(AppConstant.play[AppConstant.Man],AppConstant.play,me);
				}
				//移动车
				else if (AppConstant.Man >=0 && AppConstant.Man < 4){
					AppConstant.rule.cannonRule(AppConstant.play[AppConstant.Man],AppConstant.play,me);
				}
				//移动马
				else if (AppConstant.Man > 3 && AppConstant.Man < 8){
					AppConstant.rule.horseRule(AppConstant.play[AppConstant.Man],AppConstant.play,me);
				}
				//移动相、象
				else if (AppConstant.Man > 7 && AppConstant.Man < 12){
					AppConstant.rule.elephantRule(AppConstant.Man,AppConstant.play[AppConstant.Man],AppConstant.play,me);
				}else if (AppConstant.Man > 11 && AppConstant.Man < 16){//移动仕、士
					AppConstant.rule.chapRule(AppConstant.Man,AppConstant.play[AppConstant.Man],AppConstant.play,me);
				}else if (AppConstant.Man == 30 || AppConstant.Man == 31){//移动将、帅			
					AppConstant.rule.willRule(AppConstant.Man,AppConstant.play[AppConstant.Man],AppConstant.play,me);
				}
				//是否走棋错误(是否在原地没有动)
				if (Ex == AppConstant.play[AppConstant.Man].getX() && Ey == AppConstant.play[AppConstant.Man].getY()){
					AppConstant.text.setText("               红棋走棋");
					AppConstant.chessPlayClick=2;
				}else {
					AppConstant.text.setText("               黑棋走棋");
					AppConstant.chessPlayClick=1;
				}
			}
			//该黑棋走棋的时候
			else if (AppConstant.chessPlayClick == 1 && AppConstant.play[AppConstant.Man].getName().charAt(1) == '1'){
				Ex = AppConstant.play[AppConstant.Man].getX();
				Ey = AppConstant.play[AppConstant.Man].getY();

				//移动卒、兵
				if (AppConstant.Man > 15 && AppConstant.Man < 26){
					AppConstant.rule.armsRule(AppConstant.Man,AppConstant.play[AppConstant.Man],me);
				}
				
				//移动炮
				else if (AppConstant.Man > 25 && AppConstant.Man < 30){
					AppConstant.rule.cannonRule(AppConstant.play[AppConstant.Man],AppConstant.play,me);
				}
				
				//移动车
				else if (AppConstant.Man >=0 && AppConstant.Man < 4){
					AppConstant.rule.cannonRule(AppConstant.play[AppConstant.Man],AppConstant.play,me);
				}
				
				//移动马
				else if (AppConstant.Man > 3 && AppConstant.Man < 8){
					AppConstant.rule.horseRule(AppConstant.play[AppConstant.Man],AppConstant.play,me);
				}
				
				//移动相、象
				else if (AppConstant.Man > 7 && AppConstant.Man < 12){
					AppConstant.rule.elephantRule(AppConstant.Man,AppConstant.play[AppConstant.Man],AppConstant.play,me);
				}
				
				//移动仕、士
				else if (AppConstant.Man > 11 && AppConstant.Man < 16){
					AppConstant.rule.chapRule(AppConstant.Man,AppConstant.play[AppConstant.Man],AppConstant.play,me);
				}
				//移动将、帅
				else if (AppConstant.Man == 30 || AppConstant.Man == 31){
					AppConstant.rule.willRule(AppConstant.Man,AppConstant.play[AppConstant.Man],AppConstant.play,me);
				}
				//是否走棋错误(是否在原地没有动)
				if (Ex == AppConstant.play[AppConstant.Man].getX() && Ey == AppConstant.play[AppConstant.Man].getY()){
					AppConstant.text.setText("               黑棋走棋");
					AppConstant.chessPlayClick=1;
				}
				else {
					AppConstant.text.setText("               红棋走棋");
					AppConstant.chessPlayClick=2;	
				}
			}
			//当前没有操作(停止闪烁)
			AppConstant.chessManClick=false;
		}
		//单击棋子
		else{
			//第一次单击棋子(闪烁棋子)
			if (!AppConstant.chessManClick){
				for (int i=0;i<32;i++){
					//被单击的棋子
					if (me.getSource().equals(AppConstant.play[i])){
						//告诉线程让该棋子闪烁
						AppConstant.Man=i;
						//开始闪烁
						AppConstant.chessManClick=true;
						break;
					}
				}
			}
			//第二次单击棋子(吃棋子)
			else if (AppConstant.chessManClick){
				//当前没有操作(停止闪烁)
				AppConstant.chessManClick=false;
				
				for (AppConstant.i=0;AppConstant.i<32;AppConstant.i++){
					//找到被吃的棋子
					if (me.getSource().equals(AppConstant.play[AppConstant.i])){
						//该红棋吃棋的时候
						if (AppConstant.chessPlayClick == 2 && AppConstant.play[AppConstant.Man].getName().charAt(1) == '2'){
							Ex = AppConstant.play[AppConstant.Man].getX();
							Ey = AppConstant.play[AppConstant.Man].getY();
							
							//卒、兵吃规则
							if (AppConstant.Man > 15 && AppConstant.Man < 26){
								AppConstant.rule.armsRule(AppConstant.play[AppConstant.Man],AppConstant.play[AppConstant.i]);
							}
							//炮吃规则
							else if (AppConstant.Man > 25 && AppConstant.Man < 30){
								AppConstant.rule.cannonRule(0,AppConstant.play[AppConstant.Man],AppConstant.play[AppConstant.i],AppConstant.play,me);
							}
							//车吃规则
							else if (AppConstant.Man >=0 && AppConstant.Man < 4){
								AppConstant.rule.cannonRule(1,AppConstant.play[AppConstant.Man],AppConstant.play[AppConstant.i],AppConstant.play,me);
							}
							//马吃规则
							else if (AppConstant.Man > 3 && AppConstant.Man < 8){
								AppConstant.rule.horseRule(AppConstant.play[AppConstant.Man],AppConstant.play[AppConstant.i],AppConstant.play,me);	
							}
							//相、象吃规则
							else if (AppConstant.Man > 7 && AppConstant.Man < 12){
								AppConstant.rule.elephantRule(AppConstant.play[AppConstant.Man],AppConstant.play[AppConstant.i],AppConstant.play);
							}
							//士、仕吃棋规则
							else if (AppConstant.Man > 11 && AppConstant.Man < 16){
								AppConstant.rule.chapRule(AppConstant.Man,AppConstant.play[AppConstant.Man],AppConstant.play[AppConstant.i],AppConstant.play);
							}
							//将、帅吃棋规则
							else if (AppConstant.Man == 30 || AppConstant.Man == 31){
								AppConstant.rule.willRule(AppConstant.Man,AppConstant.play[AppConstant.Man],AppConstant.play[AppConstant.i],AppConstant.play);
								AppConstant.play[AppConstant.Man].setVisible(true);	
							}
							//是否走棋错误(是否在原地没有动)
							if (Ex == AppConstant.play[AppConstant.Man].getX() && Ey == AppConstant.play[AppConstant.Man].getY()){
								AppConstant.text.setText("               红棋走棋");
								AppConstant.chessPlayClick=2;
								break;
							}
							else{
								AppConstant.text.setText("               黑棋走棋");
								AppConstant.chessPlayClick=1;
								break;
							}	
						}
						//该黑棋吃棋的时候
						else if (AppConstant.chessPlayClick == 1 && AppConstant.play[AppConstant.Man].getName().charAt(1) == '1'){
							Ex = AppConstant.play[AppConstant.Man].getX();
							Ey = AppConstant.play[AppConstant.Man].getY();
													
							//卒吃规则
							if (AppConstant.Man > 15 && AppConstant.Man < 26){
								AppConstant.rule.armsRule(AppConstant.play[AppConstant.Man],AppConstant.play[AppConstant.i]);
							}
							
							//炮吃规则
							else if (AppConstant.Man > 25 && AppConstant.Man < 30){
								AppConstant.rule.cannonRule(0,AppConstant.play[AppConstant.Man],AppConstant.play[AppConstant.i],AppConstant.play,me);
							}
							
							//车吃规则
							else if (AppConstant.Man >=0 && AppConstant.Man < 4){
								AppConstant.rule.cannonRule(1,AppConstant.play[AppConstant.Man],AppConstant.play[AppConstant.i],AppConstant.play,me);	
							}
							
							//马吃规则
							else if (AppConstant.Man > 3 && AppConstant.Man < 8){
								AppConstant.rule.horseRule(AppConstant.play[AppConstant.Man],AppConstant.play[AppConstant.i],AppConstant.play,me);
							}
							
							//相、象吃规则
							else if (AppConstant.Man > 7 && AppConstant.Man < 12){
								AppConstant.rule.elephantRule(AppConstant.play[AppConstant.Man],AppConstant.play[AppConstant.i],AppConstant.play);
							}
							
							//士、仕吃棋规则
							else if (AppConstant.Man > 11 && AppConstant.Man < 16){
								AppConstant.rule.chapRule(AppConstant.Man,AppConstant.play[AppConstant.Man],AppConstant.play[AppConstant.i],AppConstant.play);
							}
							
							//将、帅吃棋规则
							else if (AppConstant.Man == 30 || AppConstant.Man == 31){
								AppConstant.rule.willRule(AppConstant.Man,AppConstant.play[AppConstant.Man],AppConstant.play[AppConstant.i],AppConstant.play);
								AppConstant.play[AppConstant.Man].setVisible(true);			
							}
							
							//是否走棋错误(是否在原地没有动)
							if (Ex == AppConstant.play[AppConstant.Man].getX() && Ey == AppConstant.play[AppConstant.Man].getY()){
								AppConstant.text.setText("               黑棋走棋");
								AppConstant.chessPlayClick=1;
								break;
							}
							else {
								AppConstant.text.setText("               红棋走棋");
								AppConstant.chessPlayClick=2;	
								break;
							}
						}
					}
				}
				//是否胜利
				if (!AppConstant.play[31].isVisible()){
					JOptionPane.showConfirmDialog(
						null,"黑棋胜利","玩家一胜利",
						JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
					//双方都不可以在走棋了
					AppConstant.chessPlayClick=3;
					AppConstant.text.setText("  黑棋胜利");
				}else if (!AppConstant.play[30].isVisible()){
					JOptionPane.showConfirmDialog(
							null,"红棋胜利","玩家二胜利",
						JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
					AppConstant.chessPlayClick=3;
					AppConstant.text.setText("  红棋胜利");
				}
			}
		}
	}
	
	public void mousePressed(MouseEvent me){
	}
	public void mouseReleased(MouseEvent me){
	}
	public void mouseEntered(MouseEvent me){
	}
	public void mouseExited(MouseEvent me){
	}
}
