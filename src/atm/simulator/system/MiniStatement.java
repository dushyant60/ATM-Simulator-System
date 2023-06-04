package atm.simulator.system;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.text.html.HTML;

import com.mysql.cj.protocol.Resultset;


public class MiniStatement extends JFrame {
    
    MiniStatement(String pinnnumber){
        setLayout(null);

        setTitle("Mini Statement");

       

        JLabel bank = new JLabel("Olive Bank");
        bank.setBounds( 150, 20, 100, 30);
        bank.setFont(new Font("Raleway", Font.BOLD, 16));
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(30, 90, 300, 20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(30, 460, 300, 20);
        balance.setFont(new Font("Raleway", Font.BOLD, 14));
        add(balance);

        JLabel mini = new JLabel();
        mini.setBounds(30, 150, 350, 200);
        add(mini);


        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin_number = '"+pinnnumber+"'");
            while(rs.next()){
                card.setText("Card Number: XXXXXXXXXX" + rs.getString("card_Number").substring(10,16));

            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Conn conn = new Conn();
            int bal = 0;
            ResultSet rs = conn.s.executeQuery("select * from bank where pin_number = '"+pinnnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText()+ "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                
                if(rs.getString("type").equals("Deposit"))
                    {
                    bal += Integer.parseInt(rs.getString("amount"));
                    }else{ 
                        bal -= Integer.parseInt(rs.getString("amount"));
                    }
            }
            balance.setText("Your Current Account Balance is Rs " + bal);

        } catch (Exception e) {
            System.out.println(e);
        }



        setSize(400, 600);
        setLocation(40, 30);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }


    public static void main(String[] args) {
        new MiniStatement("");
    }
}
