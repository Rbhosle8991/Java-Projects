package com.BankLoginPage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener{
	
	long random;
	JTextField nameTextField , FnameTextField , dobTextField ,   emailTextField  , addressTextField , cityTextField , stateTextField , pinTextField ;
	JRadioButton male , Female , married , unmarried , other;
	JDateChooser datechooser;
	JButton next;
	
	SignupOne()
	{
		setLayout(null);
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 1");
		
		Random ran = new Random();  // This line creates Random number
		random = Math.abs((ran.nextLong() % 9000L) + 1000L);   // This line creates Random number
		JLabel formno = new JLabel("APPLICATION FORM No: " + random);
		formno.setFont(new Font("Raleway" , Font.BOLD , 38));
		formno.setBounds(140, 20, 800, 40);
		add(formno);
		
		JLabel personalDetails = new JLabel("Page 1: Personal Details");
		personalDetails.setFont(new Font("Raleway" , Font.BOLD , 22));
		personalDetails.setBounds(290, 80, 400, 30);
		add(personalDetails);

		

		JLabel name = new JLabel("Name:");
		name.setFont(new Font("Raleway" , Font.BOLD , 20));
		name.setBounds(100, 140, 100, 30);
		add(name);
		
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		nameTextField.setBounds(300, 140, 400, 30);
		add(nameTextField);


		JLabel fathername = new JLabel("Father Name:");
		fathername.setFont(new Font("Raleway" , Font.BOLD , 20));
		fathername.setBounds(100, 190, 200, 30);
		add(fathername);
		
		FnameTextField = new JTextField();
		FnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		FnameTextField.setBounds(300, 190, 400, 30);
		add(FnameTextField);
		
		JLabel dob = new JLabel("DOB:");
		dob.setFont(new Font("Raleway" , Font.BOLD , 20));
		dob.setBounds(100, 240, 150, 30);
		add(dob);
		
		datechooser = new JDateChooser();  // First download JCalender jar file and paste that jar files in classpath.
		datechooser.setBounds(300, 240, 400, 30);
		add(datechooser);
		
		JLabel gender = new JLabel("Gender:");
		gender.setFont(new Font("Raleway" , Font.BOLD , 20));
		gender.setBounds(100, 290, 150, 30);
		add(gender);
		
		male = new JRadioButton("Male");
		male.setBounds(300, 290, 120, 30);
		male.setBackground(Color.WHITE);
		add(male);
		
		Female = new JRadioButton("Female");
		Female.setBounds(450, 290, 120, 30);
		Female.setBackground(Color.WHITE);
		add(Female);
		
		ButtonGroup gendergroup = new ButtonGroup();
		gendergroup.add(male);
		gendergroup.add(Female);
		
		
		JLabel email = new JLabel("Email Id:");
		email.setFont(new Font("Raleway" , Font.BOLD , 20));
		email.setBounds(100, 340, 150, 30);
		add(email);
		
		
		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		emailTextField.setBounds(300, 340, 400, 30);
		add(emailTextField);
		
		JLabel marital = new JLabel("Marital Status:");
		marital.setFont(new Font("Raleway" , Font.BOLD , 20));
		marital.setBounds(100, 390, 150, 30);
		add(marital);
		
		
		married = new JRadioButton("Married");
		married.setBounds(300, 390, 100, 30);
		married.setBackground(Color.WHITE);
		add(married);
		
		unmarried = new JRadioButton("Unmarried");
		unmarried.setBounds(450, 390, 100, 30);
		unmarried.setBackground(Color.WHITE);
		add(unmarried);
		
		other = new JRadioButton("Other");
		other.setBounds(630, 390, 100, 30);
		other.setBackground(Color.WHITE);
		add(other);
		
		ButtonGroup maritalgroup = new ButtonGroup();
		maritalgroup.add(married);
		maritalgroup.add(unmarried);
		maritalgroup.add(other);
		
		JLabel address = new JLabel("Address:");
		address.setFont(new Font("Raleway" , Font.BOLD , 20));
		address.setBounds(100, 440, 150, 30);
		add(address);
		
		addressTextField = new JTextField();
		addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		addressTextField.setBounds(300, 440, 400, 30);
		add(addressTextField);
		
		JLabel city = new JLabel("City:");
		city.setFont(new Font("Raleway" , Font.BOLD , 20));
		city.setBounds(100, 490, 150, 30);
		add(city);
		
		cityTextField = new JTextField();
		cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		cityTextField.setBounds(300, 490, 400, 30);
		add(cityTextField);
		
		JLabel state = new JLabel("State:");
		state.setFont(new Font("Raleway" , Font.BOLD , 20));
		state.setBounds(100, 540, 150, 30);
		add(state);
		
		stateTextField = new JTextField();
		stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		stateTextField.setBounds(300, 540, 400, 30);
		add(stateTextField);


		JLabel pincode = new JLabel("PinCode:");
		pincode.setFont(new Font("Raleway" , Font.BOLD , 20));
		pincode.setBounds(100, 590, 150, 30);
		add(pincode);
		
		pinTextField = new JTextField();
		pinTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		pinTextField.setBounds(300, 590, 400, 30);
		add(pinTextField);

		next = new JButton("Next");
		next.setBackground(Color.LIGHT_GRAY);
		next.setFont(new Font("Raleway", Font.BOLD, 14));
		next.setBounds(620, 660, 80, 30);
		next.addActionListener(this);
		add(next);
		
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(850 , 800);
		setLocation(350, 10);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String formno = "" + random;
		String name = nameTextField.getText();
		String fname = FnameTextField.getText();
		String dob =((JTextField)datechooser.getDateEditor().getUiComponent()).getText();
		String gender = null;
		if(male.isSelected())
		{
			gender = "Male";
		}
		else if(Female.isSelected())
		{
			gender = "Female";
		}
		
		String email = emailTextField.getText();
		String marital = null;
		if(married.isSelected())
		{
			marital = "Married";
		}
		else if(unmarried.isSelected())
		{
			marital = "Unarried";
		}
		else if(other.isSelected())
		{
			marital = "Other";
		}
		
		String address = addressTextField.getText();
		String city = cityTextField.getText();
		String state = stateTextField.getText();
		String pin = pinTextField.getText();
		
		
		
		try {
			if(name.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Name Field is Required");
			}
			else if(fname.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Father Name is Required");
			}
			else if(dob.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "DOB is Required");
			}
			else if(gender.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Select Gender");
			}
			else if(email.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Email Id is Required");
			}
			else if(marital.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Select Marital status");
			}
			else if(address.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Address is Required");
			}
			else if(city.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "City is Required");
			}
			else if(state.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "State is Required");
			}
			else if(pin.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Pin is Required");
			}
			else
			{
				Conn c = new Conn();
				String query = "insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+state+"', '"+pin+"')";
				c.s.executeUpdate(query);
				
				setVisible(false);
				SignUpTwo  sut = new SignUpTwo(formno);
				sut.setVisible(true);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		}
	
	

	public static void main(String[] args) {

		SignupOne sign = new SignupOne();
	}

}
