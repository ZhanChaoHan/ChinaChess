package com.jachs.chess;

import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JToolBar;

/***
 * 多线程常量池
 * @author zhanchaohan
 *
 */
public class AppConstant {
/*--------------------MainJFrame---------------------**/
	//保存当前操作
	public static Vector Var=new Vector();
	//把第一次的单击棋子给线程响应
	public static int Man,i;
	/**
	** 单击棋子
	** chessManClick = true 闪烁棋子 并给线程响应
	** chessManClick = false 吃棋子 停止闪烁  并给线程响应
	*/
	public static boolean chessManClick;
	
	/**
	** 控制玩家走棋
	** chessPlayClick=1 黑棋走棋
	** chessPlayClick=2 红棋走棋 默认红棋
	** chessPlayClick=3 双方都不能走棋
	*/
	public static int chessPlayClick=2;
	//控制棋子闪烁的线程
	public static Thread tmain;
	//玩家
	public static JLabel play[] = new JLabel[32];
	//当前信息
	public static JLabel text;
	//工具栏
	public static JToolBar jmain;	
}
