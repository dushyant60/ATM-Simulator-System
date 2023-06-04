package atm.simulator.system;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import java.util.Date;


public class FastCash extends JFrame implements ActionListener {

    JButton fc1, fc2, fc3, fc4, fc5, fc6, back;
    String pinnumber;
    FastCash (String pinnumber){
        this.pinnumber = pinnumber;


// Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 700);
        add(image);

// Buttons
        JLabel text = new JLabel("SELECT WITHDRAWAL AMOUNT");
        text.setBounds(170, 210, 700, 35);
        text.setFont(new Font("Raleway", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        image.add(text);

        fc1 = new JButton("Rs 100");
        fc1.setBounds(140, 305, 130, 25);
        fc1.addActionListener(this);
        image.add(fc1);

        fc2 = new JButton("Rs 500");
        fc2.setBounds(315, 305, 130, 25);
        fc2.addActionListener(this);
        image.add(fc2);

        fc3 = new JButton("Rs 1000");
        fc3.setBounds(140, 332, 130, 25);
        fc3.addActionListener(this);
        image.add(fc3);

        
        fc4 = new JButton("Rs 2000");
        fc4.setBounds(315, 332, 130, 25);
        fc4.addActionListener(this);
        image.add(fc4);

        fc5 = new JButton("Rs 5000");
        fc5.setBounds(140, 358, 130, 25);
        fc5.addActionListener(this);
        image.add(fc5);

    
        fc6 = new JButton("Rs 10000");
        fc6.setBounds(315, 358, 130, 25);
        fc6.addActionListener(this);
        image.add(fc6);

        back = new JButton("Back");
        back.setBounds(315, 385, 130, 25);
        back.addActionListener(this);
        image.add(back);

    
// Frame

        setSize(800, 700);
        setLocation(220, 0);
        setVisible(true);
    }

// Action Listner
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new transactions(pinnumber).setVisible(true);
        }else{
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from bank where pin_number = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit"))
                    {
                    balance += Integer.parseInt(rs.getString("amount"));
                    }else{ 
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                if(ae.getSource()!=back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return ;
                }
                Date date = new Date();
                String query = "insert into bank value ('"+pinnumber+"', '"+date+"', 'Withdrawal', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs" + amount + " Debited Sucessfully");
                setVisible(false);
                new transactions(pinnumber).setVisible(true);


            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }


    public static void main(String[] args){
        new FastCash("");

    }
}
