package com.BankLoginPage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BalanceEnquiry extends JFrame implements ActionListener {

	String pinnumber;
	JButton back;

	BalanceEnquiry(String pinnumber) {

		this.pinnumber = pinnumber;

		setLayout(null);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/Atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);

		back = new JButton("Back");
		back.setBounds(405, 520, 100, 30);
		back.addActionListener(this);
		image.add(back);

		Conn c = new Conn();
		int balance = 0;
		try
		{
			ResultSet rs = c.s.executeQuery("Select * from bank where pin = '"+pinnumber+"'");
			
			while(rs.next())
			{
				if(rs.getString("type").equals("Deposit"))
				{
					balance +=Integer.parseInt(rs.getString("amoun"));
				}
				else
				{
					balance -=Integer.parseInt(rs.getString("amoun"));
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		JLabel text = new JLabel("Your current Account Balance is Rs " + balance);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Raleway" , Font.BOLD , 14));
		text.setBounds(170, 350, 500, 30);
		image.add(text);

		
		getContentPane().setBackground(Color.WHITE);
		setSize(900, 900);
		setLocation(300, 0);
		setUndecorated(true); // This line removes the Top portion of the Screen(eg:- cross mark , minimize
								// and maximize logo)
		setVisible(true);

	}

	public void actionPerformed(ActionEvent ae) {

		setVisible(false);
		Transactions tr = new Transactions(pinnumber);
		tr.setVisible(true);

	}

	public static void main(String[] args) {

		BalanceEnquiry be = new BalanceEnquiry("");

	}
}
