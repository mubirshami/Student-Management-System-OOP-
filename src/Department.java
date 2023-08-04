import java.io.Serializable;

public class Department implements Serializable {
    private int DepartmentId;
    private String DepartmentName;
    private String section;

    public Department() {
    }

    public Department(int id, String name, String sec){

        this.DepartmentId =id;
        this.DepartmentName = name;
        this.section = sec;
    }

    public Department(Department d){
        this.DepartmentId = d.DepartmentId;
        this.DepartmentName = d.DepartmentName;
        this.section =d.section;
    }

    public int getDepartmentId() {
        return DepartmentId;
    }

    public void setDepartmentId(int departmentId) {
        DepartmentId = departmentId;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String departmentName) {
        DepartmentName = departmentName;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String toString(){
        return  this.DepartmentId +" " + this.DepartmentName+" "+this.section;
    }

}
