package atm.simulator.system;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class SignUp3 extends JFrame implements ActionListener {
    
    JLabel accountdetails, accType, cardNo, carddetail, number, pinNO, pindetail, pnumber, services;
    JRadioButton savings, fixed, current, reccuring;
    JCheckBox cb1, cb2, cb3, cb4, cb5, cb6, cb7;
    JButton submit, cancel;
    String appNo;



    SignUp3(String appNo){
        this.appNo = appNo;    

        setLayout(null);



// Page-3
        JLabel accountdetails = new JLabel("Page 3: Account Details");
        accountdetails.setFont(new Font("Raleway", Font.BOLD,24));
        accountdetails.setBounds(280,40,400,30);
        add(accountdetails);

// Account Type (Radio Button)

        JLabel accType = new JLabel("Account Type:");
        accType.setFont(new Font("Raleway", Font.BOLD,22));
        accType.setBounds(100,100,200,30);
        add(accType);

        savings = new JRadioButton("Savings Account");
        savings.setBounds(100, 140, 200, 30);
        savings.setFont(new Font("Raleway", Font.BOLD, 16));
        savings.setBackground(Color.WHITE);
        add(savings);

        fixed = new JRadioButton("Fixed Deposit Account");
        fixed.setBounds(100, 180, 200, 30);
        fixed.setFont(new Font("Raleway", Font.BOLD, 16));
        fixed.setBackground(Color.WHITE);
        add(fixed);

        current = new JRadioButton("Current Account");
        current.setBounds(350, 140, 200, 30);
        current.setFont(new Font("Raleway", Font.BOLD, 16));
        current.setBackground(Color.WHITE);
        add(current);

        reccuring = new JRadioButton("Reccuring Deposit Account");
        reccuring.setBounds(350, 180, 300, 30);
        reccuring.setFont(new Font("Raleway", Font.BOLD, 16));
        reccuring.setBackground(Color.WHITE);
        add(reccuring);

        ButtonGroup accounttype = new ButtonGroup();
        accounttype.add(savings);
        accounttype.add(fixed);
        accounttype.add(current);
        accounttype.add(reccuring);

// Card Number
         
        cardNo = new JLabel("Card Number:");
        cardNo.setBounds(100, 240, 200, 30);
        cardNo.setFont(new Font("Raleway", Font.BOLD, 22));
        add(cardNo);

        carddetail = new JLabel("Your 16 Digits Card Number.");
        carddetail.setBounds(100, 270, 300, 20);
        carddetail.setFont(new Font("Raleway", Font.BOLD, 12));
        add(carddetail);

        number = new JLabel("XXXX-XXXX-XXXX-7351");
        number.setBounds(350, 240, 300, 30);
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        add(number);

// Pin Number        
        pinNO = new JLabel("PIN Number:");
        pinNO.setBounds(100, 310, 200, 30);
        pinNO.setFont(new Font("Raleway", Font.BOLD, 22));
        add(pinNO);

        pindetail = new JLabel("Your 4 Digits PIN Number.");
        pindetail.setBounds(100, 340, 300, 20);
        pindetail.setFont(new Font("Raleway", Font.BOLD, 12));
        add(pindetail);

        pnumber = new JLabel("XXXX");
        pnumber.setBounds(350, 310, 300, 30);
        pnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        add(pnumber);

// Services

        services = new JLabel("Services Required:");
        services.setBounds(100, 380, 200, 30);
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        add(services);

        cb1 = new JCheckBox("ATM Card");
        cb1.setBounds(100, 420, 200, 20);
        cb1.setFont(new Font("Raleway", Font.BOLD, 18));
        cb1.setBackground(Color.WHITE);
        add(cb1);

        cb2 = new JCheckBox("Mobile Banking");
        cb2.setBounds(100, 460, 200, 20);
        cb2.setFont(new Font("Raleway", Font.BOLD, 18));
        cb2.setBackground(Color.WHITE);
        add(cb2);

        cb3 = new JCheckBox("Cheque Book");
        cb3.setBounds(100, 500, 200, 20);
        cb3.setFont(new Font("Raleway", Font.BOLD, 18));
        cb3.setBackground(Color.WHITE);
        add(cb3);

        cb4 = new JCheckBox("Internet Banking");
        cb4.setBounds(350, 420, 250, 20);
        cb4.setFont(new Font("Raleway", Font.BOLD, 18));
        cb4.setBackground(Color.WHITE);
        add(cb4);

        cb5 = new JCheckBox("E-Mail and SMS Alerts");
        cb5.setBounds(350, 460, 250, 20);
        cb5.setFont(new Font("Raleway", Font.BOLD, 18));
        cb5.setBackground(Color.WHITE);
        add(cb5);

        cb6 = new JCheckBox("E-Statements");
        cb6.setBounds(350, 500, 250, 20);
        cb6.setFont(new Font("Raleway", Font.BOLD, 18));
        cb6.setBackground(Color.WHITE);
        add(cb6);

        cb7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my Knowledge.");
        cb7.setBounds(100, 560, 700, 20);
        cb7.setFont(new Font("Raleway", Font.BOLD, 12));
        cb7.setBackground(Color.WHITE);
        add(cb7);

// Buttons
        cancel = new JButton("Cancel");
        cancel.setBounds(280, 600, 100, 30);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        submit = new JButton("Submit");
        submit.setBounds(440, 600, 100, 30);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);



// Frame
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(260, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==submit){
            String accountType = null;
            if(savings.isSelected()){
                accountType = "Saving Account";
            }else if(current.isSelected()){
                accountType = "Current Account";
            }else if(fixed.isSelected()){
                accountType = "Fixed Deposit Account";
            }else if(reccuring.isSelected()){
                accountType = "Recurring Deposit Account";
            }

            Random random = new Random();
            String cardnumber = "" +Math.abs((random.nextLong()%90000000L) + 9058083200000000L);

            String pinnumber = "" + Math.abs((random.nextLong()%9000L) + 1000L);

            String services = null;
            if(cb1.isSelected()){
                services = services + " ATM Card";
            }else if(cb2.isSelected()){
                services = services + " Mobile Banking";
            }else if(cb3.isSelected()){
                services = services + " Cheque Book";
            }else if(cb4.isSelected()){
                services = services + " Internet Banking";
            }else if(cb5.isSelected()){
                services = services + " E-Mail and SMS Alerts";
            }else if(cb6.isSelected()){
                services = services + " E-Statements";
            }

            try {
                Conn c = new Conn();
                String query1 = "insert into signup3 values('"+appNo+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"', '"+services+"')";
                String query2 = "insert into login values('"+appNo+"','"+cardnumber+"','"+pinnumber+"')";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\n Pin: " + pinnumber);

                setVisible(false);
                new Deposit(pinnumber).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }

         }else if(ae.getSource()==cancel){
            setVisible(false);
            new LogIn().setVisible(true);

         }
    }
    public static void main(String[] args) {
        new SignUp3("");
    }
}
