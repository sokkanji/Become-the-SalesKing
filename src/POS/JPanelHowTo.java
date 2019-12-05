package POS;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class JPanelHowTo extends JPanel{
	private Image screenImage;
	private Graphics screenGraphic; // ��üȭ�鿡 ���� �� �ν��Ͻ�
	private Image Background = Toolkit.getDefaultToolkit().createImage("images/howto.jpg");
	
	private ImageIcon Backbtn[] = { new ImageIcon("images/BeforeBack.png"), new ImageIcon("images/AfterBack.png"),
			new ImageIcon("images/OnBack.png") };
	private JButton Bbtn = new JButton(Backbtn[0]);

	public JPanelHowTo(frame win) {
		setLayout(null);
		Bbtn.setBounds(1050, 630, 180, 110);
		Bbtn.setBorderPainted(false);
		Bbtn.setFocusPainted(false);
		Bbtn.setContentAreaFilled(false);
		add(Bbtn);
		Bbtn.setPressedIcon(Backbtn[1]);
		Bbtn.setRolloverIcon(Backbtn[2]);
		Bbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				win.change("intro");
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
