package com.jachs.chess.client;

import java.awt.event.MouseEvent;

import javax.swing.JLabel;

/***
 * 定义中国象棋规则类
 * @author zhanchaohan
 *
 */
public class ChessRule {
	/**卒子的移动规则*/
	public void armsRule(int Man,JLabel play,MouseEvent me){
		//黑卒向下
		if (Man < 21){
			//向下移动、得到终点的坐标模糊成合法的坐标
			if ((me.getY()-play.getY()) > 27 && (me.getY()-play.getY()) < 86 && (me.getX()-play.getX()) < 55 && (me.getX()-play.getX()) > 0){
				
				//当前记录添加到集合(用于悔棋)
				AppConstant.Var.add(String.valueOf(play.isVisible()));
				AppConstant.Var.add(String.valueOf(play.getX()));
				AppConstant.Var.add(String.valueOf(play.getY()));
				AppConstant.Var.add(String.valueOf(Man));
				
				play.setBounds(play.getX(),play.getY()+57,55,55);
			}
			//向右移动、得到终点的坐标模糊成合法的坐标、必须过河				
			else if (play.getY() > 284 && (me.getX() - play.getX()) >= 57 && (me.getX() - play.getX()) <= 112){
				play.setBounds(play.getX()+57,play.getY(),55,55);	
			}
			//向左移动、得到终点的坐标模糊成合法的坐标、必须过河
			else if (play.getY() > 284 && (play.getX() - me.getX()) >= 2 && (play.getX() - me.getX()) <=58){
				//模糊坐标
				play.setBounds(play.getX()-57,play.getY(),55,55);
			}
		}
		
		//红卒向上
		else{
			//当前记录添加到集合(用于悔棋)
			AppConstant.Var.add(String.valueOf(play.isVisible()));
			AppConstant.Var.add(String.valueOf(play.getX()));
			AppConstant.Var.add(String.valueOf(play.getY()));
			AppConstant.Var.add(String.valueOf(AppConstant.Man));
			
			//向上移动、得到终点的坐标模糊成合法的坐标
			if ((me.getX()-play.getX()) >= 0 && (me.getX()-play.getX()) <= 55 && (play.getY()-me.getY()) >27 && play.getY()-me.getY() < 86){
				play.setBounds(play.getX(),play.getY()-57,55,55);
			}
			
			//向右移动、得到终点的坐标模糊成合法的坐标、必须过河
			else if (play.getY() <= 341 && (me.getX() - play.getX()) >= 57 && (me.getX() - play.getX()) <= 112){
				play.setBounds(play.getX()+57,play.getY(),55,55);
			}				
			
			//向左移动、得到终点的坐标模糊成合法的坐标、必须过河
			else if (play.getY() <= 341 && (play.getX() - me.getX()) >= 3 && (play.getX() - me.getX()) <=58){
				play.setBounds(play.getX()-57,play.getY(),55,55);
			}
		}
	}//卒移动结束

	/**卒吃棋规则*/
	public void armsRule(JLabel play1,JLabel play2){
		//向右走
		if ((play2.getX() - play1.getX()) <= 112 && (play2.getX() - play1.getX()) >= 57 && (play1.getY() - play2.getY()) < 22 && (play1.getY() - play2.getY()) > -22 && play2.isVisible() && play1.getName().charAt(1)!=play2.getName().charAt(1)){
			//黑棋要过河才能右吃棋
			if (play1.getName().charAt(1) == '1' && play1.getY() > 284 && play1.getName().charAt(1) != play2.getName().charAt(1)){
				play2.setVisible(false);
				//把对方的位置给自己
				play1.setBounds(play2.getX(),play2.getY(),55,55);
			}
			//红棋要过河才左能吃棋
			else if (play1.getName().charAt(1) == '2' && play1.getY() < 341 && play1.getName().charAt(1) != play2.getName().charAt(1)){
				play2.setVisible(false);
				//把对方的位置给自己
				play1.setBounds(play2.getX(),play2.getY(),55,55);				
			}
		}
		
		//向左走
		else if ((play1.getX() - play2.getX()) <= 112 && (play1.getX() - play2.getX()) >= 57 && (play1.getY() - play2.getY()) < 22 && (play1.getY() - play2.getY()) > -22 && play2.isVisible() && play1.getName().charAt(1)!=play2.getName().charAt(1)){
			//黑棋要过河才能左吃棋
			if (play1.getName().charAt(1) == '1' && play1.getY() > 284 && play1.getName().charAt(1) != play2.getName().charAt(1)){
				play2.setVisible(false);
				//把对方的位置给自己
				play1.setBounds(play2.getX(),play2.getY(),55,55);
			}
			//红棋要过河才能右吃棋
			else if (play1.getName().charAt(1) == '2' && play1.getY() < 341 && play1.getName().charAt(1) != play2.getName().charAt(1)){
				play2.setVisible(false);
				//把对方的位置给自己
				play1.setBounds(play2.getX(),play2.getY(),55,55);				
			}
		}
		
		//向上走
		else if (play1.getX() - play2.getX() >= -22 && play1.getX() - play2.getX() <= 22 && play1.getY() - play2.getY() >= -112 && play1.getY() - play2.getY() <= 112){
			//黑棋不能向上吃棋
			if (play1.getName().charAt(1) == '1' && play1.getY() < play2.getY() && play1.getName().charAt(1) != play2.getName().charAt(1)){
				play2.setVisible(false);
				//把对方的位置给自己
				play1.setBounds(play2.getX(),play2.getY(),55,55);
			}
			
			//红棋不能向下吃棋
			else if (play1.getName().charAt(1) == '2' && play1.getY() > play2.getY() && play1.getName().charAt(1) != play2.getName().charAt(1)){
				play2.setVisible(false);
				//把对方的位置给自己
				play1.setBounds(play2.getX(),play2.getY(),55,55);
			}			
		}
		
		//当前记录添加到集合(用于悔棋)
		AppConstant.Var.add(String.valueOf(play1.isVisible()));
		AppConstant.Var.add(String.valueOf(play1.getX()));
		AppConstant.Var.add(String.valueOf(play1.getY()));
		AppConstant.Var.add(String.valueOf(AppConstant.Man));
		
		//当前记录添加到集合(用于悔棋)
		AppConstant.Var.add(String.valueOf(play2.isVisible()));
		AppConstant.Var.add(String.valueOf(play2.getX()));
		AppConstant.Var.add(String.valueOf(play2.getY()));
		AppConstant.Var.add(String.valueOf(AppConstant.i));

	}//卒吃结束
	
