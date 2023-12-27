package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {
   JButton deposit,fastcash,pinchange,withdrawl,ministatement,balanceenquiry,exit;
   String pinnumber,cardnumber;
    Transactions(String pinnumber,String cardnumber){

        this.cardnumber = cardnumber;
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,840,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel atm = new JLabel(i3);
        atm.setBounds(0,0,900,840);
        add(atm);

        JLabel text = new JLabel("Please Select Your Transaction");
        text.setBounds(220,290,300,20);
        text.setForeground(Color.white);
        text.setFont(new Font("SAN_SERIf",Font.BOLD,16));
        atm.add(text);

        deposit = new JButton("DEPOSIT");
        deposit.setBounds(160,387,160,28);
        deposit.addActionListener(this);
        atm.add(deposit);

        fastcash = new JButton("FAST CASH");
        fastcash.setBounds(160,420,160,28);
        fastcash.addActionListener(this);
        atm.add(fastcash);

        pinchange = new JButton("PIN CHANGE");
        pinchange.setBounds(160,453,160,28);
        pinchange.addActionListener(this);
        atm.add(pinchange);

        withdrawl = new JButton("CASH WITHDRAWL");
        withdrawl.setBounds(350,387,160,28);
        withdrawl.addActionListener(this);
        atm.add(withdrawl);

        ministatement = new JButton("MINI STATEMENT");
        ministatement.setBounds(350,420,160,28);
        ministatement.addActionListener(this);
        atm.add(ministatement);

        balanceenquiry = new JButton("BALANCE ENQUIRY");
        balanceenquiry.setBounds(350,453,160,28);
        balanceenquiry.addActionListener(this);
        atm.add(balanceenquiry);

        exit = new JButton("EXIT");
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
        if(e.getSource()==exit){
            System.exit(0);
        }
        else if(e.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber,cardnumber).setVisible(true);
        }
        else if(e.getSource()==withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber,cardnumber).setVisible(true);
        }
        else if(e.getSource()==fastcash){
            setVisible(false);
            new FastCash(pinnumber,cardnumber).setVisible(true);
        }
        else if(e.getSource()==pinchange){
            setVisible(false);
            new PinChange(pinnumber,cardnumber).setVisible(true);
        }
        else if(e.getSource()==balanceenquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber,cardnumber).setVisible(true);
        }
        else if(e.getSource()==ministatement){
            new MiniStatement(pinnumber,cardnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {

        new Transactions("","");
    }

}
