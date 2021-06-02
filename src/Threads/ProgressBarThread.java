package Threads;

import javafx.application.Platform;
import model.LoadingBar;
import ui.Program2Controller;

public class ProgressBarThread extends Thread{
	
	private LoadingBar loadBar;
	private Program2Controller play;
	
	public ProgressBarThread(LoadingBar loadB, Program2Controller naisuS) {
		loadBar = loadB;
		play = naisuS;
	}
	
	public void run() {
		while (loadBar.isActive()) {
			loadBar.advance();
			Platform.runLater(new Thread() {
				public void run() {
					play.updateBar();
				}
			});
			try {
				Thread.sleep(8);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
				
	}
}