	/**炮、车移动规则*/
	public void cannonRule(JLabel play,JLabel playQ[],MouseEvent me){
		//起点和终点之间是否有棋子
		int Count = 0;
		
		//上、下移动
		if (play.getX() - me.getX() <= 0 && play.getX() - me.getX() >= -55){
			//指定所有模糊Y坐标
			for (int i=56;i<=571;i+=57){
				//移动的Y坐标是否有指定坐标相近的
				if (i - me.getY() >= -27 && i - me.getY() <= 27){
					//所有的棋子
					for (int j=0;j<32;j++){
						//找出在同一条竖线的所有棋子、并不包括自己
						if (playQ[j].getX() - play.getX() >= -27 && playQ[j].getX() - play.getX() <= 27 && playQ[j].getName()!=play.getName() && playQ[j].isVisible()){
							//从起点到终点(从左到右)
							for (int k=play.getY()+57;k<i;k+=57){
								//大于起点、小于终点的坐标就可以知道中间是否有棋子
								if (playQ[j].getY() < i && playQ[j].getY() > play.getY()){
									//中间有一个棋子就不可以从这条竖线过去
									Count++;
									break;
								}
							}
							
							//从起点到终点(从右到左)
							for (int k=i+57;k<play.getY();k+=57){
								//找起点和终点的棋子
								if (playQ[j].getY() < play.getY() && playQ[j].getY() > i){
									Count++;
									break;
								}
							}
						}
					}
					
					//起点和终点没有棋子就可以移动了
					if (Count == 0){
						//当前记录添加到集合(用于悔棋)
						AppConstant.Var.add(String.valueOf(play.isVisible()));
						AppConstant.Var.add(String.valueOf(play.getX()));
						AppConstant.Var.add(String.valueOf(play.getY()));
						AppConstant.Var.add(String.valueOf(AppConstant.Man));
						play.setBounds(play.getX(),i,55,55);
						break;
					}
				}
			}
		}

		//左、右移动
		else if (play.getY() - me.getY() >=-27 && play.getY() - me.getY() <= 27){
			//指定所有模糊X坐标
			for (int i=24;i<=480;i+=57){
				//移动的X坐标是否有指定坐标相近的
				if (i - me.getX() >= -55 && i-me.getX() <= 0){
					//所有的棋子
					for (int j=0;j<32;j++){
						//找出在同一条横线的所有棋子、并不包括自己
						if (playQ[j].getY() - play.getY() >= -27 && playQ[j].getY() - play.getY() <= 27 && playQ[j].getName()!=play.getName() && playQ[j].isVisible()){
							//从起点到终点(从上到下)				
							for (int k=play.getX()+57;k<i;k+=57){
								//大于起点、小于终点的坐标就可以知道中间是否有棋子
								if (playQ[j].getX() < i && playQ[j].getX() > play.getX()){
									//中间有一个棋子就不可以从这条横线过去
									Count++;
									break;
								}
							}//for
							
							//从起点到终点(从下到上)
							for (int k=i+57;k<play.getX();k+=57){
								//找起点和终点的棋子
								if (playQ[j].getX() < play.getX() && playQ[j].getX() > i){
									Count++;
									break;
								}
							}//for
						}//if
					}//for
					
					//起点和终点没有棋子
					if (Count == 0){
						//当前记录添加到集合(用于悔棋)
						AppConstant.Var.add(String.valueOf(play.isVisible()));
						AppConstant.Var.add(String.valueOf(play.getX()));
						AppConstant.Var.add(String.valueOf(play.getY()));
						AppConstant.Var.add(String.valueOf(AppConstant.Man));
						
						play.setBounds(i,play.getY(),55,55);
						break;
					}
				}
			}
		}
	}//炮、车移动方法结束


	/**炮、车吃棋规则*/
	public void cannonRule(int Chess,JLabel play,JLabel playTake,JLabel playQ[],MouseEvent me){
		//起点和终点之间是否有棋子
		int Count = 0;


		//所有的棋子
		for (int j=0;j<32;j++){
			//找出在同一条竖线的所有棋子、并不包括自己
			if (playQ[j].getX() - play.getX() >= -27 && playQ[j].getX() - play.getX() <= 27 && playQ[j].getName()!=play.getName() && playQ[j].isVisible()){

				//自己是起点被吃的是终点(从上到下)
				for (int k=play.getY()+57;k<playTake.getY();k+=57){
					//大于起点、小于终点的坐标就可以知道中间是否有棋子
					if (playQ[j].getY() < playTake.getY() && playQ[j].getY() > play.getY()){
							//计算起点和终点的棋子个数
							Count++;			
							break;							
					}
				}//for
							
				//自己是起点被吃的是终点(从下到上)
				for (int k=playTake.getY();k<play.getY();k+=57){
					//找起点和终点的棋子
					if (playQ[j].getY() < play.getY() && playQ[j].getY() > playTake.getY()){
							Count++;	
							break;
					}
				}//for
			}//if
						
			//找出在同一条竖线的所有棋子、并不包括自己
			else if (playQ[j].getY() - play.getY() >= -10 && playQ[j].getY() - play.getY() <= 10 && playQ[j].getName()!=play.getName() && playQ[j].isVisible()){
				//自己是起点被吃的是终点(从左到右)
				for (int k=play.getX()+50;k<playTake.getX();k+=57){
					//大于起点、小于终点的坐标就可以知道中间是否有棋子						
					if (playQ[j].getX() < playTake.getX() && playQ[j].getX() > play.getX()){
						Count++;			
						break;	
					}
				}//for
							
				//自己是起点被吃的是终点(从右到左)
				for (int k=playTake.getX();k<play.getX();k+=57){
					//找起点和终点的棋子
					if (playQ[j].getX() < play.getX() && playQ[j].getX() > playTake.getX()){
							Count++;
							break;
					}
				}//for
			}//if
		}//for
					
		//起点和终点之间要一个棋子是炮的规则、并不能吃自己的棋子
		if (Count == 1 && Chess == 0 && playTake.getName().charAt(1) != play.getName().charAt(1)){
			//当前记录添加到集合(用于悔棋)
			AppConstant.Var.add(String.valueOf(play.isVisible()));
			AppConstant.Var.add(String.valueOf(play.getX()));
			AppConstant.Var.add(String.valueOf(play.getY()));
			AppConstant.Var.add(String.valueOf(AppConstant.Man));
			
			//当前记录添加到集合(用于悔棋)
			AppConstant.Var.add(String.valueOf(playTake.isVisible()));
			AppConstant.Var.add(String.valueOf(playTake.getX()));									
			AppConstant.Var.add(String.valueOf(playTake.getY()));
			AppConstant.Var.add(String.valueOf(AppConstant.i));
			
			playTake.setVisible(false);
			play.setBounds(playTake.getX(),playTake.getY(),55,55);
		}
		
		//起点和终点之间没有棋子是车的规则、并不能吃自己的棋子			
		else if (Count ==0  && Chess == 1 && playTake.getName().charAt(1) != play.getName().charAt(1)){
			
			//当前记录添加到集合(用于悔棋)
			AppConstant.Var.add(String.valueOf(play.isVisible()));
			AppConstant.Var.add(String.valueOf(play.getX()));									
			AppConstant.Var.add(String.valueOf(play.getY()));
			AppConstant.Var.add(String.valueOf(AppConstant.Man));
			
			//当前记录添加到集合(用于悔棋)
			AppConstant.Var.add(String.valueOf(playTake.isVisible()));
			AppConstant.Var.add(String.valueOf(playTake.getX()));									
			AppConstant.Var.add(String.valueOf(playTake.getY()));
			AppConstant.Var.add(String.valueOf(AppConstant.i));
			
			playTake.setVisible(false);
			play.setBounds(playTake.getX(),playTake.getY(),55,55);
		}
		
	}//炮、车吃棋方法结束
	
