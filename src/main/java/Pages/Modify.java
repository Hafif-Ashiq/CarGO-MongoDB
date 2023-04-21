package Pages;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.*;

import Essentials.*;
import Essentials.Button;
import org.bson.Document;

public class Modify {
    protected JFrame frame;
    protected JPanel panel;
    protected ImageIcon image;
    protected JLabel label;
    protected Font font;
    protected ArrayList<Backend.Car> array = new ArrayList<>();

    // Side Buttons
    private Button Stats, Products, ModifyB, Logout;

    String pic_address = "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Logo\\CarGo-Light-PNG.png";

    // Argumented Constructor
    public Modify(int width, int height, String title, String location, String CarText, String Name) {

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

        // Adding TypeText
        Text TypeText = new Text(this.frame, 350, 30, 180, 100, "Modify", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 40f);
        TypeText.setInvertColor();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Connection Code!
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl", "LAB_FINAL", "database");

            Statement stmt = con.createStatement();

            ResultSet pic  = stmt.executeQuery("SELECT address from picture WHERE picture_id = (select picture_id from manufacturer where company_name = '" + Static.current_user + "')");
            while (pic.next()){
                pic_address = pic.getString(1);
            }
        }
        catch (Exception e2){
            System.out.println("Error <Add Picture - Company Home Screen> .................");
        }

