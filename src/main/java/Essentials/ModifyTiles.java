package Essentials;
import javax.swing.*;

public class ModifyTiles {
    private TextPanel car_id, car_name, car_price;
    private Button car_picture, delete;

    public ModifyTiles(JFrame frame, int y,String id, String name, String price, String pictureAddress){
        this.car_id = new TextPanel(frame, 580, y, 130, 95,id, "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 24f);
        this.car_id.setLightColor();
        this.car_name = new TextPanel(frame, 710, y, 295, 95,name, "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 24f);
        this.car_name.setLightColor();
        this.car_price = new TextPanel(frame, 1005, y, 140, 95,price, "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 24f);
        this.car_price.setLightColor();
        delete = new Button(false);
        frame.add(delete.iconButton(1145, y, 65, 95, "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Logo\\delete.png"));


        // Finalize Button
        this.car_picture = new Button(false);
        frame.add(car_picture.iconButton(350, y, 230, 95, pictureAddress));
        car_picture.setIconSize(pictureAddress, 230, 95);
        car_picture.setText(this.car_name.getText());

        delete.setText(this.car_name.getText());
    }
}