	/**马移动规则*/
	public void horseRule(JLabel play,JLabel playQ[],MouseEvent me){
		//保存坐标和障碍
		int Ex=0,Ey=0,Move=0;			
		
		//上移、左边
		if (play.getX() - me.getX() >= 2 && play.getX() - me.getX() <= 57 && play.getY() - me.getY() >= 87 && play.getY() - me.getY() <= 141){
			//合法的Y坐标
			for (int i=56;i<=571;i+=57){
				//移动的Y坐标是否有指定坐标相近的
				if (i - me.getY() >= -27 && i - me.getY() <= 27){
					Ey = i;
					break;
				}
			}
			
			//合法的X坐标
			for (int i=24;i<=480;i+=57){
				//移动的X坐标是否有指定坐标相近的
				if (i - me.getX() >= -55 && i-me.getX() <= 0){
					Ex = i;
					break;
				}
			}
			
			//正前方是否有别的棋子
			for (int i=0;i<32;i++){
				if (playQ[i].isVisible() && play.getX() - playQ[i].getX() == 0  && play.getY() - playQ[i].getY() == 57 ){
					Move = 1;
					break;
				}	
			}
			
			//可以移动该棋子
			if (Move == 0){
				//当前记录添加到集合(用于悔棋)
				AppConstant.Var.add(String.valueOf(play.isVisible()));
				AppConstant.Var.add(String.valueOf(play.getX()));
				AppConstant.Var.add(String.valueOf(play.getY()));
				AppConstant.Var.add(String.valueOf(AppConstant.Man));
								
				play.setBounds(Ex,Ey,55,55);
			}
			
		}//if
		
		//左移、上边
		else if (play.getY() - me.getY() >= 27 && play.getY() - me.getY() <= 86 && play.getX() - me.getX() >= 70 && play.getX() - me.getX() <= 130){
			//Y
			for (int i=56;i<=571;i+=57){
				if (i - me.getY() >= -27 && i - me.getY() <= 27){
					Ey = i;
				}
			}
			
			//X
			for (int i=24;i<=480;i+=57){
				if (i - me.getX() >= -55 && i-me.getX() <= 0){
					Ex = i;
				}
			}
			
			//正左方是否有别的棋子
			for (int i=0;i<32;i++){
				if (playQ[i].isVisible() && play.getY() - playQ[i].getY() == 0 && play.getX() - playQ[i].getX() == 57 ){
					Move = 1;
					break;
				}
			}
			
			if (Move == 0){
				//当前记录添加到集合(用于悔棋)
				AppConstant.Var.add(String.valueOf(play.isVisible()));
				AppConstant.Var.add(String.valueOf(play.getX()));
				AppConstant.Var.add(String.valueOf(play.getY()));
				AppConstant.Var.add(String.valueOf(AppConstant.Man));
				
				play.setBounds(Ex,Ey,55,55);
			}
		}//else
		
		//下移、右边
		else if (me.getY() - play.getY() >= 87 && me.getY() - play.getY() <= 141 && me.getX() - play.getX() <= 87 && me.getX() - play.getX() >= 2 ){	
			//Y		
			for (int i=56;i<=571;i+=57){
				if (i - me.getY() >= -27 && i - me.getY() <= 27){
					Ey = i;
				}
			}
			
			//X
			for (int i=24;i<=480;i+=57){
				if (i - me.getX() >= -55 && i-me.getX() <= 0){
					Ex = i;
				}
			}
			
			//正下方是否有别的棋子
			for (int i=0;i<32;i++){
				if (playQ[i].isVisible() && play.getX() - playQ[i].getX() == 0  && playQ[i].getY() - play.getY() == 57 ){
					Move = 1;
					break;
				}
			}
			
			if (Move == 0){
				//当前记录添加到集合(用于悔棋)
				AppConstant.Var.add(String.valueOf(play.isVisible()));
				AppConstant.Var.add(String.valueOf(play.getX()));
				AppConstant.Var.add(String.valueOf(play.getY()));
				AppConstant.Var.add(String.valueOf(AppConstant.Man));
				
				play.setBounds(Ex,Ey,55,55);
			}
		}//else
		
		//上移、右边
		else if (play.getY() - me.getY() >= 87 && play.getY() - me.getY() <= 141 && me.getX() - play.getX() <= 87 && me.getX() - play.getX() >= 30 ){
			//合法的Y坐标
			for (int i=56;i<=571;i+=57){
				if (i - me.getY() >= -27 && i - me.getY() <= 27){
					Ey = i;
					break;
				}
			}
			
			//合法的X坐标
			for (int i=24;i<=480;i+=57){
				if (i - me.getX() >= -55 && i-me.getX() <= 0){
					Ex = i;
					break;
				}
			}
			
			//正前方是否有别的棋子
			for (int i=0;i<32;i++){
				System.out.println(i+"playQ[i].getX()="+playQ[i].getX());
				//System.out.println("play.getX()="+play.getX());
				if (playQ[i].isVisible() && play.getX() - playQ[i].getX() == 0 && play.getY() - playQ[i].getY() == 57 ){
					Move = 1;
					//System.out.println("play.getY()="+play.getY());
					//System.out.println("playQ[i].getY()="+playQ[i].getY());
					break;
				}
			}
			
			//可以移动该棋子
			if (Move == 0){
				//当前记录添加到集合(用于悔棋)
				AppConstant.Var.add(String.valueOf(play.isVisible()));
				AppConstant.Var.add(String.valueOf(play.getX()));	
				AppConstant.Var.add(String.valueOf(play.getY()));
				AppConstant.Var.add(String.valueOf(AppConstant.Man));
				
				play.setBounds(Ex,Ey,55,55);
			}
		}//else 
		
		//下移、左边
		else if (me.getY() - play.getY() >= 87 && me.getY() - play.getY() <= 141 && play.getX() - me.getX() <= 87 && play.getX() - me.getX() >= 10 ){
			//合法的Y坐标
			for (int i=56;i<=571;i+=57){
				if (i - me.getY() >= -27 && i - me.getY() <= 27){
					Ey = i;
					break;
				}
			}
			
			//合法的X坐标
			for (int i=24;i<=480;i+=57){
				if (i - me.getX() >= -55 && i-me.getX() <= 0){
					Ex = i;
					break;
				}
			}
			
			//正下方是否有别的棋子
			for (int i=0;i<32;i++){
				if (playQ[i].isVisible() && play.getX() - playQ[i].getX() == 0 && play.getY() - playQ[i].getY() == 57 ){
					Move = 1;
					break;
				}
			}
			
			//可以移动该棋子
			if (Move == 0){
				//当前记录添加到集合(用于悔棋)
				AppConstant.Var.add(String.valueOf(play.isVisible()));
				AppConstant.Var.add(String.valueOf(play.getX()));
				AppConstant.Var.add(String.valueOf(play.getY()));
				AppConstant.Var.add(String.valueOf(AppConstant.Man));
				
				play.setBounds(Ex,Ey,55,55);
			}
		}//else
		
		//右移、上边
		else if (play.getY() - me.getY() >= 30 && play.getY() - me.getY() <= 87 && me.getX() - play.getX() <= 141 && me.getX() - play.getX() >= 87 ){
			//Y		
			for (int i=56;i<=571;i+=57){
				if (i - me.getY() >= -27 && i - me.getY() <= 27){
					Ey = i;
				}
			}
			
			//X
			for (int i=24;i<=480;i+=57){
				if (i - me.getX() >= -55 && i-me.getX() <= 0){
					Ex = i;
				}
			}
			
			//正右方是否有别的棋子
			for (int i=0;i<32;i++){
				if (playQ[i].isVisible() && play.getY() - playQ[i].getY() == 0 && playQ[i].getX() - play.getX() == 57 ){
					Move = 1;
					break;
				}
			}
			
			if (Move == 0){
				//当前记录添加到集合(用于悔棋)
				AppConstant.Var.add(String.valueOf(play.isVisible()));
				AppConstant.Var.add(String.valueOf(play.getX()));
				AppConstant.Var.add(String.valueOf(play.getY()));
				AppConstant.Var.add(String.valueOf(AppConstant.Man));
				
				play.setBounds(Ex,Ey,55,55);
			}
		}//else
		
		//右移、下边
		else if (me.getY() - play.getY() >= 30 && me.getY() - play.getY() <= 87 && me.getX() - play.getX() <= 141 && me.getX() - play.getX() >= 87 ){
			//Y		
			for (int i=56;i<=571;i+=57){
				if (i - me.getY() >= -27 && i - me.getY() <= 27){
					Ey = i;
				}
			}
			
			//X
			for (int i=24;i<=480;i+=57){
				if (i - me.getX() >= -55 && i-me.getX() <= 0){
					Ex = i;
				}
			}
			
			//正右方是否有别的棋子
			for (int i=0;i<32;i++){
				if (playQ[i].isVisible() && play.getY() - playQ[i].getY() == 0 && playQ[i].getX() - play.getX() == 57 ){
					Move = 1;
					break;
				}
			}
			
			if (Move == 0){
				//当前记录添加到集合(用于悔棋)
				AppConstant.Var.add(String.valueOf(play.isVisible()));
				AppConstant.Var.add(String.valueOf(play.getX()));
				AppConstant.Var.add(String.valueOf(play.getY()));
				AppConstant.Var.add(String.valueOf(AppConstant.Man));
				
				play.setBounds(Ex,Ey,55,55);
			}
		}//else
		
		//左移、下边
		else if (me.getY() - play.getY() >= 30 && me.getY() - play.getY() <= 87 && play.getX() - me.getX() <= 141 && play.getX() - me.getX() >= 87 ){
			//Y		
			for (int i=56;i<=571;i+=57){
				if (i - me.getY() >= -27 && i - me.getY() <= 27){
					Ey = i;
				}
			}
			
			//X
			for (int i=24;i<=480;i+=57){
				if (i - me.getX() >= -55 && i-me.getX() <= 0){
					Ex = i;
				}
			}
			
			//正左方是否有别的棋子
			for (int i=0;i<32;i++){
				if (playQ[i].isVisible() && play.getY() - playQ[i].getY() == 0 && play.getX() - playQ[i].getX() == 57 ){
					Move = 1;
					break;
				}
			}
			
			if (Move == 0){
				//当前记录添加到集合(用于悔棋)
				AppConstant.Var.add(String.valueOf(play.isVisible()));
				AppConstant.Var.add(String.valueOf(play.getX()));
				AppConstant.Var.add(String.valueOf(play.getY()));
				AppConstant.Var.add(String.valueOf(AppConstant.Man));
			
				play.setBounds(Ex,Ey,55,55);
			}
			
		}//else
		
	}//马移动结束

