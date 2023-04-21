package Backend;

public class Booking {
    private int booking_id, owner_ID;
    private String  car_ID;
    private Date booking_date;
    private boolean pending;
    private Picture carPicture;
    private String carName;
    private int carPrice;
//    public Booking(int booking_id, int car_ID, int owner_ID, String car_company, Date booking_date) {
//        this.booking_id = booking_id;
//        this.car_ID = car_ID;
//        this.owner_ID = owner_ID;
//        this.car_company = car_company;
//        this.booking_date = booking_date;
//    }

    public Booking(int booking_id, int owner_ID, String car_ID, Date booking_date, boolean pending) {
        this.booking_id = booking_id;
        this.owner_ID = owner_ID;
        this.car_ID = car_ID;
        this.booking_date = booking_date;
        this.pending = pending;
    }


    public Booking(int owner_ID, String car_ID, Picture carPicture, String carName, int carPrice) {
        this.owner_ID = owner_ID;
        this.car_ID = car_ID;
        this.carPicture = carPicture;
        this.carName = carName;
        this.carPrice = carPrice;
    }
// setters


    public void setPending(boolean pending) {
        this.pending = pending;
    }

    public void setBooking_date(Date booking_date) {
        this.booking_date = booking_date;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public void setCar_ID(String car_ID) {
        this.car_ID = car_ID;
    }

    public void setOwner_ID(int owner_ID) {
        this.owner_ID = owner_ID;
    }

    // Getters

    public int getCarPrice() {
        return carPrice;
    }

    public String getCarName() {
        return carName;
    }

    public Picture getCarPicture() {
        return carPicture;
    }


    public Date getBooking_date() {
        return booking_date;
    }

    public int getBooking_id() {
        return booking_id;
    }


    public int getOwner_ID() {
        return owner_ID;
    }

    public String getCar_ID() {
        return car_ID;
    }
}
