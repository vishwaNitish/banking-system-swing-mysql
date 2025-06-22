package src;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;

public class SignupTwo extends JFrame implements ActionListener {

    JTextField pan, adhar;
    JButton next;
    JRadioButton eyes, eno, syes, sno;
    JComboBox<String> religion, income, category, occupation, education;
    String formno;

    SignupTwo(String formno) {
        this.formno = formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION - PAGE 2");

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 28));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

        JLabel lblReligion = new JLabel("Religion:");
        lblReligion.setFont(new Font("Raleway", Font.BOLD, 20));
        lblReligion.setBounds(100, 140, 100, 30);
        add(lblReligion);

        String valReligion[] = { "Hindu", "Muslim", "Sikh", "Christian", "Other" };
        religion = new JComboBox<>(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel lblCategory = new JLabel("Category:");
        lblCategory.setFont(new Font("Raleway", Font.BOLD, 20));
        lblCategory.setBounds(100, 190, 200, 30);
        add(lblCategory);

        String categoryVal[] = { "OBC", "General", "SC", "ST", "Minority" };
        category = new JComboBox<>(categoryVal);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel lblIncome = new JLabel("Income:");
        lblIncome.setFont(new Font("Raleway", Font.BOLD, 20));
        lblIncome.setBounds(100, 240, 200, 30);
        add(lblIncome);

        String incomeCategory[] = { "Null", "<1,50,000", "<2,00,000", "2,50,000", "Up to 10,00,000" };
        income = new JComboBox<>(incomeCategory);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);

        JLabel lblEducation = new JLabel("Educational Qualification:");
        lblEducation.setFont(new Font("Raleway", Font.BOLD, 20));
        lblEducation.setBounds(100, 290, 300, 30);
        add(lblEducation);

        String educationValues[] = { "Non-Graduation", "Graduation", "Post-Graduate", "Doctorate", "Others" };
        education = new JComboBox<>(educationValues);
        education.setBounds(300, 330, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);

        JLabel lblOccupation = new JLabel("Occupation:");
        lblOccupation.setFont(new Font("Raleway", Font.BOLD, 20));
        lblOccupation.setBounds(100, 390, 200, 30);
        add(lblOccupation);

        String occupationValues[] = { "Salaried", "Self-Employed", "Business", "Student", "Retired", "Other" };
        occupation = new JComboBox<>(occupationValues);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        JLabel lblPan = new JLabel("PAN No:");
        lblPan.setFont(new Font("Raleway", Font.BOLD, 20));
        lblPan.setBounds(100, 440, 200, 30);
        add(lblPan);

        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300, 440, 400, 30);
        add(pan);

        JLabel lblAdhar = new JLabel("Adhar No:");
        lblAdhar.setFont(new Font("Raleway", Font.BOLD, 20));
        lblAdhar.setBounds(100, 490, 200, 30);
        add(lblAdhar);

        adhar = new JTextField();
        adhar.setFont(new Font("Raleway", Font.BOLD, 14));
        adhar.setBounds(300, 490, 400, 30);
        add(adhar);

        JLabel lblSenior = new JLabel("Senior Citizen:");
        lblSenior.setFont(new Font("Raleway", Font.BOLD, 20));
        lblSenior.setBounds(100, 540, 200, 30);
        add(lblSenior);

        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(syes);
        seniorGroup.add(sno);

        JLabel lblAccount = new JLabel("Existing Account:");
        lblAccount.setFont(new Font("Raleway", Font.BOLD, 20));
        lblAccount.setBounds(100, 590, 200, 30);
        add(lblAccount);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup accountGroup = new ButtonGroup();
        accountGroup.add(eyes);
        accountGroup.add(eno);

        next = new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String stringpan = pan.getText();
        String stringadhar = adhar.getText();

        String seniorCitizen = null;
        if (syes.isSelected()) {
            seniorCitizen = "Yes";
        } else if (sno.isSelected()) {
            seniorCitizen = "No";
        }

        String existingAccount = null;
        if (eyes.isSelected()) {
            existingAccount = "Yes";
        } else if (eno.isSelected()) {
            existingAccount = "No";
        }

        try {
            Conn c = new Conn();
            String query = "INSERT INTO signupTwo (formno, religion, category, income, education, occupation, pan, adhar, seniorCitizen, existingAccount) "
                    +
                    "VALUES ('" + formno + "', '" + sreligion + "', '" + scategory + "', '" + sincome + "', '"
                    + seducation + "', '" + soccupation + "', '" + stringpan + "', '" + stringadhar + "', '"
                    + seniorCitizen + "', '" + existingAccount + "')";

            c.s.executeUpdate(query);

           
            setVisible(false);
            new SignupThree(formno).setVisible(true);
        } catch (Exception e) {
            System.out.println("Error in SignupTwo: " + e);
        }
    }

    public static void main(String[] args) {
        new SignupTwo("");
    }
}
