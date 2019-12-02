package POS;

import javax.swing.JLabel;

class TimerThread extends Thread {
	private JLabel timerLabel;
	private frame win;
	
	public TimerThread(JLabel timerLabel, frame win) { 
		this.timerLabel = timerLabel;
		this.win = win;
	}

	@Override
	public void run() {
		int n=0; 
		while(true) {
			timerLabel.setText(Integer.toString(n));
			n++; 
				try {
					Thread.sleep(1000);
					if(n==5) win.change("story");
				}
				catch(InterruptedException e) {
					return;
				}
		}
	}
}

