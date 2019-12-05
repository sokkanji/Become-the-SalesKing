package POS;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class JPanelEnding extends JPanel{
	private frame win;
	private Image screenImage;
	private Graphics screenGraphic; // ��üȭ�鿡 ���� �� �ν��Ͻ�
	private Image Background;
	private ImageIcon exit[] = {new ImageIcon("images/exitBbtn.png"), new ImageIcon("images/exitAbtn.png")}; 
	
	private JButton exitbtn = new JButton(exit[0]);
	
	JPanelEnding(frame win){
		setLayout(null);
		if(win.money<0) Background = Toolkit.getDefaultToolkit().createImage("images/fail.jpg");
		else Background=Toolkit.getDefaultToolkit().createImage("images/success.jpg");
		
		
		exitbtn.setBounds(600,360,200,150);
		exitbtn.setBorderPainted(false);
		exitbtn.setFocusPainted(false);
		exitbtn.setContentAreaFilled(false);
		exitbtn.setPressedIcon(exit[1]);
		exitbtn.setRolloverIcon(exit[0]);
		add(exitbtn);
		exitbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	public void paint(Graphics g) { // GUIȭ�� �� ���� ù��° ȭ���� �׷��ִ� �Լ�
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // ScreenImage�� 1200X700�� �̹����� �־���
		screenGraphic = screenImage.getGraphics(); // �ٱ׷����� �̿��ؼ� ��ũ���׷����� ����
		screenDraw(screenGraphic); // screenDraw ȣ��
		g.drawImage(screenImage, 0, 0, null); // screenImage�� �̹����� (0,0)��ġ�� �׷���.
	}

	public void screenDraw(Graphics g) {
		g.drawImage(Background, 0, 0, null); // Background�� �̹����� (0,0)��ġ�� �׷���.
		paintComponents(g); // ������Ʈ ����
		this.repaint(); // ��üȭ�� �̹����� �� �������� �׷���, ���α׷� ����~������� �ݺ��Ǹ� ȭ�鿡 �׷���.
	}
}
