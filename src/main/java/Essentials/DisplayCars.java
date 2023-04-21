package Essentials;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class DisplayCars implements ActionListener {
    protected JButton button;
    protected Font font;
    protected JPanel buttonPanel;
    protected JLabel buttonLabel;
    //protected static String address1 = null;

    public DisplayCars(JFrame frame, int x, int y, String imageLocation, String companyName){
        // Creating a new button
        this.button = new JButton();
        this.button.setBounds(x, y, 420, 208);
        this.button.addActionListener(this);
        this.button.setBorder(BorderFactory.createLineBorder(new Color(236, 236, 236), 0));
        this.button.setBackground(Color.white);
        this.button.setIcon(Static.resizeImageIcon(new ImageIcon(imageLocation), 420, 208));

        // Creates hover state
        this.button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setBounds(x - 5, y - 5, 420 + 10, 208 + 10);
                button.setIcon(Static.resizeImageIcon(new ImageIcon(imageLocation), 420 + 10, 208 + 10));
                button.setBorder(BorderFactory.createLineBorder((new Color(57, 57, 57)), 3));

            }

            public void mouseExited(MouseEvent e) {
                button.setBounds(x, y, 420, 208);
                button.setIcon(Static.resizeImageIcon(new ImageIcon(imageLocation), 420, 208));
                button.setBorder(BorderFactory.createLineBorder((new Color(236, 236, 236)), 0));
            }
        });

        // Adding the bottom panel to indicate company
        // Creating new Label
        this.buttonLabel = new JLabel();
        this.buttonLabel.setText(companyName);
        this.buttonLabel.setFont(Static.newFont("C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-SemiBold.ttf", 18f));
        this.buttonLabel.setForeground(Color.WHITE);
        this.buttonLabel.setVerticalAlignment(JLabel.CENTER);
        this.buttonLabel.setHorizontalAlignment(JLabel.CENTER);

        // Creating new panels
        buttonPanel = new JPanel();
        this.buttonPanel.setBounds(x, y+203, 420, 40);
        this.buttonPanel.setBackground(new Color(57,57,57));
        this.buttonPanel.setLayout(new BorderLayout(20, 5));

        // Inserting label into panel
        this.buttonPanel.add(buttonLabel);

        // Imported frame as it'd add on top of the above screen
        frame.add(this.button);
        // Add this to frame too
        frame.add(buttonPanel);

    }

    // Get Text of Company
    public String getCarNameText() {
        return this.buttonLabel.getText();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == this.button && (Static.route.peek() instanceof Pages.ListCars)){
            // Check the "CarName" and override ListCars.carName with getCarNameText();
            // Based on that open up that page!

            // Closes the previous screen and opens up the new screen
            Pages.Main.closeInstance(Static.route.peek());
            Pages.Car car_page = new Pages.Car(Pages.Main.screen_Width, Pages.Main.screen_Height, Pages.Main.screen_Title, Pages.Main.screen_Image_Location, getCarNameText(), "Abdullah");
            car_page.setVisible(true);
            Static.route.push(car_page);
        }
        else if(e.getSource() == this.button && this.button.getText().equalsIgnoreCase("Back")){
            Pages.Main.closeInstance(Static.route.pop());
            Pages.Main.openInstance(Static.route.peek());
        }
    }

}
