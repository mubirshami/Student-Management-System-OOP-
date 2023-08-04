import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteStudentGUI extends JFrame {
    JButton b1,b2;
    JPanel p1;
    JLabel l,l1;
    JTextField t1;

    public DeleteStudentGUI() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\HP\\OneDrive\\Pictures\\New folder\\logo.png"));
        setTitle("Student Management System");
        setSize(825, 500);
        p1 = new JPanel();
        p1.setLayout(null);

        p1.setBackground(Color.decode("#D5DEE0"));
        l = new JLabel("DELETE PANEL");
        l.setFont(new Font("Times New Roman", Font.BOLD, 30));
        l.setBounds(280, 10, 400, 30);
        l.setForeground(Color.blue);
        p1.add(l);

        l1 = new JLabel("Enter the Student's Registration ID:");
        l1.setBounds(140, 70, 250, 200);
        l1.setForeground(Color.black);
        p1.add(l1);
        t1 = new JTextField(20);
        t1.setBounds(360, 160, 200, 20);
        p1.add(t1);

        b1 = new JButton("DELETE");
        b1.setSize(20, 50);
        b1.setBounds(20, 400, 100, 20);
        b1.setBackground(Color.white);
        p1.add(b1);

        b2 = new JButton("STUDENT MENU");
        b2.setSize(20, 50);
        b2.setBounds(150, 400, 150, 20);
        b2.setBackground(Color.white);
        p1.add(b2);


        add(p1);
        setVisible(true);

        MyActionListener m = new MyActionListener();
        b1.addActionListener(m);
        b2.addActionListener(m);

    }
    public class MyActionListener implements ActionListener {

        public void actionPerformed(ActionEvent a) {
            if (a.getActionCommand().equals("DELETE")) {
                dispose();
                if(Student.Search(Integer.parseInt(t1.getText()))){
                    Student.deleteFromFile(Integer.parseInt(t1.getText()));
                    JOptionPane.showMessageDialog(new JFrame(), "Student RECORD DELETED");}
                else{
                    JOptionPane.showMessageDialog(new JFrame(), "Student NOT Found");
                }
                StudentGUI g = new StudentGUI();
            }
            else{
                dispose();
                StudentGUI g = new StudentGUI();
            }
        }
    }
}