        //Adding Logo to the Top
        new Picture(this.frame, pic_address, 200, 42, 60, 60);
        new Text(this.frame, 40, 26, 140, 60, "Welcome,", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-SemiBold.ttf", 18f);
        new Text(this.frame, 40, 55, 180, 60, Name, "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 30f);

        JPanel dark = new JPanel();
        dark.setBounds(0, 0, 300, 144);
        dark.setBackground(new Color(Main.fg, Main.fg, Main.fg));
        frame.add(dark);

        // Current Stick-Bar Indicating what page we currently on
        JPanel stick = new JPanel();
        stick.setBounds(0, start*3+3, 7, 144);
        stick.setBackground(new Color(Main.bg, Main.bg, Main.bg));
        stick.setLayout(new BorderLayout(40, 10));
        frame.add(stick);


        Stats = new Button(false);
        frame.add(Stats.newButton(0, start+1, 300, 144, "Statistics", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 20f));

        Products = new Button(false);
        frame.add(Products.newButton(0, start*2+2, 300, 144, "Products", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 20f));

        ModifyB = new Button(false);
        frame.add(ModifyB.newButton(0, start*3+3, 300, 144, "Modify", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 20f));
        ModifyB.setEnabled(false);

        Logout = new Button(false);
        frame.add(Logout.newButton(0, start*4+4, 300, 144, "Logout", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 20f));

        Button Add = new Button(false);
        frame.add(Add.newButton(350, 140, 860, 95, "+ Add New Product", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 24f));
        Add.setLightColor();

        try {

            String company = Static.current_user;

            Document filter = new Document("company", Static.current_company);
            Document projection = new Document("company",0);

            for (Document doc : Static.db.getCollection("SUV").find(filter).projection(projection)){
                System.out.println(doc.toJson());
                String name = doc.toJson().split(",")[1].split(":")[1].split("\"")[1];
                boolean coupe = Boolean.parseBoolean(doc.toJson().split(",")[2].split(":")[1].substring(1));
//                String company = Static.current_company;
                String color = doc.toJson().split(",")[3].split(":")[1].split("\"")[1];
                int quantity = Integer.parseInt(doc.toJson().split(",")[4].split(":")[1].substring(1));
                int price = Integer.parseInt(doc.toJson().split(",")[5].split(":")[1].substring(1));
                String picture_name = doc.toJson().split(",")[6].split(":")[1].split("\"")[1];
                String pic_address = doc.toJson().split(",")[7];
                String picture_address = pic_address.substring(21,pic_address.length()-1);
                String id = doc.toJson().split(",")[8].split(":")[1].split("\"")[1];

                Backend.Car c= new Backend.Car(price,quantity,0,id,color,company,name,"SUV",coupe,new Backend.Picture(0,picture_address,picture_name));
                array.add(c);
            }
            for (Document doc : Static.db.getCollection("Sedan").find(filter).projection(projection)){
                System.out.println(doc.toJson());
                String name = doc.toJson().split(",")[1].split(":")[1].split("\"")[1];
                boolean coupe = Boolean.parseBoolean(doc.toJson().split(",")[2].split(":")[1].substring(1));
//                String company = Static.current_company;
                String color = doc.toJson().split(",")[3].split(":")[1].split("\"")[1];
                int quantity = Integer.parseInt(doc.toJson().split(",")[4].split(":")[1].substring(1));
                int price = Integer.parseInt(doc.toJson().split(",")[5].split(":")[1].substring(1));
                String picture_name = doc.toJson().split(",")[6].split(":")[1].split("\"")[1];
                String pic_address = doc.toJson().split(",")[7];
                String picture_address = pic_address.substring(21,pic_address.length()-1);
                String id = doc.toJson().split(",")[8].split(":")[1].split("\"")[1];

                Backend.Car c= new Backend.Car(price,quantity,0,id,color,company,name,"Sedan",coupe,new Backend.Picture(0,picture_address,picture_name));
                array.add(c);
            }
            for (Document doc : Static.db.getCollection("Sports").find(filter).projection(projection)){
                System.out.println(doc.toJson());
                String name = doc.toJson().split(",")[1].split(":")[1].split("\"")[1];
                boolean coupe = Boolean.parseBoolean(doc.toJson().split(",")[2].split(":")[1].substring(1));
//                String company = Static.current_company;
                String color = doc.toJson().split(",")[3].split(":")[1].split("\"")[1];
                int quantity = Integer.parseInt(doc.toJson().split(",")[4].split(":")[1].substring(1));
                int price = Integer.parseInt(doc.toJson().split(",")[5].split(":")[1].substring(1));
                String picture_name = doc.toJson().split(",")[6].split(":")[1].split("\"")[1];
                String pic_address = doc.toJson().split(",")[7];
                String picture_address = pic_address.substring(21,pic_address.length()-1);
                String id = doc.toJson().split(",")[8].split(":")[1].split("\"")[1];

                Backend.Car c= new Backend.Car(price,quantity,0,id,color,company,name,"Sports",coupe,new Backend.Picture(0,picture_address,picture_name));
                array.add(c);
            }
            for (Document doc : Static.db.getCollection("Hatch_Back").find(filter).projection(projection)){
                System.out.println(doc.toJson());
                String name = doc.toJson().split(",")[1].split(":")[1].split("\"")[1];
                boolean coupe = Boolean.parseBoolean(doc.toJson().split(",")[2].split(":")[1].substring(1));
//                String company = Static.current_company;
                String color = doc.toJson().split(",")[3].split(":")[1].split("\"")[1];
                int quantity = Integer.parseInt(doc.toJson().split(",")[4].split(":")[1].substring(1));
                int price = Integer.parseInt(doc.toJson().split(",")[5].split(":")[1].substring(1));
                String picture_name = doc.toJson().split(",")[6].split(":")[1].split("\"")[1];
                String pic_address = doc.toJson().split(",")[7];
                String picture_address = pic_address.substring(21,pic_address.length()-1);
                String id = doc.toJson().split(",")[8].split(":")[1].split("\"")[1];

                Backend.Car c= new Backend.Car(price,quantity,0,id,color,company,name,"Hatch Back",coupe,new Backend.Picture(0,picture_address,picture_name));
                array.add(c);
            }
            for (Document doc : Static.db.getCollection("Jeep").find(filter).projection(projection)){
                System.out.println(doc.toJson());
                String name = doc.toJson().split(",")[1].split(":")[1].split("\"")[1];
                boolean coupe = Boolean.parseBoolean(doc.toJson().split(",")[2].split(":")[1].substring(1));
//                String company = Static.current_company;
                String color = doc.toJson().split(",")[3].split(":")[1].split("\"")[1];
                int quantity = Integer.parseInt(doc.toJson().split(",")[4].split(":")[1].substring(1));
                int price = Integer.parseInt(doc.toJson().split(",")[5].split(":")[1].substring(1));
                String picture_name = doc.toJson().split(",")[6].split(":")[1].split("\"")[1];
                String pic_address = doc.toJson().split(",")[7];
                String picture_address = pic_address.substring(21,pic_address.length()-1);
                String id = doc.toJson().split(",")[8].split(":")[1].split("\"")[1];

                Backend.Car c= new Backend.Car(price,quantity,0,id,color,company,name,"Jeep",coupe,new Backend.Picture(0,picture_address,picture_name));
                array.add(c);
            }

        }
        catch (Exception e){
            System.out.println("Error  List Products....");
        }
            int start_y = 0;
        for (int i = 1; i <= array.size(); i++) {

            new ModifyTiles(this.frame, 255 + start_y, array.get(i-1).getCar_id(), array.get(i-1).getCar_name(), "$"+array.get(i-1).getCar_price(), array.get(i-1).getCar_picture().getPicture_address());
            start_y = start_y+115;
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
