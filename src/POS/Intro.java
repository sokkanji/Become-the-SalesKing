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
	private Graphics screenGraphic; // ��üȭ�鿡 ���� �� �ν��Ͻ�
	private Image Background = Toolkit.getDefaultToolkit().createImage("images/Introbackground.jpg");

	// ������ ��ư �̹���
	private ImageIcon End[] = { new ImageIcon("images/End.png"), new ImageIcon("images/OnEnd.png") };
	// ���۹�ư �̹���
	private ImageIcon Startbtn[] = { new ImageIcon("images/BeforeStart.png"), // ��[0] ����, ��[1] ���콺 �÷��� ��, ��[2] ���콺 ���� ��
			new ImageIcon("images/AfterStart.png"), new ImageIcon("images/OnStart.png") };
	// ���۹�� �̹���
	private ImageIcon HowToPlaybtn[] = { new ImageIcon("images/BeforeHowToPlay.png"),
			new ImageIcon("images/AfterHowToPlay.png"), new ImageIcon("images/OnHowToPlay.png") };
	// �ڷΰ��� ��ư
	private ImageIcon Backbtn[] = { new ImageIcon("images/BeforeBack.png"), new ImageIcon("images/AfterBack.png"),
			new ImageIcon("images/OnBack.png") };

	private ImageIcon Checkbtn[] = { new ImageIcon("images/BeforeCheck.png"), new ImageIcon("images/AfterCheck.png"),
			new ImageIcon("images/OnCheck.png") };

	private ImageIcon Nextbtn[] = { new ImageIcon("images/ANext.png"), new ImageIcon("images/BNext.png"),
			new ImageIcon("images/OnNext.png") }; ///

	private ImageIcon monster[] = { new ImageIcon("images/monster1.png"), new ImageIcon("images/monster2.png"),
			new ImageIcon("images/monster3.png"), new ImageIcon("images/monster4.png"),
			new ImageIcon("images/monster5.png") };

	private JLabel order_txt[] = { new JLabel("���� �� �� ����ũ "), new JLabel("ġŰġŰ ���� ��ī��"), new JLabel("���� ���丮 ���� ����ũ") };
	private JLabel order_end = new JLabel("�� �ּ���.");

	private JLabel monsterLa = new JLabel(monster[1]);

	// ������, ����, ���۹�� ��ư
	private JButton Endbtn = new JButton(End[0]);
	private JButton Lbtn = new JButton(Startbtn[0]);
	private JButton Rbtn = new JButton(HowToPlaybtn[0]);

	private JButton Bbtn = new JButton(Backbtn[0]);
	private JButton Cbtn = new JButton(Checkbtn[0]);
	private JButton Nbtn = new JButton(Nextbtn[0]);

	private JButton clickbtn = new JButton("Click!");

	private JTextField Name = new JTextField(20);

	private JLabel story[] = { new JLabel("����� �����л� ����"), new JLabel("����� �ϻ�."), new JLabel("��ҿ� �Ȱ��� ���� ������ ������ ���δ�."),
			new JLabel("������ ������ ������ �ٽ� �� ������ ���������忡 �ִ�."), new JLabel("���������忡�� �� ����� �Ⱬ�ϰ� ���� �ܰ����� �ִ�."),
			new JLabel("������ ó���� �ܰ����� ���� �ʹ� ��� �� �� �����߾���."),
			new JLabel("������ �ٽ� ������ ���� �� ���� �������Ѽ� �ܰ������� ���Ⱑ ������� ������ ����Ѵ�."), new JLabel("�����.. ���� �� ���嵵 �ǳ���..?"),
			new JLabel("���� ���̳�? �߻��Ѳ�") };

	Random order_rand = new Random();
	Random Menu_rand = new Random();
	int o_rand = 0;
	int m_rand = 0;

	Intro() {
		setTitle("������� ����!!");
		
		Music introMusic = new Music("introMusic.MP3", true);
		introMusic.start();
		
		setUndecorated(true); // �������� �� �⺻������ ���̴� �޴��ٰ� �� ����.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
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

		// ���۹�ư
		Lbtn.setPressedIcon(Startbtn[1]);
		Lbtn.setRolloverIcon(Startbtn[2]);
		Lbtn.setBounds(350, 620, 220, 100);
		Lbtn.setBorderPainted(false);
		Lbtn.setFocusPainted(false);
		Lbtn.setContentAreaFilled(false);
		add(Lbtn);
		Lbtn.addMouseListener(new ConfigMouseAdapter());

		// ���۹�� ��ư
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

		// �ڷΰ����ư
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

	
	
	// ���丮 ȭ��
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

			// �̸� �Է�
			add(Name);
			Name.setVisible(true);
			Name.setBounds(140, 600, 400, 80);
			Name.setFont(new Font("����ǹ��� �־�", Font.BOLD, 45));
			Name.setOpaque(false);

			String name = Name.getText();

//			story[i].setBounds(100, 450, 800, 400);
//			story[i].setFont(new Font("����ǹ��� �־�", Font.BOLD, 30));
//			add(story[i]);
//			story[i].setVisible(false);

		}
	}

	
	
// Next ��ư�� ���� ����� (�ֹ� ȭ��)
	class NextMouseAdapter extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			Background = Toolkit.getDefaultToolkit().createImage("images/Menubackground.jpg");
			monsterLa.setBounds(10, 160, 400, 400);
			add(monsterLa);
			Nbtn.setVisible(false);
			Name.setVisible(false);

			o_rand = order_rand.nextInt(3);
			m_rand = Menu_rand.nextInt(7);
			order_txt[o_rand].setBounds(440, 10, 400, 160);
			order_txt[o_rand].setFont(new Font("����ǹ��� ����", Font.BOLD, 25));

			String num = Integer.toString(m_rand);
			JLabel menu_num = new JLabel(num);
			menu_num.setBounds(730, 10, 400, 160);
			menu_num.setFont(new Font("����ǹ��� ����", Font.BOLD, 25));

			order_end.setBounds(750, 10, 400, 160);
			order_end.setFont(new Font("����ǹ��� ����", Font.BOLD, 25));

			add(order_txt[o_rand]);
			add(menu_num);
			add(order_end);

			// click ��ư �ֱ�
			clickbtn.setBounds(927, 315, 130, 80);
			clickbtn.setBorderPainted(false);
			clickbtn.setFocusPainted(false);
			clickbtn.setContentAreaFilled(false);
			clickbtn.setFont(new Font("����ǹ��� ����", Font.BOLD, 30));
			clickbtn.setForeground(Color.BLUE);
			add(clickbtn);
			clickbtn.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e2) {
					new Pos();
				}
			});
		}
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