	/**马吃棋规则*/
	public void horseRule(JLabel play,JLabel playTake ,JLabel playQ[],MouseEvent me){
		//障碍
		int Move=0;
		boolean Chess=false;
		
		//上移、左吃
		if (play.getName().charAt(1)!=playTake.getName().charAt(1) && play.getX() - playTake.getX() == 57 && play.getY() - playTake.getY() == 114 ){
			//正前方是否有别的棋子
			for (int i=0;i<32;i++){
				if (playQ[i].isVisible() && play.getX() - playQ[i].getX() == 0 && play.getY() - playQ[i].getY() == 57){
					Move = 1;
					break;
				}
			}//for
			
			Chess = true;
			
		}//if
		
		//上移、右吃
		else if (play.getY() - playTake.getY() == 114 && playTake.getX() - play.getX() == 57 ){
			//正前方是否有别的棋子
			for (int i=0;i<32;i++){
				if (playQ[i].isVisible() && play.getX() - playQ[i].getX() == 0 && play.getY() - playQ[i].getY() == 57){
					Move = 1;
					break;
				}
			}//for		
			
			Chess = true;
			
		}//else
		
		//左移、上吃
		else if (play.getY() - playTake.getY() == 57 && play.getX() - playTake.getX() == 114 ){
			//正左方是否有别的棋子
			for (int i=0;i<32;i++){
				if (playQ[i].isVisible() && play.getY() - playQ[i].getY() == 0 && play.getX() - playQ[i].getX() == 57){
					Move = 1;
					break;
				}
			}//for
			
			Chess = true;
			
		}//else
		
		//左移、下吃
		else if (playTake.getY() - play.getY() == 57 && play.getX() - playTake.getX() == 114 ){
			//正左方是否有别的棋子
			for (int i=0;i<32;i++){
				if (playQ[i].isVisible() && play.getY() - playQ[i].getY() == 0 && play.getX() - playQ[i].getX() == 57){
					Move = 1;
					break;
				}
			}//for
			
			Chess = true;
			
		}//else
		
		//右移、上吃
		else if (play.getY() - playTake.getY() == 57 && playTake.getX() - play.getX() == 114 ){
			//正右方是否有别的棋子
			for (int i=0;i<32;i++){
				if (playQ[i].isVisible() && play.getY() - playQ[i].getY() == 0 && playQ[i].getX() - play.getX() == 57){
					Move = 1;
					break;
				}
			}//for
			
			Chess = true;
			
		}//else
		
		//右移、下吃
		else if (playTake.getY() - play.getY() == 57  && playTake.getX() - play.getX() == 114 ){
			//正右方是否有别的棋子
			for (int i=0;i<32;i++){
				if (playQ[i].isVisible() && play.getY() - playQ[i].getY() == 0 && playQ[i].getX() - play.getX() == 57){
					Move = 1;
					break;
				}
			}//for
			
			Chess = true;
			
		}//else
		
		//下移、左吃
		else if (playTake.getY() - play.getY() == 114 && play.getX() - playTake.getX() == 57 ){
			//正下方是否有别的棋子
			for (int i=0;i<32;i++){
				if (playQ[i].isVisible() && play.getX() - playQ[i].getX() == 0 && play.getY() - playQ[i].getY() == -57 ){
					Move = 1;
					break;
					
				}
			}//for
			
			Chess = true;
			
		}//else 
		
		//下移、右吃
		else if (playTake.getY() - play.getY() == 114 && playTake.getX() - play.getX() == 57){
			//正下方是否有别的棋子
			for (int i=0;i<32;i++){
				if (playQ[i].isVisible() && play.getX() - playQ[i].getX() == 0 && play.getY() - playQ[i].getY() == -57 ){
					Move = 1;
					break;
				}
			}//for
			
			Chess = true;
			
		}//else  
		
		//没有障碍、并可以吃棋、不能吃自己颜色
		if (Chess && Move == 0 && playTake.getName().charAt(1) != play.getName().charAt(1)){
			//当前记录添加到集合(用于悔棋)
			AppConstant.Var.add(String.valueOf(play.isVisible()));
			AppConstant.Var.add(String.valueOf(play.getX()));
			AppConstant.Var.add(String.valueOf(play.getY()));
			AppConstant.Var.add(String.valueOf(AppConstant.Man));
			
			//当前记录添加到集合(用于悔棋)
			AppConstant.Var.add(String.valueOf(playTake.isVisible()));
			AppConstant.Var.add(String.valueOf(playTake.getX()));
			AppConstant.Var.add(String.valueOf(playTake.getY()));
			AppConstant.Var.add(String.valueOf(AppConstant.i));			
			
			playTake.setVisible(false);
			play.setBounds(playTake.getX(),playTake.getY(),55,55);
		}
	}
	
