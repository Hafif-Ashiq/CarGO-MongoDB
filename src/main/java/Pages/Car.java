package Pages;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

import Essentials.*;
import Essentials.Button;

public class Car {
    protected JFrame frame;
    protected JPanel panel;
    protected ImageIcon image;
    protected JLabel label;
    protected Font font;
    protected Text carName;
    // Side Buttons
    private Button Home, Store, Booking, Back;
    // Argumented Constructor
    public Car(int width, int height, String title, String location, String text, String Name) {

        this.frame = new JFrame();

        // Essentials for menu display
        this.frame.setSize(width, height);
        this.frame.setLayout(null);
        this.frame.setResizable(false);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.getContentPane().setBackground(new Color(Main.bg, Main.bg, Main.bg));

        // Title and Logo
        this.image = new ImageIcon(location);
        this.frame.setIconImage(image.getImage());
        this.frame.setTitle(title);

        
        // Side Buttons
        int start = 144;
        
        // Adding Text Store
        this.carName = new Text(this.frame, 350, 30, 300, 100, text, "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 40f);
        this.carName.setInvertColor();
        
        // Adding Logo to the Top
        new Picture(this.frame, "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Logo\\CarGo-Light-PNG.png", 200, 42, 60, 60);
        new Text(this.frame, 40, 26, 140, 60, "Welcome,", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-SemiBold.ttf", 18f);
        new Text(this.frame, 40, 55, 180, 60, Name, "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 30f);
        
        JPanel dark = new JPanel();
        dark.setBounds(0, 0, 300, 144);
        dark.setBackground(new Color(Main.fg, Main.fg, Main.fg));
        frame.add(dark);


        Home = new Button(false);
        frame.add(Home.newButton(0, start+1, 300, 144, "Home", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 20f));
        
        Store = new Button(false);
        frame.add(Store.newButton(0, start*2+2, 300, 144, "Store", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 20f));
        //Store.setEnabled(false);
        
        Booking = new Button(false);
        frame.add(Booking.newButton(0, start*3+3, 300, 144, "Booking", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 20f));
        
        Back = new Button(false);
        frame.add(Back.newButton(0, start*4+4, 300, 144, "Back", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 20f));


        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");


            // Connection Code!
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl", "LAB_FINAL", "database");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from car cross join picture where car.picture_id = picture.picture_id and car.name = '" + text + "'");
            while (rs.next()){

                // Picture of a Car
                new Picture(this.frame, rs.getString(11), 350, 140, 860, 305);

                // Description
                TextPanel Description = new TextPanel(this.frame, 350, 455, 480, 95,"Description", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 24f);
                Description.setLightColor();

                // Price
                TextPanel Price = new TextPanel(this.frame, 840, 455, 370, 95,"$"+rs.getInt(7), "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 24f);
                Price.setLightColor();

                // Description Box
                TextPanel color = new TextPanel(this.frame, 420, 560, 175, 47,"Color: "+rs.getString(5), "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 18f);
                color.setLeftAlignment();
                if (rs.getInt(3) == 1){
                    TextPanel coupe =  new TextPanel(this.frame, 420, 560+47, 175, 47,"Coupe: Yes", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 18f);
                    coupe.setLeftAlignment();
                }
                TextPanel coupe =  new TextPanel(this.frame, 420, 560+47, 175, 47,"Coupe: No", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 18f);
                coupe.setLeftAlignment();

                if (rs.getString(1).contains("SV")){
                    TextPanel type = new TextPanel(this.frame, 640-40, 560, 190, 48,"Type: SUV", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 18f);
                    type.setLeftAlignment();
                }
                else if (rs.getString(1).contains("SP")){
                    TextPanel type = new TextPanel(this.frame, 640-40, 560, 190, 48,"Type: Sports", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 18f);
                    type.setLeftAlignment();
                }
                else if (rs.getString(1).contains("SD")){
                    TextPanel type = new TextPanel(this.frame, 640-40, 560, 190, 48,"Type: Sedan", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 18f);
                    type.setLeftAlignment();
                }
                else if (rs.getString(1).contains("JP")){
                    TextPanel type = new TextPanel(this.frame, 640-40, 560, 190, 48,"Type: Jeep", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 18f);
                    type.setLeftAlignment();
                }
                else if (rs.getString(1).contains("HB")){
                    TextPanel type = new TextPanel(this.frame, 640-40, 560, 190, 48,"Type: Hatch Back", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 18f);
                    type.setLeftAlignment();
                }
                TextPanel company = new TextPanel(this.frame, 640-40, 560+47, 190, 48,"Company: "+rs.getString(4), "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 18f);
                company.setLeftAlignment();
                new TextPanel(this.frame, 350, 560, 480, 95,"", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 18f);
            }
        }
        catch (Exception e){
            System.out.println("Error <Pages.Car>....");
        }

        // Start adding stuff from here
        // SELECT * from car cross join picture where car.picture_id = picture.picture_id and car.name = 'Tesla Model X'

        Button BookNow = new Button(false);
        frame.add(BookNow.newButton(840, 560, 370, 95, "Book Now", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 24f));

    }

    public void dispose() {
        this.frame.dispose();
    }


    // Must call Method to display
    public void setVisible(boolean set) {
        this.frame.setVisible(set);
    }

    // get carName

    public String getCarName() {
        return carName.getText();
    }

    // Getters
    public JFrame getFrame() {
        return this.frame;
    }
}
