import java.io.Serializable;

public class Address implements Serializable {
    private int house;
    private int street;
    private String city;

    public Address(){

    }
    public Address(int h, int s, String c){
        house=h;
        street=s;
        city=c;
    }

    public Address(Address a){
        this.house=a.house;
        this.street = a.street;
        this.city = a.city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public int getStreet() {
        return street;
    }

    public void setStreet(int street) {
        this.street = street;
    }
}