	/**相移动规则*/
	public void elephantRule(int Man,JLabel play,JLabel playQ[],MouseEvent me){
		//坐标和障碍
		int Ex=0,Ey=0,Move=0;
		
		//上左
		if (play.getX() - me.getX() <= 141 && play.getX() - me.getX() >= 87 && play.getY() - me.getY() <= 141 && play.getY() - me.getY() >= 87){
			//合法的Y坐标
			for (int i=56;i<=571;i+=57){
				if (i - me.getY() >= -27 && i - me.getY() <= 27){
					Ey = i;
					break;
				}
			}
			
			//合法的X坐标
			for (int i=24;i<=480;i+=57){
				if (i - me.getX() >= -27 && i-me.getX() <= 27){
					Ex = i;
					break;
				}
			}
			
			//左上方是否有棋子
			for (int i=0;i<32;i++){
				if (playQ[i].isVisible() && play.getX() - playQ[i].getX() == 57 && play.getY() - playQ[i].getY() == 57){
					Move++;
					break;
				}
			}
			
			//红旗不能过楚河
			if (Move == 0 && Ey >= 341 && AppConstant.Man > 9){
				//当前记录添加到集合(用于悔棋)
				AppConstant.Var.add(String.valueOf(play.isVisible()));
				AppConstant.Var.add(String.valueOf(play.getX()));
				AppConstant.Var.add(String.valueOf(play.getY()));
				AppConstant.Var.add(String.valueOf(AppConstant.Man));
							
							System.out.println("Ex="+Ex);
							System.out.println("Ey="+Ey);
				play.setBounds(Ex,Ey,55,55);
			}
			
			//黑旗不能过汉界
			else if (Move == 0 && Ey <= 284 && AppConstant.Man < 10){
				//当前记录添加到集合(用于悔棋)
				AppConstant.Var.add(String.valueOf(play.isVisible()));
				AppConstant.Var.add(String.valueOf(play.getX()));
				AppConstant.Var.add(String.valueOf(play.getY()));
				AppConstant.Var.add(String.valueOf(AppConstant.Man));
				
				play.setBounds(Ex,Ey,55,55);	
			}
		}//if
		
		//上右
		else if (play.getY() - me.getY() <= 141 && play.getY() - me.getY() >= 87 &&  me.getX() - play.getX() >= 87 && me.getX() - play.getX() <= 141){
			//合法的Y坐标
			for (int i=56;i<=571;i+=57){
				if (i - me.getY() >= -27 && i - me.getY() <= 27){
					Ey = i;
					break;
				}
			}
			
			//合法的X坐标
			for (int i=24;i<=480;i+=57){
				if (i - me.getX() >= -27 && i-me.getX() <= 27){
					Ex = i;
					break;
				}
			}
			
			//右上方是否有棋子
			for (int i=0;i<32;i++){
				if (playQ[i].isVisible() &&  playQ[i].getX() - play.getX() == 57 && play.getY() - playQ[i].getY() == 57){
					Move++;
					break;
				}
			}
			
			//相、象规则
			if (Move == 0 && Ey >= 341 && AppConstant.Man > 9){
				//当前记录添加到集合(用于悔棋)
				AppConstant.Var.add(String.valueOf(play.isVisible()));
				AppConstant.Var.add(String.valueOf(play.getX()));
				AppConstant.Var.add(String.valueOf(play.getY()));
				AppConstant.Var.add(String.valueOf(AppConstant.Man));
				
				play.setBounds(Ex,Ey,55,55);
			}
			
			else if (Move == 0 && Ey <= 284 && AppConstant.Man < 10){
				//当前记录添加到集合(用于悔棋)
				AppConstant.Var.add(String.valueOf(play.isVisible()));
				AppConstant.Var.add(String.valueOf(play.getX()));
				AppConstant.Var.add(String.valueOf(play.getY()));
				AppConstant.Var.add(String.valueOf(AppConstant.Man));
				
				play.setBounds(Ex,Ey,55,55);
			}
			
		}// else if 
		
		//下左
		else if (play.getX() - me.getX() <= 141 && play.getX() - me.getX() >= 87 && me.getY() - play.getY() <= 141 && me.getY() - play.getY() >= 87){
			//合法的Y坐标
			for (int i=56;i<=571;i+=57){
				if (i - me.getY() >= -27 && i - me.getY() <= 27){
					Ey = i;
					break;
				}
			}
			
			//合法的X坐标
			for (int i=24;i<=480;i+=57){
				if (i - me.getX() >= -27 && i-me.getX() <= 27){
					Ex = i;
					break;
				}
			}
			
			//下左方是否有棋子
			for (int i=0;i<32;i++){
				if (playQ[i].isVisible() && play.getX() - playQ[i].getX() == 57 && play.getY() - playQ[i].getY() == -57){
					Move++;
					break;
				}
			}			
			
			//相、象规则
			
			if (Move == 0 && Ey >= 341 && AppConstant.Man > 9){
				//当前记录添加到集合(用于悔棋)
				AppConstant.Var.add(String.valueOf(play.isVisible()));
				AppConstant.Var.add(String.valueOf(play.getX()));
				AppConstant.Var.add(String.valueOf(play.getY()));
				AppConstant.Var.add(String.valueOf(AppConstant.Man));
								
				play.setBounds(Ex,Ey,55,55);
			}
			
			else if (Move == 0 && Ey <= 284 && AppConstant.Man < 10)
			{
				//当前记录添加到集合(用于悔棋)
				AppConstant.Var.add(String.valueOf(play.isVisible()));
				AppConstant.Var.add(String.valueOf(play.getX()));
				AppConstant.Var.add(String.valueOf(play.getY()));
				AppConstant.Var.add(String.valueOf(AppConstant.Man));
				
				play.setBounds(Ex,Ey,55,55);
			}
		}//else if 
		
		//下右
		else if (me.getX() - play.getX() >= 87 &&  me.getX() - play.getX() <= 141 && me.getY() - play.getY() >= 87 && me.getY() - play.getY() <= 141){
			//Y		
			for (int i=56;i<=571;i+=57){
				if (i - me.getY() >= -27 && i - me.getY() <= 27){
					Ey = i;
				}
			}
			
			//X
			for (int i=24;i<=480;i+=57){
				if (i - me.getX() >= -27 && i-me.getX() <= 27){
					Ex = i;
				}
			}
			
			//下右方是否有棋子
			for (int i=0;i<32;i++){
				if (playQ[i].isVisible() && playQ[i].getX() - play.getX() == 57 && playQ[i].getY() - play.getY() == 57){
					Move = 1;
					break;
				}
			}
			
			//相、象规则
			if (Move == 0 && Ey >= 341 && AppConstant.Man > 9){
				//当前记录添加到集合(用于悔棋)
				AppConstant.Var.add(String.valueOf(play.isVisible()));
				AppConstant.Var.add(String.valueOf(play.getX()));
				AppConstant.Var.add(String.valueOf(play.getY()));
				AppConstant.Var.add(String.valueOf(AppConstant.Man));
				
				play.setBounds(Ex,Ey,55,55);
			}
			
			else if (Move == 0 && Ey <= 284 && AppConstant.Man < 10){
				//当前记录添加到集合(用于悔棋)
				AppConstant.Var.add(String.valueOf(play.isVisible()));
				AppConstant.Var.add(String.valueOf(play.getX()));									
				AppConstant.Var.add(String.valueOf(play.getY()));
				AppConstant.Var.add(String.valueOf(AppConstant.Man));
				
				play.setBounds(Ex,Ey,55,55);
			}
			
		}//else
		
	}//相移动规则吉束

