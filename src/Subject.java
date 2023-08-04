import java.io.*;
import java.util.ArrayList;

public class Subject implements Serializable {
    private String SubjectId;
    private String SubjectName;
    private int Credit_Hours;
    private double Obtained_GPA;

    public Subject() {
    }

    public Subject(String subjectId, String subjectName, int credit_Hours, double gpa) {
        SubjectId = subjectId;
        SubjectName = subjectName;
        Credit_Hours = credit_Hours;
        this.Obtained_GPA = gpa;
    }

    public int getCredit_Hours() {
        return Credit_Hours;
    }

    public void setCredit_Hours(int credit_Hours) {
        Credit_Hours = credit_Hours;
    }

    public String getSubjectId() {
        return SubjectId;
    }

    public void setSubjectId(String subjectId) {
        SubjectId = subjectId;
    }

    public String getSubjectName() {
        return SubjectName;
    }

    public void setSubjectName(String subjectName) {
        SubjectName = subjectName;
    }

    public double getObtained_GPA() {
        return Obtained_GPA;
    }

    public void setObtained_GPA(double obtained_GPA) {
        Obtained_GPA = obtained_GPA;
    }

    public static void writeToFile(Subject s) {
        ArrayList<Subject> List = readAllData();
        List.add(s);
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Subject Record"));
            output.writeObject(List);
        } catch (Exception e) {
            System.out.println("Error Writing File");
        }

    }

    public static ArrayList<Subject> readAllData() {
        ArrayList<Subject> List = new ArrayList<Subject>();
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("Subject Record"));
            List = (ArrayList<Subject>) input.readObject();
        } catch (ClassNotFoundException c) {

        } catch (Exception e) {

        }
        return List;
    }

}
