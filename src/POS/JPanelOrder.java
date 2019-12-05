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
	private Graphics screenGraphic; // ��üȭ�鿡 ���� �� �ν��Ͻ�
	private Image Background = Toolkit.getDefaultToolkit().createImage("images/Menubackground.jpg");
	private Pos p;
	
	private ImageIcon monster[] = { new ImageIcon("images/monster1.png"), new ImageIcon("images/monster2.png"),
			new ImageIcon("images/monster3.png"), new ImageIcon("images/monster4.png"),
			new ImageIcon("images/monster5.png") };
	private ImageIcon End[] = { new ImageIcon("images/End.png"), new ImageIcon("images/OnEnd.png") };
	
	private JButton clickbtn = new JButton("Click!");
	private JButton Endbtn = new JButton(End[0]);
	
	int o_rand, o_rand2, m_rand, m_rand2;
	
	// ������ ��ư �̹���
		public static ImageIcon End[] = { new ImageIcon("images/End.png"), new ImageIcon("images/OnEnd.png") };
		public static JButton Endbtn = new JButton(End[0]);


	JPanelOrder(frame win, int ordernum)
	{	
		this.win=win;
		setLayout(null);
	
		// �����ư
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
				
		JLabel date = new JLabel(String.valueOf(ordernum));
		//JLabel money=new JLabel();
		//�ֹ� �޴� �̸� ���� ��
		JLabel order_txt[]=new JLabel[10];
		JLabel order_txt2[]=new JLabel[10];
		//�޴��̸�
		String Menu_txt[]= {"���� �� �� ����ũ", "ġŰġŰ ���� ��ī��", "���� ���丮 ���� ����ũ", "�������� ���纣�� ��ī��", "�ƺ��� ���� �ܰ��� ��",
				"�߸��߸� �����༺�� ���̵�", "���� ���丮���� ����ũ", "��� ���̳��� �Ƹ޸�ī��", "�Ž� �ּ� �������� ��Ű", "���ܾ��� ����ϱ�� ��Ű"};
		JLabel timerLabel = new JLabel();
		JLabel monsterLa[]=new JLabel[5];
		
		JLabel order_end = new JLabel("�� �ּ���.");
		JLabel order_end2 = new JLabel("����");
		
		JLabel priceLabel = new JLabel(String.valueOf(win.money));
		
		int i = 0;
		o_rand = 0;
		o_rand2 = 0;
		m_rand = 0;
		m_rand2 = 0;
		
		//�ֹ�
		for(i=0; i<Menu_txt.length; i++) {
			order_txt[i]=new JLabel(Menu_txt[i]); //�󺧿� �ֹ� �޴� �̸� ����
			order_txt2[i]=new JLabel(Menu_txt[i]);
		}
		
		o_rand = (int)(Math.random()*10);
		while(o_rand2==o_rand) {
			o_rand2 = (int)(Math.random()*10);
		}
		m_rand =  (int)(Math.random()*5+1);
		m_rand2 =  (int)(Math.random()*5+1);
		
		order_txt[o_rand].setBounds(500, 10, 400, 160);
		order_txt[o_rand].setFont(new Font("����ǹ��� ����", Font.BOLD, 25));
		
		order_txt2[o_rand2].setBounds(500, 45, 400, 160);
		order_txt2[o_rand2].setFont(new Font("����ǹ��� ����", Font.BOLD, 25));


		String num = Integer.toString(m_rand);
		JLabel menu_num = new JLabel(num);
		menu_num.setBounds(820, 10, 400, 160);
		menu_num.setFont(new Font("����ǹ��� ����", Font.BOLD, 30));
		
		String num2 = Integer.toString(m_rand2);
		JLabel menu_num2 = new JLabel(num2);
		menu_num2.setBounds(820, 45, 400, 160);
		menu_num2.setFont(new Font("����ǹ��� ����", Font.BOLD, 30));

		order_end.setBounds(840, 45, 400, 160);
		order_end.setFont(new Font("����ǹ��� ����", Font.BOLD, 25));
		order_end2.setBounds(840, 10, 400, 160);
		order_end2.setFont(new Font("����ǹ��� ����", Font.BOLD, 25));
		
		priceLabel.setBounds(265,15,400,160);
		priceLabel.setFont(new Font("����ǹ��� ����", Font.BOLD, 25)); 
		
		add(order_txt[o_rand]);
		add(order_txt2[o_rand2]);
		add(menu_num);
		add(menu_num2);
		add(order_end);
		add(order_end2);
		add(priceLabel);

		//Ÿ�̸�
		timerLabel.setFont(new Font("����ǹ��� ����", Font.CENTER_BASELINE, 50));
		add(timerLabel);
		timerLabel.setBounds(1195, 86, 100, 100);

		TimerThread th = new TimerThread(timerLabel,win);
		th.start();
		
		add(date);
		date.setFont(new Font("Gothic", Font.ITALIC, 35));
		date.setBounds(165, -5, 100, 100);
		
		//���� �̹��� ���
		for(i=0; i<monster.length; i++)
			monsterLa[i]= new JLabel(monster[i]);
		
		int r_monster=(int)(Math.random()*5);
		monsterLa[r_monster].setBounds(50, 95, 500, 500);
		add(monsterLa[r_monster]);
		
		//�����ư
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
		
		// click ��ư �ֱ�
		clickbtn.setBounds(927, 315, 130, 80);
		clickbtn.setBorderPainted(false);
		clickbtn.setFocusPainted(false);
		clickbtn.setContentAreaFilled(false);
		clickbtn.setFont(new Font("����ǹ��� ����", Font.BOLD, 30));
		clickbtn.setForeground(Color.BLUE);
		clickbtn.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e2) {
				p = new Pos(Menu_txt[o_rand],Menu_txt[o_rand2],m_rand, m_rand2,win);
				
			}
		});
		add(clickbtn);
		
		
		
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
