import java.io.Serializable;

public class Date implements Serializable {
    int day;
    int month;
    int year;

    public Date(){}

    public Date(int d,int m, int y){
        this.day=d;
        this.year=y;
        this.month=m;
    }
    public Date(Date D){
        this.day=D.day;
        this.month=D.month;
        this.year=D.year;
    }
    public void setDay(int d){
        day=d;
    }
    public void setMonth(int m){
        month=m;
    }
    public void setYear(int y){
        year=y;
    }
    public int getDay(){
        return day;
    }
    public int getMonth(){
        return month;
    }
    public int getYear(){
        return year;
    }
}
