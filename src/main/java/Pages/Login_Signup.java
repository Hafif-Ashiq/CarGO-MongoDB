package Pages;

import java.awt.*;
import javax.swing.*;

import Essentials.Static;
import Essentials.Button;

public class Login_Signup {
    
    private JFrame frame;
    private Button login, signup; 
    private ImageIcon image;
    protected ImageIcon logo;
    protected JLabel logoName;

    //private JLabel label;
    //private Font font;

    // Argumented Constructor
    public Login_Signup(int width, int height, String title, String location){
        
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
        
        // Adding Logo
        this.frame.add(setLogo("C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Logo\\CarGo-Dark-PNG.png", "CarGo", 280, 280, "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 26f));
        
        // Login
        login = new Button(true);
        this.frame.add(login.newButton(440, 460, 400, 75, "Login", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 18f));
        
        // Signup
        signup = new Button(true);
        this.frame.add(signup.newButton(440, 545, 400, 75, "Signup", "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 18f));
        
        
    }
    public boolean isVisible() {
        return frame != null && frame.isVisible();
    }

    // Getters
    public JFrame getFrame(){
        return this.frame;
    }

    // Must call Method to display
    public void setVisible(Boolean check){
        this.frame.setVisible(check);
    }

    public JLabel setLogo(String imageName, String logoText, int logoWidth, int logoHeight, String fontLocation, float fontSize){
        // Initialization
        this.logo = new ImageIcon();
        this.logo = Static.resizeImageIcon(new ImageIcon(imageName), logoWidth, logoHeight);
        this.logoName = new JLabel("CarGO");
        this.logoName.setFont(Static.newFont(fontLocation, fontSize));
        this.logoName.setBounds(500, 60, 280, 350);
        this.logoName.setIconTextGap(10);
        this.logoName.setForeground(new Color(Main.fg, Main.fg, Main.fg));
        this.logoName.setHorizontalTextPosition(JLabel.CENTER);
        this.logoName.setVerticalTextPosition(JLabel.BOTTOM);

        // Setting Logo inside JLabel of Logo
        logoName.setIcon(logo);

        return logoName;
    }
}
