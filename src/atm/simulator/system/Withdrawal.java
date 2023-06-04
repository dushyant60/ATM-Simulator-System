package atm.simulator.system;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Withdrawal extends JFrame implements ActionListener {

    JButton withdraw, back;
    JTextField amount;
    String pinnumber;
    Withdrawal(String pinnumber){ 
        this.pinnumber = pinnumber; 

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 700);
        add(image);

        JLabel text = new JLabel("Enter the ammount you want to Witdraw.");
        text.setFont(new Font("Raleway", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        text.setBounds(140, 210, 700, 30);
        image.add(text);

        amount = new JTextField();
        amount.setBounds(140, 260, 300, 30);
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        image.add(amount);


// Buttons
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(340, 340, 100, 25);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back = new JButton("Back");
        back.setBounds(340, 370, 100, 25);
        back.addActionListener(this);
        image.add(back);




// Frame
        setSize(800, 700);
        setLocation(220, 0);
        setVisible(true);

    }


// Action Listner
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== withdraw){
            String withdrawammount = amount.getText();
            Date date = new Date();
            if(withdrawammount.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter the amount you want to Withdraw");
            }else{
                try {
                    Conn conn = new Conn();
                    String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawal', '"+withdrawammount+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+withdrawammount+ " Withdrawal Successfully");
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

        }else if(ae.getSource()==back){
            setVisible(false);
            new transactions(pinnumber).setVisible(true);
        }

    }

public static void main(String[] args) {
    new Withdrawal("");
}
}
