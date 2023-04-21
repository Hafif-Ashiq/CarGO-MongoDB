package Essentials;

import java.awt.*;
import javax.swing.*;

public class Picture {
    
    protected ImageIcon logo;
    protected JLabel logoName;

    private int width, height;
    // Default Constructor
    public Picture(JFrame frame, String imageName, int x, int y, int logoWidth, int logoHeight) {

        this.logo = new ImageIcon();
        this.logo = Static.resizeImageIcon(new ImageIcon(imageName), logoWidth, logoHeight);
        this.logoName = new JLabel();
        this.logoName.setBounds(x, y, logoWidth, logoHeight);
        logoName.setIcon(logo);
        frame.add(logoName);

        width = logoWidth;
        height = logoHeight;
    }

    // Add Image
    public void addImage(String imageName){
        this.logo = Static.resizeImageIcon(new ImageIcon(imageName), width, height);
    }
}
