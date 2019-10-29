import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")

class Pos extends JFrame{
	private ImageIcon B_menu[] = {new ImageIcon("images/B_menu1.png"),new ImageIcon("images/B_menu2.png"),new ImageIcon("images/B_menu3.png"),
			new ImageIcon("images/B_menu4.png"),new ImageIcon("images/B_menu5.png"),new ImageIcon("images/B_menu6.png"),
			new ImageIcon("images/B_menu7.png"),new ImageIcon("images/B_menu8.png"),new ImageIcon("images/B_menu9.png")};

	private ImageIcon A_menu[] = {new ImageIcon("images/A_menu1.png"),new ImageIcon("images/A_menu2.png"),new ImageIcon("images/A_menu3.png"),
			new ImageIcon("images/A_menu4.png"),new ImageIcon("images/A_menu5.png"),new ImageIcon("images/A_menu6.png"),
			new ImageIcon("images/A_menu7.png"),new ImageIcon("images/A_menu8.png"),new ImageIcon("images/A_menu9.png")};
	
	private ImageIcon On_menu[] = {new ImageIcon("images/On_menu1.png"),new ImageIcon("images/On_menu2.png"),new ImageIcon("images/On_menu3.png"),
				new ImageIcon("images/On_menu4.png"),new ImageIcon("images/On_menu5.png"),new ImageIcon("images/On_menu6.png"),
				new ImageIcon("images/On_menu7.png"),new ImageIcon("images/On_menu8.png"),new ImageIcon("images/On_menu9.png")};
	
	private ImageIcon Inventory[]= {new ImageIcon("images/B_Inventory_btn.png"),new ImageIcon("images/A_Inventory_btn.png"),new ImageIcon("images/On_Inventory_btn.png")};
	
	private ImageIcon Init[]= {new ImageIcon("images/B_init.png"),new ImageIcon("images/A_init.png"),new ImageIcon("images/On_init.png")};
	
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
	
	private JLabel total_label = new JLabel("총합 : ");
//	private JTextField total_cost = new JTextField("0",10);
//	private JTextField total_cost2 = new JTextField("0",10);

	// MyTableModel model;

	DefaultTableModel dmodel;
	JTable table;
	JScrollPane scroll;
	Vector colName = new Vector();
	int selRow; // 선택한 셀
	String bar = "";
	int no = 1;
	Vector record;
	Vector vec;

	Pos(){
        // 주의, 여기서 setDefaultCloseOperation() 정의를 하지 말아야 한다
        // 정의하게 되면 새 창을 닫으면 모든 창과 프로그램이 동시에 꺼진다
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 1340, 780);
        
