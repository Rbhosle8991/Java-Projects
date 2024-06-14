package com.BankLoginPage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class SignUpThree extends JFrame implements ActionListener{
	
	JRadioButton r1 , r2 , r3 , r4;
	JCheckBox c1 , c2, c3 , c4 , c5 , c6 , c7;
	JButton submit , cancel;
	String formno;
	
	SignUpThree(String formno)
	{
		
		this.formno = formno;
		
		setLayout(null);
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
		
		JLabel j3 = new JLabel("Page 3: Account Details");
		j3.setFont(new Font("Raleway" , Font.BOLD , 22));
		j3.setBounds(280, 40, 400, 40);
		add(j3);
		
		JLabel acctype = new JLabel("Account Type");
		acctype.setFont(new Font("Raleway" , Font.BOLD , 22));
		acctype.setBounds(100, 140, 200, 30);
		add(acctype);
		
		r1 = new JRadioButton("Saving Account");
		r1.setFont(new Font("Raleway" , Font.BOLD , 15));
		r1.setBounds(100 , 180 , 150 , 30);
		r1.setBackground(Color.WHITE);
		add(r1);
		
		r2 = new JRadioButton("Fixed Deposit Account");
		r2.setFont(new Font("Raleway" , Font.BOLD , 15));
		r2.setBounds(350 , 180 , 200 , 30);
		r2.setBackground(Color.WHITE);
		add(r2);
		
		r3 = new JRadioButton("Current Account");
		r3.setFont(new Font("Raleway" , Font.BOLD , 15));
		r3.setBounds(100 , 220 , 200 , 30);
		r3.setBackground(Color.WHITE);
		add(r3);
		
		r4 = new JRadioButton("Recurring Deposit Account");
		r4.setFont(new Font("Raleway" , Font.BOLD , 15));
		r4.setBounds(350 , 220 , 250 , 30);
		r4.setBackground(Color.WHITE);
		add(r4);
		
		ButtonGroup type = new ButtonGroup();
		type.add(r1);
		type.add(r2);
		type.add(r3);
		type.add(r4);
		
		JLabel cardno = new JLabel("Card Number:");
		cardno.setFont(new Font("Raleway" , Font.BOLD , 22));
		cardno.setBounds(100, 290, 200, 30);
		add(cardno);
		
		JLabel dumycard = new JLabel("XXXX XXXX XXXX 4194");
		dumycard.setFont(new Font("Raleway" , Font.BOLD , 22));
		dumycard.setBounds(330, 290, 350, 30);
		add(dumycard);
		

		JLabel pin = new JLabel("PIN:");
		pin.setFont(new Font("Raleway" , Font.BOLD , 22));
		pin.setBounds(100, 360, 200, 30);
		add(pin);
		
		JLabel pinno = new JLabel("XXXX");
		pinno.setFont(new Font("Raleway" , Font.BOLD , 22));
		pinno.setBounds(330, 360, 350, 30);
		add(pinno);
		
		JLabel services = new JLabel("Services Required:");
		services.setFont(new Font("Raleway" , Font.BOLD , 22));
		services.setBounds(100, 430, 300, 30);
		add(services);
		
		c1 = new JCheckBox("ATM Card");
		c1.setBackground(Color.WHITE);
		c1.setFont(new Font("Raleway" , Font.BOLD , 16));
		c1.setBounds(100, 480, 200, 30);
		add(c1);
		
		c2 = new JCheckBox("Internet Banking");
		c2.setBackground(Color.WHITE);
		c2.setFont(new Font("Raleway" , Font.BOLD , 16));
		c2.setBounds(350, 480, 200, 30);
		add(c2);
		
		c3 = new JCheckBox("Mobile Banking");
		c3.setBackground(Color.WHITE);
		c3.setFont(new Font("Raleway" , Font.BOLD , 16));
		c3.setBounds(100, 530, 200, 30);
		add(c3);
		
		c4 = new JCheckBox("Email & SMS Alerts");
		c4.setBackground(Color.WHITE);
		c4.setFont(new Font("Raleway" , Font.BOLD , 16));
		c4.setBounds(350, 530, 200, 30);
		add(c4);
		
		c5 = new JCheckBox("Cheque Book");
		c5.setBackground(Color.WHITE);
		c5.setFont(new Font("Raleway" , Font.BOLD , 16));
		c5.setBounds(100, 580, 200, 30);
		add(c5);
		
		c6 = new JCheckBox("E-Statement");
		c6.setBackground(Color.WHITE);
		c6.setFont(new Font("Raleway" , Font.BOLD , 16));
		c6.setBounds(350, 580, 200, 30);
		add(c6);
		
		c7 = new JCheckBox("I hereby declare that the above entered details are correct.");
		c7.setBackground(Color.WHITE);
		c7.setFont(new Font("Raleway" , Font.BOLD , 12));
		c7.setBounds(100, 640, 600, 30);
		add(c7);
		
		submit = new JButton("Submit");
		submit.setBackground(Color.LIGHT_GRAY);
		submit.setFont(new Font("Raleway" , Font.BOLD ,14));
		submit.setBounds(250, 700, 100, 30);
		submit.addActionListener(this);
		add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setBackground(Color.LIGHT_GRAY);
		cancel.setFont(new Font("Raleway" , Font.BOLD ,14));
		cancel.setBounds(450, 700, 100, 30);
		cancel.addActionListener(this);
		add(cancel);
		
		getContentPane().setBackground(Color.WHITE);
		setSize(850, 800);
		setLocation(350 , 10);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == submit)
		{
			String accountType = null;
			if(r1.isSelected())
			{
				accountType = "Saving Account";
			}
			else if(r2.isSelected())
			{
				accountType = "Fixed Deposit Account";
			}
			else if(r3.isSelected())
			{
				accountType = "Current Account";
			}
			else if(r4.isSelected())
			{
				accountType = "Recurring Deposit Account";
			}
			
			Random random = new Random();
			
			String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
			
			String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
			
			String facility = "";
			if(c1.isSelected())
			{
				facility = facility + " ATM Card";
			}
			 if(c2.isSelected())
			{
				facility = facility + " ,Internet Banking";
			}
			
			 if(c3.isSelected())
			{
				facility = facility + " ,Mobile Banking";
			}
			if(c4.isSelected())
			{
				facility = facility + " ,Email & SMS Alerts";
			}
			if(c5.isSelected())
			{
				facility = facility + " ,Cheque Book";
			}
			if(c6.isSelected())
			{
				facility = facility + " ,E-Statement";
			}
			
			try {
				
				if(accountType.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Account Type is Required");
				}
				else if(facility.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Facilities are required");
				}
				else
				{
					Conn co = new Conn();
					String query1 = "insert into SignUpThree values ('"+formno+"' , '"+accountType+"' , '"+cardnumber+"' , '"+pinnumber+"' , '"+facility+"')";
					String query2 = "insert into Login values ('"+formno+"' , '"+pinnumber+"' , '"+cardnumber+"' )";
					co.s.executeUpdate(query1);
					co.s.executeUpdate(query2);
					
					JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\n Pin: " + pinnumber);
					
					setVisible(false);
					Transactions tr = new Transactions(pinnumber);
					tr.setVisible(true);
				}
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		else if(ae.getSource() == cancel)
		{
			setVisible(false);
			Login  l = new Login();
			l.setVisible(true);
		}
	}

	public static void main(String[] args) {
		
		SignUpThree sth = new SignUpThree("");

		
	}

}