	/**相、象吃棋规则*/
	public void elephantRule(JLabel play,JLabel playTake,JLabel playQ[]){
		//障碍
		int Move=0;
		boolean Chess=false;
		
		//吃左上方的棋子
		if (play.getX() - playTake.getX() >= 87 && play.getX() - playTake.getX() <= 141 && play.getY() - playTake.getY() >= 87 && play.getY() - playTake.getY() <= 141){
			//左上方是否有棋子
			for (int i=0;i<32;i++){
				if (playQ[i].isVisible() && play.getX() - playQ[i].getX() == 57 && play.getY() - playQ[i].getY() == 57){
					Move++;
					break;
				}
			}//for
			Chess=true;
		}//if
		//吃右上方的棋子
		else if (playTake.getX() - play.getX() >= 87 && playTake.getX() - play.getX() <= 141 && play.getY() - playTake.getY() >= 87 && play.getY() - playTake.getY() <= 141 ){
			//右上方是否有棋子
			for (int i=0;i<32;i++){
				if (playQ[i].isVisible() &&  playQ[i].getX() - play.getX() == 57 && play.getY() - playQ[i].getY() == 57 ){
					Move++;
					break;
				}
			}//for	
			
			Chess=true;
		}//else
		
		//吃下左方的棋子
		else if (play.getX() - playTake.getX() >= 87 && play.getX() - playTake.getX() <= 141 && playTake.getY() - play.getY() >= 87 && playTake.getY() - play.getY() <= 141){
			//下左方是否有棋子
			for (int i=0;i<32;i++){
				if (playQ[i].isVisible() && play.getX() - playQ[i].getX() == 57 && play.getY() - playQ[i].getY() == -57 ){
					Move++;
					break;
				}
			}//for
			
			Chess=true;
		}//else
		
		//吃下右放的棋子
		else if (playTake.getX() - play.getX() >= 87 && playTake.getX() - play.getX() <= 141 && playTake.getY() - play.getY() >= 87 && playTake.getY() - play.getY() <= 141){
			//下右方是否有棋子
			for (int i=0;i<32;i++){
				if (playQ[i].isVisible() && playQ[i].getX() - play.getX() == 57 && playQ[i].getY() - play.getY() == 57 ){
					Move = 1;
					break;
				}
			}//for		

			Chess=true;
			
		}//else
		
		//没有障碍、并不能吃自己的棋子
		if (Chess && Move == 0 && playTake.getName().charAt(1) != play.getName().charAt(1)){
			//当前记录添加到集合(用于悔棋)
			AppConstant.Var.add(String.valueOf(play.isVisible()));
			AppConstant.Var.add(String.valueOf(play.getX()));
			AppConstant.Var.add(String.valueOf(play.getY()));
			AppConstant.Var.add(String.valueOf(AppConstant.Man));
			
			//当前记录添加到集合(用于悔棋)
			AppConstant.Var.add(String.valueOf(playTake.isVisible()));
			AppConstant.Var.add(String.valueOf(playTake.getX()));
			AppConstant.Var.add(String.valueOf(playTake.getY()));
			AppConstant.Var.add(String.valueOf(AppConstant.i));
			
			playTake.setVisible(false);
			play.setBounds(playTake.getX(),playTake.getY(),55,55);
		}
		
	}//相、象吃棋规则结束
	
	/**士、仕移动方法*/
	public void chapRule(int Man,JLabel play,JLabel playQ[],MouseEvent me){
		//上、右
		if (me.getX() - play.getX() >= 29 && me.getX() - play.getX() <= 114 && play.getY() - me.getY() >= 25 && play.getY() - me.getY() <= 90){
			//士不能超过自己的界限
			if (AppConstant.Man < 14 && (play.getX()+57) >= 195 && (play.getX()+57) <= 309 && (play.getY()-57) <= 170){
				//当前记录添加到集合(用于悔棋)
				AppConstant.Var.add(String.valueOf(play.isVisible()));
				AppConstant.Var.add(String.valueOf(play.getX()));
				AppConstant.Var.add(String.valueOf(play.getY()));
				AppConstant.Var.add(String.valueOf(AppConstant.Man));
				
				play.setBounds(play.getX()+57,play.getY()-57,55,55);
			}	
			
			//仕不能超过自己的界限
			else if (AppConstant.Man > 13 && (play.getY()-57) >= 455 && (play.getX()+57)  >= 195 && (play.getX()+57) <= 309){
				//当前记录添加到集合(用于悔棋)
				AppConstant.Var.add(String.valueOf(play.isVisible()));
				AppConstant.Var.add(String.valueOf(play.getX()));
				AppConstant.Var.add(String.valueOf(play.getY()));
				AppConstant.Var.add(String.valueOf(AppConstant.Man));
				
				play.setBounds(play.getX()+57,play.getY()-57,55,55);
			}	
		}// else if 
		
		//上、左
		else if (play.getX() - me.getX() <= 114 && play.getX() - me.getX() >= 25 && play.getY() - me.getY() >= 20 && play.getY() - me.getY() <= 95){
			//士不能超过自己的界限
			if (AppConstant.Man < 14 &&  (play.getX()-57) >= 195 && (play.getX()-57) <= 309 && (play.getY()-57) <= 170  ){
				//当前记录添加到集合(用于悔棋)
				AppConstant.Var.add(String.valueOf(play.isVisible()));
				AppConstant.Var.add(String.valueOf(play.getX()));
				AppConstant.Var.add(String.valueOf(play.getY()));
				AppConstant.Var.add(String.valueOf(AppConstant.Man));
				
				play.setBounds(play.getX()-57,play.getY()-57,55,55);
			}	
			
			//仕不能超过自己的界限
			else if (AppConstant.Man > 13 &&(play.getY()-57) >= 455 && (play.getX()-57)  >= 195 && (play.getX()-57) <= 309){
				//当前记录添加到集合(用于悔棋)
				AppConstant.Var.add(String.valueOf(play.isVisible()));
				AppConstant.Var.add(String.valueOf(play.getX()));
				AppConstant.Var.add(String.valueOf(play.getY()));
				AppConstant.Var.add(String.valueOf(AppConstant.Man));
				
				play.setBounds(play.getX()-57,play.getY()-57,55,55);
			}	
		}// else if 
		
		//下、左
		else if (play.getX() - me.getX() <= 114 && play.getX() - me.getX() >= 20 && me.getY() - play.getY() >= 2 && me.getY() - play.getY() <= 87){
			//士不能超过自己的界限
			if (AppConstant.Man < 14 && (play.getX()-57) >= 195 && (play.getX()-57) <= 309 && (play.getY()+57) <= 170 ){
				//当前记录添加到集合(用于悔棋)
				AppConstant.Var.add(String.valueOf(play.isVisible()));
				AppConstant.Var.add(String.valueOf(play.getX()));
				AppConstant.Var.add(String.valueOf(play.getY()));
				AppConstant.Var.add(String.valueOf(AppConstant.Man));
				
				play.setBounds(play.getX()-57,play.getY()+57,55,55);
			}	
			
			//仕不能超过自己的界限
			else if (AppConstant.Man > 13 && (play.getY()+57) >= 455 && (play.getX()-57)  >= 195 && (play.getX()-57) <= 309){
				//当前记录添加到集合(用于悔棋)
				AppConstant.Var.add(String.valueOf(play.isVisible()));
				AppConstant.Var.add(String.valueOf(play.getX()));
				AppConstant.Var.add(String.valueOf(play.getY()));
				AppConstant.Var.add(String.valueOf(AppConstant.Man));
				
				play.setBounds(play.getX()-57,play.getY()+57,55,55);
			}
			
		}// else if 
		
		
		//下、右
		else if (me.getX() - play.getX() >= 27 && me.getX() - play.getX() <= 114 && me.getY() - play.getY() >= 2 && me.getY() - play.getY() <= 87){
			//士不能超过自己的界限
			if (AppConstant.Man < 14 && (play.getX()+57) >= 195 && (play.getX()+57) <= 309 && (play.getY()+57) <= 170){
				//当前记录添加到集合(用于悔棋)
				AppConstant.Var.add(String.valueOf(play.isVisible()));
				AppConstant.Var.add(String.valueOf(play.getX()));
				AppConstant.Var.add(String.valueOf(play.getY()));
				AppConstant.Var.add(String.valueOf(AppConstant.Man));
				
				play.setBounds(play.getX()+57,play.getY()+57,55,55);
			}
			
			//仕不能超过自己的界限
			else if (AppConstant.Man > 13 &&(play.getY()+57) >= 455 && (play.getX()+57)  >= 195 && (play.getX()+57) <= 309){
				//当前记录添加到集合(用于悔棋)
				AppConstant.Var.add(String.valueOf(play.isVisible()));
				AppConstant.Var.add(String.valueOf(play.getX()));
				AppConstant.Var.add(String.valueOf(play.getY()));
				AppConstant.Var.add(String.valueOf(AppConstant.Man));
				
				play.setBounds(play.getX()+57,play.getY()+57,55,55);
			}
		}//else if 
		
	}//士、仕移动规则结束


