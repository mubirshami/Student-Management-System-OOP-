import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ResultCardGui extends JFrame {
    JButton b1,b2;
    JPanel p1;
    JLabel l,l1;
    JTextField t1;

    ResultCardGui(){
        setTitle("Student Management System");
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\HP\\OneDrive\\Pictures\\New folder\\logo.png"));
        setSize(500, 500);
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.decode("#D5DEE0"));

        l = new JLabel("DISPLAY RESULT CARD");
        l.setFont(new Font("Times New Roman", Font.BOLD, 25));
        l.setBounds(75, 10, 500, 30);
        l.setForeground(Color.blue);
        p1.add(l);

        l1 = new JLabel("Enter The Student Registration ID:");
        l1.setBounds(35,20,200,200);
        l1.setForeground(Color.black);
        p1.add(l1);
        t1 = new JTextField(20);
        t1.setBounds(235,110,200,20);
        p1.add(t1);

        b1=new JButton("DISPLAY RESULT");
        b2=new JButton("MAIN MENU");

        b1.setSize(20, 50);
        b1.setBounds(20, 400, 200, 20);
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
            if (a.getActionCommand().equals("DISPLAY RESULT")) {
                if (Student.Search(Integer.parseInt(t1.getText()))) {
                    for (Student student : list) {
                        if (student.getRegistrationId()==Integer.parseInt(t1.getText())) {
                            JOptionPane.showMessageDialog(null, student.getRegistrationId() + " " + student.getName() + " " +student.getCourse().getCourseName() + " " + student.CGPA(Integer.parseInt(t1.getText())));
                            dispose();
                            MainMenuGUi mainMenuGUi=new MainMenuGUi();
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"No Record Found");
                    dispose();
                    MainMenuGUi mainMenuGUi=new MainMenuGUi();
                }
            }
        }
    }
}
