package com.jachs.chess.client.event.mainframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import com.jachs.chess.client.AppConstant;
import com.jachs.chess.client.frame.MainJFrame;

/***
 * 
 * @author zhanchaohan
 *
 */
public class MainJFrameEvent implements ActionListener{

	/**
	** 定义按钮的事件响应
	*/
	public void actionPerformed(ActionEvent ae) {
		//重新开始按钮
		if (ae.getSource().equals(AppConstant.anew)){
			int i,k;
			//重新排列每个棋子的位置
			//黑色棋子
		
			//车
			for (i=0,k=24;i<2;i++,k+=456){		
				AppConstant.play[i].setBounds(k,56,55,55);	
			}	
			
			//马
			for (i=4,k=81;i<6;i++,k+=342){	
				AppConstant.play[i].setBounds(k,56,55,55);
			}
			
			//相
			for (i=8,k=138;i<10;i++,k+=228){	
				AppConstant.play[i].setBounds(k,56,55,55);
			}
			
			//士
			for (i=12,k=195;i<14;i++,k+=114){
				AppConstant.play[i].setBounds(k,56,55,55);
			}
			
			//卒
			for (i=16,k=24;i<21;i++,k+=114){
				AppConstant.play[i].setBounds(k,227,55,55);
			}
			
			//炮
			for (i=26,k=81;i<28;i++,k+=342){
				AppConstant.play[i].setBounds(k,170,55,55);
			}
			
			//将
			AppConstant.play[30].setBounds(252,56,55,55);

			//红色棋子
			//车
			for (i=2,k=24;i<4;i++,k+=456){
				AppConstant.play[i].setBounds(k,569,55,55);
			}
			
			//马
			for (i=6,k=81;i<8;i++,k+=342){
				AppConstant.play[i].setBounds(k,569,55,55);
			}
			
			//相
			for (i=10,k=138;i<12;i++,k+=228){
				AppConstant.play[i].setBounds(k,569,55,55);
			}
			
			//士
			for (i=14,k=195;i<16;i++,k+=114){
				AppConstant.play[i].setBounds(k,569,55,55);
			}
			
			//兵
			for (i=21,k=24;i<26;i++,k+=114){
				AppConstant.play[i].setBounds(k,398,55,55);
			}
			
			//炮
			for (i=28,k=81;i<30;i++,k+=342){
				AppConstant.play[i].setBounds(k,455,55,55);
			}
			
			//帅
			AppConstant.play[31].setBounds(252,569,55,55);		
	
			AppConstant.chessPlayClick = 2;
			AppConstant.text.setText("               红棋走棋");
			
			for (i=0;i<32;i++){
				AppConstant.play[i].setVisible(true);
			}
			//清除Vector中的内容
			AppConstant.Var.clear();
		}	
		
		//悔棋按钮
		else if (ae.getSource().equals(AppConstant.repent)){
			try{
				//获得setVisible属性值
				String S = (String)AppConstant.Var.get(AppConstant.Var.size()-4);
				//获得X坐标
				int x = Integer.parseInt((String)AppConstant.Var.get(AppConstant.Var.size()-3));
				//获得Y坐标
				int y = Integer.parseInt((String)AppConstant.Var.get(AppConstant.Var.size()-2));
				//获得索引
				int M = Integer.parseInt((String)AppConstant.Var.get(AppConstant.Var.size()-1));			
		
				//赋给棋子
				AppConstant.play[M].setVisible(true);			
				AppConstant.play[M].setBounds(x,y,55,55);
				
				if (AppConstant.play[M].getName().charAt(1) == '1'){
					AppConstant.text.setText("               黑棋走棋");
					AppConstant.chessPlayClick = 1;
				} 
				else{
					AppConstant.text.setText("               红棋走棋");
					AppConstant.chessPlayClick = 2;
				}
				
				//删除用过的坐标
				AppConstant.Var.remove(AppConstant.Var.size()-4);
				AppConstant.Var.remove(AppConstant.Var.size()-3);
				AppConstant.Var.remove(AppConstant.Var.size()-2);
				AppConstant.Var.remove(AppConstant.Var.size()-1);
				
				//停止旗子闪烁
				AppConstant.chessManClick=false;
			}
			catch(Exception e){
			}
		}
		//退出
		else if (ae.getSource().equals(AppConstant.exit)){
			int j=JOptionPane.showConfirmDialog(
					null,"真的要退出吗?","退出",
				JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE);
			if (j == JOptionPane.YES_OPTION){
				System.exit(0);
			}
		}
	}

}
