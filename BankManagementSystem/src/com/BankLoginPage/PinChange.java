package com.BankLoginPage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PinChange extends JFrame implements ActionListener {
	
	String pinnumber;
	JTextField pin , repin;
	JButton change , back;

	PinChange(String pinnumber) {
		
		this.pinnumber = pinnumber;
		
		setLayout(null);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/Atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);

		JLabel text = new JLabel("CHANGE YOUR PIN");
		text.setBounds(250, 280, 700, 35);
		text.setFont(new Font("System", Font.BOLD, 16));
		text.setForeground(Color.WHITE);
		image.add(text);
		
		
		JLabel pintext = new JLabel("NEW PIN:");
		pintext.setBounds(165, 350, 200, 30);
		pintext.setFont(new Font("System", Font.BOLD, 16));
		pintext.setForeground(Color.WHITE);
		image.add(pintext);
		
		
		JLabel Repintext = new JLabel("Re-Enter NEW PIN:");
		Repintext.setBounds(165, 400, 200, 30);
		Repintext.setFont(new Font("System", Font.BOLD, 16));
		Repintext.setForeground(Color.WHITE);
		image.add(Repintext);
		
		pin = new JTextField();
		pin.setFont(new Font("Raleway" , Font.BOLD , 25));
		pin.setBounds(340 ,  350 ,  150 , 25);
		image.add(pin);
		
		repin = new JTextField();
		repin.setFont(new Font("Raleway" , Font.BOLD , 25));
		repin.setBounds(340 ,  400 ,  150 , 25);
		image.add(repin);
		
		
		change = new JButton("CHANGE");
		change.setBounds(405, 485, 100, 30);
		change.addActionListener(this);
		image.add(change);
		
		back = new JButton("BACK");
		back.setBounds(405, 520, 100, 30);
		back.addActionListener(this);
		image.add(back);
		
		
		getContentPane().setBackground(Color.WHITE);
		setSize(900, 900);
		setLocation(300, 0);
		setUndecorated(true); // This line removes the Top portion of the Screen(eg:- cross mark , minimize and maximize logo)
		setVisible(true);

	}

	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==change)
		{
		try {
			String npin = pin.getText();
			String rpin = repin.getText();
			
			if(!npin.equals(rpin))
			{
				JOptionPane.showMessageDialog(null, "Entered PIN does not Match");
				return;
			}
			
			if(npin.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Please enter new PIN");
				return;
			}
			
			if(rpin.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
				return;
			}
			
			Conn co = new Conn();
			String query1 = "update bank set pin = '"+rpin+"' where pin='"+pinnumber+"'";
			String query2 = "update login set Pin_Number = '"+rpin+"' where Pin_Number='"+pinnumber+"'";
			String query3 = "update signupthree set Pin_Number = '"+rpin+"' where Pin_Number='"+pinnumber+"'";
			
			co.s.executeUpdate(query1);
			co.s.executeUpdate(query2);
			co.s.executeUpdate(query3);
			
			JOptionPane.showMessageDialog(null, "PIN changed Successfully");
			
			setVisible(false);
			Transactions tr = new Transactions(rpin);
			tr.setVisible(true);
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		}
		
		else
		{
			setVisible(false);
			Transactions tr = new Transactions(pinnumber);
			tr.setVisible(true);
		}
		
	}
	
	

	public static void main(String[] args) {

		PinChange pc = new PinChange("");

	}

}
