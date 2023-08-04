import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddLecturerGui extends JFrame {
    JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
    JButton b1,b2;
    JPanel p1;

    AddLecturerGui(){
        setTitle("Student Management System");
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\HP\\OneDrive\\Pictures\\New folder\\logo.png"));
        setSize(825, 600);
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.decode("#D5DEE0"));

        l0 = new JLabel("LECTURER ENTRY");
        l0.setFont(new Font("Times New Roman", Font.BOLD, 30));
        l0.setBounds(220, 2, 400, 40);
        l0.setForeground(Color.blue);
        p1.add(l0);

        l1 = new JLabel("Enter Lecturer ID:");
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

        l7 = new JLabel("Enter Contact:");
        l7.setBounds(10,200,180,200);
        l7.setForeground(Color.black);
        p1.add(l7);
        t7 = new JTextField(20);
        t7.setBounds(200,290,200,20);
        p1.add(t7);

        l8 = new JLabel("Enter Salary:");
        l8.setBounds(10,230,180,200);
        l8.setForeground(Color.black);
        p1.add(l8);
        t8 = new JTextField(20);
        t8.setBounds(200,320,200,20);
        p1.add(t8);


        l9 = new JLabel("Enter Hire Date:");
        l9.setBounds(10,260,180,200);
        l9.setForeground(Color.black);
        p1.add(l9);
        t9 = new JTextField(20);
        t9.setBounds(200,350,200,20);
        p1.add(t9);

        l10 = new JLabel("Enter Hire Month:");
        l10.setBounds(10,290,180,200);
        l10.setForeground(Color.black);
        p1.add(l10);
        t10=new JTextField(20);
        t10.setBounds(200,380,200,20);
        p1.add(t10);

        l11 = new JLabel("Enter Hire Year:");
        l11.setBounds(10,320,180,200);
        l11.setForeground(Color.black);
        p1.add(l11);
        t11=new JTextField(20);
        t11.setBounds(200,410,200,20);
        p1.add(t11);



        b1 = new JButton("LECTURER MENU");
        b1.setSize(20, 50);
        b1.setBounds(10, 480, 200, 20);
        b1.setBackground(Color.white);
        p1.add(b1);
        b2 = new JButton("SUBMIT");
        b2.setSize(20, 50);
        b2.setBounds(220, 480, 200, 20);
        b2.setBackground(Color.white);
        p1.add(b2);
        b1.addActionListener(new MyActionListener());
        b2.addActionListener(new MyActionListener());
        add(p1);

        setVisible(true);
    }
    public class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            if (e.getActionCommand()=="SUBMIT"){
                dispose();
                Address a=new Address(Integer.parseInt(t3.getText()),Integer.parseInt(t4.getText()),t5.getText());
                Date d=new Date(Integer.parseInt(t9.getText()),Integer.parseInt(t10.getText()),Integer.parseInt(t11.getText()));
                Lecturer l=new Lecturer(t2.getText(),Integer.parseInt(t6.getText()),a,Integer.parseInt(t1.getText()),t7.getText(),Integer.parseInt(t8.getText()),d);
                Lecturer.writeToFile(l);

                JOptionPane.showMessageDialog(null,"Submitted");
                LecturerMainMenuGui lecturerMainMenuGui=new LecturerMainMenuGui();
            }
            else {
                dispose();
                LecturerMainMenuGui lecturerMainMenuGui=new LecturerMainMenuGui();
            }
        }
    }
}
