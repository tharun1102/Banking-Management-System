package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {
    JButton exit,change;
    JPasswordField p1,p2;
    String pinnumber,cardnumber;
    PinChange(String pinnumber,String cardnumber){
        this.cardnumber = cardnumber;
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,840, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel atm = new JLabel(i3);
        atm.setBounds(0,0,900,840);
        add(atm);

        JLabel text = new JLabel("CHANGE  YOUR  PIN");
        text.setForeground(Color.white);
        text.setBounds(240,270,300,20);
        text.setFont(new Font("SAN_SERIf",Font.BOLD,18));
        atm.add(text);

        JLabel pintext = new JLabel("New PIN:");
        pintext.setBounds(160,320,100,20);
        pintext.setForeground(Color.white);
        pintext.setFont(new Font("SAN_SERIf",Font.BOLD,17));
        atm.add(pintext);

        p1 = new JPasswordField();
        p1.setBounds(320,315,190,30);
        p1.setFont(new Font("SAN_SERIF", Font.BOLD,15));
        atm.add(p1);

        JLabel newpin = new JLabel("Re-Enter New PIN:");
        newpin.setBounds(160,370,150,20);
        newpin.setForeground(Color.white);
        newpin.setFont(new Font("SAN_SERIf",Font.BOLD,17));
        atm.add(newpin);

        p2 = new JPasswordField();
        p2.setBounds(320,365,190,30);
        p2.setFont(new Font("SAN_SERIF", Font.BOLD,15));
        atm.add(p2);

        change = new JButton("CHANGE");
        change.setBounds(350,453,160,28);
        change.addActionListener(this);
        atm.add(change);

        exit = new JButton("BACK");
        exit.setBounds(350,485,160,28);
        exit.addActionListener(this);
        atm.add(exit);


        setSize(900,840);
        setUndecorated(true);
        setLocation(250,0);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==change) {
            try {
                String npin = p1.getText();
                String rpin = p2.getText();

                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered pin does not match");
                    return;
                }
                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter new PIN");
                    return;
                }
                if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                    return;
                }
                Conn c = new Conn();
                String query1 = "update bank set pin = '"+rpin+"' where pin ='"+pinnumber+"'";
                String query2 = "update login set pin = '"+rpin+"' where pin ='"+pinnumber+"'";
                String query3 = "update signup3 set pinnumber = '"+rpin+"' where pinnumber ='"+pinnumber+"'";
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN Changed Successfully");

                setVisible(false);
                new Transactions(rpin,rpin).setVisible(true);

            } catch (Exception ae) {
                System.out.println(ae);
            }
        }
          else{
              setVisible(false);
                  new Transactions(pinnumber,cardnumber).setVisible(true);
            }
        }

    public static void main(String[] args) {
        new PinChange("","").setVisible(true);
    }
}
