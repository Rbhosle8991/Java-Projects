package com.BankLoginPage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

public class SignUpTwo extends JFrame implements ActionListener{
	
	long random;
	JTextField panTextField , aadharTextField  ;
	JRadioButton yes , no , eyes , eno;
	JComboBox relig , cat , Inc , edu , occu ;
	JButton next;
	String formno;
	
	SignUpTwo(String formno)
	{
		this.formno = formno;
	
			setLayout(null);
			setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
		
			
			JLabel additionalDetails = new JLabel("Page 2: Additional Details");
			additionalDetails.setFont(new Font("Raleway" , Font.BOLD , 22));
			additionalDetails.setBounds(280, 40, 400, 40);
			add(additionalDetails);

			

			JLabel religion = new JLabel("Religion:");
			religion.setFont(new Font("Raleway" , Font.BOLD , 20));
			religion.setBounds(100, 140, 100, 30);
			add(religion);
			
			
			String ValReligion[] = {"" ,"Hindu" , "Muslim" , "Sikh" , "Christian" , "Jain" , "Parsi" , "Buddhism" , "Jews" , "Other"};
			relig = new JComboBox(ValReligion); 
			relig.setBounds(300, 140, 400, 30);
			relig.setBackground(Color.WHITE);
			add(relig);
			

			JLabel category = new JLabel("Category:");
			category.setFont(new Font("Raleway" , Font.BOLD , 20));
			category.setBounds(100, 190, 200, 30);
			add(category);
			
			
			String ValCategory[] = {"" ,"General" , "OBC" , "SC" , "ST" , "Other"};
			cat = new JComboBox(ValCategory);
			cat.setBounds(300, 190, 400, 30);
			cat.setBackground(Color.WHITE);
			add(cat);
			
			JLabel income = new JLabel("Income:");
			income.setFont(new Font("Raleway" , Font.BOLD , 20));
			income.setBounds(100, 240, 150, 30);
			add(income);
			
			String IncomeCategory[] = {"" , "Null" , "< 1,50,000" , "< 2,50,000" , "< 5,00,000" , "Upto 10,00,000"};
			Inc = new JComboBox(IncomeCategory);
			Inc.setBounds(300, 240, 400, 30);
			Inc.setBackground(Color.WHITE);
			add(Inc);
			
			JLabel education = new JLabel("Educational:");
			education.setFont(new Font("Raleway" , Font.BOLD , 20));
			education.setBounds(100, 290, 150, 30);
			add(education);
			
			JLabel qualification = new JLabel("Qualification:");
			qualification.setFont(new Font("Raleway" , Font.BOLD , 20));
			qualification.setBounds(100, 318, 150, 30);
			add(qualification);
			
			String educationcategory[] = {"" ,  "10th" , "12th" , "Graduate" , "Post Graduation" , "Doctrate" , "Others"};
			edu = new JComboBox(educationcategory);
			edu.setBounds(300, 318, 400, 30);
			edu.setBackground(Color.WHITE);
			add(edu);
			
			JLabel occupation = new JLabel("Occupation:");
			occupation.setFont(new Font("Raleway" , Font.BOLD , 20));
			occupation.setBounds(100, 390, 150, 30);
			add(occupation);
			
			String OccuCategory[] = {"" ,"Salaried" , "Self-Employed" , "Bussiness" , "Student" , "Retired" , "Others"};
			occu = new JComboBox(OccuCategory);
			occu.setBounds(300, 390, 400, 30);
			occu.setBackground(Color.WHITE);
			add(occu);
			
		
			JLabel pan = new JLabel("PAN Number:");
			pan.setFont(new Font("Raleway" , Font.BOLD , 20));
			pan.setBounds(100, 440, 150, 30);
			add(pan);
			
			panTextField = new JTextField();
			panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
			panTextField.setBounds(300, 440, 400, 30);
			add(panTextField);
			
			JLabel aadhar = new JLabel("Aadhar Number :");
			aadhar.setFont(new Font("Raleway" , Font.BOLD , 20));
			aadhar.setBounds(100, 490, 200, 30);
			add(aadhar);
			
			aadharTextField = new JTextField();
			aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
			aadharTextField.setBounds(300, 490, 400, 30);
			add(aadharTextField);
			
			JLabel senior = new JLabel("Senior Citizen:");
			senior.setFont(new Font("Raleway" , Font.BOLD , 20));
			senior.setBounds(100, 540, 150, 30);
			add(senior);
			
			yes = new JRadioButton("Yes");
			yes.setBounds(300, 540, 120, 30);
			yes.setBackground(Color.WHITE);
			add(yes);
			
			no = new JRadioButton("No");
			no.setBounds(450, 540, 120, 30);
			no.setBackground(Color.WHITE);
			add(no);
			
			ButtonGroup seniorgroup = new ButtonGroup();
			seniorgroup.add(yes);
			seniorgroup.add(no);
			


			JLabel existingacc = new JLabel("Existing Account:");
			existingacc.setFont(new Font("Raleway" , Font.BOLD , 20));
			existingacc.setBounds(100, 590, 200, 30);
			add(existingacc);
			
			eyes = new JRadioButton("Yes");
			eyes.setBounds(300, 590, 120, 30);
			eyes.setBackground(Color.WHITE);
			add(eyes);
			
			eno = new JRadioButton("No");
			eno.setBounds(450, 590, 120, 30);
			eno.setBackground(Color.WHITE);
			add(eno);
			
			ButtonGroup existinggroup = new ButtonGroup();
			existinggroup.add(eyes);
			existinggroup.add(eno);

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
			
			String sreligion = (String)relig.getSelectedItem();
			String scategory = (String)cat.getSelectedItem();
			String sincome =(String)Inc.getSelectedItem();
			String seducation = (String)edu.getSelectedItem();
			String soccupation = (String)occu.getSelectedItem();
			String senior = null;
			if(yes.isSelected())
			{
				senior = "Yes";
			}
			else if(no.isSelected())
			{
				senior = "No";
			}
			
			
			String existing = null;
			if(eyes.isSelected())
			{
				existing = "Yes";
			}
			else if(eno.isSelected())
			{
				existing = "No";
			}
			
			
			String span = panTextField.getText();
			String saadhar =aadharTextField.getText();
			
			
			
			
			try {
				if(sreligion.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Religion Field is Required");
				}
				else if(scategory.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Category is Required");
				}
				else if(sincome.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Income is Required");
				}
				else if(seducation.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Select your Educational Qualification");
				}
				else if(soccupation.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Occupation is Required");
				}
				else if(senior.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Select you are Senior Citizen or Not");
				}
				else if(existing.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Select Existing account Option");
				}
				else if(span.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Enter your PAN Card Number");
				}
				else if(saadhar.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Enter your Aadhar Card Number");
				}
				
				else
				{
					Conn c = new Conn();
					String query = "insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+senior+"', '"+existing+"', '"+span+"', '"+saadhar+"')";
					c.s.executeUpdate(query);
					
					setVisible(false);
					SignUpThree  stt = new SignUpThree(formno);
					stt.setVisible(true);
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
			
			}
		

	public static void main(String[] args) {

		SignUpTwo st = new SignUpTwo("");
	}

}
