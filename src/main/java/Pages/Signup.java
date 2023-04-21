package Pages;

import java.awt.*;
import javax.swing.*;

import Essentials.Text;
import Essentials.Textfield;
import Essentials.Button;
//import Essentials.Companies;
import Essentials.Picture;

public class Signup {
    protected JFrame frame;
    protected JPanel panel;
    protected ImageIcon image;
    protected JLabel label;
    protected Font font;
    private static Textfield f_name, l_name,Date, Month, Year, CNIC, city, zip, Email, passwordTF, pswdField, ph, cTF;

    // Side Buttons
    private Button Home, Store, Booking, Back;
    private Text continueT, finalize;
    // Argumented Constructor
    public Signup(int width, int height, String title, String location, String text, String Name) {

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
        Text signup = new Text(this.frame, 350, 30, 300, 100, "Signup", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 40f);
        signup.setInvertColor();

        new Picture(this.frame, "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Logo\\CarGo-Light-PNG.png", 121, 331, 60, 60);

        Button backButton = new Button(false);
        frame.add(backButton.iconButton(216, 35, 50, 50, "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Logo\\arrow-left.png"));
        backButton.setIconSize("C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Logo\\arrow-left.png", 16, 28);
        backButton.setInvert();

        JPanel dark = new JPanel();
        dark.setBounds(0, 0, 300, 768);
        dark.setBackground(new Color(Main.fg, Main.fg, Main.fg));
        frame.add(dark);

        // Name
        Text cn = new Text(this.frame, 350, 140-45, 400, 150, "Name", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 50f);
        cn.setInvertColor();
        this.f_name = new Textfield();
        this.frame.add(f_name.textField(350, 211, 216, 88, "First Name"));
        this.l_name = new Textfield();
        this.frame.add(l_name.textField(580, 211, 216, 88, "Last Name"));

        // DOB
        Text dob = new Text(this.frame, 350, 318-45, 400, 150, "Date of Birth", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 50f);
        dob.setInvertColor();
        this.Date = new Textfield();
        this.frame.add(Date.textField(350, 390, 139, 88, "DD"));
        this.Month = new Textfield();
        this.frame.add(Month.textField(504, 390, 139, 88, "MM"));
        this.Year = new Textfield();
        this.frame.add(Year.textField(654, 390, 139, 88, "YYYY"));

        // CNIC
        Text cnic = new Text(this.frame, 350, 496-45, 300, 150, "CNIC", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 50f);
        cnic.setInvertColor();
        this.CNIC = new Textfield();
        this.frame.add(CNIC.textField(350, 567, 442, 88, "XXXXX-XXXXXXX-X"));

        // City
        Text City = new Text(this.frame, 870, 140-45, 300, 150, "City", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 50f);
        City.setInvertColor();
        this.city = new Textfield();
        this.frame.add(city.textField(870, 211, 343, 88, "abc"));

        // Zip
        Text Zip = new Text(this.frame, 870, 318-45, 300, 150, "Zip Code", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 50f);
        Zip.setInvertColor();
        this.zip = new Textfield();
        this.frame.add(zip.textField(870, 390, 343, 88, "XXXXX"));

        // Continue
        this.continueT = new Text(this.frame, 884, 580, 250, 70, "Continue", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 50f);
        this.continueT.setInvertColor();

        // Delete Button
        Button PaymentForward = new Button(false);
        frame.add(PaymentForward.iconButton(1144, 576, 70, 70, "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Logo\\arrow-right.png"));
        PaymentForward.setIconSize("C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Logo\\arrow-right.png", 22, 40);

    }
    // Second Constructor
    public Signup(int width, int height, String title, String location, String Name) {

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


        // Adding Text Signup
        Text signup = new Text(this.frame, 350, 30, 300, 100, "Signup", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 40f);
        signup.setInvertColor();

        new Picture(this.frame, "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Logo\\CarGo-Light-PNG.png", 121, 331, 60, 60);

        // Back Button
        Button backButton = new Button(false);
        frame.add(backButton.iconButton(216, 35, 50, 50, "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Logo\\arrow-left.png"));
        backButton.setIconSize("C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Logo\\arrow-left.png", 16, 28);
        backButton.setInvert();

        JPanel dark = new JPanel();
        dark.setBounds(0, 0, 300, 768);
        dark.setBackground(new Color(Main.fg, Main.fg, Main.fg));
        frame.add(dark);

        // Email
        Text email = new Text(this.frame, 350, 140-45, 400, 150, "Email", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 50f);
        email.setInvertColor();
        this.Email = new Textfield();
        this.frame.add(Email.textField(350, 211, 442, 88, "abc@gmail.com"));

        // Password
        Text password = new Text(this.frame, 350, 318-45, 400, 150, "Password", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 50f);
        password.setInvertColor();
        this.passwordTF = new Textfield();
        this.frame.add(passwordTF.pswdField(350, 390, 442, 88, "........"));

        // Verify Password
        Text verify_password = new Text(this.frame, 350, 496-45, 430, 150, "Verify Password", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 50f);
        verify_password.setInvertColor();
        this.pswdField = new Textfield();
        this.frame.add(pswdField.pswdField(350, 567, 442, 88, "........."));

        // Phone
        Text Phone = new Text(this.frame, 870, 140-45, 300, 150, "Phone", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 50f);
        Phone.setInvertColor();
        this.ph = new Textfield();
        this.frame.add(ph.textField(870, 211, 343, 88, "+XX-XXXXXXXXXX"));

        // Company
        Text Company = new Text(this.frame, 870, 318-45, 300, 150, "Company", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 50f);
        Company.setInvertColor();
        this.cTF = new Textfield();
        this.frame.add(cTF.textField(870, 390, 343, 88, "Manufacturers-Only"));

        // Finalize
        this.finalize = new Text(this.frame, 924, 580, 210, 70, "Finalize", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 50f);
        this.finalize.setInvertColor();

        this.continueT = new Text(this.frame,1,1,1,1,"","C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf",1);

        // Finalize Button
        Button FinalizeButton = new Button(false);
        frame.add(FinalizeButton.iconButton(1144, 576, 70, 70, "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Logo\\arrow-right.png"));
        FinalizeButton.setIconSize("C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Logo\\arrow-right.png", 22, 40);

    }

