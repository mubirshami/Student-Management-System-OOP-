import java.io.*;
import java.util.ArrayList;

public class Lecturer extends Person implements Serializable {
    private int lecturer_id;
    private String contact;
    private int salary;
    private Date hiredate;

    public Lecturer() {
        super();
    }

    public Lecturer(String n, int age, Address a, int lid, String c, int sal, Date d) {
        super(n, age, a);
        lecturer_id = lid;
        contact = c;
        salary = sal;
        hiredate = new Date(d);

    }
    public Lecturer(Lecturer t){
        super(t.getName(),t.getAge(),t.getAddress());
        this.lecturer_id=t.lecturer_id;
        this.contact=t.contact;
        this.salary=t.salary;
        this.hiredate=t.hiredate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getLecturer_id() {
        return lecturer_id;
    }

    public void setLecturer_id(int lecturer_id) {
        this.lecturer_id = lecturer_id;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }


    public static void writeToFile(Lecturer l) {
        ArrayList<Lecturer> List = readAllData();
        List.add(l);
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Lecturer Record"));
            output.writeObject(List);
        } catch (IOException e) {
            System.out.println("Error Writing File");
        }

    }

    public static ArrayList<Lecturer> readAllData() {
        ArrayList<Lecturer> List = new ArrayList<Lecturer>();
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("Lecturer Record"));
            List = (ArrayList<Lecturer>) input.readObject();
        } catch (ClassNotFoundException c) {

        } catch (IOException e) {

        }
        return List;
    }

    public static void DisplayAll() {
        ArrayList<Lecturer> list = readAllData();
        System.out.printf("%-20s%-20s%-20s%-20s%-20s", "Id:", "Name:", "Contact:", "Salary:","Hire Date:");
        for (Lecturer t : list) {
            System.out.println();
            System.out.printf("%-20s%-20s%-20s%-20s", t.getLecturer_id(), t.getName(), t.getContact(), t.getSalary());
            System.out.print(t.getHiredate().getDay()+"/"+t.getHiredate().month+"/"+t.getHiredate().getYear());
        }
        System.out.println();
    }

    public static boolean Search(int ID) {
        System.out.println();
        ArrayList<Lecturer> list = readAllData();
        boolean check=false;
        for (Lecturer l : list) {
            if (l.getLecturer_id() == ID) {
                check= true;
            }
        }
        return check;
    }

    public static void UpdateSpecific(int ID, Lecturer NewLecturer) {
        if(Search(ID)) {
            ArrayList<Lecturer> list = readAllData();
            for (Lecturer l : list) {
                if (l.getLecturer_id() == ID) {
                    l.setLecturer_id(NewLecturer.getLecturer_id());
                    l.setName(NewLecturer.getName());
                    l.setAge(NewLecturer.getAge());
                    l.setContact(NewLecturer.getContact());
                    l.setSalary(NewLecturer.getSalary());
                    l.setAddress(NewLecturer.getAddress());
                }
            }
            try {
                ObjectOutputStream data = new ObjectOutputStream(new FileOutputStream("Lecturer Record"));
                data.writeObject(list);
            } catch (Exception e) {

            }
        }
        else{
            System.out.println("No Record Found");
        }
    }

    public static void DisplaySpecific(int ID) {
        ArrayList<Lecturer> List = readAllData();
        for (Lecturer t : List) {
            if (t.getLecturer_id()==ID) {
                System.out.printf("%-20s%-20s%-20s%-20s%-20s", "Id", "Name", "Contact", "Salary","Hire Date");
                System.out.println();
                System.out.printf("%-20s%-20s%-20s%-20s", t.getLecturer_id(), t.getName(), t.getContact(), t.getSalary());
                System.out.print(t.getHiredate().getDay()+"/"+t.getHiredate().month+"/"+t.getHiredate().getYear());
                return;
            }
        }
        System.out.println("No Record Found");
    }
    public boolean CurrentStatus(int id){
        if(Search(id)) {
            return true;
        }
        else{
            return false;
        }
    }

    public static void deleteFromFile (int ID) {
        if (Search(ID)) {
            ArrayList<Lecturer> list = readAllData();
            int index = 0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getLecturer_id() == ID) {
                    index = i;
                    break;
                }
            }
            list.remove(index);

            try {
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Lecturer Record"));
                output.writeObject(list);
            } catch (IOException e) {

            }

        }
        else{
            System.out.println("No Record Found");
        }
    }
    public static boolean IsEmpty(){
        ArrayList<Lecturer> List = readAllData();
        if(List.isEmpty()){
            return true;
        }
        else {
            return false;
        }
    }
}
