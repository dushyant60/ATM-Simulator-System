package atm.simulator.system;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class transactions extends JFrame implements ActionListener {

    JButton deposit, widrawl, fastcash, statement, pinchange, balance, exit;
    String pinnumber;
    transactions(String pinnumber){
        this.pinnumber = pinnumber;


// Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 700);
        add(image);

// Buttons
        JLabel text = new JLabel("Please Select your Transaction");
        text.setBounds(170, 210, 700, 35);
        text.setFont(new Font("Raleway", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        image.add(text);

        deposit = new JButton("Cash Deposit");
        deposit.setBounds(140, 305, 130, 25);
        deposit.addActionListener(this);
        image.add(deposit);

        widrawl = new JButton("Cash Widrwal");
        widrawl.setBounds(315, 305, 130, 25);
        widrawl.addActionListener(this);
        image.add(widrawl);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(140, 332, 130, 25);
        fastcash.addActionListener(this);
        image.add(fastcash);

        
        statement = new JButton("Mini Statement");
        statement.setBounds(315, 332, 130, 25);
        statement.addActionListener(this);
        image.add(statement);

        pinchange = new JButton("Pin Change");
        pinchange.setBounds(140, 358, 130, 25);
        pinchange.addActionListener(this);
        image.add(pinchange);

    
        balance = new JButton("Balance Enquiry");
        balance.setBounds(315, 358, 130, 25);
        balance.addActionListener(this);
        image.add(balance);

        exit = new JButton("Exit");
        exit.setBounds(315, 385, 130, 25);
        exit.addActionListener(this);
        image.add(exit);

    
// Frame

        setSize(800, 700);
        setLocation(220, 0);
        setVisible(true);
    }

// Action Listner
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            System.exit(0);
        }else if (ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if (ae.getSource()== widrawl){
            setVisible(false);
            new Withdrawal(pinnumber).setVisible(true);
        }else if(ae.getSource() == fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if(ae.getSource()==pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }else if(ae.getSource()==balance){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if(ae.getSource()==statement){
            new MiniStatement(pinnumber).setVisible(true);
        }

    }


    public static void main(String[] args){
        new transactions("");

    }

}
