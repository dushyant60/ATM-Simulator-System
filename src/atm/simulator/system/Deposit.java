package atm.simulator.system;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Deposit extends JFrame implements ActionListener {

    JButton deposit, back;
    JTextField amount;
    String pinnumber;
    Deposit(String pinnumber){ 
        this.pinnumber = pinnumber; 

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 700);
        add(image);

        JLabel text = new JLabel("Enter the ammount you want to deposit.");
        text.setFont(new Font("Raleway", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        text.setBounds(140, 210, 700, 30);
        image.add(text);

        amount = new JTextField();
        amount.setBounds(140, 260, 300, 30);
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        image.add(amount);


// Buttons
        deposit = new JButton("Deposit");
        deposit.setBounds(340, 340, 100, 25);
        deposit.addActionListener(this);
        image.add(deposit);

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
        if(ae.getSource()== deposit){
            String depositammount = amount.getText();
            Date date = new Date();
            if(depositammount.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter the amount you want to deposit");
            }else{
                try {
                    Conn conn = new Conn();
                    String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Deposit', '"+depositammount+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+depositammount+ " Deposited Successfully");
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
    new Deposit("");
}
}