	/**士、仕吃棋规则*/
	public void chapRule(int Man ,JLabel play,JLabel playTake,JLabel playQ[]){
		//当前状态
		boolean Chap = false;	
		
		//上、右
		if (playTake.getX() - play.getX() >= 20 && playTake.getX() - play.getX() <= 114 && play.getY() - playTake.getY() >= 2 && play.getY() - playTake.getY() <= 87){
			//被吃的棋子是否和当前士相近
			if (AppConstant.Man < 14 && playTake.getX() >= 195 && playTake.getX() <= 309 && playTake.getY() <= 170 && playTake.isVisible()){
				Chap = true;
			}
			
			//被吃的棋子是否和当前仕相近
			else if (AppConstant.Man > 13 && playTake.getX() >= 195 && playTake.getX() <= 309 && playTake.getY() >= 455 && playTake.isVisible()){
				Chap = true;
			}
		}//if
		
		//上、左
		else if (play.getX() - playTake.getX() <= 114 && play.getX() - playTake.getX() >= 25 && play.getY() - playTake.getY() >= 2 && play.getY() - playTake.getY() <= 87){
			//被吃的棋子是否和当前士相近
			if (AppConstant.Man < 14 && playTake.getX() >= 195 && playTake.getX() <= 309 && playTake.getY() <= 170 && playTake.isVisible()){
				Chap = true;
			}
			
			//被吃的棋子是否和当前仕相近
			else if (AppConstant.Man > 13 && playTake.getX() >= 195 && playTake.getX() <= 309 && playTake.getY() >= 455 && playTake.isVisible()){
				Chap = true;
			}
		}// else if 
		
		//下、左
		else if (play.getX() - playTake.getX() <= 114 && play.getX() - playTake.getX() >= 25 && playTake.getY() - play.getY() >= 2 && playTake.getY() - play.getY() <= 87){
			//被吃的棋子是否和当前士相近
			if (AppConstant.Man < 14 && playTake.getX() >= 195 && playTake.getX() <= 309 && playTake.getY() <= 170 && playTake.isVisible()){
				Chap = true;
			}
			
			//被吃的棋子是否和当前仕相近
			else if (AppConstant.Man > 13 && playTake.getX() >= 195 && playTake.getX() <= 309 && playTake.getY() >= 455 && playTake.isVisible()){
				Chap = true;
			}
		}// else if 
		
		//下、右
		else if (playTake.getX() - play.getX() >= 25 && playTake.getX() - play.getX() <= 114 && playTake.getY() - play.getY() >= 2 && playTake.getY() - play.getY() <= 87){
			//被吃的棋子是否和当前士相近
			if (AppConstant.Man < 14 && playTake.getX() >= 195 && playTake.getX() <= 309 && playTake.getY() <= 170 && playTake.isVisible()){
				Chap = true;
			}
			
			//被吃的棋子是否和当前仕相近
			else if (AppConstant.Man > 13 && playTake.getX() >= 195 && playTake.getX() <= 309 && playTake.getY() >= 455 && playTake.isVisible()){
				Chap = true;
			}
		}//else if 
		
		//可移动、并不能吃自己的棋子
		if (Chap && playTake.getName().charAt(1) != play.getName().charAt(1)){
			//当前记录添加到集合(用于悔棋)
			AppConstant.Var.add(String.valueOf(play.isVisible()));
			AppConstant.Var.add(String.valueOf(play.getX()));
			AppConstant.Var.add(String.valueOf(play.getY()));
			AppConstant.Var.add(String.valueOf(AppConstant.Man));
			
			//当前记录添加到集合(用于悔棋)
			AppConstant.Var.add(String.valueOf(playTake.isVisible()));
			AppConstant.Var.add(String.valueOf(playTake.getX()));
			AppConstant.Var.add(String.valueOf(playTake.getY()));
			AppConstant.Var.add(String.valueOf(AppConstant.i));
			
			playTake.setVisible(false);
			play.setBounds(playTake.getX(),playTake.getY(),55,55);
		}
		
	}//士、仕吃棋规则结束
	
