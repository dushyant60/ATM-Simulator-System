package atm.simulator.system;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class SignUp2 extends JFrame implements ActionListener{
    
    long random;
    JTextField existingaccounttextfield, seniorcitizentextfield, aadharnumbertextfield, pantextfield;
    JRadioButton yesbutton, nobutton, eyesbutton, enobutton;
    JComboBox religionbox, categorybox, incomebox, educationbox, occupationbox;
    JButton next;
    SignUp2(String appNo){
        setLayout(null);

//Page 2
        JLabel personaldetails = new JLabel("Page 2: Additional Details");
        personaldetails.setFont(new Font("Raleway",Font.BOLD, 22));
        personaldetails.setBounds(280,60,400,30);
        add(personaldetails);
// Religion
        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway",Font.BOLD, 20));
        religion.setBounds(120,130,200,30);
        add(religion);

        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Cristian", "Other"};
        religionbox = new JComboBox(valReligion);
        religionbox.setBounds(320, 130, 360, 30);
        religionbox.setBackground(Color.WHITE);
        add(religionbox);
        ;
//Category
        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway",Font.BOLD, 20));
        category.setBounds(120,170,400,30);
        add(category);

        String valCategory[] = {"General", "OBC", "SC", " ST"};
        categorybox = new JComboBox(valCategory);
        categorybox.setBackground(Color.WHITE);
        categorybox.setBounds(320, 170, 360, 30);
        add(categorybox);

//Income
        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway",Font.BOLD, 20));
        income.setBounds(120,210,400,30);
        add(income);

        String valIncome[] = {"Null", "< 1,50,000", "< 3,50,000", "< 5,00,000", "Upto 10,00,000"};
        incomebox = new JComboBox(valIncome);
        incomebox.setBackground(Color.WHITE);
        incomebox.setBounds(320, 210, 360, 30);
        add(incomebox);

// Education Qualification
        JLabel education = new JLabel("Education");
        education.setFont(new Font("Raleway",Font.BOLD, 20));
        education.setBounds(120,250,400,30);
        add(education);
        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway",Font.BOLD, 20));
        qualification.setBounds(120,270,400,30);
        add(qualification);

        String valEducation[] = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctorate", "Other"};
        educationbox = new JComboBox(valEducation);
        educationbox.setBackground(Color.WHITE);
        educationbox.setBounds(320, 270, 360, 30);
        add(educationbox);



// Occupation
        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway",Font.BOLD, 20));
        occupation.setBounds(120,310,400,30);
        add(occupation);

        String valOccuppation[] = {"Salaried", "Self-Employed", "Bussiness", "Student", "Retired", "Other"};
        occupationbox = new JComboBox(valOccuppation);
        occupationbox.setBackground(Color.WHITE);
        occupationbox.setBounds(320, 310, 360, 30);
        add(occupationbox);
// Pan Number
        JLabel panNo = new JLabel("Pan Number:");
        panNo.setFont(new Font("Raleway",Font.BOLD, 20));
        panNo.setBounds(120,350,400,30);
        add(panNo);
        pantextfield = new JTextField();
        pantextfield.setFont(new Font("Raleway", Font.BOLD, 14));
        pantextfield.setBounds(320, 350, 360, 30);
        add(pantextfield);

// Aadhar Number
        JLabel aadharNo = new JLabel("Aadhar Number:");
        aadharNo.setFont(new Font("Raleway",Font.BOLD, 20));
        aadharNo.setBounds(120,390,400,30);
        add(aadharNo);
        aadharnumbertextfield = new JTextField();
        aadharnumbertextfield.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharnumbertextfield.setBounds(320, 390, 360, 30);
        add(aadharnumbertextfield);

// Senior Citizen
        JLabel seniorcitizen = new JLabel("Senior Citizen:");
        seniorcitizen.setFont(new Font("Raleway",Font.BOLD, 20));
        seniorcitizen.setBounds(120,430,400,30);
        add(seniorcitizen);

        yesbutton = new JRadioButton("Yes");
        yesbutton.setBounds(320, 430, 100, 30);
        yesbutton.setBackground(Color.WHITE);
        add(yesbutton);

        nobutton = new JRadioButton("No");
        nobutton.setBounds(470, 430, 100, 30);
        nobutton.setBackground(Color.WHITE);
        add(nobutton);

        ButtonGroup seniorcitizenGroup = new ButtonGroup();
        seniorcitizenGroup.add(yesbutton);
        seniorcitizenGroup.add(nobutton);
       

// Existing Account (Radio Button)
        JLabel existingAccount = new JLabel("Existing Account:");
        existingAccount.setFont(new Font("Raleway",Font.BOLD, 20));
        existingAccount.setBounds(120,490,400,30);
        add(existingAccount);

        eyesbutton = new JRadioButton("Yes");
        eyesbutton.setBounds(320, 490, 100, 30);
        eyesbutton.setBackground(Color.WHITE);
        add(eyesbutton);

        enobutton = new JRadioButton("No");
        enobutton.setBounds(470, 490, 100, 30);
        enobutton.setBackground(Color.WHITE);
        add(enobutton);

        ButtonGroup existingaccnGroup = new ButtonGroup();
        existingaccnGroup.add(eyesbutton);
        existingaccnGroup.add(enobutton);

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

    public void actionPerformed(ActionEvent ae){
        String appNo = "" + random;
        String sreligion = (String) religionbox.getSelectedItem();
        String scategory = (String) categorybox.getSelectedItem();
        String sincome = (String) incomebox.getSelectedItem();
        String seducation = (String) educationbox.getSelectedItem();
        String soccupation = (String) occupationbox.getSelectedItem();
        String panNo = (String) pantextfield.getText();
        String aadharNo = (String) aadharnumbertextfield.getText();
        
        String seniorcitizen = null;
        if(yesbutton.isSelected()){
                seniorcitizen = "Yes";
        }else if(nobutton.isSelected()){
                seniorcitizen = "No";
        }
        
        String existingAccount = null;
        if(eyesbutton.isSelected()){
                existingAccount = "Yes";
        }else if(enobutton.isSelected()){
                existingAccount = "No";
        }

        try {
                Conn c = new Conn();
                String query = "insert into signup2 values('"+appNo+"','"+sreligion+"','"+scategory+"','"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+panNo+"', '"+aadharNo+"','"+seniorcitizen+"','"+existingAccount+"')";
                c.s.executeUpdate(query);


// For procceding to page no-3 with unique application no.
                setVisible(false);
                new SignUp3(appNo).setVisible(true);
                
        } catch (Exception e) {
                System.out.println(e);
        }

    }

    public static void main(String[] args){
        new SignUp2("");
    }

}