        Menu1.setBounds(660, 40,200,150);
		Menu1.setBorderPainted(false);
		Menu1.setFocusPainted(false);
		Menu1.setContentAreaFilled(false);
		Menu1.setPressedIcon(A_menu[0]);
		Menu1.setRolloverIcon(On_menu[0]);
		add(Menu1);
		panel.add(Menu1);
		Menu1.addMouseListener(new MouseAdapter() {
			int count=1;
			int price=4000;
			public void mousePressed(MouseEvent e) {
				if(table.getRowCount()!=0) {
					for(int i=0;i<table.getRowCount();i++) {
						if(table.getValueAt(i, 1).equals("눈알 네 개 쉐이크")) {
							table.setValueAt(count+=1, i, 2);
							table.setValueAt(price*count, i, 3);
						}
					}
					if(count==1) {
						record = new Vector();
						record.addElement(no);
						no+=1;
						record.addElement("눈알 네 개 쉐이크");
						record.addElement(count);
						record.addElement(price);
						dmodel.addRow(record);
					}
				}else {
					record = new Vector();
					record.addElement(no);
					no+=1;
					record.addElement("눈알 네 개 쉐이크");
					record.addElement(count);
					record.addElement(price);
					dmodel.addRow(record);
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
			int count=1;
			int price=2500;
			public void mousePressed(MouseEvent e) {
				if(table.getRowCount()!=0) {
					for(int i=0;i<table.getRowCount();i++) {
						if(table.getValueAt(i, 1).equals("베리베리 블루베리 마카롱")) {
							table.setValueAt(count+=1, i, 2);
							table.setValueAt(price*count, i, 3);
						}
					}
					if(count==1) {
						record = new Vector();
						record.addElement(no);
						no+=1;
						record.addElement("베리베리 블루베리 마카롱");
						record.addElement(count);
						record.addElement(price);
						dmodel.addRow(record);
					}
				}else {
					record = new Vector();
					record.addElement(no);
					no+=1;
					record.addElement("베리베리 블루베리 마카롱");
					record.addElement(count);
					record.addElement(price);
					dmodel.addRow(record);
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
		Menu3.addMouseListener(new MouseAdapter() {
			int count=1;
			int price=2500;
			public void mousePressed(MouseEvent e) {
				if(table.getRowCount()!=0) {
					for(int i=0;i<table.getRowCount();i++) {
						if(table.getValueAt(i, 1).equals("치키치키 초코 마카롱")) {
							table.setValueAt(count+=1, i, 2);
							table.setValueAt(price*count, i, 3);
						}
					}
					if(count==1) {
						record = new Vector();
						record.addElement(no);
						no+=1;
						record.addElement("치키치키 초코 마카롱");
						record.addElement(count);
						record.addElement(price);
						dmodel.addRow(record);
					}
				}else {
					record = new Vector();
					record.addElement(no);
					no+=1;
					record.addElement("치키치키 초코 마카롱");
					record.addElement(count);
					record.addElement(price);
					dmodel.addRow(record);
				}
			}
		});
		
		Menu4.setBounds(660, 200,200,150);
		Menu4.setBorderPainted(false);
		Menu4.setFocusPainted(false);
		Menu4.setContentAreaFilled(false);
		Menu4.setPressedIcon(A_menu[3]);
		Menu4.setRolloverIcon(On_menu[3]);
		add(Menu4);
		panel.add(Menu4);
		Menu4.addMouseListener(new MouseAdapter() {
			int count=1;
			int price=5500;
			public void mousePressed(MouseEvent e) {
				if(table.getRowCount()!=0) {
					for(int i=0;i<table.getRowCount();i++) {
						if(table.getValueAt(i, 1).equals("아빠와 나는 외계인 라떼")) {
							table.setValueAt(count+=1, i, 2);
							table.setValueAt(price*count, i, 3);
						}
					}
					if(count==1) {
						record = new Vector();
						record.addElement(no);
						no+=1;
						record.addElement("아빠와 나는 외계인 라떼");
						record.addElement(count);
						record.addElement(price);
						dmodel.addRow(record);
					}
				}else {
					record = new Vector();
					record.addElement(no);
					no+=1;
					record.addElement("아빠와 나는 외계인 라떼");
					record.addElement(count);
					record.addElement(price);
					dmodel.addRow(record);
				}
			}
		});
		
		Menu5.setBounds(870, 200,200,150);
		Menu5.setBorderPainted(false);
		Menu5.setFocusPainted(false);
		Menu5.setContentAreaFilled(false);
		Menu5.setPressedIcon(A_menu[4]);
		Menu5.setRolloverIcon(On_menu[4]);
		add(Menu5);
		panel.add(Menu5);
		Menu5.addMouseListener(new MouseAdapter() {
			int count=1;
			int price=5000;
			public void mousePressed(MouseEvent e) {
				if(table.getRowCount()!=0) {
					for(int i=0;i<table.getRowCount();i++) {
						if(table.getValueAt(i, 1).equals("삐립삐립 지구행성맛 에이드")) {
							table.setValueAt(count+=1, i, 2);
							table.setValueAt(price*count, i, 3);
						}
					}
					if(count==1) {
						record = new Vector();
						record.addElement(no);
						no+=1;
						record.addElement("삐립삐립 지구행성맛 에이드");
						record.addElement(count);
						record.addElement(price);
						dmodel.addRow(record);
					}
				}else {
					record = new Vector();
					record.addElement(no);
					no+=1;
					record.addElement("삐립삐립 지구행성맛 에이드");
					record.addElement(count);
					record.addElement(price);
					dmodel.addRow(record);
				}
			}
		});
		
		Menu6.setBounds(1080, 200,200,150);
		Menu6.setBorderPainted(false);
		Menu6.setFocusPainted(false);
		Menu6.setContentAreaFilled(false);
		Menu6.setPressedIcon(A_menu[5]);
		Menu6.setRolloverIcon(On_menu[5]);
		add(Menu6);
		panel.add(Menu6);
		Menu6.addMouseListener(new MouseAdapter() {
			int count=1;
			int price=4000;
			public void mousePressed(MouseEvent e) {
				if(table.getRowCount()!=0) {
					for(int i=0;i<table.getRowCount();i++) {
						if(table.getValueAt(i, 1).equals("슈스 스트로베리 쉐이크")) {
							table.setValueAt(count+=1, i, 2);
							table.setValueAt(price*count, i, 3);
						}
					}
					if(count==1) {
						record = new Vector();
						record.addElement(no);
						no+=1;
						record.addElement("슈스 스트로베리 쉐이크");
						record.addElement(count);
						record.addElement(price);
						dmodel.addRow(record);
					}
				}else {
					record = new Vector();
					record.addElement(no);
					no+=1;
					record.addElement("슈스 스트로베리 쉐이크");
					record.addElement(count);
					record.addElement(price);
					dmodel.addRow(record);
				}
			}
		});
		
		Menu7.setBounds(660, 360,200,150);
		Menu7.setBorderPainted(false);
		Menu7.setFocusPainted(false);
		Menu7.setContentAreaFilled(false);
		Menu7.setPressedIcon(A_menu[6]);
		Menu7.setRolloverIcon(On_menu[6]);
		add(Menu7);
		panel.add(Menu7);
		Menu7.addMouseListener(new MouseAdapter() {
			int count=1;
			int price=3000;
			public void mousePressed(MouseEvent e) {
				if(table.getRowCount()!=0) {
					for(int i=0;i<table.getRowCount();i++) {
						if(table.getValueAt(i, 1).equals("룩앳 마이노즈 아메리카노")) {
							table.setValueAt(count+=1, i, 2);
							table.setValueAt(price*count, i, 3);
						}
					}
					if(count==1) {
						record = new Vector();
						record.addElement(no);
						no+=1;
						record.addElement("룩앳 마이노즈 아메리카노");
						record.addElement(count);
						record.addElement(price);
						dmodel.addRow(record);
					}
				}else {
					record = new Vector();
					record.addElement(no);
					no+=1;
					record.addElement("룩앳 마이노즈 아메리카노");
					record.addElement(count);
					record.addElement(price);
					dmodel.addRow(record);
				}
			}
		});
		
		Menu8.setBounds(870, 360,200,150);
		Menu8.setBorderPainted(false);
		Menu8.setFocusPainted(false);
		Menu8.setContentAreaFilled(false);
		Menu8.setPressedIcon(A_menu[7]);
		Menu8.setRolloverIcon(On_menu[7]);
		add(Menu8);
		panel.add(Menu8);
		Menu8.addMouseListener(new MouseAdapter() {
			int count=1;
			int price=3500;
			public void mousePressed(MouseEvent e) {
				if(table.getRowCount()!=0) {
					for(int i=0;i<table.getRowCount();i++) {
						if(table.getValueAt(i, 1).equals("매쉬 핫솟 포테이토 쿠기")) {
							table.setValueAt(count+=1, i, 2);
							table.setValueAt(price*count, i, 3);
						}
					}
					if(count==1) {
						record = new Vector();
						record.addElement(no);
						no+=1;
						record.addElement("매쉬 핫솟 포테이토 쿠기");
						record.addElement(count);
						record.addElement(price);
						dmodel.addRow(record);
					}
				}else {
					record = new Vector();
					record.addElement(no);
					no+=1;
					record.addElement("매쉬 핫솟 포테이토 쿠기");
					record.addElement(count);
					record.addElement(price);
					dmodel.addRow(record);
				}
			}
		});
		
		Menu9.setBounds(1080, 360,200,150);
		Menu9.setBorderPainted(false);
		Menu9.setFocusPainted(false);
		Menu9.setContentAreaFilled(false);
		Menu9.setPressedIcon(A_menu[8]);
		Menu9.setRolloverIcon(On_menu[8]);
		add(Menu9);
		panel.add(Menu9);
		Menu9.addMouseListener(new MouseAdapter() {
			int count=1;
			int price=3500;
			public void mousePressed(MouseEvent e) {
				if(table.getRowCount()!=0) {
					for(int i=0;i<table.getRowCount();i++) {
						if(table.getValueAt(i, 1).equals("씨쁠씨쁠 사람일까요 쿠키")) {
							table.setValueAt(count+=1, i, 2);
							table.setValueAt(price*count, i, 3);
						}
					}
					if(count==1) {
						record = new Vector();
						record.addElement(no);
						no+=1;
						record.addElement("씨쁠씨쁠 사람일까요 쿠키");
						record.addElement(count);
						record.addElement(price);
						dmodel.addRow(record);
					}
				}else {
					record = new Vector();
					record.addElement(no);
					no+=1;
					record.addElement("씨쁠씨쁠 사람일까요 쿠키");
					record.addElement(count);
					record.addElement(price);
					dmodel.addRow(record);
				}
			}
		});
        
		Inventory_btn.setBounds(50,530,230,150);
		Inventory_btn.setBorderPainted(false);
		Inventory_btn.setFocusPainted(false);
		Inventory_btn.setContentAreaFilled(false);
		Inventory_btn.setPressedIcon(Inventory[1]);
		Inventory_btn.setRolloverIcon(Inventory[2]);
		add(Inventory_btn);
		panel.add(Inventory_btn); 
		Inventory_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					new Manage();
				}
		});
			
		
		
		Init_btn.setBounds(330, 530, 230, 150);
		Init_btn.setBorderPainted(false);
		Init_btn.setFocusPainted(false);
		Init_btn.setContentAreaFilled(false);
		Init_btn.setPressedIcon(Init[1]);
		Init_btn.setRolloverIcon(Init[2]);
		add(Init_btn);
		panel.add(Init_btn);
		Init_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for(int i = dmodel.getRowCount() - 1; i >= 0; i--) {
					
					dmodel.removeRow(i);
					
					}
			}
		});
				
		
		/*테이블 내용 변경시 자동으로 최종 금액나오게하는 이벤트*/
//		table.getModel().addTableModelListener(new TableModelListener() {
//			@Override
//			public void tableChanged(TableModelEvent e) {
//				int tcost=0;
//				int count=0;
//				// TODO Auto-generated method stub
//				for (int i = 0; i < dmodel.getRowCount(); i++) {
//					count = (Integer) table.getValueAt(i, 3);
//					tcost += count;
//				}
//				total_cost.setText(Integer.toString(tcost));
//				total_cost2.setText(total_cost.getText());
//			}
//		});
		
		colName.add("번호"); //0

		colName.add("상품명"); //1
		
		colName.add("수량"); //2

		colName.add("금액"); //3

		// model = new MyTableModel();

		dmodel = new DefaultTableModel(colName, 0) {

		public boolean isCellEditable(int row, int column) {

		return false;

		}

		};

		table = new JTable(dmodel);

		scroll = new JScrollPane(table);

		scroll.setBounds(30,10,600,500);
		add(scroll);
		
		total_label.setBounds(600,540,300,150);
		total_label.setFont(total_label.getFont().deriveFont(40.0f));
		add(total_label);
		
		//테이블 변경 자동 계산 코드
//		total_cost.setEditable(false);
//		total_cost2.setBounds(900,540,100,100);
//		add(total_cost2);
		
		add(panel);
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); 
        setResizable(false);
        setVisible(true);

	}
}