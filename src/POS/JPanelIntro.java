package POS;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class JPanelIntro extends JPanel{
	private Image screenImage;
	private Graphics screenGraphic; // 전체화면에 대한 두 인스턴스
	private Image Background = Toolkit.getDefaultToolkit().createImage("images/Introbackground.jpg");
	
	private frame win;
	
	// 나가기 버튼 이미지
	private ImageIcon End[] = { new ImageIcon("images/End.png"), new ImageIcon("images/OnEnd.png") };
	// 시작버튼 이미지
	private ImageIcon Startbtn[] = { new ImageIcon("images/BeforeStart.png"), // ㅁ[0] 평상시, ㅁ[1] 마우스 올렸을 때, ㅁ[2] 마우스 누를 때
			new ImageIcon("images/AfterStart.png"), new ImageIcon("images/OnStart.png") };
	// 조작방법 이미지
		private ImageIcon HowToPlaybtn[] = { new ImageIcon("images/BeforeHowToPlay.png"),
				new ImageIcon("images/AfterHowToPlay.png"), new ImageIcon("images/OnHowToPlay.png") };
		
	
	// 나가기, 시작, 조작방법 버튼
	private JButton Endbtn = new JButton(End[0]);
	private JButton Lbtn = new JButton(Startbtn[0]);
	private JButton Rbtn = new JButton(HowToPlaybtn[0]);
		
	public JPanelIntro(frame win)
	{
		this.win=win;
		setLayout(null);
		
		// 종료버튼
			Endbtn.setRolloverIcon(End[1]);
			Endbtn.setBounds(1250, 10, 100, 80);
			Endbtn.setBorderPainted(false);
			Endbtn.setFocusPainted(false);
			Endbtn.setContentAreaFilled(false);
			add(Endbtn);
			Endbtn.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					System.exit(0);
				}
			});

			// 시작버튼
			Lbtn.setPressedIcon(Startbtn[1]);
			Lbtn.setRolloverIcon(Startbtn[2]);
			Lbtn.setBounds(350, 620, 220, 100);
			Lbtn.setBorderPainted(false);
			Lbtn.setFocusPainted(false);
			Lbtn.setContentAreaFilled(false);
			add(Lbtn);
//				Lbtn.addMouseListener(new ConfigMouseAdapter());
			Lbtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					win.change("story");
					
				}
			});

			// 조작방법 버튼
			Rbtn.setPressedIcon(HowToPlaybtn[1]);
			Rbtn.setRolloverIcon(HowToPlaybtn[2]);
			Rbtn.setBounds(810, 620, 220, 100);
			Rbtn.setBorderPainted(false);
			Rbtn.setFocusPainted(false);
			Rbtn.setContentAreaFilled(false);
			add(Rbtn);
			Rbtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					win.change("howto");
				}
			});
	} 
	
	public void paint(Graphics g) { // GUI화면 중 제일 첫번째 화면을 그려주는 함수
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // ScreenImage에 1200X700의 이미지를 넣어줌
		screenGraphic = screenImage.getGraphics(); // 겟그래픽을 이용해서 스크린그래픽을 얻어옴
		screenDraw(screenGraphic); // screenDraw 호출
		g.drawImage(screenImage, 0, 0, null); // screenImage의 이미지를 (0,0)위치에 그려줌.
	}

	public void screenDraw(Graphics g) {
		g.drawImage(Background, 0, 0, null); // Background의 이미지를 (0,0)위치에 그려줌.
		paintComponents(g); // 컴포넌트 삽입
		this.repaint(); // 전체화면 이미지를 매 순간마다 그려줌, 프로그램 시작~종료까지 반복되며 화면에 그려줌.
	}
}
