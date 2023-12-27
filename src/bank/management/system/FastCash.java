package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JButton amt1,amt2,amt3,amt4,amt5,amt6,exit;
    String pinnumber,cardnumber;
    FastCash(String pinnumber,String cardnumber){

        this.cardnumber = cardnumber;
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,840,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel atm = new JLabel(i3);
        atm.setBounds(0,0,900,840);
        add(atm);

        JLabel text = new JLabel("Select Withdrawl Aount");
        text.setBounds(220,290,300,20);
        text.setForeground(Color.white);
        text.setFont(new Font("SAN_SERIf",Font.BOLD,16));
        atm.add(text);

        amt1 = new JButton("Rs 100");
        amt1.setBounds(160,387,160,28);
        amt1.addActionListener(this);
        atm.add(amt1);

        amt2 = new JButton("Rs 500");
        amt2.setBounds(160,420,160,28);
        amt2.addActionListener(this);
        atm.add(amt2);

        amt3 = new JButton("Rs 1000");
        amt3.setBounds(160,453,160,28);
        amt3.addActionListener(this);
        atm.add(amt3);

        amt4 = new JButton("Rs 2000");
        amt4.setBounds(350,387,160,28);
        amt4.addActionListener(this);
        atm.add(amt4);

        amt5 = new JButton("Rs 5000");
        amt5.setBounds(350,420,160,28);
        amt5.addActionListener(this);
        atm.add(amt5);

        amt6 = new JButton("Rs 10000");
        amt6.setBounds(350,453,160,28);
        amt6.addActionListener(this);
        atm.add(amt6);

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
        if(e.getSource()==exit){
            setVisible(false);
            new Transactions(pinnumber,cardnumber).setVisible(true);
        }
        else {
            String amount = ((JButton)e.getSource()).getText().substring(3);
            Conn c = new Conn();
            try{
               ResultSet rs = c.s.executeQuery("select * from bank where pin ='"+pinnumber+"'");
               int balance=0;
               while(rs.next()){
                  if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                   }
                  else{
                      balance -= Integer.parseInt(rs.getString("amount"));
                  }
               }

               if(e.getSource() != exit && balance < Integer.parseInt(amount)){
                   JOptionPane.showMessageDialog(null,"Insufficient Balance");
                   return;
               }

               Date date = new Date();
                String query = "insert into bank values('" + cardnumber +"','" + pinnumber + "','" + date + "','Withdrawl','" + amount+ "')";
               c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amount+" Debited Successfully");

                setVisible(false);
                new Transactions(pinnumber,cardnumber).setVisible(true);

            }catch(Exception ae){
                System.out.println(ae);
            }
        }

    }
    public static void main(String[] args) {

        new FastCash("","");
    }

}
