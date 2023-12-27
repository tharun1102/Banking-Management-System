package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Signup1 extends JFrame implements ActionListener {
    JTextField t1,t2,t3,t4,t5,t6,t7;
    long random;
    JRadioButton male,female,tg,married,unmarried;
    JButton next;
    JDateChooser dateChooser;
    Signup1(){
        setLayout(null);

        Random ran = new Random();
        random = Math.abs(ran.nextLong()%5000L)+1000L;

        JLabel formno = new JLabel("APLLICATION FORM NO : "+random);
        formno.setFont(new Font("Ralway",Font.BOLD,30));
        formno.setForeground(Color.black);
        formno.setBounds(70,10,500,60);
        add(formno);

        JLabel pd = new JLabel("Page 1: PERSONAL DETAILS");
        pd.setFont(new Font("Ralway",Font.BOLD,20));
        pd.setForeground(Color.black);
        pd.setBounds(165,70,400,40);
        add(pd);

        JLabel name = new JLabel("NAME :");
        name.setFont(new Font("Ralway",Font.BOLD,14));
        name.setForeground(Color.black);
        name.setBounds(50,140,80,20);
        add(name);

        t1 = new JTextField();
        t1.setFont(new Font("Ralway",Font.PLAIN,12));
        t1.setBounds(180,140,300,25);
        add(t1);

        JLabel fname = new JLabel("FATHER'S NAME :");
        fname.setFont(new Font("Ralway",Font.BOLD,14));
        fname.setForeground(Color.black);
        fname.setBounds(50,180,120,20);
        add(fname);

        t2 = new JTextField();
        t2.setFont(new Font("Ralway",Font.PLAIN,12));
        t2.setBounds(180,180,300,25);
        add(t2);

        JLabel dob = new JLabel("DATE OF BIRTH :");
        dob.setFont(new Font("Ralway",Font.BOLD,14));
        dob.setForeground(Color.black);
        dob.setBounds(50,220,120,20);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(180,220,120,25);
        add(dateChooser);

        JLabel gender = new JLabel("GENDER :");
        gender.setFont(new Font("Ralway",Font.BOLD,14));
        gender.setForeground(Color.black);
        gender.setBounds(50,260,80,20);
        add(gender);


        male = new JRadioButton("Male");
        male.setBounds(180,260,60,20);
        male.setBackground(new Color(249,246,238));
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(260,260,70,20);
        female.setBackground(new Color(249,246,238));
        add(female);

        tg = new JRadioButton("Transgender");
        tg.setBounds(350,260,100,20);
        tg.setBackground(new Color(249,246,238));
        add(tg);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(tg);

        JLabel email = new JLabel("E-MAIL :");
        email.setFont(new Font("Ralway",Font.BOLD,14));
        email.setForeground(Color.black);
        email.setBounds(50,300,80,20);
        add(email);

        t3 = new JTextField();
        t3.setFont(new Font("Ralway",Font.PLAIN,12));
        t3.setBounds(180,300,300,25);
        add(t3);

        JLabel marital = new JLabel("MARITAL STATUS :");
        marital.setFont(new Font("Ralway",Font.BOLD,14));
        marital.setForeground(Color.black);
        marital.setBounds(50,340,150,20);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(180,340,80,20);
        married.setBackground(new Color(249,246,238));
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(260,340,120,20);
        unmarried.setBackground(new Color(249,246,238));
        add(unmarried);

        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);

        JLabel address = new JLabel("ADDRESS :");
        address.setFont(new Font("Ralway",Font.BOLD,14));
        address.setForeground(Color.black);
        address.setBounds(50,380,80,20);
        add(address);

        t4 = new JTextField();
        t4.setFont(new Font("Ralway",Font.PLAIN,12));
        t4.setBounds(180,380,300,25);
        add(t4);

        JLabel city = new JLabel("CITY :");
        city.setFont(new Font("Ralway",Font.BOLD,14));
        city.setForeground(Color.black);
        city.setBounds(50,420,80,20);
        add(city);

        t5 = new JTextField();
        t5.setFont(new Font("Ralway",Font.PLAIN,12));
        t5.setBounds(180,420,190,25);
        add(t5);

        JLabel state = new JLabel("STATE :");
        state.setFont(new Font("Ralway",Font.BOLD,14));
        state.setForeground(Color.black);
        state.setBounds(50,460,80,20);
        add(state);

        t6 = new JTextField();
        t6.setFont(new Font("Ralway",Font.PLAIN,12));
        t6.setBounds(180,460,190,25);
        add(t6);

        JLabel pincode = new JLabel("PIN CODE :");
        pincode.setFont(new Font("Ralway",Font.BOLD,14));
        pincode.setForeground(Color.black);
        pincode.setBounds(50,500,80,20);
        add(pincode);

        t7 = new JTextField();
        t7.setFont(new Font("Ralway",Font.PLAIN,12));
        t7.setBounds(180,500,100,25);
        add(t7);

        next = new JButton("Next");
        next.setBounds(460,610,80,30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);

        setSize(580,680);
        setLocation(300,20);
        getContentPane().setBackground(new Color(249,246,238));
        setUndecorated(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String formno = ""+random;
        String name = t1.getText();
        String fname = t2.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender= null;
        if(male.isSelected()){
            gender = "Male";
        } else if (female.isSelected()) {
           gender = "Female" ;
        } else if (tg.isSelected()) {
            gender = "Transgender";
        }
        String email = t3.getText();
        String marital= null;
        if(married.isSelected()){
            marital = "Married";
        } else if (unmarried.isSelected()) {
            marital = "Unmarried";
        }
        String address = t4.getText();
        String city = t5.getText();
        String state = t6.getText();
        String pincode = t7.getText();


        try{
           if(name.equals("")){
               JOptionPane.showMessageDialog(null,"Name is required");
           }else{
               Conn c = new Conn();
               String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
               c.s.executeUpdate(query);

               setVisible(false);
               new Signup2(formno).setVisible(true);
           }
        }catch(Exception ae){
            System.out.println(ae);
        }

    }

    public static void main(String[] args) {
       new Signup1();
    }


}
