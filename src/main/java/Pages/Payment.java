package Pages;

import java.awt.*;
import javax.swing.*;

import Essentials.Text;
import Essentials.Textfield;
import Essentials.Button;
//import Essentials.Companies;
import Essentials.Picture;

public class Payment {
    protected JFrame frame;
    protected JPanel panel;
    protected ImageIcon image;
    protected JLabel label;
    protected Font font;
    
    // Side Buttons
    private Button Home, Store, Booking, Back;
    private Textfield creditCard, Month, Year, CVC, DD, MM, YY;

    private String carID = "";
    // Argumented Constructor
    public Payment(int width, int height, String title, String location, String text, String Name) {

        carID = text;
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
        
        // Adding Text Payment
        Text payment = new Text(this.frame, 350, 30, 300, 100, "Payment", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 40f);
        payment.setInvertColor();
        
        // Adding C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Logo to the Top
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
        
        // Card Number
        Text cn = new Text(this.frame, 350, 140-45, 400, 150, "Card Number", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 50f);
        cn.setInvertColor();        
        this.creditCard = new Textfield();
        this.frame.add(creditCard.textField(350, 211, 442, 88, "XXXX-XXXX-XXXX-XXXX"));

        // Expiry Date
        Text expiry = new Text(this.frame, 350, 318-45, 400, 150, "Expiry Date", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 50f);
        expiry.setInvertColor();
        this.Month = new Textfield();
        this.frame.add(Month.textField(350, 390, 216, 88, "MM"));
        this.Year = new Textfield();
        this.frame.add(Year.textField(580, 390, 216, 88, "YYYY"));

        // CVV
        Text CVV = new Text(this.frame, 350, 496-45, 300, 150, "CVV", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 50f);
        CVV.setInvertColor();
        this.CVC = new Textfield();
        this.frame.add(CVC.textField(350, 567, 442, 88, "XXX"));


        // Date
        Text Date = new Text(this.frame, 870, 140-45, 300, 150, "Date", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 50f);
        Date.setInvertColor();
        this.DD = new Textfield();
        this.frame.add(DD.textField(870, 211, 107, 88, "DD"));
        this.MM = new Textfield();
        this.frame.add(MM.textField(989, 211, 107, 88, "MM"));
        this.YY = new Textfield();
        this.frame.add(YY.textField(1107, 211, 107, 88, "YYYY"));

        // Finalize
        Text finalize = new Text(this.frame, 924, 580, 210, 70, "Finalize", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 50f);
        finalize.setInvertColor();

        // Forward Button
        Button PaymentForward = new Button(false);
        frame.add(PaymentForward.iconButton(1144, 576, 70, 70, "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Logo\\arrow-right.png"));
        PaymentForward.setIconSize("C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Logo\\arrow-right.png", 22, 40);
        
    }

    //    private Textfield cnic, Month, Year, CVC, DD, MM, YY;

    public String getCreditText(){
        return this.creditCard.getText();
    }
    public String getMonthText(){
        return this.Month.getText();
    }
    public String getYearText(){
        return this.Year.getText();
    }
    public String getCVVText(){
        return this.CVC.getText();
    }
    public String getDDText(){
        return this.DD.getText();
    }
    public String getMMText(){
        return this.MM.getText();
    }
    public String getYYText(){
        return this.YY.getText();
    }
    public String getCarID() {
        return this.carID;
    }

    public void dispose() {
        this.frame.dispose();
    }

    public Textfield getCreditCard() {
        return creditCard;
    }

    public Textfield getCVC() {
        return CVC;
    }

    public Textfield getDD() {
        return DD;
    }

    public Textfield getMM() {
        return MM;
    }

    public Textfield getMonth() {
        return Month;
    }

    public Textfield getYY() {
        return YY;
    }

    public Textfield getYear() {
        return Year;
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
