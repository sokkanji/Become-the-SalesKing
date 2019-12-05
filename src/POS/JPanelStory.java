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
	private Graphics screenGraphic; // ��üȭ�鿡 ���� �� �ν��Ͻ�
	private Image Background = Toolkit.getDefaultToolkit().createImage("images/#1.jpg");
	
	private int story_num=0;
	private int add=0;
	private int change = 0;
	
	private ImageIcon End[] = { new ImageIcon("images/End.png"), new ImageIcon("images/OnEnd.png") };
	private ImageIcon Nextbtn[] = { new ImageIcon("images/ANext.png"), new ImageIcon("images/BNext.png"),
			new ImageIcon("images/OnNext.png") }; ///
	
	private JButton Endbtn = new JButton(End[0]);
	private JButton Nbtn = new JButton(Nextbtn[0]);
	
	private String[] story1_text = {"����� �����л�","����� �ϻ�.","��ҿ� �Ȱ��� ���� ������ ������ ���δ�."
									,"������ ������ ������ �ٽ� �� ������ ���������忡 �ִ�.","���������忡�� �� ����� �Ⱬ�ϰ� ���� �ܰ����� �ִ�."
									,"������ ó���� �ܰ����� ���� �ʹ� ��� �� �� �����߾���.","������ �ٽ� ������ ���� �� ���� �������Ѽ� �ܰ������� ���Ⱑ ������� ������ ����Ѵ�."
									,"�����.. ���� �� ���嵵 �ǳ���..?","���� ���̳�? �߻��Ѳ�","���Ⱑ �����?","���Ⱑ ���� ȭ������ �峭�� �Ÿ� �׳� ����. ��ߗ���?", 
									"��... �׷�����.. �׷��� ������ ���ư����� ��� �ؾ� �ؿ�?","��Ÿ��� �ִ� �ܰ��� : ��ߗ���? �������� ��? ������ ������ ���ּ� Ÿ�� ������.",
									"���ּ�? ���ּ��� Ÿ���� ��� �ؾ� ����?","��Ÿ��� �ִ� �ܰ��� : ��ߗ��� ���� ��Ⱑ ���� �� ���Ƽ� ������ ���� �ö����ٵ�..... �󸶴���.."
									,"��Ÿ��� �ִ� �ܰ��� : ���� 100�����̾��� �� ���� ��߻���?","100�����̿�? �ʹ� ��ѵ���!!","�Ͼ� ���� ��� ������?","��Ÿ��� �ִ� �ܰ��� : �� �ʿ���?��ħ �� �տ� ī�� �ϳ��� �ִµ� ���ڱ� �˹ٻ� �ϳ��� �׸��ּ� ","������ ��û ����� �ϰ� �ִµ� ���� �˹� ��޶�� �� ���غ�. ��ߗ���?���� ���� ��������!"};
	private String[] story1_1_text= {"[�ܰ���ī��]","����~!","�ȳ��ϼ���.","���� : ��Ͷ� ��ߗ��� �� ��������? ��ߗ���?","���⼭ �Ƹ�����Ʈ�� �ϰ� �; �Դµ���.."
									,"���� : ���������������� ��� �˰� �Գ�? ��ߗ���?","�� �տ� �ִ� ���������� �˹ٸ� ���Ѵٴ� �ҽ��� ��� �Ծ��."
									,"���� : �����˿������� ���� �ٷ� �Ƹ�����Ʈ �� �� �ֳ�? ��ߗ���?","��? ���ݿ�? ","���� : �� �� �����԰� �ͼ� �ٷ� �����ض�. ��ߗ���"};
	private String[] story2_text= {"(����~! : �մ��� ������ ������ �Ҹ�)","(�տ� ��Ű�� ��� �ִ� �Ķ��� ���Ϳ� ���������� ������ �԰� �ִ� ����, 2������ ���´�.)"
									,"���ΰ� : �������~!","(�̰� �� ������? �� �������� �ʿ��� ���� �ǰ�?)","����1(��Ű����) : ����ī, ����������?","����2(����ī) : ���õ� ���� �� �Դ� �ɷ�."
									,"���ΰ� : ���� ���� ó�� �ٹ��ϴ� �Ŷ󼭿�. �޴��� �������ֽ� �� �ֳ���?","����2(����ī) : ��, ��.�� �� ������ ���ϴ� �ſ����."
									,"���ΰ� : ���̽� �Ƹ޸�ī�� �� ������ �����̿�, ���� �е� �ֹ��Ͻó���?","����1(��Ű����) : �޴��� �� �԰� ������, ��õ���� �� �������?"
									,"���ΰ� : �Ż����� ���� ���ƺ��� �ܰ��Ρ��� �մԲ��� ã���ô� ���� �� ���׿�~","����1(��Ű����) : �� �׷�, ���ƺ��� ���� �ܰ��Ρ� �ּ���"
									,"���ΰ� : �� ���ƺ��� ���� �ܰ��Ρ��̿�. ��ø� ��ٷ��ּ���~!"};
	private String[] story3_text = {"(�մԵ��� ������ ������ ����)","���� : (���忡 �ִ� ��Ű���Ϳ� ����ī�� �վ����� �Ĵٺ���.)","�� �մԵ� ��Ư����? ��ߗ���?","���ΰ� : (? ���ʵ�..) ��..��Ư�Ͻ� �� ���ƿ�."
									,"���� : ��ߗ���, �ñ��� �� ���Ƽ� ����ϴ� �ǵ� ��ߗ���.","�� �Ķ��� ���ʹ� ����ó�� ���� �տ� ��Ű�� ��� �ٳ�. ","����, �� ���Ͱ� ���� ī�信 ó�� ���� �� 324������ �� �� ������."
									,"ó�� �� ������ ���� ������ ��Ű�� ��� �ٴϱ淡, ���� �ѹ� �������. ","�˰�����.. �� 1�� �༺���� ��, �ǳ��濡 ������ ��������µ�. ������ ���������� �� ���� �� ��Ű�� ���� ��� �ٴϴ� �Ŷ��ϴ���."
									,"���ΰ� : ���� �׷��� ���� ���� ����..","�׷�.. �� �������� ���� �԰� �ִ� ������..?","���� : ��������? �� ����ī? �� �ʷ� �ܰ��� ���ϴ� �ǰ�?","���ΰ� : ���� ���� �翬�̶�.."
									,"���� : ��..","������ ����þ��µ�... �׳� �����̷���.","���ΰ� : ��?","���� : ��ó�� �ΰ��� �ܰ��ε� ���� �ٸ� ������ ������ ���� �ʴ°�. �װſ� ����.","���ΰ� : ? ���� ���ΰ����̶�� �� �˰� ��̾��?? "
									,"���� : �� ���� ���� 3���� �ƴ϶��. ��ߗ�Ŀ.","���ΰ� : (����~!) �������~!"};
			
	private String[] stroy4_text= {"���ΰ� : (����~!) �������~!","(��ġū �Ķ��� ���Ϳ� ���λ��� ����, �������� ���� � ���̰� ���� ������ ���Դ�.)","���λ� ���� : �δ� �� ��������?","�Ķ��� ���� : ���� � �ִϱ�, ������ �� ���� ������?"
									,"���λ� ���� : �Ƴ�, �ܰ������� ȭ���ϰų� �Ϳ��� �� ���̵��� ȣ����� �ڱ��ϴϱ� �и� �� ���� �ž�!","�Ķ��� ���� : �ƴϾ�, �׷��� �� �� �� ���� �ž�. �����δ� �����ѵ� ���� ������ ���� �����Ŷ��."
									,"���λ� ���� : �׷�, �������� ��õ�� ����! ���� � �ְ� ���� ���� �޴��� ���� �������?","���� �װ� ����ũ�� �����?","���λ� ���� : �� �׷�����, �װɷ� �ּ���!"
									,"���� ���� : ���̽� �Ƹ޸�ī�븦 �� �� �������� �� ���ٰ� ���� �ļ� ���������."};

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
		story1.setFont(new Font("����ǹ��� ����", Font.BOLD, 25));
		
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
							Background = Toolkit.getDefaultToolkit().createImage("images/#2.jpg"); //ī���̹����� ����
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
