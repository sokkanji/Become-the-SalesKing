import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Intro extends JFrame {
	
	private Image screenImage;
	private Graphics screenGraphic; //전체화면에 대한 두 인스턴스
	private Image IntroBackground=Toolkit.getDefaultToolkit().createImage("images/Introbackground.jpg"); 
	
	//나가기버튼 이미지
	private ImageIcon End=new ImageIcon("images/End.png");
	private ImageIcon OnEnd=new ImageIcon("images/OnEnd.png");
	
	//시작버튼 이미지
	private ImageIcon BStartbtn = new ImageIcon("images/BeforeStart.png");
	private ImageIcon AStartbtn = new ImageIcon("images/AfterStart.png");
	private ImageIcon OnStartbtn = new ImageIcon("images/OnStart.png");
	
	//조작방법 이미지
	private ImageIcon BHowToPlaybtn = new ImageIcon("images/BeforeHowToPlay.png");
	private ImageIcon AHowToPlaybtn = new ImageIcon("images/AfterHowToPlay.png");
	private ImageIcon OnHowToPlaybtn = new ImageIcon("images/OnHowToPlay.png");
	
	//나가기, 시작, 조작방법 버튼
	private JButton Endbtn = new JButton(End);
	private JButton Lbtn=new JButton(BStartbtn);
	private JButton Rbtn=new JButton(BHowToPlaybtn);
	
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
		Endbtn.setRolloverIcon(OnEnd);
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
		Lbtn.setPressedIcon(AStartbtn); //눌렀을 때의 이미지
		Lbtn.setRolloverIcon(OnStartbtn); //이미지 위에 마우스 올렸을 때의 이미지 
		
		Lbtn.setBounds(350, 620, 220, 100); //버튼의 위치 및 크기 설정
		Lbtn.setBorderPainted(false); 
		Lbtn.setFocusPainted(false);
		Lbtn.setContentAreaFilled(false); 
		//Lbtn.addMouseListener(new MyMouse());
		add(Lbtn);
		
		//<조작방법 버튼>
		Rbtn.setPressedIcon(AHowToPlaybtn);
		Rbtn.setRolloverIcon(OnHowToPlaybtn);

		Rbtn.setBounds(810, 620, 220, 100);
		Rbtn.setBorderPainted(false);
		Rbtn.setFocusPainted(false);
		Rbtn.setContentAreaFilled(false);
		add(Rbtn);	
	}

	public void paint(Graphics g) { //GUI화면 중 제일 첫번째 화면을 그려주는 함수
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); //ScreenImage에 1200X700의 이미지를 넣어줌
		screenGraphic = screenImage.getGraphics(); //겟그래픽을 이용해서 스크린그래픽을 얻어옴 
		screenDraw(screenGraphic); //screenDraw 호출
		g.drawImage(screenImage, 0, 0, null); //screenImage의 이미지를 (0,0)위치에 그려줌.
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(IntroBackground, 0, 0, null); //IntroBackground의 이미지를 (0,0)위치에 그려줌.
		paintComponents(g); //컴포넌트 삽입
		this.repaint(); //전체화면 이미지를 매 순간마다 그려줌, 프로그램 시작~종료까지 반복되며 화면에 그려줌.
	}
	
}