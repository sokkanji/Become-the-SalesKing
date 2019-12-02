package POS;

import java.awt.Font;
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
import javax.swing.JTextField;

public class JPanelStory extends JPanel{
	
	private frame win;
	private Image screenImage;
	private Graphics screenGraphic; // 전체화면에 대한 두 인스턴스
	private Image Background = Toolkit.getDefaultToolkit().createImage("images/Storybackground.jpg");
	
	private ImageIcon Nextbtn[] = { new ImageIcon("images/ANext.png"), new ImageIcon("images/BNext.png"),
			new ImageIcon("images/OnNext.png") }; 
	
	private JButton Nbtn = new JButton(Nextbtn[0]);
	
	private JTextField Name = new JTextField(20);
	
	// 나가기 버튼 이미지
	public static ImageIcon End[] = { new ImageIcon("images/End.png"), new ImageIcon("images/OnEnd.png") };
	public static JButton Endbtn = new JButton(End[0]);
		
	public JPanelStory(frame win)
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
				
		add(Nbtn);
		Nbtn.setPressedIcon(Nextbtn[1]);
		Nbtn.setRolloverIcon(Nextbtn[2]);
		Nbtn.setBounds(1170, 625, 180, 110);
		Nbtn.setBorderPainted(false);
		Nbtn.setFocusPainted(false);
		Nbtn.setContentAreaFilled(false);
		Nbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				win.change("order");
			}
		});
		
		add(Name);
		Name.setVisible(true);
		Name.setBounds(140, 600, 400, 80);
		Name.setFont(new Font("배달의민족 주아", Font.BOLD, 45));
		Name.setOpaque(false);

		String name = Name.getText(); 
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
