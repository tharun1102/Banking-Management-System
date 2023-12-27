package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JButton back;
    String pinnumber,cardnumber;
    BalanceEnquiry(String pinnumber,String cardnumber){
        this.pinnumber= pinnumber;
        this.cardnumber= cardnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,840, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel atm = new JLabel(i3);
        atm.setBounds(0,0,900,840);
        add(atm);

        back = new JButton("Back");
        back.setBounds(350,485,160,28);
        back.addActionListener(this);
        atm.add(back);

        Conn c = new Conn();
        int balance = 0;
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pin ='" + pinnumber + "'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception ae){
            System.out.println(ae);
        }

        JLabel text = new JLabel("Your Current Account Balamce is Rs "+ balance);
        text.setForeground(Color.white);
        text.setFont(new Font("SAN_SERIF",Font.BOLD,14));
        text.setBounds(170,300,400,30);
        atm.add(text);

        setSize(900,840);
        setUndecorated(true);
        setLocation(250,0);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Transactions(pinnumber,cardnumber).setVisible(true);
    }
    public static void main(String[] args) {
        new BalanceEnquiry("","");
    }

}
