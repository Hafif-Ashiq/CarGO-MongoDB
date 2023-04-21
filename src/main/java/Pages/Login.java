package Pages;

import java.awt.*;
import javax.swing.*;

import Essentials.Text;
//import Essentials.TextPanel;
import Essentials.Textfield;
import Essentials.Button;
//import Essentials.Companies;
import Essentials.Picture;

public class Login {
    protected JFrame frame;
    protected JPanel panel;
    protected ImageIcon image;
    protected JLabel label;
    protected Font font;
    
    // Side Buttons
    private Button Home, Store, Booking, Back;
    private Textfield fullName, pswdField;
    // Argumented Constructor
    public Login(int width, int height, String title, String location, String text, String Name) {

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
        Text login = new Text(this.frame, 350, 30, 300, 100, "Login", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 40f);
        login.setInvertColor();
        
        // Adding C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Logo to the Top
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
        Text Email = new Text(this.frame, 350, 140-45, 400, 150, "Email", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 50f);
        Email.setInvertColor();
        this.fullName = new Textfield();
        this.frame.add(fullName.textField(350, 211, 442, 88, "abc@gmail.com"));

        // Password
        Text password = new Text(this.frame, 350, 318-45, 300, 150, "Password", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 50f);
        password.setInvertColor();
        this.pswdField = new Textfield();
        this.frame.add(pswdField.pswdField(350, 390, 442, 88, "........."));

        // Finalize
        Text finalize = new Text(this.frame, 924, 580, 210, 70, "Finalize", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 50f);
        finalize.setInvertColor();

        // Forward Button
        Button PaymentForward = new Button(false);
        frame.add(PaymentForward.iconButton(1144, 576, 70, 70, "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Logo\\arrow-right.png"));
        PaymentForward.setIconSize("C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Logo\\arrow-right.png", 22, 40);
        
    }

    public Textfield getFullName() {
        return fullName;
    }

    public Textfield getPswdField() {
        return pswdField;
    }

    // Get Email Text
    public String getEmailText(){
        return this.fullName.getText();
    }
    // Get Password Text
    public char[] getPasswordText(){
        return this.pswdField.getPassword();
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
