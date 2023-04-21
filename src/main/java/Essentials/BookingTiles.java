package Essentials;

import Pages.Main;

import java.awt.*;
import javax.swing.*;
import Essentials.Text;
import Essentials.TextPanel;
import Essentials.Button;
import Essentials.Picture;


public class BookingTiles {

    protected TextPanel car_id, car_name, car_price;
    protected Button Delete, Proceed;
    protected JPanel line;

    public BookingTiles(JFrame frame, int y, String carID, String carName, String imgAddress, int carPrice){

        // Picture of a Car
        new Picture(frame, imgAddress, 350, y, 360, 200);

        // y -> 140

        // Car-ID
        this.car_id = new TextPanel(frame, 720, y, 130, 95,carID, "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 24f);
        car_id.setLightColor();

        // Car-Name
        this.car_name = new TextPanel(frame, 850, y, 360, 95,carName, "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 24f);
        car_name.setLightColor();

        // Delete Button
        this.Delete = new Button(false);
        frame.add(Delete.iconButton(870, y+105, 84, 95, "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Logo\\delete.png"));
        this.Delete.setText(carID);
        // Car-Price
        this.car_price = new TextPanel(frame, 720, y+105, 140, 95,"$" + carPrice, "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 24f);
        car_price.setLightColor();

        // Booking
        this.Proceed = new Button(false);
        frame.add(Proceed.iconButton(964, y+105, 246, 95, "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Logo\\Proceed.png"));
        this.Proceed.setIconSize("C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Logo\\Proceed.png", 106, 29);
        this.Proceed.setText(carID);

        this.line = new JPanel();
        line.setBounds(350, y + 220, 860, 3);
        line.setBackground(new Color(Main.fg, Main.fg, Main.fg));
        line.setLayout(new BorderLayout(40, 10));
        frame.add(line);
    }

    // Get Car id!
    public String getCar_id() {
        return car_id.getText();
    }
}
