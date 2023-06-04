package atm.simulator.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class LogIn extends JFrame implements ActionListener{

    JButton signin, clear, signup;
    JTextField cardTextField;
    JPasswordField pinTextField;

    LogIn() {

        setTitle("Automated Teller Machine");
        setLayout(null);

        //Logo_Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, DO_NOTHING_ON_CLOSE);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(90, 10, 100, 100);
        add(label);
        getContentPane().setBackground(Color.WHITE);
        
        //Text
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 500, 50);
        add(text);

        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 26));
        cardno.setBounds(110, 150, 150, 30);
        add(cardno);
        cardTextField = new JTextField();
        cardTextField.setBounds(260, 150, 230, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 26));
        pin.setBounds(110, 210, 150, 30);
        add(pin);
        pinTextField = new JPasswordField();
        pinTextField.setBounds(260, 210, 230, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);
        
        //BUTTON
        signin = new JButton("SIGN IN");
        signin.setBounds(260, 280, 100, 30);
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.WHITE);
        signin.addActionListener(this);
        add(signin);

        clear = new JButton("CLEAR");
        clear.setBounds(390, 280, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(260, 330, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);


         setSize(800, 480);
         setVisible(rootPaneCheckingEnabled);
         setLocation(260, 100);
    }
    
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()== clear){
            cardTextField.setText("");
            pinTextField.setText("");
        } else if(ae.getSource()==signin){
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();

            String query = "select * from login where card_Number = '"+cardnumber+"' and  pin_number = '"+pinnumber+"'";
            try {
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new transactions(pinnumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin.");
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        }else if(ae.getSource()==signup){
            setVisible(false);
            new SignUp1().setVisible(true);
        }

    }
    public static void main(String[] args) {
        new LogIn();
    }
    
}
