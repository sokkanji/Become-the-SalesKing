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
import javax.swing.JLabel;
import javax.swing.JTextField;

class Intro extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic; // 전체화면에 대한 두 인스턴스
	private Image Background = Toolkit.getDefaultToolkit().createImage("images/Introbackground.jpg");

	// 나가기 버튼 이미지
	private ImageIcon End[] = { new ImageIcon("images/End.png"), new ImageIcon("images/OnEnd.png") };
	// 시작버튼 이미지
	private ImageIcon Startbtn[] = { new ImageIcon("images/BeforeStart.png"), // ㅁ[0] 평상시, ㅁ[1] 마우스 올렸을 때, ㅁ[2] 마우스 누를 때
			new ImageIcon("images/AfterStart.png"), new ImageIcon("images/OnStart.png") };
	// 조작방법 이미지
	private ImageIcon HowToPlaybtn[] = { new ImageIcon("images/BeforeHowToPlay.png"),
			new ImageIcon("images/AfterHowToPlay.png"), new ImageIcon("images/OnHowToPlay.png") };
	// 뒤로가기 버튼
	public ImageIcon Backbtn[] = { new ImageIcon("images/BeforeBack.png"), new ImageIcon("images/AfterBack.png"),
			new ImageIcon("images/OnBack.png") };

	private ImageIcon Checkbtn[] = { new ImageIcon("images/BeforeCheck.png"), new ImageIcon("images/AfterCheck.png"),
			new ImageIcon("images/OnCheck.png") };

	private ImageIcon Nextbtn[] = { new ImageIcon("images/ANext.png"), new ImageIcon("images/BNext.png"),
			new ImageIcon("images/OnNext.png") };

	ImageIcon monster[] = { new ImageIcon("images/monster1.png"), new ImageIcon("images/monster2.png"),
			new ImageIcon("images/monster3.png"), new ImageIcon("images/monster4.png"),
			new ImageIcon("images/monster5.png") };

	private JLabel order[] = { new JLabel("눈알 네 개 쉐이크 3잔 "), new JLabel("치키치키 초코 마카롱 3개"),
			new JLabel("슈스 스토리베리 쉐이크 6잔") };

	JLabel story[] = { new JLabel("평범한 고등학생 민지"), new JLabel("평범한 일상."), new JLabel("평소와 똑같이 눈을 떴더니 지구가 보인다."),
			new JLabel("정신을 차리고 민지는 다시 눈 떠보니 우주정거장에 있다."), new JLabel("우주정거장에는 못 생기고 기괴하게 생긴 외계인이 있다."),
			new JLabel("민지는 처음에 외계인을 보고 너무 놀라서 한 번 기절했었다."),
			new JLabel("민지는 다시 정신을 차린 후 마음 진정시켜서 외계인한테 여기가 어디인지 물어보기로 결심한다."), new JLabel("저기요.. 말씀 좀 여쭤도 되나요..?"),
			new JLabel("무슨 일이냐? 삐뻐뿌꺼") };

	private JLabel monsterLa = new JLabel(monster[1]);

	// 나가기, 시작, 조작방법 버튼
	private JButton Endbtn = new JButton(End[0]);
	private JButton Lbtn = new JButton(Startbtn[0]);
	private JButton Rbtn = new JButton(HowToPlaybtn[0]);

	private JButton Bbtn = new JButton(Backbtn[0]);
	private JButton Cbtn = new JButton(Checkbtn[0]);
	private JButton Nbtn = new JButton(Nextbtn[0]);

	private JButton clickbtn = new JButton("Click!");

	private JTextField Name = new JTextField(20);
	private JTextField SName = new JTextField(20); // 제거 예정

	Intro() {
		setTitle("매출왕이 되자!!");

		setUndecorated(true); // 실행했을 때 기본적으로 보이는 메뉴바가 안 보임.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
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
		Lbtn.addMouseListener(new StartMouseAdapter());

		// 조작방법 버튼
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
				Lbtn.setVisible(false);
				Rbtn.setVisible(false);

				Background = Toolkit.getDefaultToolkit().createImage("images/HowToPlaybackground.jpg");

				Bbtn.setBounds(1050, 610, 180, 110);
				Bbtn.setBorderPainted(false);
				Bbtn.setFocusPainted(false);
				Bbtn.setContentAreaFilled(false);
				add(Bbtn);
			}
		});

		// 뒤로가기버튼
		Bbtn.setPressedIcon(Backbtn[1]);
		Bbtn.setRolloverIcon(Backbtn[2]);
		Bbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Bbtn.setVisible(false);
				Lbtn.setVisible(true);
				Rbtn.setVisible(true);
				Background = Toolkit.getDefaultToolkit().createImage("images/Introbackground.jpg");
			}
		});
	}

	// 시작하기 버튼에 대한 어댑터 (정보 입력 화면)
	class StartMouseAdapter extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			Background = Toolkit.getDefaultToolkit().createImage("images/Initbackground.jpg");
			Rbtn.setVisible(false);
			Lbtn.setVisible(false);

			// 이름 입력
			add(Name);
			Name.setVisible(true);
			Name.setBounds(640, 175, 400, 80);
			Name.setFont(new Font("BOLD", Font.BOLD, 50));

			// 확인버튼
			Cbtn.setPressedIcon(Checkbtn[1]);
			Cbtn.setRolloverIcon(Checkbtn[2]);
			Cbtn.setBounds(560, 620, 220, 100);
			Cbtn.setBorderPainted(false);
			Cbtn.setFocusPainted(false);
			Cbtn.setContentAreaFilled(false);
			add(Cbtn);

			SName.setVisible(true);
			SName.setBounds(640, 415, 400, 80);
			SName.setFont(new Font("BOLD", Font.BOLD, 50));
			add(SName);

			Cbtn.addMouseListener(new ConfigtMouseAdapter());
		}
	}

	// 이름, 가게 이름 입력 화면의 확인 버튼에 대한 어댑터 (스토리 화면)
	class ConfigtMouseAdapter extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			Background = Toolkit.getDefaultToolkit().createImage("images/Storybackground.jpg");

			String name = Name.getText();
			String sname = SName.getText();

			Name.setVisible(false);
			SName.setVisible(false);
			Cbtn.setVisible(false);

			story[7].setBounds(100, 450, 400, 400);
			story[7].setFont(new Font("배달의민족 주아", Font.CENTER_BASELINE, 30));
			add(story[7]);

			add(Nbtn);
			Nbtn.setPressedIcon(Nextbtn[1]);
			Nbtn.setRolloverIcon(Nextbtn[2]);
			Nbtn.setBounds(1170, 625, 180, 110);
			Nbtn.setBorderPainted(false);
			Nbtn.setFocusPainted(false);
			Nbtn.setContentAreaFilled(false);

			Nbtn.addMouseListener(new NextMouseAdapter());

		}
	}

	// Next 버튼에 대한 어댑터 (주문 화면)
	class NextMouseAdapter extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			Background = Toolkit.getDefaultToolkit().createImage("images/Menubackground.jpg");
			monsterLa.setBounds(10, 160, 400, 400);
			add(monsterLa);
			Nbtn.setVisible(false);
			story[7].setVisible(false);

			order[0].setBounds(520, 0, 400, 160);
			order[0].setFont(new Font("배달의민족 도현", Font.CENTER_BASELINE, 25));
			add(order[0]);
			order[1].setBounds(520, 30, 400, 160);
			order[1].setFont(new Font("배달의민족 도현", Font.CENTER_BASELINE, 25));
			add(order[1]);

			// click 버튼 넣기
			clickbtn.setBounds(927, 315, 130, 80);
			clickbtn.setBorderPainted(false);
			clickbtn.setFocusPainted(false);
			clickbtn.setContentAreaFilled(false);
			clickbtn.setFont(new Font("배달의민족 도현", Font.BOLD, 30));
			clickbtn.setForeground(Color.BLUE);
			add(clickbtn);
			clickbtn.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e2) {
					new Pos();
				}
			});
		}
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