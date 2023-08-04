import java.io.Serializable;

public class Person implements Serializable {
    private String Name;
    private int Age;
    private Address address;

    public Person() {
    }

    public Person(String name, int age, Address add) {
        this.Name = name;
        this.Age = age;
        this.address = new Address(add);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        this.Age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
