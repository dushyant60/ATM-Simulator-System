package atm.simulator.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
    JLabel text;
    JButton back;

    String pinnumber;
    BalanceEnquiry(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
// Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 700);
        add(image);
// Button

        back = new JButton("Back");
        back.setBounds(350, 360, 100, 25);
        back.addActionListener(this);
        image.add(back);

// Balance 
Conn c = new Conn();
int balance = 0; 
try {
    ResultSet rs = c.s.executeQuery("select * from bank where pin_number = '"+pinnumber+"'");
    while(rs.next()){
        if(rs.getString("type").equals("Deposit"))
        {
        balance += Integer.parseInt(rs.getString("amount"));
        }else{ 
            balance -= Integer.parseInt(rs.getString("amount"));
        }
    }
    } catch (Exception e) {
        System.out.println(e);
    }

    text = new JLabel("Your Account Balance is Rs " + balance);
    text.setForeground(Color.WHITE);
    text.setFont(new Font("Raleway", Font.BOLD, 14));
    text.setBounds(140, 250, 700, 30);
    image.add(text);

// Frame
        setSize(800, 700);
        setLocation(220, 0);
        setVisible(true);
        

    }

    public void actionPerformed(ActionEvent ae){
            setVisible(false);
            new transactions(pinnumber).setVisible(true);

    }
    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
