import java.io.*;
import java.util.ArrayList;

public class Student extends Person implements Serializable,Result {
    private int RegistrationId;
    private int Semester;
    private double previous_gpa;
    private Course course;
    private Department department;

    public Student(){
        super();
    }

    public Student(String name, int age, Address add, int id, int sem , Course course , Department d, double gpa){

        super(name,age,add);
        this.RegistrationId =id;
        this.Semester =sem;
        this.course =new Course(course);
        this.department = new Department(d);
        this.previous_gpa = gpa;

    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course= course;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


    public int getRegistrationId() {
        return RegistrationId;
    }

    public void setRegistrationId(int registrationId) {
        RegistrationId = registrationId;
    }

    public int getSemester() {
        return Semester;
    }

    public void setSemester(int semester) {
        Semester = semester;
    }
    public double getPrevious_gpa() {
        return previous_gpa;
    }

    public void setPrevious_gpa(double previous_gpa) {
        this.previous_gpa = previous_gpa;
    }

    public static void writeToFile(Student s) {
        ArrayList<Student> List = readAllData();
        List.add(s);
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Student Record"));
            output.writeObject(List);
        } catch (Exception e) {
            System.out.println("Error Writing File");
        }

    }

    public static ArrayList<Student> readAllData() {
        ArrayList<Student> List = new ArrayList<Student>();
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("Student Record"));
            List = (ArrayList<Student>) input.readObject();
        } catch (ClassNotFoundException c) {

        } catch (Exception e) {

        }
        return List;
    }

    public static void DisplayAllStudents() {
        ArrayList<Student> List = readAllData();
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s","Reg No:","Name:","Semester:","Department Name:","Section:","Course:");
        System.out.println();
        System.out.println();
        for (Student s : List) {
            System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s",s.getRegistrationId(),s.getName(),s.getSemester(),s.getDepartment().getDepartmentName(),s.getDepartment().getSection(),s.getCourse().getCourseName());
            System.out.println();
        }
    }

    public static void Update(int RegistrationNumber , Student New){
        if(Search(RegistrationNumber)) {
            ArrayList<Student> list = readAllData();
            for (Student s : list) {

                if (s.getRegistrationId() == RegistrationNumber) {
                    s.setRegistrationId(New.getRegistrationId());
                    s.setName(New.getName());
                    s.setAge(New.getAge());
                    s.setDepartment(New.getDepartment());
                    s.setCourse(New.getCourse());
                    s.setAddress(New.getAddress());
                    s.setSemester(New.getSemester());

                }
            }
            try {
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Student Record"));
                output.writeObject(list);
            } catch (IOException e) {

            }
        }
        else {
            System.out.println("No Record to Update");
        }

    }

    public static boolean Search(int Registration) {
        ArrayList<Student> List = readAllData();
        boolean search = false;
        for (Student s : List) {
            if (s.getRegistrationId() == Registration) {
                search = true;
            }
        }
        return search;
    }

    public static void DisplaySpecific(int Registration) {
        ArrayList<Student> List = readAllData();
        for (Student s : List) {
            if (s.getRegistrationId() == Registration) {
                System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s","Reg No:","Name:","Semester:","Department Name:","Section:","Course:");
                System.out.println();
                System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s",s.getRegistrationId(),s.getName(),s.getSemester(),s.getDepartment().getDepartmentName(),s.getDepartment().getSection(),s.getCourse().getCourseName());
                return;
            }
        }
        System.out.println("No Student Found");
    }
    public double CGPA(int reg) {
        double cgpa = 0;
        double gpa =0;
        int credit_hrs=0;
        ArrayList<Student> List = readAllData();
        for (Student s : List) {
            if (s.getRegistrationId() == reg) {
                gpa = s.getPrevious_gpa();
                for(int i=0 ; i<5 ;i++){
                    gpa = gpa+ ((s.getCourse().getSubjects().get(i).getObtained_GPA()) *(s.getCourse().getSubjects().get(i).getCredit_Hours()));
                    credit_hrs = credit_hrs+ (s.getCourse().getSubjects().get(i).getCredit_Hours());

                }
                cgpa = gpa/credit_hrs;
            }

        }
        return   Math.round(cgpa * 100.0) / 100.0;
    }


    public static void DisplayResult(int registrationId){
        ArrayList<Student> List = readAllData();
        for (Student s : List) {
            if (s.getRegistrationId() == registrationId) {
                System.out.printf("%-15s%-15s%-15s%-15s","Name","Semester","Course","CGPA");
                System.out.println();
                System.out.printf("%-15s%-15s%-15s%-15s",s.getName(),s.getSemester(),s.getCourse().getCourseName(),s.CGPA(registrationId));
                return;
            }
        }
        System.out.println("No Student Found");
    }
    public static boolean IsEmpty(){
        ArrayList<Student> List = readAllData();
        if(List.isEmpty()){
            return true;
        }
        else {
            return false;
        }
    }


    public static void deleteFromFile (int Registration) {
        if (Search(Registration)) {
            ArrayList<Student> list = readAllData();
            int index = 0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getRegistrationId() == Registration) {
                    index = i;
                    break;
                }
            }
            list.remove(index);

            try {
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Student Record"));
                output.writeObject(list);
            } catch (IOException e) {

            }

        } else {
            System.out.println("No Record Found");
        }
    }
}
