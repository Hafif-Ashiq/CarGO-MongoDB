package Pages;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

import Backend.Manufacturer;
import Backend.Name;
import Backend.Person;
import Essentials.Text;
//import Essentials.TextPanel;
import Essentials.Button;
//import Essentials.Companies;


public class AdminUsers {
    protected JFrame frame;
    protected JPanel panel;
    protected ImageIcon image;
    protected JLabel label;
    protected Font font;
    private ArrayList<Person> c_array = new ArrayList<>();
    private ArrayList<Manufacturer> m_array = new ArrayList<>();
    private Text Admin;
    private String entity;


    // Argumented Constructor
    public AdminUsers(int width, int height, String title, String location, String entity, String Name) {
        this.entity = entity;
        this.frame = new JFrame();

        // Essentials for menu display
        this.frame.setSize(width, height);
        this.frame.setLayout(null);
        this.frame.setResizable(false);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.getContentPane().setBackground(new Color(Main.bg, Main.bg, Main.bg));

        // Title and C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Logo
        this.image = new ImageIcon(location);
        this.frame.setIconImage(image.getImage());
        this.frame.setTitle(title);


        // Adding Text Login
        Text Entity = new Text(this.frame, 350, 30, 300, 100, entity, "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 40f);
        Entity.setInvertColor();

        // Admin
        this.Admin = new Text(this.frame, 121, 331, 80, 30, "Admin", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 22f);

        Button backButton = new Button(false);
        frame.add(backButton.iconButton(216, 35, 50, 50, "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Logo\\arrow-left.png"));
        backButton.setIconSize("C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Logo\\arrow-left.png", 16, 28);
        backButton.setInvert();

        JPanel dark = new JPanel();
        dark.setBounds(0, 0, 300, 768);
        dark.setBackground(new Color(Main.fg, Main.fg, Main.fg));
        frame.add(dark);


        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");


            // Connection Code!
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl", "LAB_FINAL", "database");

            Statement stmt = con.createStatement();

            if(entity.equalsIgnoreCase("Users")){

                ResultSet rs = stmt.executeQuery("select * from customer natural join name");
                // String company, int id, Picture carPicture
                while (rs.next()){
                    c_array.add(new Backend.Person(rs.getString(1), new Name(rs.getString(3), rs.getString(4))));
                }
            }
            else{

                ResultSet rs = stmt.executeQuery("select * from manufacturer");
                // String company, int id, Picture carPicture
                while (rs.next()){
                    m_array.add(new Backend.Manufacturer(rs.getString(3), rs.getString(2)));
                }
            }

        }
        catch (Exception e){
            System.out.println("Error <Store>....");
        }

        // Use this as an array list
        int start_x = 0;
        int start_y = 0;

        System.out.println("Company Array -> " + m_array.size());
        if (entity.equalsIgnoreCase("Users")){
            for(int i = 1; i <= c_array.size(); i++){
                if (i % 2 == 0){
                    // Keep on adding in loop!
                    Button user = new Button(false);
                    frame.add(user.newButton(350 + start_x, 140 + start_y, 420, 88, c_array.get(i - 1).getName().getF_name() + " " + c_array.get(i - 1).getName().getL_name() + " - " + c_array.get(i - 1).getCnic(), "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-SemiBold.ttf", 22f));
                    user.setLightColor();
                    start_x = 0;
                    start_y = start_y + 103;
                }
                else{
                    // Keep on adding in loop!
                    Button user = new Button(false);
                    frame.add(user.newButton(350 + start_x, 140 + start_y, 420, 88, c_array.get(i - 1).getName().getF_name() + " " + c_array.get(i - 1).getName().getL_name() + " - " + c_array.get(i - 1).getCnic(), "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-SemiBold.ttf", 22f));
                    user.setLightColor();
                    start_x = start_x + 440;
                }
            }
        }
        else {
            for(int i = 1; i <= m_array.size(); i++){
                if (i % 2 == 0){
                    // Keep on adding in loop!
                    Button user = new Button(false);
                    frame.add(user.newButton(350 + start_x, 140 + start_y, 420, 88, m_array.get(i - 1).getCompany() + " - " + m_array.get(i - 1).getCnic(), "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-SemiBold.ttf", 22f));
                    user.setLightColor();
                    start_x = 0;
                    start_y = start_y + 103;
                }
                else {
                    // Keep on adding in loop!
                    Button user = new Button(false);
                    frame.add(user.newButton(350 + start_x, 140 + start_y, 420, 88, m_array.get(i - 1).getCompany() + " - " + m_array.get(i - 1).getCnic(), "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-SemiBold.ttf", 22f));
                    user.setLightColor();
                    start_x = start_x + 440;
                }
            }
        }




    }

    // Get Admin Text
    public String getAdmin(){
        return this.Admin.getText();
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

    public String getEntity() {
        return entity;
    }
}