    public String getContinue(){
        return this.continueT.getText();
    }

    public String getFinalize(){

        return this.finalize.getText();
    }

    public void dispose() {
        this.frame.dispose();
    }

    public Textfield getPswdField() {
        return pswdField;
    }

    public Textfield getCity() {
        return city;
    }

    public Textfield getZip() {
        return zip;
    }

    public Textfield getYear() {
        return Year;
    }

    public Textfield getPh() {
        return ph;
    }

    public Textfield getPasswordTF() {
        return passwordTF;
    }





    public Textfield getMonth() {
        return Month;
    }

    public Textfield getL_name() {
        return l_name;
    }

    public Textfield getF_name() {
        return f_name;
    }

    public Textfield getEmail() {
        return Email;
    }

    public Textfield getDate() {
        return Date;
    }

    public Textfield getCNIC() {
        return CNIC;
    }

    public Textfield getcTF() {
        return cTF;
    }
    public String getEmailText(){return this.Email.getText();}

    // Must call Method to display
    public void setVisible(boolean set) {
        this.frame.setVisible(set);
    }

    // Getters
    public JFrame getFrame() {
        return this.frame;
    }
    // Get text of all the text fields
    public String getF_NameText(){
        return this.f_name.getText();
    }
    public String getL_NameText(){
        return this.l_name.getText();
    }
    public String getDateText(){
        return this.Date.getText();
    }
    public String getMonthText(){
        return this.Month.getText();
    }

    public String getYearText(){
        return this.Year.getText();
    }
    public String getCNICText(){
        return this.CNIC.getText();
    }
    public String getCityText(){
        return this.city.getText();
    }
    public String getZipText(){
        return this.zip.getText();
    }
    public char[] getPasswordText(){
        return this.passwordTF.getPassword();
    }
    public char[] getVerifyPasswordText(){
        return this.pswdField.getPassword();
    }
    public String getPhoneText(){
        return this.ph.getText();
    }
    public String getCompanyText(){
        return this.cTF.getText();
    }
}
