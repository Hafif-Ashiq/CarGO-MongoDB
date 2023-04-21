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

public class ListCars {
    protected JFrame frame;
    protected JPanel panel;
    protected ImageIcon image;
    protected JLabel label;
    protected Font font;
    protected ArrayList<Backend.Car> array = new ArrayList<Backend.Car>();
    public static String carName;

    // Side Buttons
    private Button Home, Store, Booking, Back;

    // Argumented Constructor
    public ListCars(int width, int height, String title, String location, String CarText, String Name) {

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
        Text TypeText = new Text(this.frame, 350, 30, 400, 100, CarText, "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 40f);
        TypeText.setInvertColor();

        //Adding Logo to the Top
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

        Booking = new Button(false);
        frame.add(Booking.newButton(0, start*3+3, 300, 144, "Booking", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 20f));

        Back = new Button(false);
        frame.add(Back.newButton(0, start*4+4, 300, 144, "Back", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 20f));


        try {


            Document filter = new Document("company", Static.current_company);
            Document projection = new Document("company",0);
            // SELECT * from car cross join picture where car.picture_id = picture.picture_id and company = 'Tesla' and car_id like 'SV%'
            if (CarText.equalsIgnoreCase("SUV")){

                for (Document doc : Static.db.getCollection("SUV").find(filter).projection(projection)){
                    String name = doc.toJson().split(",")[1].split(":")[1].split("\"")[1];
                    boolean coupe = Boolean.parseBoolean(doc.toJson().split(",")[2].split(":")[1].substring(1));
                    String company = Static.current_company;
                    String color = doc.toJson().split(",")[3].split(":")[1].split("\"")[1];
                    int quantity = Integer.parseInt(doc.toJson().split(",")[4].split(":")[1].substring(1));
                    int price = Integer.parseInt(doc.toJson().split(",")[5].split(":")[1].substring(1));
                    String picture_name = doc.toJson().split(",")[6].split(":")[1].split("\"")[1];
                    String pic_address = doc.toJson().split(",")[7];
                    String picture_address = pic_address.substring(21,pic_address.length()-1);
                    String id = doc.toJson().split(",")[8].split(":")[1].split("\"")[1];
                    System.out.println("In SUV");
                    Backend.Car c= new Backend.Car(price,quantity,0,id,color,company,name,"SUV",coupe,new Backend.Picture(0,picture_address,picture_name));
                    array.add(c);

                }

            }
            else if (CarText.equalsIgnoreCase("Sports")){
                for (Document doc : Static.db.getCollection("Sports").find(filter).projection(projection)){
                    String name = doc.toJson().split(",")[1].split(":")[1].split("\"")[1];
                    boolean coupe = Boolean.parseBoolean(doc.toJson().split(",")[2].split(":")[1].substring(1));
                    String company = Static.current_company;
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

            }
            else if (CarText.equalsIgnoreCase("sedan")){
                for (Document doc : Static.db.getCollection("Sedan").find(filter).projection(projection)){
                    String name = doc.toJson().split(",")[1].split(":")[1].split("\"")[1];
                    boolean coupe = Boolean.parseBoolean(doc.toJson().split(",")[2].split(":")[1].substring(1));
                    String company = Static.current_company;
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

            }
            else if (CarText.equalsIgnoreCase("jeep")){
                for (Document doc : Static.db.getCollection("Jeep").find(filter).projection(projection)){
                    String name = doc.toJson().split(",")[1].split(":")[1].split("\"")[1];
                    boolean coupe = Boolean.parseBoolean(doc.toJson().split(",")[2].split(":")[1].substring(1));
                    String company = Static.current_company;
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
            else if (CarText.equalsIgnoreCase("hatch back")){
                for (Document doc : Static.db.getCollection("Hatch_Back").find()){
                    String name = doc.toJson().split(",")[1].split(":")[1].split("\"")[1];
                    boolean coupe = Boolean.parseBoolean(doc.toJson().split(",")[2].split(":")[1].substring(1));
                    String company = Static.current_company;
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
            }
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Error <List Cars>....");
        }

        if (array.size() == 0){
            Text sorry = new Text(this.frame, 590, 350, 400, 40, "Adding New Products Soon : )", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-SemiBold.ttf", 25f);
            sorry.setInvertColor();

        }
        // This can certainly get fixed
        int start_x = 0; // 140
        int start_y = 0; // 267

        System.out.println("Array size is: " + array.size());
        for(int i = 1; i <= array.size(); i++){
            if (i % 2 == 0){
                new DisplayCars(frame, 350 + start_x, 140 + start_y, array.get(i-1).getCar_picture().getPicture_address(), array.get(i-1).getCar_name());
                start_x = 0;
                start_y = start_y + 268;
            }
            else{
                new DisplayCars(frame, 350 + start_x, 140 + start_y, array.get(i-1).getCar_picture().getPicture_address(), array.get(i-1).getCar_name());
                start_x = start_x + 440;
            }
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
