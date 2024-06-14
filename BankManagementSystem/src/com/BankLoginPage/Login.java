package com.BankLoginPage;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;

public class Login extends JFrame implements ActionListener {
	
	JButton login , clear , signup;
	JTextField  cardTextField ;
	JPasswordField PinTextField;
	
	Login()
	{
		
		setLayout(null); // no any Layout.
		
		setTitle("Automated Teller Machine");  // This line giver the Title for the Frame(in Left Top Corner).
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/bankLogo.jpg"));
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);  // This line will set the image size.
		ImageIcon i3 = new ImageIcon(i2);  // The Image is Converted into ImageIcon because in JLabel we cannot Pass Image.
		JLabel label = new JLabel(i3);
		label.setBounds(100, 10, 100, 100); // This line will set the Image where we want to put.
		add(label);  // This line adds Image on the Frame.
		
		
		JLabel text = new JLabel("Welcome to ATM");  // This line sets the text.
		text.setFont(new Font("Osward", Font.BOLD, 38));
		text.setBounds(230, 40, 400, 40);  //This line is used to where we want to put the Image.
		add(text);
		
		JLabel cardno = new JLabel("Card No");  // This line sets the text.
		cardno.setFont(new Font("Raleway", Font.BOLD, 28));
		cardno.setBounds(150, 150, 150, 30);  //This line is used to where we want to put the Image.
		add(cardno);
		
		
		cardTextField = new JTextField();  //This Line Creates a TextField.
		cardTextField.setBounds(300, 150, 230, 30);
		cardTextField.setFont(new Font("Arial" , Font.BOLD , 14));
		add(cardTextField);
		
		JLabel pin = new JLabel("PIN");  // This line sets the text.
		pin.setFont(new Font("Raleway", Font.BOLD, 28));
		pin.setBounds(150, 220, 150, 30);  //This line is used to where we want to put the Image.
		add(pin);
		
		PinTextField = new JPasswordField();  //This Line Creates a TextField.
		PinTextField.setBounds(300, 220, 230, 30);
		PinTextField.setFont(new Font("Arial" , Font.BOLD , 14));
		add(PinTextField);
		
		 login = new JButton("SIGN IN");  // This line is to create a Button.
		login.setBounds(300, 300, 100, 30);
		login.setBackground(Color.LIGHT_GRAY);  // This line changes the button background color.
		//login.setForeground(Color.WHITE);   This line changes the Button Font Color.
		login.addActionListener(this);
		add(login);
		
		
		 clear = new JButton("CLEAR");  // This line is to create a Button.
		clear.setBounds(430, 300, 100, 30);
		clear.setBackground(Color.LIGHT_GRAY);  // This line changes the button background color.
		clear.addActionListener(this);
		add(clear);
		
		
		signup = new JButton("SIGN UP");  // This line is to create a Button.
		signup.setBounds(300, 350, 230, 30);
		signup.setBackground(Color.LIGHT_GRAY);  // This line changes the button background color.
		signup.addActionListener(this);
		add(signup);
		
		
		getContentPane().setBackground(Color.WHITE);  // This line changes the Background color.
		
		
		setSize(800 , 480);   // setSize creates a frame of width 800 and 480 height.
		setVisible(true);  // This line makes the Frame Visible.
		setLocation(350, 200);  // This line makes the frame to open in center of Screen (or else it opens in Corner).
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == clear)
		{
			cardTextField.setText("");
			PinTextField.setText("");
		}
		else if(ae.getSource() == login)
		{
			Conn con = new Conn();
			String cardnumber = cardTextField.getText();
			String pinnumber = PinTextField.getText();
			
			String query = "Select * from login where Card_Number = '"+cardnumber+"' and Pin_Number ='"+pinnumber+"'";
			try
			{
				ResultSet rs = con.s.executeQuery(query);
				
				if(rs.next())
				{
					setVisible(false);
					Transactions tr = new Transactions(pinnumber);
					tr.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Incorrect CardNumber or PIN");
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		else if(ae.getSource() == signup)
		{
			setVisible(false);
			SignupOne so = new SignupOne();
			so.setVisible(true);
		}
	}

	public static void main(String[] args) {
		Login l = new Login();

		
	}

}
