package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {
    JTextField amount;
    JButton withdrawl,back;
    String pinnumber,cardnumber;
    Withdrawl(String pinnumber,String cardnumber){
        this.cardnumber = cardnumber;
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,840,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel atm = new JLabel(i3);
        atm.setBounds(0,0,900,840);
        add(atm);

        JLabel text = new JLabel("ENTER  AMOUNT  YOU  WANT  TO  WITHDRAW");
        text.setBounds(172,280,600,30);
        text.setForeground(Color.white);
        text.setFont(new Font("SAN_SERIf",Font.BOLD,15));
        atm.add(text);

        amount = new JTextField();
        amount.setBounds(172,320,325,30);
        amount.setFont(new Font("SAN_SERIf",Font.BOLD,14));
        atm.add(amount);

        withdrawl = new JButton("WITHDRAW");
        withdrawl.setBounds(350,453,160,28);
        withdrawl.addActionListener(this);
        atm.add(withdrawl);

        back = new JButton("BACK");
        back.setBounds(350,485,160,28);
        back.addActionListener(this);
        atm.add(back);


        setSize(900,840);
        setUndecorated(true);
        setLocation(250,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == withdrawl) {
            String amountwithdraw = amount.getText();
            Date date = new Date();
            if (amountwithdraw.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to Withdraw");
            } else {
                try {
                    Conn c = new Conn();
                    String query = "insert into bank values('" + cardnumber +"','" + pinnumber + "','" + date + "','Withdrawl','" + amountwithdraw + "')";
                    c.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "RS. " + amountwithdraw + " Withdraw Successfully");
                    setVisible(false);
                    new Transactions(pinnumber,cardnumber).setVisible(true);
                } catch (Exception ae) {
                    System.out.println(ae);
                }
            }
        }
        else  if (e.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber,cardnumber).setVisible(true);
        }

    }

    public static void main(String[] args) {

        new Withdrawl("","");
    }

}

