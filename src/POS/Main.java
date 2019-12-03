package POS;

import javax.swing.JFrame;

public class Main {
	public static final int SCREEN_WIDTH=1344;
	public static final int SCREEN_HEIGHT=780;
	
	public static void main(String ar[]) throws InterruptedException {
		frame win = new frame(100000);
		
		win.setTitle("매출왕이 되어라");
		win.intro = new JPanelIntro(win);
		win.story = new JPanelStory(win);
		//win.order = new JPanelOrder(win);
		win.howto = new JPanelHowTo(win);
		win.ending=new JPanelEnding(win);
		
		win.add(win.intro);
		
		win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		win.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
		win.setVisible(true);
		
	}
}
