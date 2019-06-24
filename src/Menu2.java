import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class Pos_system extends JFrame{
	public static final int SCREEN_WIDTH=1344;
	public static final int SCREEN_HEIGHT=780;
	private int menu_count[]= {0,0,0,0,0,0,0,0,0};
	private int menu_money[]= {0,0,0,0,0,0,0,0,0};

	private ImageIcon B_menu[] = {new ImageIcon("image/B_menu1.png"),new ImageIcon("image/B_menu2.png"),new ImageIcon("image/B_menu3.png"),
									new ImageIcon("image/B_menu4.png"),new ImageIcon("image/B_menu5.png"),new ImageIcon("image/B_menu6.png"),
									new ImageIcon("image/B_menu7.png"),new ImageIcon("image/B_menu8.png"),new ImageIcon("image/B_menu9.png")};
	
	private ImageIcon A_menu[] = {new ImageIcon("image/A_menu1.png"),new ImageIcon("image/A_menu2.png"),new ImageIcon("image/A_menu3.png"),
								new ImageIcon("image/A_menu4.png"),new ImageIcon("image/A_menu5.png"),new ImageIcon("image/A_menu6.png"),
								new ImageIcon("image/A_menu7.png"),new ImageIcon("image/A_menu8.png"),new ImageIcon("image/A_menu9.png")};
	
	private ImageIcon On_menu[] = {new ImageIcon("image/On_menu1.png"),new ImageIcon("image/On_menu2.png"),new ImageIcon("image/On_menu3.png"),
									new ImageIcon("image/On_menu4.png"),new ImageIcon("image/On_menu5.png"),new ImageIcon("image/On_menu6.png"),
									new ImageIcon("image/On_menu7.png"),new ImageIcon("image/On_menu8.png"),new ImageIcon("image/On_menu9.png")};
	
	private ImageIcon Inventory[]= {new ImageIcon("image/B_Inventory_btn.png"),new ImageIcon("image/A_Inventory_btn.png"),new ImageIcon("image/On_Inventory_btn.png")};
	
	private ImageIcon Init[]= {new ImageIcon("image/B_init.png"),new ImageIcon("image/A_init.png"),new ImageIcon("image/On_init.png")};
	
	private JButton Menu1 = new JButton(B_menu[0]);
	private JButton Menu2 = new JButton(B_menu[1]);
	private JButton Menu3 = new JButton(B_menu[2]);
	private JButton Menu4 = new JButton(B_menu[3]);
	private JButton Menu5 = new JButton(B_menu[4]);
	private JButton Menu6 = new JButton(B_menu[5]);
	private JButton Menu7 = new JButton(B_menu[6]);
	private JButton Menu8 = new JButton(B_menu[7]);
	private JButton Menu9 = new JButton(B_menu[8]);
	
	private JButton Inventory_btn = new JButton(Inventory[0]);
	
	private JButton Init_btn = new JButton(Init[0]);
	
	JPanel panel;
	JScrollPane sp;
	JTable table;
	
	Vector userColumn = new Vector();
	DefaultTableModel model;
	Vector userRow;
	
	
	Pos_system(){
		setLayout(null);
		setTitle("Pos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		/*JTextArea textArea = new JTextArea();
		textArea.setBounds(10,10,600,500);
		textArea.setEditable(false);
		
		panel.add(textArea);*/
		userColumn.addElement("이름");
		userColumn.addElement("수량");
		userColumn.addElement("가격");
		
		model = new DefaultTableModel(userColumn,0);
		
		table = new JTable(model);
		setBounds(10,10,600,500);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 1340, 780);
		
		sp = new JScrollPane(table);
		sp.setBounds(10,10,600,500);
		panel.add(sp);
		
		add(panel);
		
		Menu1.setBounds(660, 40,200,150);
		Menu1.setBorderPainted(false);
		Menu1.setFocusPainted(false);
		Menu1.setContentAreaFilled(false);
		Menu1.setPressedIcon(A_menu[0]);
		Menu1.setRolloverIcon(On_menu[0]);
		add(Menu1);
		panel.add(Menu1);
		Menu1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int rowIndex = table.getSelectedRow();
				menu_count[0]++;
				if(menu_count[0]==1) {
					userRow = new Vector();
					userRow.add("눈알 네 개 쉐이크");
					userRow.add(new Integer(menu_count[0]));
					userRow.add(menu_money[0]+=3400);
					model.addRow(userRow);
				}
				else {
					userRow = new Vector();
					userRow.add("눈알 네 개 쉐이크");
					userRow.add(new Integer(menu_count[0]));
					userRow.add(menu_money[0]+=3400);
					model.addRow(userRow);
					
				}
			}
		});
		
		Menu2.setBounds(870, 40,200,150);
		Menu2.setBorderPainted(false);
		Menu2.setFocusPainted(false);
		Menu2.setContentAreaFilled(false);
		Menu2.setPressedIcon(A_menu[1]);
		Menu2.setRolloverIcon(On_menu[1]);
		add(Menu2);
		panel.add(Menu2);
		Menu2.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int rowIndex = table.getSelectedRow();
				menu_count[1]++;
				if(menu_count[1]==1) {
					userRow = new Vector();
					userRow.add("베리베리 블루베리 마카롱");
					userRow.add(new Integer(menu_count[1]));
					userRow.add(menu_money[1]+=5000);
					model.addRow(userRow);
				}
				else {
					userRow = new Vector();
					userRow.add("베리베리 블루베리 마카롱");
					userRow.add(new Integer(menu_count[1]));
					userRow.add(menu_money[1]+=5000);
					model.addRow(userRow);
					
				}
			}
		});
		
		
		Menu3.setBounds(1080, 40,200,150);
		Menu3.setBorderPainted(false);
		Menu3.setFocusPainted(false);
		Menu3.setContentAreaFilled(false);
		Menu3.setPressedIcon(A_menu[2]);
		Menu3.setRolloverIcon(On_menu[2]);
		add(Menu3);
		panel.add(Menu3);
		
		Menu4.setBounds(660, 200,200,150);
		Menu4.setBorderPainted(false);
		Menu4.setFocusPainted(false);
		Menu4.setContentAreaFilled(false);
		Menu4.setPressedIcon(A_menu[3]);
		Menu4.setRolloverIcon(On_menu[3]);
		add(Menu4);
		panel.add(Menu4);
		
		Menu5.setBounds(870, 200,200,150);
		Menu5.setBorderPainted(false);
		Menu5.setFocusPainted(false);
		Menu5.setContentAreaFilled(false);
		Menu5.setPressedIcon(A_menu[4]);
		Menu5.setRolloverIcon(On_menu[4]);
		add(Menu5);
		panel.add(Menu5);
		
		Menu6.setBounds(1080, 200,200,150);
		Menu6.setBorderPainted(false);
		Menu6.setFocusPainted(false);
		Menu6.setContentAreaFilled(false);
		Menu6.setPressedIcon(A_menu[5]);
		Menu6.setRolloverIcon(On_menu[5]);
		add(Menu6);
		panel.add(Menu6);
		
		Menu7.setBounds(660, 360,200,150);
		Menu7.setBorderPainted(false);
		Menu7.setFocusPainted(false);
		Menu7.setContentAreaFilled(false);
		Menu7.setPressedIcon(A_menu[6]);
		Menu7.setRolloverIcon(On_menu[6]);
		add(Menu7);
		panel.add(Menu7);
		
		Menu8.setBounds(870, 360,200,150);
		Menu8.setBorderPainted(false);
		Menu8.setFocusPainted(false);
		Menu8.setContentAreaFilled(false);
		Menu8.setPressedIcon(A_menu[7]);
		Menu8.setRolloverIcon(On_menu[7]);
		add(Menu8);
		panel.add(Menu8);
		
		Menu9.setBounds(1080, 360,200,150);
		Menu9.setBorderPainted(false);
		Menu9.setFocusPainted(false);
		Menu9.setContentAreaFilled(false);
		Menu9.setPressedIcon(A_menu[8]);
		Menu9.setRolloverIcon(On_menu[8]);
		add(Menu9);
		panel.add(Menu9);
		
		Inventory_btn.setBounds(30,530,250,150);
		Inventory_btn.setBorderPainted(false);
		Inventory_btn.setFocusPainted(false);
		Inventory_btn.setContentAreaFilled(false);
		Inventory_btn.setPressedIcon(Inventory[1]);
		Inventory_btn.setRolloverIcon(Inventory[2]);
		add(Inventory_btn);
		panel.add(Inventory_btn);
		
		Init_btn.setBounds(320, 530, 250, 150);
		Init_btn.setBorderPainted(false);
		Init_btn.setFocusPainted(false);
		Init_btn.setContentAreaFilled(false);
		Init_btn.setPressedIcon(Init[1]);
		Init_btn.setRolloverIcon(Init[2]);
		add(Init_btn);
		panel.add(Init_btn);
		Init_btn.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				model.setNumRows(0);
				
			}
		});
		
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		setVisible(true);


	}
	
	private MouseListener MouseAdapter() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String ar[]) {
		new Pos_system();
		
	}
}
