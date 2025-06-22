package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JButton amount1, amount2, amount3, amount4, amount5, amount6, back;
    String pinnumber;

    FastCash(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(getClass().getResource("image.png"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("SELECT YOUR AMOUNT");
        text.setBounds(200, 330, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 20));
        image.add(text);

        amount1 = new JButton("RS 100");
        amount1.setBounds(170, 400, 150, 30);
        amount1.addActionListener(this);
        image.add(amount1);

        amount2 = new JButton("RS 300");
        amount2.setBounds(355, 400, 150, 30);
        amount2.addActionListener(this);
        image.add(amount2);

        amount3 = new JButton("RS 500");
        amount3.setBounds(170, 450, 150, 30);
        amount3.addActionListener(this);
        image.add(amount3);

        amount4 = new JButton("RS 1000");
        amount4.setBounds(355, 450, 150, 30);
        amount4.addActionListener(this);
        image.add(amount4);

        amount5 = new JButton("RS 2000");
        amount5.setBounds(170, 500, 150, 30);
        amount5.addActionListener(this);
        image.add(amount5);

        amount6 = new JButton("RS 10000");
        amount6.setBounds(355, 500, 150, 30);
        amount6.addActionListener(this);
        image.add(amount6);

        back = new JButton("BACK");
        back.setBounds(265, 550, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton) ae.getSource()).getText().substring(3).trim();
            Conn c = new Conn();
            int balance = 0;

            try {
                ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pinnumber + "'");
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                if (balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                Date date = new Date();
                String query = "INSERT INTO bank VALUES ('" + pinnumber + "', '" + date + "', 'Withdrawl', '" + amount + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " + amount + " Debited Successfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
