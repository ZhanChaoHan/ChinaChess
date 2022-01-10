package com.jachs.chess.frame;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.UIManager;

import com.jachs.chess.AppConstant;
import com.jachs.chess.ChessRule;
import com.jachs.chess.thread.MainJFrameThread;


/***
 * 主窗体
 * @author zhanchaohan
 *
 */
public class MainJFrame extends JFrame implements ActionListener,MouseListener{
		//棋盘
		JLabel image;	
		//窗格
		Container con;
		//重新开始
		JButton anew;
		//悔棋
		JButton repent;
		//退出
		JButton exit;
		//规则类对象(使于调用方法)
		ChessRule rule;
		
		
		/**
		** 构造函数
		** 初始化图形用户界面
		*/
		public MainJFrame(String Title){
			//改变系统默认字体
			Font font = new Font("Dialog", Font.PLAIN, 12);
			java.util.Enumeration keys = UIManager.getDefaults().keys();
			while (keys.hasMoreElements()) {
				Object key = keys.nextElement();
				Object value = UIManager.get(key);
				if (value instanceof javax.swing.plaf.FontUIResource) {
					UIManager.put(key, font);
				}
			}
			//获行客格引用
			con = this.getContentPane();
			con.setLayout(null);
			//实例化规则类
			rule = new ChessRule();
			
			//创建工具栏
			AppConstant.jmain = new JToolBar();
			AppConstant.text = new JLabel("欢迎使用象棋对弈系统");
			//当鼠标放上显示信息
			AppConstant.text.setToolTipText("信息提示");
			anew = new JButton(" 新 游 戏 ");
			anew.setToolTipText("重新开始新的一局");
			exit = new JButton(" 退  出 ");
			exit.setToolTipText("退出象棋程序程序");
			repent = new JButton(" 悔  棋 ");
			repent.setToolTipText("返回到上次走棋的位置");

			//把组件添加到工具栏
			AppConstant.jmain.setLayout(new GridLayout(0,4));
			AppConstant.jmain.add(anew);
			AppConstant.jmain.add(repent);
			AppConstant.jmain.add(exit);
			AppConstant.jmain.add(AppConstant.text);
			AppConstant.jmain.setBounds(0,0,558,30);
			con.add(AppConstant.jmain);
			
			//添加棋子标签
			drawChessMan();

			//注册按扭监听
			anew.addActionListener(this);
			repent.addActionListener(this);
			exit.addActionListener(this);		
					
			//注册棋子移动监听
			for (int i=0;i<32;i++){
				con.add(AppConstant.play[i]);
				AppConstant.play[i].addMouseListener(this);
			}
			
			//添加棋盘标签
			con.add(image = new JLabel(new ImageIcon(MainJFrame.class.getResource("/image/main.gif"))));
			image.setBounds(0,30,558,620);
			image.addMouseListener(this);
			
			//注册窗体关闭监听
			this.addWindowListener(
				new WindowAdapter() {
					public void windowClosing(WindowEvent we){
						System.exit(0);
					}
				}
			);
			
			//窗体居中
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			Dimension frameSize = this.getSize();
			
			if (frameSize.height > screenSize.height){
				frameSize.height = screenSize.height;
			}
			if (frameSize.width > screenSize.width){
				frameSize.width = screenSize.width;
			}
			
			this.setLocation((screenSize.width - frameSize.width) / 2 - 280 ,(screenSize.height - frameSize.height ) / 2 - 350);
		
			//设置
			this.setIconImage(new ImageIcon(MainJFrame.class.getResource("/image/红将.gif")).getImage());
			this.setResizable(false);
			this.setTitle(Title);
			this.setSize(558,670);
			this.show();
		}
		
