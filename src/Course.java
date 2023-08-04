import java.io.*;
import java.util.ArrayList;

public class Course implements Serializable {
        private int CourseId;
        private String CourseName;
        private int CourseFee;
        ArrayList<Subject> subjects = new ArrayList<Subject>(5);

        public Course() {
        }

        public Course(int id, String name, int fee, ArrayList<Subject> s) {
            this.CourseId = id;
            this.CourseName = name;
            this.CourseFee = fee;
            for (int i = 0; i < s.size(); i++) {
                subjects.add(i, s.get(i));
            }
        }

        public Course(Course c) {
            this.CourseId = c.CourseId;
            this.subjects = c.subjects;
            this.CourseFee = c.CourseFee;
            this.CourseName = c.CourseName;
        }

        public int getCourseFee() {
            return CourseFee;
        }

        public void setCourseFee(int courseFee) {
            CourseFee = courseFee;
        }

        public int getCourseId() {
            return CourseId;
        }

        public void setCourseId(int courseId) {
            CourseId = courseId;
        }

        public String getCourseName() {
            return CourseName;
        }

        public void setCourseName(String courseName) {
            CourseName = courseName;
        }

        public ArrayList<Subject> getSubjects() {
            return new ArrayList<>(subjects);
        }

        public void setSubjects(ArrayList<Subject> subjects) {
            this.subjects = subjects;
        }

        public static void writeToFile(Course c) {
            ArrayList<Course> List = readAllData();
            List.add(c);
            try {
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Course Record"));
                output.writeObject(List);
            } catch (IOException e) {
                System.out.println("Error Writing File");
            }

        }

        public static ArrayList<Course> readAllData() {
            ArrayList<Course> List = new ArrayList<Course>();
            try {
                ObjectInputStream input = new ObjectInputStream(new FileInputStream("Course Record"));
                List = (ArrayList<Course>) input.readObject();
            } catch (ClassNotFoundException c) {

            } catch (IOException e) {

            }
            return List;
        }

        public static void DisplayAllCourses() {
            ArrayList<Course> List = readAllData();
            for (Course c : List) {
                System.out.println();
                System.out.printf("%-20s%-20s%-20s", "Course ID:", "Name:", "Fee:");
                System.out.println();
                System.out.printf("%-20s%-20s%-20s", c.getCourseId(), c.getCourseName(), c.getCourseFee());
                System.out.println("\n");
                System.out.printf("%-20s%-20s", "Subject Name:", "Credit Hours:");
                System.out.println();
                for (int i = 0; i < c.getSubjects().size(); i++) {
                    System.out.printf("%-20s%-20s",c.getSubjects().get(i).getSubjectName(),c.getSubjects().get(i).getCredit_Hours());
                    System.out.println();
                }
            }
        }

        public static boolean Search(int ID) {
            System.out.println();
            ArrayList<Course> list = readAllData();
            boolean check = false;
            for (Course c : list) {
                if (c.getCourseId() == ID) {
                    check = true;
                }
            }
            return check;
        }
        public static void DisplaySpecific(int ID) {
            ArrayList<Course> List = readAllData();
            for (Course c : List) {
                if (c.getCourseId()==ID) {
                    System.out.printf("%-20s%-20s%-20s", "Id", "Name", "Fee");
                    System.out.println();
                    System.out.printf("%-20s%-20s%-20s", c.getCourseId(), c.getCourseName(),c.getCourseFee());
                    return;
                }
            }
            System.out.println("No Record Found");
        }
        public static void deleteFromFile (int ID) {
            if (Search(ID)) {
                ArrayList<Course> list = readAllData();
                int index = 0;
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getCourseId() == ID) {
                        index = i;
                        break;
                    }
                }
                list.remove(index);

                try {
                    ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Course Record"));
                    output.writeObject(list);
                } catch (IOException e) {

                }
            }
            else{
                System.out.println("No Record Found");
            }
        }

}