	/**将移动规则*/
	public void willRule(int Man,JLabel play,JLabel playQ[],MouseEvent me){
		//向上
		if ((me.getX()-play.getX()) >= 0 && (me.getX()-play.getX()) <= 55 && (play.getY()-me.getY()) >=2 && play.getY()-me.getY() <= 87){
			//将是否超过自己的界限
			if (AppConstant.Man == 30 && me.getX() >= 195 && me.getX() <= 359 && me.getY() <= 170){
				//当前记录添加到集合(用于悔棋)
				AppConstant.Var.add(String.valueOf(play.isVisible()));
				AppConstant.Var.add(String.valueOf(play.getX()));
				AppConstant.Var.add(String.valueOf(play.getY()));
				AppConstant.Var.add(String.valueOf(AppConstant.Man));
				
				play.setBounds(play.getX(),play.getY()-57,55,55);	
			}	
			
			//帅是否超过自己的界限
			else if (AppConstant.Man == 31 && me.getY() >= 455 && me.getX() >= 195 && me.getX() <= 359){
				//当前记录添加到集合(用于悔棋)
				AppConstant.Var.add(String.valueOf(play.isVisible()));
				AppConstant.Var.add(String.valueOf(play.getX()));
				AppConstant.Var.add(String.valueOf(play.getY()));
				AppConstant.Var.add(String.valueOf(AppConstant.Man));
				
				play.setBounds(play.getX(),play.getY()-57,55,55);
			}
		}//if
		
		//向左
		else if (play.getX() - me.getX() >= 2 && play.getX() - me.getX() <= 57 && me.getY() - play.getY() <= 27 && me.getY() - play.getY() >= -27){
			//将是否超过自己的界限
			if (AppConstant.Man == 30 && me.getX() >= 195 && me.getX() <= 359 && me.getY() <= 170){
				//当前记录添加到集合(用于悔棋)
				AppConstant.Var.add(String.valueOf(play.isVisible()));
				AppConstant.Var.add(String.valueOf(play.getX()));
				AppConstant.Var.add(String.valueOf(play.getY()));
				AppConstant.Var.add(String.valueOf(AppConstant.Man));
				
				play.setBounds(play.getX()-57,play.getY(),55,55);
			}
			
			//帅是否超过自己的界限
			else if (AppConstant.Man == 31 && me.getY() >= 455 && me.getX() >= 195 && me.getX() <= 359){
				//当前记录添加到集合(用于悔棋)
				AppConstant.Var.add(String.valueOf(play.isVisible()));
				AppConstant.Var.add(String.valueOf(play.getX()));
				AppConstant.Var.add(String.valueOf(play.getY()));
				AppConstant.Var.add(String.valueOf(AppConstant.Man));
				
				play.setBounds(play.getX()-57,play.getY(),55,55);
			}
		}//else if 
		
		//向右
		else if (me.getX() - play.getX() >= 57 && me.getX() - play.getX() <= 112 && me.getY() - play.getY() <= 27 && me.getY() - play.getY() >= -27){
			//将、帅规则
			if (AppConstant.Man == 30 && me.getX() >= 195 && me.getX() <= 359 && me.getY() <= 170){
				//当前记录添加到集合(用于悔棋)
				AppConstant.Var.add(String.valueOf(play.isVisible()));
				AppConstant.Var.add(String.valueOf(play.getX()));
				AppConstant.Var.add(String.valueOf(play.getY()));
				AppConstant.Var.add(String.valueOf(AppConstant.Man));
				
				play.setBounds(play.getX()+57,play.getY(),55,55);	
			}	
			
			else if (AppConstant.Man == 31 && me.getY() >= 455 && me.getX() >= 195 && me.getX() <= 359){
				//当前记录添加到集合(用于悔棋)
				AppConstant.Var.add(String.valueOf(play.isVisible()));
				AppConstant.Var.add(String.valueOf(play.getX()));	
				AppConstant.Var.add(String.valueOf(play.getY()));
				AppConstant.Var.add(String.valueOf(AppConstant.Man));
				
				play.setBounds(play.getX()+57,play.getY(),55,55);
			}
		}//else if 
		
		//向下
		else if (me.getX() - play.getX() >= 0 && me.getX() - play.getX() <= 55 && me.getY() - play.getY() <= 87 && me.getY() - play.getY() >= 27){
			//将、帅规则
			if (AppConstant.Man == 30 && me.getX() >= 195 && me.getX() <= 359 && me.getY() <= 170){
				//当前记录添加到集合(用于悔棋)
				AppConstant.Var.add(String.valueOf(play.isVisible()));
				AppConstant.Var.add(String.valueOf(play.getX()));
				AppConstant.Var.add(String.valueOf(play.getY()));
				AppConstant.Var.add(String.valueOf(AppConstant.Man));
				
				play.setBounds(play.getX(),play.getY()+57,55,55);
			}
			
			else if (AppConstant.Man == 31 && me.getY() >= 455 && me.getX() >= 195 && me.getX() <= 359){
				//当前记录添加到集合(用于悔棋)
				AppConstant.Var.add(String.valueOf(play.isVisible()));
				AppConstant.Var.add(String.valueOf(play.getX()));
				AppConstant.Var.add(String.valueOf(play.getY()));
				AppConstant.Var.add(String.valueOf(AppConstant.Man));
			
				play.setBounds(play.getX(),play.getY()+57,55,55);
			}
		}
	}//将、帅移动规则结束

	public void willRule(int Man ,JLabel play,JLabel playTake ,JLabel playQ[]){
		//当前状态
		boolean will = false;
		
		//向上吃
		if (play.getX() - playTake.getX() >= 0 && play.getX() - playTake.getX() <= 55 && play.getY() - playTake.getY() >= 27 && play.getY() - playTake.getY() <= 87 && playTake.isVisible()){
			//被吃的棋子是否和当前将相近
			if (AppConstant.Man == 30 && playTake.getX() >= 195 && playTake.getX() <= 309 && playTake.getY() <= 170){
				will = true;
			}
			
			//被吃的棋子是否和当前帅相近
			else if (AppConstant.Man == 31 && playTake.getY() >= 455 && playTake.getX() >= 195 && playTake.getX() <= 309){
				will = true; 
			}
		}
		
		//向左吃
		else if (play.getX() - playTake.getX() >= 2 && play.getX() - playTake.getX() <= 57 && playTake.getY() - play.getY() <= 27 && playTake.getY() - play.getY() >= -27 && playTake.isVisible()){
			//被吃的棋子是否和当前将相近
			if (AppConstant.Man == 30 && playTake.getX() >= 195 && playTake.getX() <= 309 && playTake.getY() <= 170){
				will = true;
			}
			
			//被吃的棋子是否和当前帅相近
			else if (AppConstant.Man == 31 && playTake.getY() >= 455 && playTake.getX() >= 195 && playTake.getX() <= 309){
				will = true; 
			}
		}
		
		//向右吃
		else if (playTake.getX() - play.getX() >= 2 && playTake.getX() - play.getX() <= 57 && playTake.getY() - play.getY() <= 27 && playTake.getY() - play.getY() >= -27 && playTake.isVisible()){
			//被吃的棋子是否和当前将相近
			if (AppConstant.Man == 30 && playTake.getX() >= 195 && playTake.getX() <= 309 && playTake.getY() <= 170){
				will = true;
			}
			
			//被吃的棋子是否和当前帅相近
			else if (AppConstant.Man == 31 && playTake.getY() >= 455 && playTake.getX() >= 195 && playTake.getX() <= 309){
				will = true; 
			}
		}
		
		//向下
		else if (playTake.getX() - play.getX() >= 0 && playTake.getX() - play.getX() <= 87 && playTake.getY() - play.getY() <= 27 && playTake.getY() - play.getY() >= 40 && playTake.isVisible()){
			//被吃的棋子是否和当前将相近
			if (AppConstant.Man == 30 && playTake.getX() >= 195 && playTake.getX() <= 309 && playTake.getY() <= 170){
				will = true;
			}
			
			//被吃的棋子是否和当前帅相近
			else if (AppConstant.Man == 31 && playTake.getY() >= 455 && playTake.getX() >= 195 && playTake.getX() <= 309){
				will = true; 
			}
		}
			
		//不能吃自己的棋子、符合当前要求	
		if (playTake.getName().charAt(1) != play.getName().charAt(1) && will){
			//当前记录添加到集合(用于悔棋)
			AppConstant.Var.add(String.valueOf(play.isVisible()));
			AppConstant.Var.add(String.valueOf(play.getX()));
			AppConstant.Var.add(String.valueOf(play.getY()));
			AppConstant.Var.add(String.valueOf(AppConstant.Man));
			
			//当前记录添加到集合(用于悔棋)
			AppConstant.Var.add(String.valueOf(playTake.isVisible()));
			AppConstant.Var.add(String.valueOf(playTake.getX()));
			AppConstant.Var.add(String.valueOf(playTake.getY()));
			AppConstant.Var.add(String.valueOf(AppConstant.i));

			playTake.setVisible(false);
			play.setBounds(playTake.getX(),playTake.getY(),55,55);
		}			
	}//将、帅吃规则结束
}//规则类
