package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {
    String pinnumber,cardnumber;
    MiniStatement(String pinnumber,String cardnumber){
        this.cardnumber=cardnumber;
        this.pinnumber=pinnumber;
        setLayout(null);

        JLabel mini = new JLabel();
        mini.setBounds(5,60,390,480);
        add(mini);

        JLabel bank = new JLabel("HDFC Bank");
        bank.setBounds(150,20,100,20);
        bank.setFont(new Font("SAN_SERIF",Font.BOLD,14));
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20,450,300,20);
        add(balance);

        try{
            Conn c = new Conn();
            ResultSet rs =c.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number: "+ rs.getString("cardnumber").substring(0,4)+"XXXXXXXX"+ rs.getString("cardnumber").substring(12));
            }
        }catch(Exception e){
            System.out.println(e);
        }

        try{
            Conn c = new Conn();
            int bal=0;
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Rs " + rs.getString("amount") + "<br><br><html>");

                if(rs.getString("type").equals("Deposit")){
                    bal += Integer.parseInt(rs.getString("amount"));
                }
                else{
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("You Current Account Balance is Rs " + bal);
        }catch(Exception e){
            System.out.println(e);
        }

        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setUndecorated(true);
        setVisible(true);

    }

    public static void main(String[] args) {
        new MiniStatement("","");
    }
}
