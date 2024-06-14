package com.BankLoginPage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Deposit extends JFrame implements ActionListener{
	
	JButton deposit , back ;
	JTextField amountField;
	String pinnumber;
	
	Deposit(String pinnumber)
	{
		this.pinnumber = pinnumber;
		
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/Atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		JLabel text = new JLabel("Enter your amount: ");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System" , Font.BOLD , 16));
		text.setBounds(250, 320, 400, 30);
		image.add(text);
		
		amountField = new JTextField();
		amountField.setFont(new Font("Raleway" , Font.BOLD , 15));
		amountField.setBounds(235, 380, 180, 25);
		image.add(amountField);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(410, 485, 100, 25);
		deposit.addActionListener(this);
		image.add(deposit);
		
		back = new JButton("Back");
		back.setBounds(410,520, 100, 25);
		back.addActionListener(this);
		image.add(back);
		
		getContentPane().setBackground(Color.WHITE);
		setSize(900 , 900);
		setLocation(300, 0);
		setUndecorated(true);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == deposit)
		{
			String number = amountField.getText();
			Date date = new Date();
			
			if(number.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Please enter the amount");
			}
			else
			{
				try
				{
					
				Conn co = new Conn();
				String query = "insert into Bank values ('"+pinnumber+"' , '"+date+"' , 'Deposit' ,'"+number+"')";
				
				co.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Rs "+number+" Deposited Successfully");
				setVisible(false);
				Transactions trn = new Transactions(pinnumber);
				trn.setVisible(true);
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		}
		else if(ae.getSource() == back)
		{
			setVisible(false);
			Transactions trac = new Transactions(pinnumber);
			trac.setVisible(true);
		}
	}

	public static void main(String[] args) {

		Deposit d = new Deposit("");
		
	}

}
