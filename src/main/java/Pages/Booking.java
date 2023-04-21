package Pages;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

import Essentials.*;
import Essentials.Button;

public class Booking {
    protected JFrame frame;
    protected JPanel panel;
    protected ImageIcon image;
    protected JLabel label;
    protected Font font;
    private ArrayList<Backend.Booking> array = new ArrayList<>();
    private String allCars = "";
    // Side Buttons
    private Button Home, Store, Booking, Back;
    //private String car_id = "";
    // Argumented Constructor
    public Booking(int width, int height, String title, String location, String text, String Name) {

        this.frame = new JFrame();

        // Essentials for menu display
        this.frame.setSize(width, height);
        this.frame.setLayout(null);
        this.frame.setResizable(false);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.getContentPane().setBackground(new Color(Main.bg, Main.bg, Main.bg));

        // Title and C\:\Users\\Abdullah\\D\esktop\DatabaseProject\\src\\main\\Logo
        this.image = new ImageIcon(location);
        this.frame.setIconImage(image.getImage());
        this.frame.setTitle(title);


        // Side Buttons
        int start = 144;

        // Adding Text Booking
        Text BookingText = new Text(this.frame, 350, 30, 300, 100, "Booking", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 40f);
        BookingText.setInvertColor();

        // Adding C\:\Users\\Abdullah\\D\esktop\DatabaseProject\\src\\main\\Logo to the Top
        new Picture(this.frame, "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Logo\\CarGo-Light-PNG.png", 200, 42, 60, 60);
        new Text(this.frame, 40, 26, 140, 60, "Welcome,", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-SemiBold.ttf", 18f);
        new Text(this.frame, 40, 55, 180, 60, Name, "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 30f);

        JPanel dark = new JPanel();
        dark.setBounds(0, 0, 300, 144);
        dark.setBackground(new Color(Main.fg, Main.fg, Main.fg));
        frame.add(dark);

        // Current Stick-Bar Indicating what page we currently on
        JPanel stick = new JPanel();
        stick.setBounds(0, start * 3 + 3, 7, 144);
        stick.setBackground(new Color(Main.bg, Main.bg, Main.bg));
        stick.setLayout(new BorderLayout(40, 10));
        frame.add(stick);

        Home = new Button(false);
        frame.add(Home.newButton(0, start + 1, 300, 144, "Home", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 20f));

        Store = new Button(false);
        frame.add(Store.newButton(0, start * 2 + 2, 300, 144, "Store", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 20f));
        //Store.setEnabled(false);

        Booking = new Button(false);
        frame.add(Booking.newButton(0, start * 3 + 3, 300, 144, "Booking", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 20f));
        Booking.setEnabled(false);

        Back = new Button(false);
        frame.add(Back.newButton(0, start * 4 + 4, 300, 144, "Back", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 20f));

        // JFrame frame, int y, String carID, String carName, String imgAddress, int carPrice


        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");


            // Connection Code!
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl", "LAB_FINAL", "database");

            Statement stmt = con.createStatement();

            int c_id = 0;
            System.out.println("CNIC" + Static.CNIC);
            ResultSet rs2 = stmt.executeQuery("SELECT ID FROM CUSTOMER WHERE CNIC='"+Static.CNIC+"'");
            while (rs2.next()){
                c_id = rs2.getInt(1);
            }
            System.out.println(c_id);


            ResultSet rs = stmt.executeQuery("select booking.owner,picture.address,car.car_id,car.name,car.price from (car natural join booking) cross join picture where car.picture_id = picture.picture_id and booking.pending = 1 and car.car_id = booking.car and Booking.owner = " + c_id);

            // String company, int id, Picture carPicture
            // int owner_ID, String car_ID, Picture carPicture, Car car
            while (rs.next()) {
                array.add(new Backend.Booking(rs.getInt(1), rs.getString(3), new Backend.Picture(0, rs.getString(2), ""), rs.getString(4), rs.getInt(5)));
            }
        } catch (Exception e) {
            System.out.println("Error <Booking Disp>....");
        }

        //new BookingTiles(this.frame, 140 + y_inc, rs.getString(1), rs.getString(2), rs.getString(11), rs.getInt(7));

        if (array.size() == 0){
            Text sorry = new Text(this.frame, 670, 350, 250, 40, "No Products Exist!", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-SemiBold.ttf", 25f);
            sorry.setInvertColor();
        }
        System.out.println("Array Size: " + array.size());

        int y_inc = 0;
        // frame.add(scrollPanel)
        for (int i = 1; i <= array.size(); i++) {
            //     public BookingTiles(JFrame frame, int y, String carID, String carName, String imgAddress, int carPrice){
            new BookingTiles(this.frame, 140 + y_inc, array.get(i - 1).getCar_ID(), array.get(i - 1).getCarName(), array.get(i - 1).getCarPicture().getPicture_address(), array.get(i - 1).getCarPrice());
            y_inc = y_inc + 243;
            allCars += array.get(i - 1).getCar_ID();
        }

    }
    public void dispose() {
        this.frame.dispose();
    }

    public String getAllCars() {
        return allCars;
    }

    // Must call Method to display
    public void setVisible(boolean set) {
        this.frame.setVisible(set);
    }

    // Getters
    public JFrame getFrame() {
        return this.frame;
    }
}
