package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup2 extends JFrame implements ActionListener{
    JTextField t1,t2;

    JRadioButton y,n,yy,nn;
    JButton next;
    Choice c0,c1,c2,c3,c4;
    String formno;
    Signup2(String formno){
        this.formno = formno;
        setLayout(null);

        JLabel no = new JLabel("FORM NO :" + formno);
        no.setFont(new Font("SAN_SERIF",Font.BOLD,13));
        no.setForeground(Color.red);
        no.setBounds(50,30,300,30);
        add(no);

        JLabel ad= new JLabel("Page 2: ADDITIONAL DETAILS");
        ad.setFont(new Font("Ralway",Font.BOLD,20));
        ad.setForeground(Color.black);
        ad.setBounds(165,50,400,40);
        add(ad);

        JLabel religion = new JLabel("RELIGION :");
        religion.setFont(new Font("Ralway",Font.BOLD,12));
        religion.setForeground(Color.black);
        religion.setBounds(50,140,80,20);
        add(religion);

        c0 = new Choice();
        c0.add("--select--");
        c0.add("Hindu");
        c0.add("Muslim");
        c0.add("Sikh");
        c0.add("Christian");
        c0.add("Others");
        c0.setBounds(240,140,300,25);
        add(c0);

        JLabel category = new JLabel("CATEGORY :");
        category.setFont(new Font("Ralway",Font.BOLD,12));
        category.setForeground(Color.black);
        category.setBounds(50,190,120,20);
        add(category);

        c1 = new Choice();
        c1.add("--select--");
        c1.add("General");
        c1.add("OBC");
        c1.add("SC");
        c1.add("ST");
        c1.add("Others");
        c1.setBounds(240,190,300,25);
        add(c1);

        JLabel income = new JLabel("INCOME :");
        income.setFont(new Font("Ralway",Font.BOLD,12));
        income.setForeground(Color.black);
        income.setBounds(50,240,120,20);
        add(income);

        c2 = new Choice();
        c2.add("--select--");
        c2.add("Null");
        c2.add("< 1,00,000");
        c2.add("< 2,50,000");
        c2.add("< 5,00,000");
        c2.add("Upto 10,00,0000");
        c2.setBounds(240,240,300,25);
        add(c2);


        JLabel education = new JLabel("EDUCATIONAL QUALIFICATION :");
        education.setFont(new Font("Ralway",Font.BOLD,12));
        education.setForeground(Color.black);
        education.setBounds(50,290,180,15);
        add(education);


        c3 = new Choice();
        c3.add("--select--");
        c3.add("Non-Graduate");
        c3.add("Graduate");
        c3.add("Post-Graduate");
        c3.add("Doctrate");
        c3.add("Others");
        c3.setBounds(240,290,300,25);
        add(c3);


        JLabel occupation = new JLabel("OCCUPATION :");
        occupation.setFont(new Font("Ralway",Font.BOLD,12));
        occupation.setForeground(Color.black);
        occupation.setBounds(50,340,120,20);
        add(occupation);

        c4 = new Choice();
        c4.add("--select--");
        c4.add("Self-Employeed");
        c4.add("Unemployeed");
        c4.add("Business");
        c4.add("Student");
        c4.add("Retired");
        c4.add("Others");
        c4.setBounds(240,340,300,25);
        add(c4);


        JLabel pan = new JLabel("PAN NO. :");
        pan.setFont(new Font("Ralway",Font.BOLD,12));
        pan.setForeground(Color.black);
        pan.setBounds(50,390,150,20);
        add(pan);

        t1 = new JTextField();
        t1.setFont(new Font("Ralway",Font.PLAIN,12));
        t1.setBounds(240,390,300,25);
        add(t1);


        JLabel aadhar = new JLabel("AADHAR NO. :");
        aadhar.setFont(new Font("Ralway",Font.BOLD,12));
        aadhar.setForeground(Color.black);
        aadhar.setBounds(50,440,100,20);
        add(aadhar);

        t2 = new JTextField();
        t2.setFont(new Font("Ralway",Font.PLAIN,12));
        t2.setBounds(240,440,300,25);
        add(t2);

        JLabel senior = new JLabel("SENIOR CITIZEN :");
        senior.setFont(new Font("Ralway",Font.BOLD,12));
        senior.setForeground(Color.black);
        senior.setBounds(50,490,180,15);
        add(senior);


        y= new JRadioButton("YES");
        y.setBounds(240,490,80,20);
        y.setBackground(new Color(249,246,238));
        add(y);

        n = new JRadioButton("No");
        n.setBounds(350,490,80,20);
        n.setBackground(new Color(249,246,238));
        add(n);

        ButtonGroup seniorgroup = new ButtonGroup();
        seniorgroup.add(y);
        seniorgroup.add(n);


        JLabel exist = new JLabel("EXISTING ACCOUNT :");
        exist.setFont(new Font("Ralway",Font.BOLD,12));
        exist.setForeground(Color.black);
        exist.setBounds(50,540,180,15);
        add(exist);


        yy= new JRadioButton("YES");
        yy.setBounds(240,540,80,20);
        yy.setBackground(new Color(249,246,238));
        add(yy);

        nn = new JRadioButton("No");
        nn.setBounds(350,540,80,20);
        nn.setBackground(new Color(249,246,238));
        add(nn);

        ButtonGroup eaccountgroup = new ButtonGroup();
        eaccountgroup.add(yy);
        eaccountgroup.add(nn);


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
        String religion = c0.getSelectedItem();
        String category = c1.getSelectedItem();
        String income = c2.getSelectedItem();
        String education = c3.getSelectedItem();
        String occupation = c4.getSelectedItem();
        String senior= null;
        if(y.isSelected()){
            senior = "YES";
        } else if (n.isSelected()) {
            senior = "NO" ;
        }
        String pan = t1.getText();
        String aadhar = t2.getText();
        String exist= null;
        if(yy.isSelected()){
            exist = "YES";
        } else if (nn.isSelected()) {
            exist = "NO";
        }


        try{
                Conn c = new Conn();
                String query = "insert into signup2 values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+senior+"','"+pan+"','"+aadhar+"','"+exist+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new Signup3(formno).setVisible(true);

        }catch(Exception ae){
            System.out.println(ae);
        }

    }

    public static void main(String[] args) {

        new Signup2("");
    }


}

