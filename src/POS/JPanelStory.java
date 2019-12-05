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
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelStory extends JPanel{
	
	private frame win;
	private Image screenImage;
	private Graphics screenGraphic; // 전체화면에 대한 두 인스턴스 
	private Image Background = Toolkit.getDefaultToolkit().createImage("images/#1.jpg");
	
	private int story_num=0;
	private int add=0;
	private int change = 0;
	
	private ImageIcon End[] = { new ImageIcon("images/End.png"), new ImageIcon("images/OnEnd.png") };
	private ImageIcon Nextbtn[] = { new ImageIcon("images/ANext.png"), new ImageIcon("images/BNext.png"),
			new ImageIcon("images/OnNext.png") }; ///
	
	private JButton Endbtn = new JButton(End[0]);
	private JButton Nbtn = new JButton(Nextbtn[0]);
	
	private String[] story1_text = {"평범한 고등학생","평범한 일상.","평소와 똑같이 눈을 떴더니 지구가 보인다."
			,"정신을 차리고 민지는 다시 눈 떠보니 우주정거장에 있다.","우주정거장에는 못 생기고 기괴하게 생긴 외계인이 있다."
			,"민지는 처음에 외계인을 보고 너무 놀라서 한 번 기절했었다.","민지는 다시 정신을 차린 후 마음 진정시켜서 외계인한테 여기가 어디인지 물어보기로 결심한다."
			,"저기요.. 말씀 좀 여쭤도 되나요..?","무슨 일이냐? 삐뻐뿌꺼","여기가 어디죠?","여기가 어디긴 화성이지 장난할 거면 그냥 가라. 띠삐뿨꺼?", 
			"아... 그렇군요.. 그러면 지구로 돌아가려면 어떻게 해야 해요?","길거리에 있는 외계인 : 띠삐뿨꺼? 지구에는 왜? 지구에 갈려면 우주선 타고 가야지.",
			"우주선? 우주선을 타려면 어떻게 해야 하죠?","길거리에 있는 외계인 : 띠삐뿨꺼 요즘 경기가 워낙 안 좋아서 가격이 많이 올랐을텐데..... 얼마더라.."
			,"길거리에 있는 외계인 : 흐음 100만원이었던 것 같다 띠삐뻐꺼?","100만원이요? 너무 비싼데요!!","하아 돈을 어디서 구하지?","길거리에 있는 외계인 : 돈 필요해?마침 저 앞에 카페 하나가 있는데 갑자기 알바생 하나가 그만둬서 ","점장이 엄청 곤란해 하고 있는데 가서 알바 써달라고 함 말해봐. 띠삐뿨꺼?좋은 정보 고마워요!"};
	private String[] story1_1_text= {"[외계인카페]","딸랑~!","안녕하세요.","점장 : 어서와라 띠삐뿨꺼 뭘 먹을꺼냐? 띠삐뿨꺼?","여기서 아르바이트를 하고 싶어서 왔는데요.."
				,"점장 : 오오오오오오오옹 어떻게 알고 왔냐? 띠삐뿨꺼?","저 앞에 있는 아저씨한테 알바를 구한다는 소식을 듣고 왔어요."
				,"점장 : 오오옹오오오옹 지금 바로 아르바이트 할 수 있냐? 띠삐뿪꺼?","네? 지금요? ","점장 : 얼른 옷 갈아입고 와서 바로 시작해라. 띠삐뿪꺼"};
	private String[] story2_text= {"(딸랑~! : 손님이 문열고 들어오는 소리)","(손에 쿠키를 들고 있는 파란색 몬스터와 쓰레기통을 옷으로 입고 있는 몬스터, 2명에서 들어온다.)"
				,"주인공 : 어서오세요~!","(이게 뭔 냄새지? 저 쓰레기통 옷에서 나는 건가?)","몬스터1(쿠키몬스터) : 오스카, 뭐먹을꺼야?","몬스터2(오스카) : 오늘도 역시 늘 먹던 걸로."
				,"주인공 : 제가 오늘 처음 근무하는 거라서요. 메뉴명 말씀해주실 수 있나요?","몬스터2(오스카) : 음, 아.아 톨 사이즈 말하는 거였어요."
				,"주인공 : 아이스 아메리카노 톨 사이즈 한잔이요, 옆에 분도 주문하시나요?","몬스터1(쿠키몬스터) : 달달한 거 먹고 싶은데, 추천해줄 수 있을까요?"
				,"주인공 : 신상으로 나온 ‘아빠는 외계인’이 손님께서 찾으시는 맛일 것 같네요~","몬스터1(쿠키몬스터) : 앗 그럼, ‘아빠와 나는 외계인’ 주세요"
				,"주인공 : 넵 ‘아빠와 나는 외계인’이요. 잠시만 기다려주세요~!"};
	private String[] story3_text = {"(손님들이 나가고 점장이 들어옴)","점장 : (매장에 있는 쿠키몬스터와 오스카를 뚫어져라 쳐다본다.)","저 손님들 독특하지? 띠삐뿨꺼?","주인공 : (? 그쪽도..) 예..독특하신 거 같아요."
				,"점장 : 띠삐뿨거, 궁금할 것 같아서 얘기하는 건데 띠삐뿨꺼.","저 파란색 몬스터는 지금처럼 매일 손에 쿠키를 들고 다녀. ","벌써, 저 몬스터가 여기 카페에 처음 온지 한 324년정도 된 것 같은데."
				,"처음 온 날부터 매일 저렇게 쿠키를 들고 다니길래, 언제 한번 물어봤지. ","알고보니.. 제 1차 행성대전 때, 피난길에 엄마와 헤어졌었는데. 엄마가 마지막으로 준 것이 저 쿠키라서 매일 들고 다니는 거라하더군."
				,"주인공 : 세상에 그렇게 마음 아픈 일이..","그럼.. 저 쓰레기통 옷을 입고 있는 분은요..?","점장 : 쓰레기통? 아 오스카? 저 초록 외계인 말하는 건가?","주인공 : 예… 무슨 사연이라도.."
				,"점장 : 아..","저번에 물어봤었는데... 그냥 컨셉이랬네.","주인공 : 예?","점장 : 너처럼 인간도 외계인도 각자 다른 개성이 가지고 있지 않는가. 그거와 같네.","주인공 : ? 제가 ‘인간’이라는 거 알고 계셨어요?? "
				,"점장 : 내 눈이 괜히 3개가 아니라네. 띠삐뿨커.","주인공 : (딸랑~!) 어서오세요~!"};

	private String[] stroy4_text= {"주인공 : (딸랑~!) 어서오세요~!","(덩치큰 파란색 몬스터와 연두색의 몬스터, 괴물옷을 입은 어린 아이가 매장 안으로 들어왔다.)","연두색 몬스터 : 부는 뭘 좋아하지?","파란색 몬스터 : 역시 어린 애니까, 달콤한 게 낫지 않을까?"
				,"연두색 몬스터 : 아냐, 외관상으로 화려하거나 귀여운 게 아이들의 호기심을 자극하니까 분명 더 좋을 거야!","파란색 몬스터 : 아니야, 그래도 단 게 더 나을 거야. 겉으로는 멀쩡한데 맛이 없으면 먹지 않을거라고."
				,"연두색 몬스터 : 그럼, 직원한테 추천을 받자! 여기 어린 애가 먹을 만한 메뉴가 뭐가 있을까요?","눈알 네개 쉐이크는 어떠세요?","연두색 몬스터 : 오 그렇군요, 그걸로 주세요!"
				,"꼬마 아이 : 아이스 아메리카노를 한 번 맛보고는 맛 없다고 컵을 쳐서 엎어버린다."};

	private JLabel story1 = new JLabel();
	
	
	public JPanelStory(frame win)
	{
		this.win=win;
		setLayout(null);
		
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
		
		add(story1);
		story1.setBounds(50,625,1100,100);
		story1.setFont(new Font("배달의민족 도현", Font.BOLD, 25));
		
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
				if(story_num==0) {
						if(add==story1_text.length) {
							add=0;
							++story_num;
							Background = Toolkit.getDefaultToolkit().createImage("images/#2.jpg"); 
						}else {
							story1.setText(story1_text[add]);
							++add;
						}
				}
				if(story_num==1) {
					if(add==story1_1_text.length) {
						add=0;
						story_num++;
						Background = Toolkit.getDefaultToolkit().createImage("images/#4.jpg");
						win.change("order");
					}else {
						story1.setText(story1_1_text[add]);
						++add;
					}
				}
				if(story_num==2) {
					if(add==story2_text.length) {
						add=0;
						story_num++;
						Background = Toolkit.getDefaultToolkit().createImage("images/#3.jpg");
						win.change("order");
					}else {
						story1.setText(story2_text[add]);
						++add;
					}
				}
				if(story_num==3) {
					if(add==story3_text.length) {
						add=0;
						story_num++;
						win.change("order");
					}else {
						story1.setText(story3_text[add]);
						++add;
					}
				}
				if(story_num==4) {
					if(add==stroy4_text.length) {
						add=0;
						story_num++;
						win.change("order");
					}else {
						story1.setText(stroy4_text[add]);
						++add;
					}
				}
//				if(story_num==5) {
//					win.change("ending");
//				}
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
