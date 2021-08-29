package Airline_Management_System;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.io.*;
import java.sql.*;
public class BookTicket extends JFrame implements ActionListener{
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17;
	JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19;
    int PassportNo;
    String Date;
	
	JButton b1,b2,b3,b4;
	Font f1;
	JRadioButton g1,g2;
	PreparedStatement preparedStatement;
	Statement statement;
	Connection con;
	ResultSet result;
	String sql;
	String conUrl="jdbc:ucanaccess://C:\\Users\\Home\\Documents\\Login.accdb";
	BookTicket(){
		super("BOOK TICKET");
		setSize(1000,620);
		setVisible(true);
		setLayout(null);
		setLocation(100,20);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1=new Font("Tahoma",Font.PLAIN,17);
		l0=new JLabel("Add personal Details");
		l0.setBounds(60, 10, 350, 27);
		l0.setFont(new Font("Tahoma",Font.PLAIN,22));
		add(l0);
		l1=new JLabel("Name");
		l1.setFont(f1);
		l1.setBounds(60,50,150,27);
		t1=new JTextField(10);
		t1.setBounds(200,50,150,27);
		l2=new JLabel("Email Id");
		l2.setFont(f1);
		l2.setBounds(60,85,150,27);
		t2=new JTextField(10);
		t2.setBounds(200,85,150,27);
		l3=new JLabel("Passport No");
		l3.setFont(f1);
		l3.setBounds(60,120,150,27);
		t3=new JTextField(10);
		t3.setBounds(200,120,150,27);
		l4=new JLabel("Mobile No");
		l4.setFont(f1);
		l4.setBounds(60,155,135,27);
		t4=new JTextField(10);
		t4.setBounds(200,155,150,27);
		
		l5=new JLabel("Age");
	    l5.setFont(f1);
		l5.setBounds(425,50,150,27);
		t5=new JTextField(60);
		t5.setBounds(565,50,150,27);
		l6=new JLabel("Adress");
		l6.setFont(f1);
		l6.setBounds(425,85,150,27);
		add(l6);
		
		t6=new JTextField(50);
		t6.setBounds(565,85,150,27);
		add(t6);
		l8=new JLabel("Nationality");
		l8.setFont(f1);
		l8.setBounds(425,120,150,27);
		add(l8);
		t8=new JTextField(20);
		t8.setBounds(565,120,150,27);
		add(t8);
		l9=new JLabel("Gender");
		l9.setFont(f1);
		l9.setBounds(425,155,150,27);
		add(l9);
		ButtonGroup bg=new ButtonGroup();
		g1=new JRadioButton("MALE");
		g1.setBounds(565,160,70,27);
		g2=new JRadioButton("FEMALE");
		g2.setBounds(645,160,70,27);
		g1.setBackground(Color.WHITE);
		g2.setBackground(Color.WHITE);
		bg.add(g1);
		bg.add(g2);
		add(g1);
		add(g2);
		l10=new JLabel("Add Flight Details");
		l10.setFont(new Font("Tahoma",Font.PLAIN,22));
		l10.setBounds(60,235,400,27);
		add(l10);
		l12=new JLabel("Flight Code");
		l12.setBounds(60,280,400,27);
		l12.setFont(f1);
		add(l12);
     	t9=new JTextField(20);
		t9.setBounds(200,280,150,27);
		add(t9);
		l11=new JLabel("Flight Name");
		l11.setFont(f1);
	    l11.setBounds(60,315,150,27);
		add(l11);
		
		t10=new JTextField(20);
		t10.setBounds(200,315,150,27);
		add(t10);
		
		l7=new JLabel("Source");
		l7.setFont(f1);
		l7.setBounds(60,350,150,27);
		t7=new JTextField(10);
		t7.setBounds(200,350,150,27);
		add(t7);
		
		l13=new JLabel("Destination");
		l13.setFont(f1);
		l13.setBounds(60,385,150,27);
		add(l13);
		t11=new JTextField(10);
		t11.setBounds(200,385,150,27);
		add(t11);
		l14=new JLabel("Fare");
		l14.setFont(f1);
		l14.setBounds(60,420,150,27);
		add(l14);
		t12=new JTextField(10);
		t12.setBounds(200,425,150,27);
		add(t12);
		l15=new JLabel("Arival Time");
		l15.setFont(f1);
		l15.setBounds(425,280,150,27);
		add(l15);
		t13=new JTextField(10);
		t13.setBounds(565,280,150,27);
		add(t13);
		l16=new JLabel("Departure Time");
		l16.setFont(f1);
		l16.setBounds(425,315,150,27);
		add(l16);
		t14=new JTextField(10);
		t14.setBounds(565,315,150,27);
		add(t14);
		l17=new JLabel("Class Code");
		l17.setFont(f1);
		l17.setBounds(425,350,150,27);
		add(l17);
		t15=new JTextField(10);
		t15.setBounds(565,350,150,27);
		add(t15);
		l18=new JLabel("Class Name");
		l18.setFont(f1);
		l18.setBounds(425,385,150,27);
		add(l18);
		t16=new JTextField(10);
		t16.setBounds(565,385,150,27);
		add(t16);
		l19=new JLabel("Date");
		l19.setFont(f1);
		l19.setBounds(425,420,150,27);
		add(l19);
		t17=new JTextField(10);
		t17.setBounds(565,425,150,27);
		add(t17);
		b2=new JButton("Reset");
		b2.setBounds(300,465,135,30);
		b2.addActionListener(this);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		add(b2);

		b1=new JButton("RESET");
		b1.setBounds(300,200,135,30);
		b1.addActionListener(this);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		add(b1);
	    b3=new JButton("BOOK TICKET");
		b3.setBounds(280,510,165,30);
	    b3.addActionListener(this);
		add(b3);
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		getContentPane().setBackground(Color.WHITE);
		b3.addActionListener(this);
		
		//add(b1);
		
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
		add(l7);
		 ImageIcon i1=new ImageIcon("C:\\Users\\Home\\Downloads\\b1.jpeg");
			Image i2=i1.getImage().getScaledInstance(280, 490, Image.SCALE_DEFAULT);
			ImageIcon i3=new ImageIcon(i2);
			
			JLabel image=new JLabel(i3);
			
			image.setBounds(720, 20, 280 ,490);
			add(image);
			
		try {
			
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			 con=DriverManager.getConnection(conUrl);
			if(con!=null)
				System.out.println("Connected Sucessfully");
			sql="select * from Sector";
			statement=con.createStatement();
			result=statement.executeQuery(sql);
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void actionPerformed(ActionEvent a)
	{  
		String str=a.getActionCommand();
		if(str.equals("RESET"))
		{
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
			t8.setText("");
		}
		else if(str.equals("Reset"))
		{
			t7.setText("");
			t9.setText("");
			t10.setText("");
			t11.setText("");
			t12.setText("");
			t13.setText("");
			t14.setText("");
			t15.setText("");
			t16.setText("");
			t17.setText("");
		}
		else if(str.equals("BOOK TICKET"))
		{   PassportNo=Integer.parseInt(t3.getText());
		    Date=t7.getText();
			String g=null;
			if(g1.isSelected())
			{
				g="Male";
			}
			else if(g2.isSelected())
			{
				g="Female";
			}
			try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	        	 con=DriverManager.getConnection(conUrl);

				if(con!=null) {
					System.out.println("Connected Sucessfully");
					sql="insert into BookedPer(UserName,EmailId,PassportNo,MobileNo,Age,Adress,Nationality,Gender,Dated) values(?,?,?,?,?,?,?,?,?)";
					preparedStatement=con.prepareStatement(sql);
					preparedStatement.setString(1, t1.getText());
					preparedStatement.setString(2, t2.getText());
					preparedStatement.setInt(3, Integer.parseInt(t3.getText()));
					preparedStatement.setInt(4, Integer.parseInt(t4.getText()));
					preparedStatement.setInt(5, Integer.parseInt(t5.getText()));
					preparedStatement.setString(6, t6.getText());
					preparedStatement.setString(7, t8.getText());
					preparedStatement.setString(8, g);
					preparedStatement.setString(9, t17.getText());
					int row=preparedStatement.executeUpdate();
					if(row>0)
						System.out.println("Details Inserted Sucessfully in Bookper");				
					sql="insert into BookedFl(FlightCode,FlightName,Source,Destination,Fare,ArivalTime,DepartureTime,ClassCode,ClassName,Dated,PassportNo) values(?,?,?,?,?,?,?,?,?,?,?)";
					preparedStatement=con.prepareStatement(sql);
					preparedStatement.setString(1, t9.getText());
					preparedStatement.setString(2, t10.getText());
					preparedStatement.setString(3, t7.getText());
					preparedStatement.setString(4, (t11.getText()));
					preparedStatement.setString(5, (t12.getText()));
					preparedStatement.setString(6, t13.getText());
					preparedStatement.setString(7, t14.getText());
					preparedStatement.setString(8, t15.getText());
					preparedStatement.setString(9, t16.getText());
					preparedStatement.setString(10, t17.getText());
					preparedStatement.setInt(11, Integer.parseInt(t3.getText()));
					 row=preparedStatement.executeUpdate();
					if(row>0) {
				   System.out.println("Details Inserted Sucessfully in BookFl");
					//new SittingArr();
					//JOptionPane.showMessageDialog(null, "Your Booking dtails saved.");
					setVisible(false);
					}
				}
				
			}catch(Exception e)
			{
				System.out.println(e);
			
			}
		}
		
		 
		  }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new BookTicket();
			}
		});
	}

}
