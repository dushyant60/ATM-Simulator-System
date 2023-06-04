package atm.simulator.system;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import com.toedter.calendar.JDateChooser;

public class SignUp1 extends JFrame implements ActionListener {
    
        long random;
        JTextField nametextfield, fnametextfield, emailtextfield, addresstextfield, statetextfield, citytextfield, pincodetextfield;
        JRadioButton male, female, married, unmarried, other;
        JDateChooser dateChooser;
        JButton next; 

    SignUp1(){

        Random ran = new Random();
        random = Math.abs((ran.nextLong()%9000L)+1000L);
        
        setLayout(null);

//Applicaton No.
        JLabel appNo = new JLabel("Application No. : " + random);
        appNo.setFont(new Font("Raleway",Font.BOLD, 38));
        appNo.setBounds(200,20,600,40);
        add(appNo);
//Page 1
        JLabel personaldetails = new JLabel("Page 1: Personal Details");
        personaldetails.setFont(new Font("Raleway",Font.BOLD, 22));
        personaldetails.setBounds(280,80,400,30);
        add(personaldetails);
// Name
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD, 20));
        name.setBounds(120,130,200,30);
        add(name);
        nametextfield = new JTextField();
        nametextfield.setFont(new Font("Raleway", Font.BOLD, 14));
        nametextfield.setBounds(320, 130, 360, 30);
        add(nametextfield);
//Fathers Name
        JLabel fname = new JLabel("Fathers Name:");
        fname.setFont(new Font("Raleway",Font.BOLD, 20));
        fname.setBounds(120,170,400,30);
        add(fname);
        fnametextfield = new JTextField();
        fnametextfield.setFont(new Font("Raleway", Font.BOLD, 14));
        fnametextfield.setBounds(320, 170, 360, 30);
        add(fnametextfield);
//DOB
        JLabel dob = new JLabel("Date Of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD, 20));
        dob.setBounds(120,210,400,30);
        add(dob);
        dateChooser = new JDateChooser();
        dateChooser.setBounds(320, 210, 360, 30);
        dateChooser.setForeground(Color.BLACK);
        add(dateChooser);
// Gendre (Radio Buttons)
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD, 20));
        gender.setBounds(120,250,400,30);
        add(gender);
        male = new JRadioButton("Male");
        male.setBounds(320,250 ,100, 30);
        male.setBackground(Color.WHITE);
        add(male);
        female = new JRadioButton("Female");
        female.setBounds(460,250 ,100, 30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup gendregroup = new ButtonGroup();
        gendregroup.add(male);
        gendregroup.add(female);

// Email
        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway",Font.BOLD, 20));
        email.setBounds(120,290,400,30);
        add(email);
        emailtextfield = new JTextField();
        emailtextfield.setFont(new Font("Raleway", Font.BOLD, 14));
        emailtextfield.setBounds(320, 290, 360, 30);
        add(emailtextfield);

// Marital Status (Radio Button)
        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway",Font.BOLD, 20));
        marital.setBounds(120,330,400,30);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(320, 330, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(460, 330, 100, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        other = new JRadioButton("Other");
        other.setBounds(600, 330, 100, 30);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);
// Address
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD, 20));
        address.setBounds(120,370,400,30);
        add(address);
        addresstextfield = new JTextField();
        addresstextfield.setFont(new Font("Raleway", Font.BOLD, 14));
        addresstextfield.setBounds(320, 370, 360, 30);
        add(addresstextfield);

// City
        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD, 20));
        city.setBounds(120,410,400,30);
        add(city);
        citytextfield = new JTextField();
        citytextfield.setFont(new Font("Raleway", Font.BOLD, 14));
        citytextfield.setBounds(320, 410, 360, 30);
        add(citytextfield);

// State
        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD, 20));
        state.setBounds(120,450,400,30);
        add(state);
        statetextfield = new JTextField();
        statetextfield.setFont(new Font("Raleway", Font.BOLD, 14));
        statetextfield.setBounds(320, 450, 360, 30);
        add(statetextfield);

// Pin Code
        JLabel pincode = new JLabel("Pin Code:");
        pincode.setFont(new Font("Raleway",Font.BOLD, 20));
        pincode.setBounds(120,490,400,30);
        add(pincode);
        pincodetextfield = new JTextField();
        pincodetextfield.setFont(new Font("Raleway", Font.BOLD, 14));
        pincodetextfield.setBounds(320, 490, 360, 30);
        add(pincodetextfield);
// Next Button
        next = new JButton("Next");
        next.setBounds(600, 550, 80, 30);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);



        // Frame
        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(260, 10);
        setVisible(true);

    }
// Action Listner

    public void actionPerformed(ActionEvent ae){
        String appNo = "" + random;
        String name = nametextfield.getText();
        String fname = fnametextfield.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
                gender = "Male";
        }else if(female.isSelected()){
                gender = "Female";
        }
        String email = emailtextfield.getText();
        String marital = null;
        if(married.isSelected()){
                marital = "Married";
        }else if(unmarried.isSelected()){
                marital = "Unmarried";
        }else if(other.isSelected()){
                marital = "Other";
        }
        String address = addresstextfield.getText();
        String city = citytextfield.getText();
        String state = statetextfield.getText();
        String pincode = pincodetextfield.getText();


        try {
                if (name.equals("")){
                        JOptionPane.showMessageDialog(null, "Name is Required");
                }else{
                        Conn c = new Conn();
                        String query = "insert into signup values('"+appNo+"','"+name+"','"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
                        c.s.executeUpdate(query); 

                        // For proceding to page-2 with unique Application Number. 
                        setVisible(false);
                        new SignUp2(appNo).setVisible(true);
        ;
                }
        } catch (Exception e) {
                System.out.println(e);
        }

    }

    public static void main(String[] args) {
        new SignUp1();
    } 

}
