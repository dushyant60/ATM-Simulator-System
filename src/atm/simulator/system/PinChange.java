package atm.simulator.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class PinChange extends JFrame implements ActionListener {
    
    String pinnumber;
    JPasswordField npin, renpin;
    JLabel newpin, renewpin;
    JButton change, back;


    PinChange(String pinnumber){
        this.pinnumber = pinnumber;

        setLayout(null);
// Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 700);
        add(image);


// Text and TextFiels
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(220, 220, 700, 35);
        text.setFont(new Font("Raleway", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        image.add(text);

        newpin = new JLabel("NEW PIN:");
        newpin.setBounds(150, 280, 100, 30);
        newpin.setFont(new Font("Raleway", Font.BOLD, 16));
        newpin.setForeground(Color.WHITE);
        image.add(newpin);

        npin = new JPasswordField();
        npin.setFont(new Font("Raleway", Font.BOLD, 20));
        npin.setBounds(280, 280, 170, 25);
        image.add(npin);

        renewpin = new JLabel("RE-ENTER PIN:");
        renewpin.setBounds(150, 310, 150, 30);
        renewpin.setFont(new Font("Raleway", Font.BOLD, 16));
        renewpin.setForeground(Color.WHITE);
        image.add(renewpin);

        renpin = new JPasswordField();
        renpin.setFont(new Font("Raleway", Font.BOLD, 20));
        renpin.setBounds(280, 310, 170, 25);
        image.add(renpin);

// Buttons
        change = new JButton("CHANGE");
        change.setBounds(350, 360, 100, 25);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setBounds(350, 390, 100, 25);
        back.addActionListener(this);
        image.add(back);



// Frame
        setSize(800, 700);
        setLocation(220, 0);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==change){
        try {
            String newPin = npin.getText();
            String reNewPin = renpin.getText();
            
            if(!newPin.equals(reNewPin)){
                JOptionPane.showMessageDialog(null, "Entered Pin does not match");
            }if (newPin.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter a four digit New Pin");

            }if (reNewPin.equals("")){
                JOptionPane.showMessageDialog(null, "Please Re-Enter new Pin");
                return;
            }

            Conn conn = new Conn();
            String query1 = "update bank set pin_number = '"+reNewPin+"' where pin_number = '"+pinnumber+"'";
            String query2 = "update login set pin_number = '"+reNewPin+"' where pin_number = '"+pinnumber+"'";
            String query3 = "update signup3 set pin_number = '"+reNewPin+"' where pin_number = '"+pinnumber+"'";

            conn.s.executeUpdate(query1);
            conn.s.executeUpdate(query2);
            conn.s.executeUpdate(query3);

            JOptionPane.showMessageDialog(null, "PIN Changed Successfully");

            setVisible(false);
            new transactions(reNewPin).setVisible(true);

        } catch (Exception e) {
            System.out.println(e);
        }
        
       }

    }


    public static void main(String[] args) {
        new PinChange("");
    }
}
