import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentGUI extends JFrame {
    JButton b1, b2, b3, b4, b5, b6, b7;
    JPanel p1;
    JLabel l1;

    public StudentGUI() {
        setTitle("Student Management System");
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\HP\\OneDrive\\Pictures\\New folder\\logo.png"));
        setSize(825, 500);
        p1 = new JPanel();
        p1.setLayout(null);

        p1.setBackground(Color.decode("#D5DEE0"));

        l1 = new JLabel("STUDENT INFORMATION");
        l1.setFont(new Font("Times New Roman", Font.BOLD, 30));
        l1.setBounds(220, 2, 500, 50);
        l1.setForeground(Color.decode("#C3001A"));
        p1.add(l1);

        b1 = new JButton("Enter Student Record");
        b2 = new JButton("Search");
        b3 = new JButton("Update");
        b4 = new JButton("Delete");
        b5 = new JButton("Display ALL");
        b6 = new JButton("Display Specific Student");
        b7 = new JButton("Main Menu");

        b1.setSize(50, 35);
        b1.setBounds(50, 80, 200, 100);
        b1.setBackground(Color.decode("#A9AAAA"));

        b2.setSize(50, 35);
        b2.setBounds(300, 80, 200, 100);
        b2.setBackground(Color.decode("#A9AAAA"));

        b3.setSize(50, 35);
        b3.setBounds(550, 80, 200, 100);
        b3.setBackground(Color.decode("#A9AAAA"));

        b4.setSize(50, 35);
        b4.setBounds(50, 230, 200, 100);
        b4.setBackground(Color.decode("#A9AAAA"));

        b5.setSize(50, 35);
        b5.setBounds(300, 230, 200, 100);
        b5.setBackground(Color.decode("#A9AAAA"));

        b6.setSize(50, 35);
        b6.setBounds(550, 230, 200, 100);
        b6.setBackground(Color.decode("#A9AAAA"));

        b7.setSize(50, 35);
        b7.setBounds(50, 400, 100, 20);
        b7.setBackground(Color.white);


        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        p1.add(b4);
        p1.add(b5);
        p1.add(b6);
        p1.add(b7);

        MyActionListener m = new MyActionListener();
        b1.addActionListener(m);
        b2.addActionListener(m);
        b3.addActionListener(m);
        b4.addActionListener(m);
        b5.addActionListener(m);
        b6.addActionListener(m);
        b7.addActionListener(m);

        add(p1);
        setVisible(true);


    }

    public class MyActionListener implements ActionListener {

        public void actionPerformed(ActionEvent a) {
            if (a.getActionCommand() == "Main Menu") {
                dispose();
                MainMenuGUi mainMenuGUi = new MainMenuGUi();

            }
            else if (a.getActionCommand() == "Enter Student Record") {
                dispose();
                AddStudentGUI g = new AddStudentGUI();
            }

            else if (a.getActionCommand() == "Search") {
                if (Student.IsEmpty()) {
                    JOptionPane.showMessageDialog(new JFrame(), "NO RECORD ADDED");
                    dispose();
                    StudentGUI g = new StudentGUI();
                } else {
                    dispose();
                    SearchStudentGUI g = new SearchStudentGUI();
                }
            }

            else if (a.getActionCommand() == "Update") {
                if (Student.IsEmpty()) {
                    JOptionPane.showMessageDialog(new JFrame(), "NO RECORD ADDED");
                    dispose();
                    StudentGUI g = new StudentGUI();
                } else {
                    dispose();
                    UpdateStudentGUI g = new UpdateStudentGUI();

                }
            }
            else if (a.getActionCommand() == "Display ALL") {
                if (Student.IsEmpty()) {
                    JOptionPane.showMessageDialog(new JFrame(), "NO RECORD ADDED");
                    dispose();
                    StudentGUI g = new StudentGUI();
                } else {
                    dispose();
                    DisplayAllStudentsGUI g = new DisplayAllStudentsGUI();

                }
            }

            else if (a.getActionCommand() == "Display Specific Student") {
                if(Student.IsEmpty()){
                    JOptionPane.showMessageDialog(new JFrame(), "NO RECORD ADDED");
                    dispose();
                    StudentGUI g = new StudentGUI();
                }
                else{
                    dispose();
                    DisplaySpecificStudentGui g = new DisplaySpecificStudentGui();

                }
            }
            else{
                if(Student.IsEmpty()){
                    JOptionPane.showMessageDialog(new JFrame(), "NO RECORD ADDED");
                    dispose();
                    StudentGUI g = new StudentGUI();
                }
                else{
                    dispose();
                    DeleteStudentGUI deleteStudentGUI=new DeleteStudentGUI();
                }
            }
        }
    }
}
