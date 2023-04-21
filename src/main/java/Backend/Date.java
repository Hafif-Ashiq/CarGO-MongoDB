package Backend;

public class Date {
        
    private int day;
    private int month;
    private int year; 

    
    // Default Constructor
    public Date() {
    }

    // Argumented Constructor
    public Date(int day, int month, int year) {

        this.day = day;
        this.month = month;
        this.year = year;
    }

    // Setters
    public void setDay(int day) {
        this.day = day;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public void setYear(int year) {
        this.year = year;
    }

    // Getters
    public int getDay() {
        return day;
    }
    public int getMonth() {
        return month;
    }
    public int getYear() {
        return year;
    }

    // Display Method
    public void display() {

        System.out.println(day + "  " + month + "  " + year);
    }

    @Override
    public String toString() {
        return day + "-" + month + "-" + year ;
    }
}