import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuGUi extends JFrame {
    JPanel main_panel;
    JButton student, lecturer , StudentResult;
    JLabel title;

    public MainMenuGUi(){
        setTitle("Student Management System");
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\HP\\OneDrive\\Pictures\\New folder\\logo.png"));
        setSize(850, 400);
        main_panel = new JPanel();
        main_panel.setLayout(null);

        main_panel.setBackground(Color.decode("#D5DEE0"));

        title = new JLabel("STUDENT MANAGEMENT SYSTEM");
        title.setFont(new Font("Times New Roman", Font.BOLD, 28));
        title.setBounds(180,10,500,100);
        title.setForeground(Color.decode("#C3001A"));
        main_panel.add(title);

        student = new JButton("Student Information");
        lecturer = new JButton("Lecturer Information");
        StudentResult = new JButton("Result Card");

        student.setSize(50,35);
        student.setBounds(20,150,200,100);
        student.setBackground(Color.decode("#A9AAAA"));

        lecturer.setSize(50,35);
        lecturer.setBounds(320,150,200,100);
        lecturer.setBackground(Color.decode("#A9AAAA"));

        StudentResult.setSize(50,35);
        StudentResult.setBounds(610,150,200,100);
        StudentResult.setBackground(Color.decode("#A9AAAA"));


        main_panel.add(student);
        main_panel.add(lecturer);
        main_panel.add(StudentResult);

        MyActionListener m = new MyActionListener();
        student.addActionListener(m);
        lecturer.addActionListener(m);
        StudentResult.addActionListener(m);

        add(main_panel);
        setVisible(true);

    }

    public class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equals("Student Information")){
                dispose();
                StudentGUI g = new StudentGUI();
            }
            else if (ae.getActionCommand().equals("Lecturer Information")){
                dispose();
                LecturerMainMenuGui lecturerMainMenuGui=new LecturerMainMenuGui();
            }
            else {
                if (Student.IsEmpty()){
                    JOptionPane.showMessageDialog(new JFrame(),"No Record Added");
                    dispose();
                    MainMenuGUi mainMenuGUi=new MainMenuGUi();
                }
                else {
                    dispose();
                    ResultCardGui resultCardGui=new ResultCardGui();
                }

            }
        }
    }
}
