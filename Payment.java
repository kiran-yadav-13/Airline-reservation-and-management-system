package Airline_Management_System;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;
import java.io.*;
import java.sql.*;
public class Payment extends JFrame implements ActionListener{
     
     JTextField t1,t2,t3,t4,t5,t6,t8,t9;
 	JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    Font f1;
    JButton b1,b2;
 	PreparedStatement preparedStatement;
 	Statement statement;
 	Connection con;
 	ResultSet result;
 	String sql;
 	String conUrl="jdbc:ucanaccess://C:\\Users\\Home\\Documents\\Login.accdb";
     Payment(){
    	 super("Payment Gateway");
    	setSize(750,450);
 		setVisible(true);
 		setLayout(null);
 		setLocation(400,100);
 		//o1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		f1=new Font("Tahoma",Font.PLAIN,17);
 		l0=new JLabel("Payment ");
 		l0.setBounds(60, 20, 250, 27);
 		l0.setFont(new Font("Tahoma",Font.PLAIN,26));
 		add(l0);
 		l1=new JLabel("Amount");
 		l1.setFont(f1);
 		l1.setBounds(60,75,170,27);
 		t1=new JTextField(10);
 		t1.setBounds(250,75,150,27);
 		l2=new JLabel("Flight Code");
 		l2.setFont(f1);
 		l2.setBounds(60,115,150,27);
 		t2=new JTextField(10);
 		t2.setBounds(250,115,150,27);
 		l3=new JLabel("Class Code");
 		l3.setFont(f1);
 		l3.setBounds(60,155,150,27);
 		t3=new JTextField(10);
 		t3.setBounds(250,155,150,27);
 		l4=new JLabel("Pay Date");
 		l4.setFont(f1);
 		l4.setBounds(60,195,150,27);
 		t4=new JTextField(10);
 		t4.setBounds(250,195,150,27);	
 		l5=new JLabel("Passport No");
 	    l5.setFont(f1);
 		l5.setBounds(60,235,150,27);
 		t5=new JTextField(60);
 		t5.setBounds(250,235,150,27);
 		l6=new JLabel("Card No");
 	    l6.setFont(f1);
 		l6.setBounds(60,275,150,27);
 		t6=new JTextField(60);
 		t6.setBounds(250,275,150,27);
 		b1=new JButton("PAY");
 		b1.setBounds(220,330,135,30);
 		b1.addActionListener(this);
 		b1.setBackground(Color.BLACK);
 		b1.setForeground(Color.WHITE);
 		b2=new JButton("RESET");
 		b2.setBounds(60,330,135,30);
 		b2.addActionListener(this);
 		b2.setBackground(Color.BLACK);
 		b2.setForeground(Color.WHITE);
 		add(b2);
 		add(b1);
 		add(l1);
 		add(t1);
 		add(l2);
 		add(t2);
 		add(l3);
 		add(t3);
 		add(l4);
 		add(t4);
 		add(l5);
 		add(t5);
 		add(l6);
 		add(t6);
 		
 		JPanel panel=new JPanel();
 		panel.setBorder(new TitledBorder(new LineBorder(new Color(0,0,0),2),"All the fields are necessary to be filled",
 				TitledBorder.LEADING, TitledBorder.TOP, null ,new Color(34,139,34)));
 		panel.setBounds(35,55,400,325);
 		add(panel);
 		
 		panel.setBackground(Color.WHITE);
 		ImageIcon i1=new ImageIcon("C:\\Users\\Home\\Downloads\\p1.jpeg");
 		Image i2=i1.getImage().getScaledInstance(250, 330, Image.SCALE_DEFAULT);
 		ImageIcon i3=new ImageIcon(i2);
 		
 		JLabel image=new JLabel(i3);
 		
 		image.setBounds(450, 50, 250, 330);
 		add(image);
 		getContentPane().setBackground(Color.WHITE);
 		try {
 			
 			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
 			 con=DriverManager.getConnection(conUrl);
 			if(con!=null)
 				System.out.println("Connected Sucessfully");
 			sql="select * from Flights";
 			statement=con.createStatement();
 			result=statement.executeQuery(sql);
 		}catch(Exception e)
 		{
 			System.out.println(e);
 		}
 		
     }
     public void actionPerformed(ActionEvent a) {
    	 String s=a.getActionCommand();
    	 if(s.equals("RESET")) {
    		    t1.setText("");
    			t2.setText("");
    			t3.setText("");
    			t4.setText("");
    			t5.setText("");
    			t6.setText("");
    	 }
    	 else if(s.equals("PAY")) {
    		 try {
    				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
    	        	 con=DriverManager.getConnection(conUrl);

    				if(con!=null) {
    					System.out.println("Connected Sucessfully");
    					sql="insert into Payments(Amount,FlightCode,ClassCode,PayDate,PassportNo,CardNo) values(?,?,?,?,?,?)";
    					preparedStatement=con.prepareStatement(sql);
    					preparedStatement.setString(1, t1.getText());
    					preparedStatement.setString(2, t2.getText());
    				   preparedStatement.setInt(3, Integer.parseInt(t3.getText()));
    				   preparedStatement.setString(4, t4.getText());
    					preparedStatement.setInt(5,Integer.parseInt(t5.getText()));
    					preparedStatement.setInt(6, Integer.parseInt(t6.getText()));
    					int row=preparedStatement.executeUpdate();
    					if(row>0) {
    						System.out.println("Details Inserted Sucessfully");
    						
    						sql="select Capacity from Sector where FlightCode='"+t2.getText()+"'and  ClassCode='"+t3.getText()+"'";
        					int seats=0;
        					result=statement.executeQuery(sql);
        					if(result.next())
        					{
        						 seats=result.getInt("Capacity");
        						System.out.println(seats);
        					}
        					sql="Update Sector set Capacity='"+(seats-1)+"' where FlightCode='"+t2.getText()+"'and ClassCode='"+t3.getText()+"'";  					
        					preparedStatement=con.prepareStatement(sql);
        					 row=preparedStatement.executeUpdate();
        					if(row>0)
        					{System.out.println("Record updated in Sector table Sucessfully");
        			         JOptionPane.showMessageDialog(null, "Booking Completed");
        			         setVisible(false);
        					}
    						}
    					
    					
    				}
    	 }
    		 catch(Exception e)
				{
					System.out.println(e);
				}}
     }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Payment();
			}
		});
	}

}
