import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Intro extends JFrame {
	
	private Image screenImage;
	private Graphics screenGraphic; //전체화면에 대한 두 인스턴스
	private Image Background=Toolkit.getDefaultToolkit().createImage("images/Introbackground.jpg"); 

	//<나가기 버튼 이미지>
	private ImageIcon End[] = {new ImageIcon("images/End.png"),
								new ImageIcon("images/OnEnd.png")};
	//시작버튼 이미지
	private ImageIcon Startbtn[] = {new ImageIcon("images/BeforeStart.png"), //ㅁ[0] 평상시, ㅁ[1] 마우스 올렸을 때, ㅁ[2] 마우스 누를 때
									new ImageIcon("images/AfterStart.png"),
									new ImageIcon("images/OnStart.png") };
	//조작방법 이미지
	private ImageIcon HowToPlaybtn[] = {new ImageIcon("images/BeforeHowToPlay.png"),
									    new ImageIcon("images/AfterHowToPlay.png"),
									    new ImageIcon("images/OnHowToPlay.png")};
	//뒤로가기 버튼
	public ImageIcon Backbtn[] = {new ImageIcon("images/BeforeBack.png"),
								  new ImageIcon("images/AfterBack.png"),
								  new ImageIcon("images/OnBack.png")};
	//나가기, 시작, 조작방법 버튼
	private JButton Endbtn = new JButton(End[0]);
	private JButton Lbtn=new JButton(Startbtn[0]);
	private JButton Rbtn=new JButton(HowToPlaybtn[0]);
	private JButton Bbtn=new JButton(Backbtn[0]);
	
	private JTextField Name = new JTextField(20);
	private JTextField SName = new JTextField(20);
	
	Intro(){
		setTitle("매출왕이 되자!!");
	
		setUndecorated(true); //실행했을 때 기본적으로 보이는 메뉴바가 안 보임.
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창 종료시, 프로그램이 완전히 종료하게 해줌.	
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); //창 화면 크기조절
		
		setResizable(false); //한 번 실행된 창 크기 수정 불가능하게 함.
		setLocationRelativeTo(null); //실행했을 때 창이 컴퓨터의 정중앙에 뜨게 함.
		setVisible(true); //창이 보이게 해주는 것
		
		setBackground(new Color(0, 0, 0, 0)); //PaintComponent를 했을 때 배경이 회색이 아닌 흰색으로 나옴.
		setLayout(null); //버튼이나 라벨을 넣었을 때 제 위치에 설정하도록 해줌.
		
		//<종료버튼>
		Endbtn.setRolloverIcon(End[1]);
		Endbtn.setBounds(1250, 10, 100, 80);
		Endbtn.setBorderPainted(false);
		Endbtn.setFocusPainted(false);
		Endbtn.setContentAreaFilled(false);
		Endbtn.addMouseListener(new MouseAdapter(){ 
			@Override
			public void mousePressed(MouseEvent e) { //눌렀을 때 프로그램 종료
				System.exit(0); 
			}
		});
		add(Endbtn); //버튼 부착
		
		//<시작버튼>
		Lbtn.setPressedIcon(Startbtn[1]); //눌렀을 때의 이미지
		Lbtn.setRolloverIcon(Startbtn[2]); //이미지 위에 마우스 올렸을 때의 이미지 
		
		Lbtn.setBounds(350, 620, 220, 100); //버튼의 위치 및 크기 설정
		Lbtn.setBorderPainted(false); 
		Lbtn.setFocusPainted(false);
		Lbtn.setContentAreaFilled(false); 
		Lbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Rbtn.setVisible(false); 
				Lbtn.setVisible(false);
				Background = Toolkit.getDefaultToolkit().createImage("images/Initbackground.jpg"); // 배경이미지 변경
				Name.setFont(new Font("BOLD", Font.BOLD, 55));
				Name.setBounds(570, 250, 400, 80);
				add(Name);
				Name.setVisible(true); 
				/*Name.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						JTextField t = (JTextField)e.getSource();
					}
				} );*/
			}
		});
		add(Lbtn);
		
		
		
		//<조작방법 버튼>
		Rbtn.setPressedIcon(HowToPlaybtn[1]);
		Rbtn.setRolloverIcon(HowToPlaybtn[2]);

		Rbtn.setBounds(810, 620, 220, 100);
		Rbtn.setBorderPainted(false);
		Rbtn.setFocusPainted(false);
		Rbtn.setContentAreaFilled(false);
		add(Rbtn);
		Rbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Bbtn.setVisible(true); 
				Lbtn.setVisible(false); // 시작버튼이 보이지 않게 됨
				Rbtn.setVisible(false); // 조작버튼이 보이지 않게 됨
				Background = Toolkit.getDefaultToolkit().createImage("images/HowToPlaybackground.jpg"); // 배경이미지 변경
				Bbtn.setBounds(1050, 610, 180, 110); //버튼의 위치 및 크기 설정
				Bbtn.setBorderPainted(false); 
				Bbtn.setFocusPainted(false);
				Bbtn.setContentAreaFilled(false); 
				add(Bbtn);
			} 
		}); 

		//#2 <뒤로가기버튼>
		Bbtn.setPressedIcon(Backbtn[1]); //눌렀을 때의 이미지
		Bbtn.setRolloverIcon(Backbtn[2]); //이미지 위에 마우스 올렸을 때의 이미지 	
		Bbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Bbtn.setVisible(false); 
				Lbtn.setVisible(true);  // 시작버튼이 보임
				Rbtn.setVisible(true);  
				Background = Toolkit.getDefaultToolkit().createImage("images/Introbackground.jpg"); 
			} 
		});  
	}

	public void paint(Graphics g) { //GUI화면 중 제일 첫번째 화면을 그려주는 함수
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); //ScreenImage에 1200X700의 이미지를 넣어줌
		screenGraphic = screenImage.getGraphics(); //겟그래픽을 이용해서 스크린그래픽을 얻어옴 
		screenDraw(screenGraphic); //screenDraw 호출
		g.drawImage(screenImage, 0, 0, null); //screenImage의 이미지를 (0,0)위치에 그려줌.
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(Background, 0, 0, null); //Background의 이미지를 (0,0)위치에 그려줌.
		paintComponents(g); //컴포넌트 삽입
		this.repaint(); //전체화면 이미지를 매 순간마다 그려줌, 프로그램 시작~종료까지 반복되며 화면에 그려줌.
	}
}