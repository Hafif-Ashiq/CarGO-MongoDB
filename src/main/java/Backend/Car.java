package Backend;

public class Car {
    private int  car_price, car_quantity,carTypeID;
    private String car_id,car_color, car_company, car_name,type;
    private Boolean isCoupe;
    private Picture car_picture;
    private Date purchase_date;

    public Car() {
    }

    public Car(int car_price, String car_id, String car_name, Date purchase_date) {
        this.car_price = car_price;
        this.car_id = car_id;
        this.car_name = car_name;
        this.purchase_date = purchase_date;
    }

    public Car(String carName){
        this.car_name = carName;
    }
    public Car(String car_name, Picture car_picture){
        this.car_name = car_name;
        this.car_picture = car_picture;
    }
    public Car(int car_price, int car_quantity, int carTypeID, String car_id, String car_color, String car_company, String car_name, String type, Boolean isCoupe, Picture car_picture) {
        this.car_price = car_price;
        this.car_quantity = car_quantity;
        this.carTypeID = carTypeID;
        this.car_id = car_id;
        this.car_color = car_color;
        this.car_company = car_company;
        this.car_name = car_name;
        this.type = type;
        this.isCoupe = isCoupe;
        this.car_picture = car_picture;
    }

    // setters

    public void setType(String type) {
        this.type = type;
    }

    public void setCar_color(String car_color) {
        this.car_color = car_color;
    }

    public void setCar_company(String car_company) {
        this.car_company = car_company;
    }



    // getters
    public Boolean getCoupe() {
        return isCoupe;
    }



    public String getType() {
        return type;
    }

    public int getCar_quantity() {
        return car_quantity;
    }

    public Picture getCar_picture() {
        return car_picture;
    }

    public int getCarTypeID() {
        return carTypeID;
    }

    public String getCar_id() {
        return car_id;
    }

    public String getCar_company() {
        return car_company;
    }

    public String getCar_color() {
        return car_color;
    }

    public String getCar_name() {
        return car_name;
    }

    public int getCar_price() {
        return car_price;
    }

    public Date getPurchase_date() {
        return purchase_date;
    }

    @Override
    public String toString() {
        return "Car{" +
                "car_id=" + car_id +
                ", car_price=" + car_price +
                ", car_quantity=" + car_quantity +
                ", car_color='" + car_color + '\'' +
                ", car_company='" + car_company + '\'' +
                ", car_name='" + car_name + '\'' +
                ", isCoupe=" + isCoupe +
                ", car_picture=" + car_picture +
                '}';
    }
}
