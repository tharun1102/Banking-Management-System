package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup3 extends JFrame implements ActionListener {
    JRadioButton r1;
    JRadioButton r2;
    JRadioButton r3;
    JRadioButton r4;
    JCheckBox atm,mobile,internet,email,estate,declaration,cheque;
    JButton submit,cancel;
    String formno;
    Signup3(String formno){
        this.formno = formno;
        setLayout(null);

        JLabel no = new JLabel("FORM NO :" + formno);
        no.setFont(new Font("SAN_SERIF",Font.BOLD,13));
        no.setForeground(Color.red);
        no.setBounds(50,20,300,30);
        add(no);

        JLabel l1 = new JLabel("Page 3: ACCOUNT  DETAILS");
        l1.setFont(new Font("Ralway",Font.BOLD,20));
        l1.setBounds(165,40,300,30);
        add(l1);

        JLabel accountType= new JLabel("ACCOUNT TYPE :");
        accountType.setFont(new Font("Ralway",Font.BOLD,15));
        accountType.setBounds(50,120,200,20);
        add(accountType);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Ralway",Font.BOLD,12));
        r1.setBackground(new Color(249,246,238));
        r1.setBounds(50,160,120,20);
        add(r1);

        r2 = new JRadioButton("Current Account");
        r2.setFont(new Font("Ralway",Font.BOLD,12));
        r2.setBackground(new Color(249,246,238));
        r2.setBounds(50,190,120,20);
        add(r2);

        r3 = new JRadioButton("Recurring Deposit Account");
        r3.setFont(new Font("Ralway",Font.BOLD,12));
        r3.setBackground(new Color(249,246,238));
        r3.setBounds(280,160,180,20);
        add(r3);

        r4 = new JRadioButton("Fixed Deposit Account");
        r4.setFont(new Font("Ralway",Font.BOLD,12));
        r4.setBackground(new Color(249,246,238));
        r4.setBounds(280,190,180,20);
        add(r4);

        ButtonGroup accountgroup =new ButtonGroup();
        accountgroup.add(r1);
        accountgroup.add(r2);
        accountgroup.add(r3);
        accountgroup.add(r4);


        JLabel card = new JLabel("CARD NUMBER :");
        card.setFont(new Font("Ralway",Font.BOLD,15));
        card.setBounds(50,240,200,20);
        add(card);

        JLabel l2 = new JLabel("(Your 16-Digit Card Number)");
        l2.setFont(new Font("Ralway",Font.BOLD,11));
        l2.setBounds(50,260,210,20);
        add(l2);

        JLabel cardnumber = new JLabel("XXXX-XXXX-XXXX-4184");
        cardnumber.setFont(new Font("Ralway",Font.BOLD,15));
        cardnumber.setBounds(280,240,210,20);
        add(cardnumber);

        JLabel l3= new JLabel("(It would appear on ATM Card/Cheque Book & Statements)");
        l3.setFont(new Font("Ralway",Font.BOLD,11));
        l3.setBounds(280,260,400,20);
        add(l3);


        JLabel pin = new JLabel("PIN :");
        pin.setFont(new Font("Ralway",Font.BOLD,15));
        pin.setBounds(50,300,200,20);
        add(pin);

        JLabel l4= new JLabel("(4-Digit Password)");
        l4.setFont(new Font("Ralway",Font.BOLD,11));
        l4.setBounds(50,320,200,20);
        add(l4);

        JLabel pinnumber = new JLabel("XXXX");
        pinnumber.setFont(new Font("Ralway",Font.BOLD,15));
        pinnumber.setBounds(280,300,60,20);
        add(pinnumber);


        JLabel services = new JLabel("SERVICES REQUIRED :");
        services.setFont(new Font("Ralway",Font.BOLD,15));
        services.setBounds(50,360,200,20);
        add(services);

        atm = new JCheckBox("ATM Card");
        atm.setFont(new Font("Ralway",Font.BOLD,12));
        atm.setBounds(50,400,150,20);
        atm.setBackground(new Color(249,246,238));
        add(atm);

        mobile = new JCheckBox("Mobile Banking");
        mobile.setFont(new Font("Ralway",Font.BOLD,12));
        mobile.setBounds(50,430,150,20);
        mobile.setBackground(new Color(249,246,238));
        add(mobile);

        cheque = new JCheckBox("Cheque Book");
        cheque.setFont(new Font("Ralway",Font.BOLD,12));
        cheque.setBounds(50,460,150,20);
        cheque.setBackground(new Color(249,246,238));
        add(cheque);


        internet = new JCheckBox("Internet Banking");
        internet.setFont(new Font("Ralway",Font.BOLD,12));
        internet.setBounds(280,400,150,20);
        internet.setBackground(new Color(249,246,238));
        add(internet);

        email = new JCheckBox("E-MAIL Alerts");
        email.setFont(new Font("Ralway",Font.BOLD,12));
        email.setBounds(280,430,150,20);
        email.setBackground(new Color(249,246,238));
        add(email);

        estate = new JCheckBox("E-Statement");
        estate.setFont(new Font("Ralway",Font.BOLD,12));
        estate.setBounds(280,460,150,20);
        estate.setBackground(new Color(249,246,238));
        add(estate);


        declaration = new JCheckBox(" I  hereby  declare  that  the  above  entered  details  to  the  best  of  my  knowledge");
        declaration.setFont(new Font("Ralway",Font.BOLD,11));
        declaration.setBounds(50,560,500,20);
        declaration.setBackground(new Color(249,246,238));
        add(declaration);


        submit = new JButton("Submit");
        submit.setBounds(165,620,80,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(380,620,80,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);


        setSize(650,800);
        setLocation(300,0);
        getContentPane().setBackground(new Color(249,246,238));
        setUndecorated(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
            String accountType = null;
            if(r1.isSelected()){
                accountType = "Saving Account";
            }
            else if(r3.isSelected()){
              accountType = "Current Account";
            }
            else if(r3.isSelected()){
              accountType = "Recurring Deposit Account";
            }
            else if(r2.isSelected()){
                accountType = "Fixed Deposit Account";
            }
           Random random = new Random();
            String cardnumber ="" + Math.abs((random.nextLong() % 90000000L) + 500409360000000L);

            String pinnumber =""+ Math.abs((random.nextLong() % 9000L +1000L ));

            String facility = "";
            if(atm.isSelected()){
                facility = facility + " ATM Card";
            }
            else if(mobile.isSelected()){
                facility = facility + " Mobile Banking";
            }
            else if(cheque.isSelected()){
                facility = facility + " Cheque Book";
            }
            else if(internet.isSelected()){
                facility = facility + " Internet Banking";
            }
            else if(email.isSelected()){
                facility = facility + " E-MAIL Alerts";
            }
            else if(estate.isSelected()){
                facility = facility + " E-Statement";
            }

            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null,"Account type is required");
                }
                else{
                    Conn c = new Conn();
                    String query1 = "insert into signup3 values('"+formno+"', '"+accountType+"', '"+cardnumber+"', '"+pinnumber+"', '"+facility+"')";
                    String query2 = "insert into login values('"+formno+"', '"+cardnumber+"', '"+pinnumber+"')";

                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null,"Card Number :" + cardnumber + "\n Pin Number :" +pinnumber);

                    setVisible(false);
                    new Deposit(pinnumber,cardnumber).setVisible(true);
                }
            }catch (Exception ae){
                System.out.println(ae);
            }

        }
        else if(e.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(false);

        }
    }

    public static void main(String[] args) {
        new Signup3("");
    }
}
