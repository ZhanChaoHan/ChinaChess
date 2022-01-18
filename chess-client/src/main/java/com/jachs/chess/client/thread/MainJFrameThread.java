package com.jachs.chess.client.thread;

import com.jachs.chess.client.AppConstant;

/***
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
			try {
				if (AppConstant.chessManClick){
					AppConstant.play[AppConstant.Man].setVisible(false);
					AppConstant.tmain.sleep(200);
					AppConstant.play[AppConstant.Man].setVisible(true);
				}else {
					AppConstant.text.setVisible(false);
					AppConstant.tmain.sleep(250);
					AppConstant.text.setVisible(true);
				}
				AppConstant.tmain.sleep(350);
			}catch (Exception e){e.printStackTrace();}
	}
  }
}
