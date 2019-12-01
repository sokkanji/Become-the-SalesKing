package POS;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelOrder extends JPanel{
	private frame win;
	private Image screenImage;
	private Graphics screenGraphic; // 전체화면에 대한 두 인스턴스
	private Image Background = Toolkit.getDefaultToolkit().createImage("images/Menubackground.jpg");
	
	private ImageIcon monster[] = { new ImageIcon("images/monster1.png"), new ImageIcon("images/monster2.png"),
			new ImageIcon("images/monster3.png"), new ImageIcon("images/monster4.png"),
			new ImageIcon("images/monster5.png") };
	
	private JButton clickbtn = new JButton("Click!");
	
	int o_rand, o_rand2, m_rand, m_rand2;
	
	
	JPanelOrder(frame win, int ordernum)
	{	
		this.win=win;
		setLayout(null);
	
		JLabel date = new JLabel(String.valueOf(ordernum));
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
		
		JLabel priceLabel = new JLabel(String.valueOf(win.money));
		
		int i = 0;
		o_rand = 0;
		o_rand2 = 0;
		m_rand = 0;
		m_rand2 = 0;
		
		//주문
		for(i=0; i<Menu_txt.length; i++) {
			order_txt[i]=new JLabel(Menu_txt[i]); //라벨에 주문 메뉴 이름 부착
			order_txt2[i]=new JLabel(Menu_txt[i]);
		}
		
		o_rand = (int)(Math.random()*10);
		while(o_rand2==o_rand) {
			o_rand2 = (int)(Math.random()*10);
		}
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
		
		priceLabel.setBounds(265,15,400,160);
		priceLabel.setFont(new Font("배달의민족 도현", Font.BOLD, 25));
		
		add(order_txt[o_rand]);
		add(order_txt2[o_rand2]);
		add(menu_num);
		add(menu_num2);
		add(order_end);
		add(order_end2);
		add(priceLabel);

		//타이머
		timerLabel.setFont(new Font("배달의민족 도현", Font.CENTER_BASELINE, 50));
		add(timerLabel);
		timerLabel.setBounds(1195, 86, 100, 100);

		TimerThread th = new TimerThread(timerLabel);
		th.start();
		
		add(date);
		date.setFont(new Font("Gothic", Font.ITALIC, 35));
		date.setBounds(165, -5, 100, 100);
		
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
		clickbtn.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e2) {
				new Pos(Menu_txt[o_rand],Menu_txt[o_rand2],m_rand, m_rand2,win);
			}
		});
		add(clickbtn);
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
