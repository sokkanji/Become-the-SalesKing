package POS;

import java.awt.Color;

import javax.swing.JFrame;

public class frame extends JFrame{
	public JPanelIntro intro = null;
	public JPanelStory story = null;
	public JPanelOrder order = null;
	public JPanelHowTo howto = null;
	public JPanelEnding ending = null;
	static int ordernum=0;
	int money;
	
	frame(int money){
		this.money = money;
		Music introMusic = new Music("introMusic.MP3", true);
		introMusic.start();
		
		setUndecorated(true); // 실행했을 때 기본적으로 보이는 메뉴바가 안 보임.
		setBackground(new Color(0, 0, 0, 0));
	}
	
	public void change(String panelName) {
		if(panelName.equals("story")) {
			if(ordernum==4) {
				//ordernum=0;
				getContentPane().removeAll();
				getContentPane().add(ending);
				revalidate();
				repaint();
			}else {
				ordernum++;
				getContentPane().removeAll();
				getContentPane().add(story);
				revalidate();
				repaint();
			}
		}
		if(panelName.equals("order")) {
				getContentPane().removeAll();
				getContentPane().add(new JPanelOrder(this,ordernum));
				revalidate();
				repaint();
		}
		if(panelName.equals("howto")) {
			getContentPane().removeAll();
			getContentPane().add(howto);
			revalidate();
			repaint();
		}
		if(panelName.equals("intro")) {
			this.money=100000;
			ordernum=0;
			getContentPane().removeAll();
			getContentPane().add(intro);
			revalidate();
			repaint();
		}
		if(panelName.equals("ending")) {
			getContentPane().removeAll();
			getContentPane().add(new JPanelEnding(this));
			revalidate();
			repaint();
		}
	}
}
