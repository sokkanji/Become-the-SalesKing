package POS;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

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
	private ImageIcon Backbtn[] = { new ImageIcon("images/BeforeBack.png"), new ImageIcon("images/AfterBack.png"),
			new ImageIcon("images/OnBack.png") };

	private ImageIcon Checkbtn[] = { new ImageIcon("images/BeforeCheck.png"), new ImageIcon("images/AfterCheck.png"),
			new ImageIcon("images/OnCheck.png") };

	private ImageIcon Nextbtn[] = { new ImageIcon("images/ANext.png"), new ImageIcon("images/BNext.png"),
			new ImageIcon("images/OnNext.png") }; ///

	private ImageIcon monster[] = { new ImageIcon("images/monster1.png"), new ImageIcon("images/monster2.png"),
			new ImageIcon("images/monster3.png"), new ImageIcon("images/monster4.png"),
			new ImageIcon("images/monster5.png") };

	// 나가기, 시작, 조작방법 버튼
	private JButton Endbtn = new JButton(End[0]);
	private JButton Lbtn = new JButton(Startbtn[0]);
	private JButton Rbtn = new JButton(HowToPlaybtn[0]);

	private JButton Bbtn = new JButton(Backbtn[0]);
	private JButton Cbtn = new JButton(Checkbtn[0]);
	private JButton Nbtn = new JButton(Nextbtn[0]);

	private JButton clickbtn = new JButton("Click!");

	private JTextField Name = new JTextField(20);

	private JLabel story[] = { new JLabel("평범한 고등학생 민지"), new JLabel("평범한 일상."), new JLabel("평소와 똑같이 눈을 떴더니 지구가 보인다."),
			new JLabel("정신을 차리고 민지는 다시 눈 떠보니 우주정거장에 있다."), new JLabel("우주정거장에는 못 생기고 기괴하게 생긴 외계인이 있다."),
			new JLabel("민지는 처음에 외계인을 보고 너무 놀라서 한 번 기절했었다."),
			new JLabel("민지는 다시 정신을 차린 후 마음 진정시켜서 외계인한테 여기가 어디인지 물어보기로 결심한다."), new JLabel("저기요.. 말씀 좀 여쭤도 되나요..?"),
			new JLabel("무슨 일이냐? 삐뻐뿌꺼") };


	Intro() {
		setTitle("매출왕이 되자!!");
		
		Music introMusic = new Music("introMusic.MP3", true);
		introMusic.start();
		
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
		Lbtn.addMouseListener(new ConfigMouseAdapter());

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

	
	
	// 스토리 화면
	class ConfigMouseAdapter extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			Background = Toolkit.getDefaultToolkit().createImage("images/Storybackground.jpg");
			Rbtn.setVisible(false);
			Lbtn.setVisible(false);

			add(Nbtn);
			Nbtn.setPressedIcon(Nextbtn[1]);
			Nbtn.setRolloverIcon(Nextbtn[2]);
			Nbtn.setBounds(1170, 625, 180, 110);
			Nbtn.setBorderPainted(false);
			Nbtn.setFocusPainted(false);
			Nbtn.setContentAreaFilled(false);

			Nbtn.addMouseListener(new NextMouseAdapter());

			// 이름 입력
			add(Name);
			Name.setVisible(true);
			Name.setBounds(140, 600, 400, 80);
			Name.setFont(new Font("배달의민족 주아", Font.BOLD, 45));
			Name.setOpaque(false);

			String name = Name.getText(); 

//			story[i].setBounds(100, 450, 800, 400);
//			story[i].setFont(new Font("배달의민족 주아", Font.BOLD, 30));
//			add(story[i]);
//			story[i].setVisible(false);

		}
	}

	
	
// Next 버튼에 대한 어댑터 (주문 화면)
	class NextMouseAdapter extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			JLabel date[] = { new JLabel("1"), new JLabel("2"), new JLabel("3"), new JLabel("4") };
			//JLabel money=new JLabel();
			//주문 메뉴 이름 붙일 라벨
			JLabel order_txt[]=new JLabel[10];
			JLabel order_txt2[]=new JLabel[10];
			//메뉴이름
			String Menu_txt[]= {"눈알 네 개 쉐이크", "치키치키 초코 마카롱", "슈스 스토리 베리 쉐이크", "베리베리 블루베리 마카롱", "아빠와 나는 외계인 라떼",
					"삐립삐립 지구행성맛 에이드", "슈스 스토리베리 쉐이크", "룩앳 마이노즈 아메리카노", "매쉬 핫솟 포테이토 쿠키", "씨쁠씨쁠 사람일까요쿠키"};
			JLabel timerLabel = new JLabel();
			JLabel monsterLa[]=new JLabel[5];
			
			JLabel order_end = new JLabel("개 주세요.");
			JLabel order_end2 = new JLabel("개랑");
			
			int i = 0;
			int o_rand = 0;
			int o_rand2 = 0;
			int m_rand = 0;
			int m_rand2 = 0;
			
			Background = Toolkit.getDefaultToolkit().createImage("images/Menubackground.jpg");
			Nbtn.setVisible(false);
			Name.setVisible(false);
			
			//주문
			for(i=0; i<Menu_txt.length; i++) {
				order_txt[i]=new JLabel(Menu_txt[i]); //라벨에 주문 메뉴 이름 부착
				order_txt2[i]=new JLabel(Menu_txt[i]);
			}
			
			o_rand = (int)(Math.random()*10); 
			o_rand2 = (int)(Math.random()*10); 
			m_rand =  (int)(Math.random()*7+1);
			m_rand2 =  (int)(Math.random()*7+1);
			
			order_txt[o_rand].setBounds(500, 10, 400, 160);
			order_txt[o_rand].setFont(new Font("배달의민족 도현", Font.BOLD, 25));
			
			order_txt2[o_rand2].setBounds(500, 45, 400, 160);
			order_txt2[o_rand2].setFont(new Font("배달의민족 도현", Font.BOLD, 25));


			String num = Integer.toString(m_rand);
			JLabel menu_num = new JLabel(num);
			menu_num.setBounds(820, 10, 400, 160);
			menu_num.setFont(new Font("배달의민족 도현", Font.BOLD, 30));
			
			String num2 = Integer.toString(m_rand2);
			JLabel menu_num2 = new JLabel(num2);
			menu_num2.setBounds(820, 45, 400, 160);
			menu_num2.setFont(new Font("배달의민족 도현", Font.BOLD, 30));

			order_end.setBounds(840, 45, 400, 160);
			order_end.setFont(new Font("배달의민족 도현", Font.BOLD, 25));
			order_end2.setBounds(840, 10, 400, 160);
			order_end2.setFont(new Font("배달의민족 도현", Font.BOLD, 25));
			
			add(order_txt[o_rand]);
			add(order_txt2[o_rand2]);
			add(menu_num);
			add(menu_num2);
			add(order_end);
			add(order_end2);

			//타이머
			timerLabel.setFont(new Font("배달의민족 도현", Font.CENTER_BASELINE, 50));
			add(timerLabel);
			timerLabel.setBounds(1195, 86, 100, 100);

			TimerThread th = new TimerThread(timerLabel);
			th.start();
			
			add(date[0]);
			date[0].setFont(new Font("Gothic", Font.ITALIC, 35));
			date[0].setBounds(165, -5, 100, 100);
			
			//몬스터 이미지 출력
			for(i=0; i<monster.length; i++)
				monsterLa[i]= new JLabel(monster[i]);
			
			int r_monster=(int)(Math.random()*5);
			monsterLa[r_monster].setBounds(50, 95, 500, 500);
			add(monsterLa[r_monster]);
			

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