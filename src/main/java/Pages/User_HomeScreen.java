package Pages;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.*;

import Backend.Date;
import Essentials.*;
import Essentials.Button;

public class User_HomeScreen {
    protected JFrame frame;
    protected JPanel panel;
    protected ImageIcon image;
    protected JLabel label;
    protected ArrayList<Backend.Car> array = new ArrayList<>();
    protected Font font;
    // Side Buttons
    private Button Home, Store, Booking, Logout;
    
    // Argumented Constructor
    public User_HomeScreen(int width, int height, String title, String location, String text, String Name) {

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

        // Adding Text Statistics
        Text stats = new Text(this.frame, 350, 30, 300, 100, "Statistics", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 40f);
        stats.setInvertColor();
        
        // Side Buttons
        int start = 144;
        
        //Adding Logo to the Top
        new Picture(this.frame, "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Logo\\CarGo-Light-PNG.png", 200, 42, 60, 60);
        new Text(this.frame, 40, 26, 140, 60, "Welcome,", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-SemiBold.ttf", 18f);
        new Text(this.frame, 40, 55, 180, 60, Name, "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 30f);
        
        JPanel dark = new JPanel();
        dark.setBounds(0, 0, 300, 144);
        dark.setBackground(new Color(Main.fg, Main.fg, Main.fg));
        frame.add(dark);

        //frame.add(homeLogo.setLogo());


        // Current Stick-Bar Indicating what page we currently on
        JPanel stick = new JPanel();
        stick.setBounds(0, start, 7, 144);
        stick.setBackground(new Color(Main.bg, Main.bg, Main.bg));
        stick.setLayout(new BorderLayout(40, 10));
        frame.add(stick);
        
        Home = new Button(false);
        frame.add(Home.newButton(0, start+1, 300, 144, "Home", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 20f));
        Home.setEnabled(false);
        //Home.setInvert();
        
        Store = new Button(false);
        frame.add(Store.newButton(0, start*2+2, 300, 144, "Store", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 20f));
        
        Booking = new Button(false);
        frame.add(Booking.newButton(0, start*3+3, 300, 144, "Booking", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 20f));
        
        Logout = new Button(false);
        frame.add(Logout.newButton(0, start*4+4, 300, 144, "Logout", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 20f));


        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");


            // Connection Code!
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl", "LAB_FINAL", "database");

            Statement stmt = con.createStatement();


            int c_id = 0;
            ResultSet rs2 = stmt.executeQuery("Select id from customer where cnic = '" + Static.CNIC + "'");

            while (rs2.next()){
                c_id = rs2.getInt(1);
            }

            System.out.println(c_id);

            ResultSet rs = stmt.executeQuery("select car.price,car.car_id,car.name,booking.booking_date,booking.id from (booking natural join car) cross join stats where owner = " + c_id + " and booking.id = stats.booking_id and car.car_id = booking.car");
//    public Car(int car_price, String car_id, String car_name, Date purchase_date) {
//
            while (rs.next()){
                String d = rs.getString(4).substring(0,10);
                System.out.println(d);
                String[] da = d.split("-");


                array.add(new Backend.Car(rs.getInt(1),rs.getString(2),rs.getString(3),new Date(Integer.parseInt(da[2]),Integer.parseInt(da[1]),Integer.parseInt(da[0]))));
            }
        }
        catch (Exception e){
            System.out.println("Error  User Stats ....");
        }

        int t_price = 0;
        
        // Stats
        int y = 0;
        for (int i = 1; i <= array.size(); i++) {
            new Statistics(frame, 140 + y, array.get(i-1).getCar_id(), array.get(i-1).getCar_name(), "$"+array.get(i-1).getCar_price(), array.get(i-1).getPurchase_date().getDay()+"-"+array.get(i-1).getPurchase_date().getMonth()+"-"+array.get(i-1).getPurchase_date().getYear());
            t_price += array.get(i-1).getCar_price();
            y = y + 105;
        }
        // 1140, 580, 70, 70
        new TextPanel(frame, 1140, 580, 70, 70,"$", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-SemiBold.ttf", 48f);
        TextPanel total_price = new TextPanel(frame, 780, 580, 360, 70,"- $" + t_price, "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 48);
        total_price.setTransparent();
        total_price.setRightAlignment();

    }

    public void dispose() {
        this.frame.dispose();
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
