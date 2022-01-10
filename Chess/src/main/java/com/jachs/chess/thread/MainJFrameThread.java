package com.jachs.chess.thread;

import com.jachs.chess.AppConstant;

/***
 * 主窗体线程
 * @author zhanchaohan
 *
 */
public class MainJFrameThread implements Runnable {
	/**
	** 线程方法控制棋子闪烁
	*/
	@Override
	public void run() {
		while (true){
			//单击棋子第一下开始闪烁
			if (AppConstant.chessManClick){
				AppConstant.play[AppConstant.Man].setVisible(false);

				//时间控制
				try{
					AppConstant.tmain.sleep(200);
				}
				catch(Exception e){
				}
				AppConstant.play[AppConstant.Man].setVisible(true);
			}else {//闪烁当前提示信息 以免用户看不见
				AppConstant.text.setVisible(false);
				//时间控制
				try{
					AppConstant.tmain.sleep(250);
				}
				catch(Exception e){
				}
				AppConstant.text.setVisible(true);
			}
			try{
				AppConstant.tmain.sleep(350);
			}
			catch (Exception e){
			}
		}
	}

}
