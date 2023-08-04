import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddStudentGUI extends JFrame {
    JLabel l,l1, l2, l3, l4, l5, l6, l7, l8,l9,l10,l11 ,l14,l15,l16,l17,l18 ;
    JTextField t1, t2, t3, t4, t5, t6,t8, t7,t9,t11,t12,t13,t14,t15 ;
    JButton b1,b2;
    JPanel p1;
    JCheckBox c1,c2,c3,c4,c5;

    public AddStudentGUI(){
        setTitle("Student Management System");
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\HP\\OneDrive\\Pictures\\New folder\\logo.png"));
        setSize(825, 750);
        p1 = new JPanel();
        p1.setLayout(null);

        p1.setBackground(Color.decode("#D5DEE0"));

        l = new JLabel("STUDENT ENTRY");
        l.setFont(new Font("Times New Roman", Font.BOLD, 30));
        l.setBounds(250, 2, 400, 40);
        l.setForeground(Color.blue);
        p1.add(l);

        l1 = new JLabel("Enter Registration ID:");
        l1.setBounds(10,20,180,200);
        l1.setForeground(Color.black);
        p1.add(l1);
        t1 = new JTextField(20);
        t1.setBounds(200,110,200,20);
        p1.add(t1);

        l2 = new JLabel("Enter Name:");
        l2.setBounds(10,50,180,200);
        l2.setForeground(Color.black);
        p1.add(l2);
        t2 = new JTextField(20);
        t2.setBounds(200,140,200,20);
        p1.add(t2);

        l3 = new JLabel("Enter the Street Number:");
        l3.setBounds(10,80,180,200);
        l3.setForeground(Color.black);
        p1.add(l3);
        t3 = new JTextField(20);
        t3.setBounds(200,170,200,20);
        p1.add(t3);

        l4 = new JLabel("Enter the house number:");
        l4.setBounds(10,110,180,200);
        l4.setForeground(Color.black);
        p1.add(l4);
        t4 = new JTextField(20);
        t4.setBounds(200,200,200,20);
        p1.add(t4);

        l5 = new JLabel("Enter the City:");
        l5.setBounds(10,140,180,200);
        l5.setForeground(Color.black);
        p1.add(l5);
        t5 = new JTextField(20);
        t5.setBounds(200,230,200,20);
        p1.add(t5);

        l6 = new JLabel("Enter Age:");
        l6.setBounds(10,170,180,200);
        l6.setForeground(Color.black);
        p1.add(l6);
        t6 = new JTextField(20);
        t6.setBounds(200,260,200,20);
        p1.add(t6);

        l7 = new JLabel("Enter Semester:");
        l7.setBounds(10,200,180,200);
        l7.setForeground(Color.black);
        p1.add(l7);
        t7 = new JTextField(20);
        t7.setBounds(200,290,200,20);
        p1.add(t7);

        l8 = new JLabel("Enter Previous GPA:");
        l8.setBounds(10,230,180,200);
        l8.setForeground(Color.black);
        p1.add(l8);
        t8 = new JTextField(20);
        t8.setBounds(200,320,200,20);
        p1.add(t8);


        l9 = new JLabel("Enter Department:");
        l9.setBounds(10,260,180,200);
        l9.setForeground(Color.black);
        p1.add(l9);
        t9 = new JTextField(20);
        t9.setBounds(200,350,200,20);
        p1.add(t9);

        l10 = new JLabel("Select a Course");
        l10.setBounds(10,290,180,200);
        l10.setForeground(Color.black);
        p1.add(l10);

        c1= new JCheckBox("BCS");
        c1.setBounds(200,380,50,20);
        c1.setBackground(Color.decode("#D5DEE0"));

        c2= new JCheckBox("BSE");
        c2.setBounds(270,380,50,20);
        c2.setBackground(Color.decode("#D5DEE0"));


        p1.add(c1);
        p1.add(c2);



        l11 = new JLabel("Subjects GPA");
        l11.setFont(new Font("Times New Roman", Font.BOLD, 20));
        l11.setBounds(10, 450, 400, 30);
        l11.setForeground(Color.decode("#C3001A"));
        p1.add(l11);


        l14 = new JLabel("Subject 1");
        l14.setBounds(10,500,180,20);
        l14.setForeground(Color.black);
        p1.add(l14);
        t11 = new JTextField(20);
        t11.setBounds(200,500,200,20);
        p1.add(t11);

        l15 = new JLabel("Subject 2");
        l15.setBounds(10,530,180,20);
        l15.setForeground(Color.black);
        p1.add(l15);
        t12 = new JTextField(20);
        t12.setBounds(200,530,200,20);
        p1.add(t12);

        l16 = new JLabel("Subject 3");
        l16.setBounds(10,560,180,20);
        l16.setForeground(Color.black);
        p1.add(l16);
        t13 = new JTextField(20);
        t13.setBounds(200,560,200,20);
        p1.add(t13);

        l17 = new JLabel("Subject 4");
        l17.setBounds(10,590,180,20);
        l17.setForeground(Color.black);
        p1.add(l17);
        t14 = new JTextField(20);
        t14.setBounds(200,590,200,20);
        p1.add(t14);

        l18 = new JLabel("Subject 5");
        l18.setBounds(10,620,180,20);
        l18.setForeground(Color.black);
        p1.add(l18);
        t15 = new JTextField(20);
        t15.setBounds(200,620,200,20);
        p1.add(t15);


        b1 = new JButton("STUDENT MENU");
        b1.setSize(20, 50);
        b1.setBounds(600, 670, 150, 20);
        b1.setBackground(Color.white);
        p1.add(b1);

        b2 = new JButton("Submit");
        b2.setSize(20, 50);
        b2.setBounds(250, 670, 100, 20);
        b2.setBackground(Color.white);
        p1.add(b2);


        MyActionListener m = new MyActionListener();
        c1.addActionListener(m);
        c2.addActionListener(m);
        b1.addActionListener(m);
        b2.addActionListener(m);
        add(p1);

        setVisible(true);
    }
    public class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent a) {

            if (a.getActionCommand() == "STUDENT MENU") {
                dispose();
                StudentGUI g = new StudentGUI();
            } else {

                ArrayList<Subject> sub = new ArrayList<>();

                sub.add(0, new Subject("01", "Subject 1", 4, 0));
                sub.add(1, new Subject("02", "Subject 2", 4, 0));
                sub.add(2, new Subject("03", "Subject 3", 4, 0));
                sub.add(3, new Subject("04", "Subject 4", 3, 0));
                sub.add(4, new Subject("05", "Subject 5", 3, 0));

                Address ad = new Address(Integer.parseInt(t3.getText()), Integer.parseInt(t4.getText()), t6.getText());
                Department d1 = new Department(1, t9.getText(), "3B");

                Course cd = new Course();
                if (c1.isSelected()) {
                    cd = new Course(011, c1.getText(), 96000, sub);

                }
                else if (c2.isSelected()) {
                    cd = new Course(011, c2.getText(), 96000, sub);
                }


                if (a.getActionCommand() == "Submit") {

                    sub.get(0).setObtained_GPA(Double.parseDouble(t11.getText()));
                    sub.get(1).setObtained_GPA(Double.parseDouble(t12.getText()));
                    sub.get(2).setObtained_GPA(Double.parseDouble(t13.getText()));
                    sub.get(3).setObtained_GPA(Double.parseDouble(t14.getText()));
                    sub.get(4).setObtained_GPA(Double.parseDouble(t15.getText()));
                    cd.setSubjects(sub);
                    Student s = new Student(t2.getText(), Integer.parseInt(t6.getText()), ad, Integer.parseInt(t1.getText()), Integer.parseInt(t7.getText()), cd, d1, Double.parseDouble(t8.getText()));
                    Student.writeToFile(s);


                    dispose();
                    JOptionPane.showMessageDialog(new JFrame(), "Student Record is added successfully");
                    StudentGUI g = new StudentGUI();

                }

            }
        }
    }

}
