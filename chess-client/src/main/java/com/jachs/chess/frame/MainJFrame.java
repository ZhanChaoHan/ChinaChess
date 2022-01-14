package com.jachs.chess.frame;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.UIManager;

import com.jachs.chess.AppConstant;
import com.jachs.chess.ChessRule;
import com.jachs.chess.event.mainframe.MainJFrameEvent;
import com.jachs.chess.event.mainframe.MainJFramePicecClickEvent;
import com.jachs.chess.event.mainframe.MainMouseStyleEvent;


/***
 * 主窗体
 * @author zhanchaohan
 *
 */
public class MainJFrame extends JFrame {
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
			AppConstant.con = this.getContentPane();
			AppConstant.con.setLayout(null);
			//实例化规则类
			AppConstant.rule = new ChessRule();
			
			//创建工具栏
			AppConstant.jmain = new JToolBar();
			AppConstant.text = new JLabel("欢迎使用象棋对弈系统");
			//当鼠标放上显示信息
			AppConstant.text.setToolTipText("信息提示");
			AppConstant.anew = new JButton(" 新 游 戏 ");
			AppConstant.anew.setToolTipText("重新开始新的一局");
			AppConstant.exit = new JButton(" 退  出 ");
			AppConstant.exit.setToolTipText("退出象棋程序程序");
			AppConstant.repent = new JButton(" 悔  棋 ");
			AppConstant.repent.setToolTipText("返回到上次走棋的位置");

			//把组件添加到工具栏
			AppConstant.jmain.setLayout(new GridLayout(0,4));
			AppConstant.jmain.add(AppConstant.anew);
			AppConstant.jmain.add(AppConstant.repent);
			AppConstant.jmain.add(AppConstant.exit);
			AppConstant.jmain.add(AppConstant.text);
			AppConstant.jmain.setBounds(0,0,558,30);
			AppConstant.con.add(AppConstant.jmain);
			
			//添加棋子标签
			drawChessMan();

			MainJFrameEvent mjEvent=new MainJFrameEvent();//面板事件
			MainJFramePicecClickEvent mjcEvent=new MainJFramePicecClickEvent();//棋子点击事件
			//注册按扭监听
			AppConstant.anew.addActionListener(mjEvent);
			AppConstant.repent.addActionListener(mjEvent);
			AppConstant.exit.addActionListener(mjEvent);

			//注册棋子移动监听
			for (int i=0;i<32;i++){
				AppConstant.con.add(AppConstant.play[i]);
				AppConstant.play[i].addMouseListener(mjcEvent);
			}
			
			//添加棋盘标签
			AppConstant.con.add(AppConstant.image = new JLabel(new ImageIcon(MainJFrame.class.getResource("/image/main.gif"))));
			AppConstant.image.setBounds(0,30,558,620);
			AppConstant.image.addMouseListener(mjcEvent);
			
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
			this.setVisible(false);
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
				AppConstant.play[i].setName("黑车");
			}
			//马
			in = new ImageIcon(MainJFrame.class.getResource("/image/黑马.gif"));
			for (i=4,k=81;i<6;i++,k+=342){
				AppConstant.play[i] = new JLabel(in);
				AppConstant.play[i].setBounds(k,56,55,55);
				AppConstant.play[i].setName("黑马");
			}
			//相
			in = new ImageIcon(MainJFrame.class.getResource("/image/黑象.gif"));
			for (i=8,k=138;i<10;i++,k+=228){
				AppConstant.play[i] = new JLabel(in);
				AppConstant.play[i].setBounds(k,56,55,55);
				AppConstant.play[i].setName("黑象");
			}
			//士
			in = new ImageIcon(MainJFrame.class.getResource("/image/黑士.gif"));
			for (i=12,k=195;i<14;i++,k+=114){
				AppConstant.play[i] = new JLabel(in);
				AppConstant.play[i].setBounds(k,56,55,55);
				AppConstant.play[i].setName("黑士");
			}
			//卒
			in = new ImageIcon(MainJFrame.class.getResource("/image/黑卒.gif"));
			for (i=16,k=24;i<21;i++,k+=114){
				AppConstant.play[i] = new JLabel(in);
				AppConstant.play[i].setBounds(k,227,55,55);
				AppConstant.play[i].setName("黑卒");
			}
			//炮
			in = new ImageIcon(MainJFrame.class.getResource("/image/黑炮.gif"));	
			for (i=26,k=81;i<28;i++,k+=342){
				AppConstant.play[i] = new JLabel(in);
				AppConstant.play[i].setBounds(k,170,55,55);
				AppConstant.play[i].setName("黑炮");
			}
			//将
			in = new ImageIcon(MainJFrame.class.getResource("/image/黑将.gif"));
			AppConstant.play[30] = new JLabel(in);
			AppConstant.play[30].setBounds(252,56,55,55);
			AppConstant.play[30].setName("黑将");

			//红色棋子
			//车
			in = new ImageIcon(MainJFrame.class.getResource("/image/红车.gif"));
			for (i=2,k=24;i<4;i++,k+=456){
				AppConstant.play[i] = new JLabel(in);
				AppConstant.play[i].setBounds(k,569,55,55);
				AppConstant.play[i].setName("红车");
			}
			//马
			in = new ImageIcon(MainJFrame.class.getResource("/image/红马.gif"));
			for (i=6,k=81;i<8;i++,k+=342){
				AppConstant.play[i] = new JLabel(in);
				AppConstant.play[i].setBounds(k,569,55,55);
				AppConstant.play[i].setName("红马");
			}
			//相
			in = new ImageIcon(MainJFrame.class.getResource("/image/红象.gif"));
			for (i=10,k=138;i<12;i++,k+=228){
				AppConstant.play[i] = new JLabel(in);
				AppConstant.play[i].setBounds(k,569,55,55);
				AppConstant.play[i].setName("红象");
			}
			//士
			in = new ImageIcon(MainJFrame.class.getResource("/image/红士.gif"));
			for (i=14,k=195;i<16;i++,k+=114){
				AppConstant.play[i] = new JLabel(in);
				AppConstant.play[i].setBounds(k,569,55,55);
				AppConstant.play[i].setName("红士");
			}
			//兵
			in = new ImageIcon(MainJFrame.class.getResource("/image/红卒.gif"));
			for (i=21,k=24;i<26;i++,k+=114){
				AppConstant.play[i] = new JLabel(in);
				AppConstant.play[i].setBounds(k,398,55,55);
				AppConstant.play[i].setName("红卒");
			}
			//炮
			in = new ImageIcon(MainJFrame.class.getResource("/image/红炮.gif"));
			for (i=28,k=81;i<30;i++,k+=342){
				AppConstant.play[i] = new JLabel(in);
				AppConstant.play[i].setBounds(k,455,55,55);
				AppConstant.play[i].setName("红炮");
			}
			//帅
			in = new ImageIcon(MainJFrame.class.getResource("/image/红将.gif"));
			AppConstant.play[31] = new JLabel(in);
			AppConstant.play[31].setBounds(252,569,55,55);
			AppConstant.play[31].setName("红将");
			
//			//添加样式
			for (int kk = 0; kk <AppConstant.play.length; kk++) {
				AppConstant.play[kk].addMouseListener(new MainMouseStyleEvent());
			}
		}
		
}
