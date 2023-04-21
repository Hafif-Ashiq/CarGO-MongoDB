package Pages;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

import Essentials.*;
import Essentials.Button;
//import Essentials.Companies;


public class Add_Product {
    protected JFrame frame;
    protected JPanel panel;
    protected ImageIcon image;
    protected JLabel label;
    protected Font font;

    // Side Buttons
    private Button Add, Stats, Products, ModifyB, Back;
    private Backend.Picture selectedPic = new Backend.Picture(0,"","");
    private JCheckBox checkBox;
    private Text Confirm;
    public static boolean pg_modify = false;
    private static Textfield p_name, p_qty, p_type, p_color, p_price;

    String pic_address = "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Logo\\CarGo-Light-PNG.png";

    // Argumented Constructor
    public Add_Product(int width, int height, String title, String location, String text, String Name) {

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

        // Side Buttons
        int start = 144;

        // Adding Text Signup
        Text signup = new Text(this.frame, 350, 30, 500, 100, text, "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 40f);
        signup.setInvertColor();

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

        Stats = new Button(false);
        frame.add(Stats.newButton(0, start+1, 300, 144, "Statistics", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 20f));
        //Home.setInvert();

        Products = new Button(false);
        frame.add(Products.newButton(0, start*2+2, 300, 144, "Products", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 20f));

        ModifyB = new Button(false);
        frame.add(ModifyB.newButton(0, start*3+3, 300, 144, "Modify", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 20f));

        Back = new Button(false);
        frame.add(Back.newButton(0, start*4+4, 300, 144, "Back", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 20f));

        // --------------------------------- //
        JPanel dark = new JPanel();
        dark.setBounds(0, 0, 300, 144);
        dark.setBackground(new Color(Main.fg, Main.fg, Main.fg));
        frame.add(dark);

        // Name
        Text ProductName = new Text(this.frame, 350, 140-45, 400, 150, "Name", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 50f);
        ProductName.setInvertColor();
        this.p_name = new Textfield();
        this.frame.add(p_name.textField(350, 211, 286, 88, "abc"));

        // QTY
        this.p_qty = new Textfield();
        this.frame.add(p_qty.textField(650, 211, 146, 88, "Qty"));
        p_qty.setInvert();

        // Type
        Text Type = new Text(this.frame, 350, 318-45, 400, 150, "Type", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 50f);
        Type.setInvertColor();
        this.p_type = new Textfield();
        this.frame.add(p_type.textField(350, 390, 286, 88, "Type"));

        // Coupe
        Text coupe = new Text(frame, 700, 453, 50, 18, "Coupe", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-SemiBold.ttf", 14f);
        //coupe.setInvertColor();
        JPanel panel = new JPanel();
        panel.setBackground(new Color(57, 57, 57));
        panel.setBounds(650, 390, 146, 88);

        // Picture
        Text Picture = new Text(this.frame, 350, 496-45, 300, 150, "Picture", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 50f);
        Picture.setInvertColor();

        Add = new Button(false);
        frame.add(Add.newButton(650, 567, 146, 88, "+ Add", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-SemiBold.ttf", 22f));


        // Color
        Text Color = new Text(this.frame, 870, 140-45, 300, 150, "Color", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 50f);
        Color.setInvertColor();
        this.p_color = new Textfield();
        this.frame.add(p_color.textField(870, 211, 340, 88, "Color"));

        // Price
        Text Price = new Text(this.frame, 870, 318-45, 400, 150, "Price", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 50f);
        Price.setInvertColor();
        this.p_price = new Textfield();
        this.frame.add(p_price.textField(870, 390, 340, 88, "Price"));


        // Confirm
        this.Confirm = new Text(this.frame, 913, 580, 250, 70, "Confirm", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 50f);
        this.Confirm.setInvertColor();

        // Delete Button
        Button PaymentForward = new Button(false);
        frame.add(PaymentForward.iconButton(1144, 576, 70, 70, "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Logo\\arrow-right.png"));
        PaymentForward.setIconSize("C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Logo\\arrow-right.png", 22, 40);

    }
    public void dispose() {
        this.frame.dispose();
    }

    // Get Confirm
    public String getConfirm(){
        return this.Confirm.getText();
    }
    // Must call Method to display
    public void setVisible(boolean set) {
        this.frame.setVisible(set);
    }

    public void addPic(){
        //this.selectedPic.addImage("C:\\Users\\07haf\\OneDrive\\Desktop\\LAB_FINAL\\src\\main\\Cars\\Lambo-1.jpg");
        new Picture(this.frame, selectedPic.getPicture_address(), 350, 567, 286, 88);
    }

    public void setSelectedPic(Backend.Picture selectedPic) {
        this.selectedPic = selectedPic;
    }

    public void addCoupe(){
        JPanel panel = new JPanel();
        panel.setBackground(new Color(57, 57, 57));
        panel.setBounds(650, 390, 146, 88);
        this.checkBox = new JCheckBox();
        this.checkBox.setIcon(new ImageIcon("C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Logo\\disabled.png"));
        this.checkBox.setDisabledIcon(new ImageIcon("C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Logo\\disabled.png"));
        this.checkBox.setSelectedIcon(new ImageIcon("C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Logo\\enabled.png"));
        this.checkBox.setBackground(new Color(57, 57, 57));
        this.checkBox.setBounds(700,404,42,36);
        frame.add(checkBox);
        frame.add(panel);

    }
    // get State
    public String getProductNameText(){
        return this.p_name.getText();
    }
    public String getProducQuantityText(){
        return this.p_qty.getText();
    }
    public String getProducTypeText(){
        return this.p_type.getText();
    }
    public String getProducColorText(){
        return this.p_color.getText();
    }
    public String getProducPriceText(){
        return this.p_price.getText();
    }

    public Textfield getP_color() {
        return p_color;
    }

    public Textfield getP_type() {
        return p_type;
    }

    public Textfield getP_qty() {
        return p_qty;
    }

    public Textfield getP_price() {
        return p_price;
    }

    public Textfield getP_name() {
        return p_name;
    }

    public Backend.Picture getSelectedPic() {
        return selectedPic;
    }

    public Button getAdd() {
        return Add;
    }

    public void setP_type(Textfield p_type) {
        Add_Product.p_type = p_type;
    }

    public void setP_qty(Textfield p_qty) {
        Add_Product.p_qty = p_qty;
    }

    public void setP_name(Textfield p_name) {
        Add_Product.p_name = p_name;
    }

    public void setP_price(Textfield p_price) {
        Add_Product.p_price = p_price;
    }

    public void setP_color(Textfield p_color) {
        Add_Product.p_color = p_color;
    }

    public boolean isCoupe(){
        return this.checkBox.isSelected();
    }
    // Getters
    public JFrame getFrame() {
        return this.frame;
    }
}