		/**
		** 添加棋子方法
		*/
		public void drawChessMan(){
			//流程控制
			int i,k;
			//图标
			Icon in;
					
			//黑色棋子
			//车
			in = new ImageIcon(MainJFrame.class.getResource("/image/黑车.gif"));
			for (i=0,k=24;i<2;i++,k+=456){		
				AppConstant.play[i] = new JLabel(in);
				AppConstant.play[i].setBounds(k,56,55,55);	
				AppConstant.play[i].setName("车1");			
			}	
			//马
			in = new ImageIcon(MainJFrame.class.getResource("/image/黑马.gif"));
			for (i=4,k=81;i<6;i++,k+=342){	
				AppConstant.play[i] = new JLabel(in);
				AppConstant.play[i].setBounds(k,56,55,55);
				AppConstant.play[i].setName("马1");
			}
			//相
			in = new ImageIcon(MainJFrame.class.getResource("/image/黑象.gif"));
			for (i=8,k=138;i<10;i++,k+=228){	
				AppConstant.play[i] = new JLabel(in);
				AppConstant.play[i].setBounds(k,56,55,55);
				AppConstant.play[i].setName("象1");
			}
			//士
			in = new ImageIcon(MainJFrame.class.getResource("/image/黑士.gif"));
			for (i=12,k=195;i<14;i++,k+=114){
				AppConstant.play[i] = new JLabel(in);
				AppConstant.play[i].setBounds(k,56,55,55);
				AppConstant.play[i].setName("士1");
			}
			//卒
			in = new ImageIcon(MainJFrame.class.getResource("/image/黑卒.gif"));
			for (i=16,k=24;i<21;i++,k+=114){
				AppConstant.play[i] = new JLabel(in);
				AppConstant.play[i].setBounds(k,227,55,55);
				AppConstant.play[i].setName("卒1" + i);
			}
			//炮
			in = new ImageIcon(MainJFrame.class.getResource("/image/黑炮.gif"));			
			for (i=26,k=81;i<28;i++,k+=342){
				AppConstant.play[i] = new JLabel(in);
				AppConstant.play[i].setBounds(k,170,55,55);
				AppConstant.play[i].setName("炮1" + i);
			}
			//将
			in = new ImageIcon(MainJFrame.class.getResource("/image/黑将.gif"));
			AppConstant.play[30] = new JLabel(in);
			AppConstant.play[30].setBounds(252,56,55,55);
			AppConstant.play[30].setName("将1");

			//红色棋子
			//车
			in = new ImageIcon(MainJFrame.class.getResource("/image/红车.gif"));
			for (i=2,k=24;i<4;i++,k+=456){
				AppConstant.play[i] = new JLabel(in);
				AppConstant.play[i].setBounds(k,569,55,55);
				AppConstant.play[i].setName("车2");
			}
			//马
			in = new ImageIcon(MainJFrame.class.getResource("/image/红马.gif"));
			for (i=6,k=81;i<8;i++,k+=342){
				AppConstant.play[i] = new JLabel(in);
				AppConstant.play[i].setBounds(k,569,55,55);
				AppConstant.play[i].setName("马2");
			}
			//相
			in = new ImageIcon(MainJFrame.class.getResource("/image/红象.gif"));			
			for (i=10,k=138;i<12;i++,k+=228){
				AppConstant.play[i] = new JLabel(in);
				AppConstant.play[i].setBounds(k,569,55,55);
				AppConstant.play[i].setName("象2");
			}
			//士
			in = new ImageIcon(MainJFrame.class.getResource("/image/红士.gif"));
			for (i=14,k=195;i<16;i++,k+=114){
				AppConstant.play[i] = new JLabel(in);
				AppConstant.play[i].setBounds(k,569,55,55);
				AppConstant.play[i].setName("士2");
			}
			//兵
			in = new ImageIcon(MainJFrame.class.getResource("/image/红卒.gif"));
			for (i=21,k=24;i<26;i++,k+=114){
				AppConstant.play[i] = new JLabel(in);
				AppConstant.play[i].setBounds(k,398,55,55);
				AppConstant.play[i].setName("卒2" + i);
			}
			//炮
			in = new ImageIcon(MainJFrame.class.getResource("/image/红炮.gif"));
			for (i=28,k=81;i<30;i++,k+=342){
				AppConstant.play[i] = new JLabel(in);
				AppConstant.play[i].setBounds(k,455,55,55);
				AppConstant.play[i].setName("炮2" + i);
			}
			//帅
			in = new ImageIcon(MainJFrame.class.getResource("/image/红将.gif"));			
			AppConstant.play[31] = new JLabel(in);
			AppConstant.play[31].setBounds(252,569,55,55);		
			AppConstant.play[31].setName("帅2");
		}
		
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
			if (me.getSource().equals(image)){
				//该红棋走棋的时候
				if (AppConstant.chessPlayClick == 2 && AppConstant.play[AppConstant.Man].getName().charAt(1) == '2'){	
					Ex = AppConstant.play[AppConstant.Man].getX();
					Ey = AppConstant.play[AppConstant.Man].getY();
					//移动卒、兵
					if (AppConstant.Man > 15 && AppConstant.Man < 26){
						rule.armsRule(AppConstant.Man,AppConstant.play[AppConstant.Man],me);
					}
					//移动炮
					else if (AppConstant.Man > 25 && AppConstant.Man < 30){			
						rule.cannonRule(AppConstant.play[AppConstant.Man],AppConstant.play,me);
					}
					//移动车
					else if (AppConstant.Man >=0 && AppConstant.Man < 4){
						rule.cannonRule(AppConstant.play[AppConstant.Man],AppConstant.play,me);
					}
					//移动马
					else if (AppConstant.Man > 3 && AppConstant.Man < 8){
						rule.horseRule(AppConstant.play[AppConstant.Man],AppConstant.play,me);
					}
					//移动相、象
					else if (AppConstant.Man > 7 && AppConstant.Man < 12){
						rule.elephantRule(AppConstant.Man,AppConstant.play[AppConstant.Man],AppConstant.play,me);
					}else if (AppConstant.Man > 11 && AppConstant.Man < 16){//移动仕、士
						rule.chapRule(AppConstant.Man,AppConstant.play[AppConstant.Man],AppConstant.play,me);
					}else if (AppConstant.Man == 30 || AppConstant.Man == 31){//移动将、帅			
						rule.willRule(AppConstant.Man,AppConstant.play[AppConstant.Man],AppConstant.play,me);
					}
					//是否走棋错误(是否在原地没有动)
					if (Ex == AppConstant.play[AppConstant.Man].getX() && Ey == AppConstant.play[AppConstant.Man].getY()){
						AppConstant.text.setText("               红棋走棋");
						AppConstant.chessPlayClick=2;
					}else {
						AppConstant.text.setText("               黑棋走棋");
						AppConstant.chessPlayClick=1;
					}
				}//if
				//该黑棋走棋的时候
				else if (AppConstant.chessPlayClick == 1 && AppConstant.play[AppConstant.Man].getName().charAt(1) == '1'){
					Ex = AppConstant.play[AppConstant.Man].getX();
					Ey = AppConstant.play[AppConstant.Man].getY();

					//移动卒、兵
					if (AppConstant.Man > 15 && AppConstant.Man < 26){
						rule.armsRule(AppConstant.Man,AppConstant.play[AppConstant.Man],me);
					}
					
					//移动炮
					else if (AppConstant.Man > 25 && AppConstant.Man < 30){
						rule.cannonRule(AppConstant.play[AppConstant.Man],AppConstant.play,me);
					}
					
					//移动车
					else if (AppConstant.Man >=0 && AppConstant.Man < 4){
						rule.cannonRule(AppConstant.play[AppConstant.Man],AppConstant.play,me);
					}
					
					//移动马
					else if (AppConstant.Man > 3 && AppConstant.Man < 8){
						rule.horseRule(AppConstant.play[AppConstant.Man],AppConstant.play,me);
					}
					
					//移动相、象
					else if (AppConstant.Man > 7 && AppConstant.Man < 12){
						rule.elephantRule(AppConstant.Man,AppConstant.play[AppConstant.Man],AppConstant.play,me);
					}
					
					//移动仕、士
					else if (AppConstant.Man > 11 && AppConstant.Man < 16){
						rule.chapRule(AppConstant.Man,AppConstant.play[AppConstant.Man],AppConstant.play,me);
					}
					//移动将、帅
					else if (AppConstant.Man == 30 || AppConstant.Man == 31){
						rule.willRule(AppConstant.Man,AppConstant.play[AppConstant.Man],AppConstant.play,me);
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
				}//else if		
				//当前没有操作(停止闪烁)
				AppConstant.chessManClick=false;
			}//if
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
					}//for
				}//if
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
									rule.armsRule(AppConstant.play[AppConstant.Man],AppConstant.play[AppConstant.i]);
								}
								//炮吃规则
								else if (AppConstant.Man > 25 && AppConstant.Man < 30){
									rule.cannonRule(0,AppConstant.play[AppConstant.Man],AppConstant.play[AppConstant.i],AppConstant.play,me);
								}
								//车吃规则
								else if (AppConstant.Man >=0 && AppConstant.Man < 4){
									rule.cannonRule(1,AppConstant.play[AppConstant.Man],AppConstant.play[AppConstant.i],AppConstant.play,me);
								}
								//马吃规则
								else if (AppConstant.Man > 3 && AppConstant.Man < 8){
									rule.horseRule(AppConstant.play[AppConstant.Man],AppConstant.play[AppConstant.i],AppConstant.play,me);	
								}
								//相、象吃规则
								else if (AppConstant.Man > 7 && AppConstant.Man < 12){
									rule.elephantRule(AppConstant.play[AppConstant.Man],AppConstant.play[AppConstant.i],AppConstant.play);
								}
								//士、仕吃棋规则
								else if (AppConstant.Man > 11 && AppConstant.Man < 16){
									rule.chapRule(AppConstant.Man,AppConstant.play[AppConstant.Man],AppConstant.play[AppConstant.i],AppConstant.play);
								}
								//将、帅吃棋规则
								else if (AppConstant.Man == 30 || AppConstant.Man == 31){
									rule.willRule(AppConstant.Man,AppConstant.play[AppConstant.Man],AppConstant.play[AppConstant.i],AppConstant.play);
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
							}//if
							//该黑棋吃棋的时候
							else if (AppConstant.chessPlayClick == 1 && AppConstant.play[AppConstant.Man].getName().charAt(1) == '1'){
								Ex = AppConstant.play[AppConstant.Man].getX();
								Ey = AppConstant.play[AppConstant.Man].getY();
														
								//卒吃规则
								if (AppConstant.Man > 15 && AppConstant.Man < 26){
									rule.armsRule(AppConstant.play[AppConstant.Man],AppConstant.play[AppConstant.i]);
								}
								
								//炮吃规则
								else if (AppConstant.Man > 25 && AppConstant.Man < 30){
									rule.cannonRule(0,AppConstant.play[AppConstant.Man],AppConstant.play[AppConstant.i],AppConstant.play,me);
								}
								
								//车吃规则
								else if (AppConstant.Man >=0 && AppConstant.Man < 4){
									rule.cannonRule(1,AppConstant.play[AppConstant.Man],AppConstant.play[AppConstant.i],AppConstant.play,me);	
								}
								
								//马吃规则
								else if (AppConstant.Man > 3 && AppConstant.Man < 8){
									rule.horseRule(AppConstant.play[AppConstant.Man],AppConstant.play[AppConstant.i],AppConstant.play,me);
								}
								
								//相、象吃规则
								else if (AppConstant.Man > 7 && AppConstant.Man < 12){
									rule.elephantRule(AppConstant.play[AppConstant.Man],AppConstant.play[AppConstant.i],AppConstant.play);
								}
								
								//士、仕吃棋规则
								else if (AppConstant.Man > 11 && AppConstant.Man < 16){
									rule.chapRule(AppConstant.Man,AppConstant.play[AppConstant.Man],AppConstant.play[AppConstant.i],AppConstant.play);
								}
								
								//将、帅吃棋规则
								else if (AppConstant.Man == 30 || AppConstant.Man == 31){
									rule.willRule(AppConstant.Man,AppConstant.play[AppConstant.Man],AppConstant.play[AppConstant.i],AppConstant.play);
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
							this,"黑棋胜利","玩家一胜利",
							JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
						//双方都不可以在走棋了
						AppConstant.chessPlayClick=3;
						AppConstant.text.setText("  黑棋胜利");
					}else if (!AppConstant.play[30].isVisible()){
						JOptionPane.showConfirmDialog(
							this,"红棋胜利","玩家二胜利",
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
		
		/**
		** 定义按钮的事件响应
		*/
		public void actionPerformed(ActionEvent ae) {
			//重新开始按钮
			if (ae.getSource().equals(anew)){
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
			else if (ae.getSource().equals(repent)){
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
			else if (ae.getSource().equals(exit)){
				int j=JOptionPane.showConfirmDialog(
					this,"真的要退出吗?","退出",
					JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE);
				
				if (j == JOptionPane.YES_OPTION){
					System.exit(0);
				}
			}
		}
}
