package POS;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

class Manage extends JFrame{
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	private ResultSet viewRS;
	
	final String[] btn_Title= {"눈알 네 개 쉐이크","베리베리 블루베리 마카롱","치키치키 초코 마카롱",
								"아빠와 나는 외계인 라떼","삐립삐립 지구행성맛 에이드","슈스 스트로베리 쉐이크",
								"룩앳 마이노즈 아메리카노","매쉬 핫솟 포테이토 쿠키","씨쁠씨쁠 사람일까요 쿠키"};
	final int[] menu_price= {4000,2500,2500,5500,5000,4000,3000,3500,3500};
	
	JButton[] btn = new JButton[9];
	JButton order_btn = new JButton("주문");
	JButton cancel_btn = new JButton("취소");
	JPanel panel = new JPanel();
	JLabel label1 = new JLabel("을 주문하시겠습니까?");
	JLabel label2 = new JLabel("?");
	JLabel label3 = new JLabel("주문 수량 입력 : ");
	JTextField tf = new JTextField();
	DefaultTableModel dmodel;
	JTable table;
	JScrollPane scroll;
	Vector colName = new Vector();
	Vector record;
	
	int num_index;//선택한 버튼에 따라 btn_Title 쓸수있는 변수
	
	Manage(frame win){
		
		
		colName.add("눈알 네 개 쉐이크"); //0

		colName.add("베리베리 블루베리 마카롱"); //1
		
		colName.add("치키치키 초코 마카롱"); //2

		colName.add("아빠와 나는 외계인 라떼"); //3
		
		colName.add("삐립삐립 지구행성맛 에이드"); //4
		
		colName.add("슈스 스트로베리 쉐이크"); //5
		
		colName.add("룩앳 마이노즈 아메리카노"); //6
		
		colName.add("매쉬 핫솟 포테이토 쿠키"); //7
		
		colName.add("씨쁠씨쁠 사람일까요 쿠키"); //8

		// model = new MyTableModel();
		
		
		

		dmodel = new DefaultTableModel(colName, 0) {

			public boolean isCellEditable(int row, int column) {
	
			return false;
	
			}

		};
		
		table = new JTable(dmodel);

		scroll = new JScrollPane(table);

		scroll.setBounds(60,30,1350,100);
		add(scroll);
	
		panel.setLayout(null);
		for(int i =0; i<btn_Title.length; i++){
			panel.add(btn[i]=new JButton(btn_Title[i]));
			btn[i].setSize(200,50);
			btn[i].setLocation(60+(250*i), 150);
			if(i>4) {
				btn[i].setLocation(60+(250*(i-5)), 230);
			}
		}
		
		for(int i=0; i<btn_Title.length; i++) {
			int num=i;
			btn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
						label2.setText(btn_Title[num]);
						
				}});
		}
		
		label2.setBounds(580, 300, 200, 50);
		add(label2);
		
		label1.setBounds(750, 300, 200, 50);
		add(label1);
		
		label3.setBounds(600,350,100,50);
		add(label3);
		
		tf.setBounds(700,360,200,30);
		add(tf);
		
		order_btn.setBounds(920,360,80,30);
		add(order_btn);
		order_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {	
					Class.forName("org.gjt.mm.mysql.Driver").newInstance();	
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/become_selling_king", "root", "mirim2");     
					System.out.println("DB 연결 완료");			
				}catch(Exception ex) {
			        System.out.println("Exception:" + ex);
			    }
				
				for(int i=0; i<9; i++) {
					if(label2.getText().equals(btn_Title[i])){
						num_index=i+1;
						break;
					}
				}
				
				try {
					int add = Integer.parseInt(tf.getText());
					String sql = "select * from inventory";
					pstmt = (PreparedStatement) conn.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();
					String sql2 = "update inventory set m?=?";
					pstmt = (PreparedStatement) conn.prepareStatement(sql2);
					while(rs.next()) {
						pstmt.setInt(1, num_index);
						pstmt.setInt(2, rs.getInt(num_index)+add);
					}
					pstmt.executeUpdate();
					win.money -= menu_price[num_index-1]*add;
					if(win.money<0) {
						dispose();
					}
					JOptionPane.showMessageDialog(null, 
							"주문이 완료되었습니다.", "알림", 
							JOptionPane.ERROR_MESSAGE);
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		cancel_btn.setBounds(1350,370,80,50);
		add(cancel_btn);
		cancel_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		
		add(panel);
		
		
		setSize(1500,500); 
        setResizable(false);
        setVisible(true);
	}
}
