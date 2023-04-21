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
//import Essentials.TextPanel;
//import Essentials.Companies;


public class AdminStats {
    protected JFrame frame;
    protected JPanel panel;
    protected ImageIcon image;
    protected JLabel label;
    protected Font font;
    protected ArrayList<Backend.Car> array = new ArrayList<>();

    // Argumented Constructor
    public AdminStats(int width, int height, String title, String location, String stats_name, String cnic,String entity) {

        this.frame = new JFrame();

        // Essentials for menu display
        this.frame.setSize(width, height);
        this.frame.setLayout(null);
        this.frame.setResizable(false);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.getContentPane().setBackground(new Color(236, 236, 236));

        // Title and C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Logo
        this.image = new ImageIcon(location);
        this.frame.setIconImage(image.getImage());
        this.frame.setTitle(title);


        // Adding Text Login
        Text Stats = new Text(this.frame, 350, 30, 700, 100, stats_name, "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 40f);
        Stats.setInvertColor();

        // Admin
        new Text(this.frame, 121, 331, 80, 30, "Admin", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 22f);

        Button backButton = new Button(false);
        frame.add(backButton.iconButton(216, 35, 50, 50, "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Logo\\arrow-left.png"));
        backButton.setIconSize("C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Logo\\arrow-left.png", 16, 28);
        backButton.setInvert();

        JPanel dark = new JPanel();
        dark.setBounds(0, 0, 300, 768);
        dark.setBackground(new Color(57, 57, 57));
        frame.add(dark);

        // Keep on adding in loop!
        // Take everything in the argument for the result

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");


            // Connection Code!
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl", "LAB_FINAL", "database");

            Statement stmt = con.createStatement();

            if (entity.equalsIgnoreCase("Users")){
                int c_id = 0;
                ResultSet rs2 = stmt.executeQuery("Select id from customer where cnic = '" + cnic + "'");

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
            else if (entity.equalsIgnoreCase("Companies")){
                String company = "";
                ResultSet rs2 = stmt.executeQuery("Select company_name from manufacturer where cnic = '" + cnic + "'");

                while (rs2.next()){
                    company = rs2.getString(1);
                }

                System.out.println(company);

                ResultSet rs = stmt.executeQuery("select car.price,car.car_id,car.name,booking.booking_date from (booking natural join car) cross join stats where company = '" + company + "' and booking.id = stats.booking_id and car.car_id = booking.car");
//    public Car(int car_price, String car_id, String car_name, Date purchase_date) {
//
                while (rs.next()){
                    String d = rs.getString(4).substring(0,10);
                    System.out.println(d);
                    String[] da = d.split("-");


                    array.add(new Backend.Car(rs.getInt(1),rs.getString(2),rs.getString(3),new Date(Integer.parseInt(da[2]),Integer.parseInt(da[1]),Integer.parseInt(da[0]))));
                }
            }


        }
        catch (Exception e){
            System.out.println("Error  User Stats ....");
        }


        int y = 0;
        for (int i = 1; i <= array.size(); i++) {
            new Statistics(frame, 140 + y, array.get(i-1).getCar_id(), array.get(i-1).getCar_name(), "$"+array.get(i-1).getCar_price(), array.get(i-1).getPurchase_date().getDay()+"-"+array.get(i-1).getPurchase_date().getMonth()+"-"+array.get(i-1).getPurchase_date().getYear());
//            t_price += array.get(i-1).getCar_price();
            y = y + 105;
        }

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
