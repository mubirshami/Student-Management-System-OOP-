import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DisplayAllStudentsGUI extends JFrame {
    JButton b1,b2;
    JPanel p1;
    JLabel l;

    DisplayAllStudentsGUI(){
        setTitle("Student Management System");
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\HP\\OneDrive\\Pictures\\New folder\\logo.png"));
        setSize(500, 500);
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.decode("#D5DEE0"));

        l = new JLabel("DISPLAY PANEL");
        l.setFont(new Font("Times New Roman", Font.BOLD, 25));
        l.setBounds(140, 10, 300, 30);
        l.setForeground(Color.blue);
        p1.add(l);

        b1=new JButton("DISPLAY");
        b2=new JButton("STUDENT MENU");

        b1.setSize(20, 50);
        b1.setBounds(20, 400, 100, 20);
        b1.setBackground(Color.white);
        p1.add(b1);

        b2.setSize(20, 50);
        b2.setBounds(280, 400, 200, 20);
        b2.setBackground(Color.white);
        p1.add(b2);

        b1.addActionListener(new MyActionListener());
        b2.addActionListener(new MyActionListener());
        add(p1);
        setVisible(true);
    }
    public class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            ArrayList<Student> list = Student.readAllData();
            if (a.getActionCommand().equals("DISPLAY")) {
                for (Student s : list) {
                    JOptionPane.showMessageDialog(null, s.getRegistrationId() + " " + s.getName() + " " + s.getSemester() + " " + s.getDepartment().getDepartmentName() + " " + s.getDepartment().getSection() + " " + s.getCourse().getCourseName());
                }
            }
            else if(a.getActionCommand().equals("STUDENT MENU")) {
                dispose();
                StudentGUI guiMainMenu=new StudentGUI();
            }
        }
    }
}
