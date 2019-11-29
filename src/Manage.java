import java.awt.Color;
import java.awt.Font;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

class Manage extends JFrame{
	JPanel panel = new JPanel();
	DefaultTableModel dmodel;
	JTable table;
	JScrollPane scroll;
	Vector colName = new Vector();
	
	Manage(){
		
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
		
		add(panel);
		setSize(1500,500); 
        setResizable(false);
        setVisible(true);
	}
}
