package Essentials;
import java.awt.*;
import javax.swing.*;

public class Statistics {
    private TextPanel car_id, car_name, car_price, purchase_date;

    public Statistics(JFrame frame, int y,String id, String name, String price, String date){
        this.car_id = new TextPanel(frame, 350, y, 130, 95,id, "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 24f);
        this.car_name = new TextPanel(frame, 480, y, 360, 95,name, "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 24f);
        this.car_name.setLightColor();
        this.car_price = new TextPanel(frame, 840, y, 140, 95,price, "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 24f);
        this.car_price.setLightColor();
        this.purchase_date = new TextPanel(frame, 980, y, 230, 95,date, "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 24f);
        this.purchase_date.setLightColor();
    }
}
