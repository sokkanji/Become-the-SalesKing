package POS;

import javax.swing.JLabel;

class TimerThread extends Thread {
	private JLabel timerLabel;
	private frame win;
	private Pos p;
	
	public TimerThread(JLabel timerLabel, frame win, Pos pos) { 
		this.timerLabel = timerLabel;
		this.win = win;
		this.p = pos;
	}
	
	@Override
	public void run() {
		int n=0; 
		while(true) {
			timerLabel.setText(Integer.toString(n)); 
			n++; 
			try {
				Thread.sleep(1000); 
				if(n==61) {
					win.change("story");
					p.dispose();
				}
			}
			catch(InterruptedException e) {
				return;
			}
		}
	}
}

