package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField t1;
    JPasswordField p1;
    JButton in,up,clear;
    Login(){
        setLayout(null);
        setTitle("Bank Management System");


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(90,90,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel bank = new JLabel(i3);
        bank.setBounds(410,5,90,90);
        add(bank);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/card.png"));
        Image i5 = i4.getImage().getScaledInstance(120,100,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel card = new JLabel(i6);
        card.setBounds(700,380,120,100);
        add(card);

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/backbg.png"));
        Image i8 = i7.getImage().getScaledInstance(850,480,Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel backbg = new JLabel(i9);
        backbg.setBounds(0,0,850,480);
        add(backbg);

        JLabel intro = new JLabel("WELCOME TO ATM...!");
        intro.setForeground(Color.red);
        intro.setFont(new Font("Ralway",Font.BOLD,40));
        intro.setBounds(250,100,480,80);
        backbg.add(intro);

        JLabel text = new JLabel("CARD NO :");
        text.setForeground(Color.BLACK);
        text.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        text.setBounds(200,180,120,30);
        backbg.add(text);

        t1 = new JTextField();
        t1.setBounds(310,180,320,30);
        backbg.add(t1);

        JLabel password = new JLabel("PIN :");
        password.setForeground(Color.BLACK);
        password.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        password.setBounds(200,250,100,30);
        backbg.add(password);

        p1 = new JPasswordField();
        p1.setBounds(310,250,320,30);
        backbg.add(p1);

        in = new JButton("SIGN IN");
        in.setBackground(Color.darkGray);
        in.setForeground(Color.white);
        in.setBounds(320,310,120,40);
        in.addActionListener(this);
        backbg.add(in);

        clear = new JButton("CLEAR");
        clear.setBackground(Color.darkGray);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        clear.setBounds(500,310,120,40);
        backbg.add(clear);

        up = new JButton("SIGN UP");
        up.setBackground(Color.darkGray);
        up.setForeground(Color.white);
        up.setBounds(355,370,230,40);
        up.addActionListener(this);
        backbg.add(up);

        setSize(850,480);
        setLocation(250,100);
        setUndecorated(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if(e.getSource()==clear){
                t1.setText("");
                p1.setText("");
            }
            else if(e.getSource()==in){
                Conn c = new Conn();
                String cardnumber = t1.getText();
                String pinnumber = p1.getText();

                String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
                try{
                  ResultSet rs = c.s.executeQuery(query);
                    if (rs.next()) {
                        setVisible(false);
                        new Transactions(pinnumber,cardnumber).setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
                    }
                }catch(Exception ae){
                    System.out.println(ae);
                }
            }
            else if(e.getSource()==up){
                setVisible(false);
                new Signup1().setVisible(true);
            }

        } catch (Exception ae) {
            ae.printStackTrace();
        }
    }
    public static void main(String[] args) {

        new Login();
    }


}
