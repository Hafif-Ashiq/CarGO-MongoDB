package Essentials;
import Backend.Car;
import Pages.Add_Product;
import org.bson.Document;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class CarProducts implements ActionListener {
    protected JButton button;
    protected Font font;
    protected JPanel buttonPanel;
    protected JLabel buttonLabel;
    //protected static String address1 = null;

    public static String carName;

    public CarProducts(JFrame frame, int x, int y, String imageLocation, String companyName){
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
    public String getText() {
        return this.buttonLabel.getText();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.button && (Static.route.peek() instanceof Pages.ListProducts)){
            // Closes the previous screen and opens up the new screen
            // Use try catch block to find the car and move to the Modify Page
            Backend.Car c = new Backend.Car();
            try {
                Document filter = new Document("car_name", getText());
                Document projection = new Document("car_name", 0);

                Document doc = Static.db.getCollection("SUV").find(filter).projection(projection).first();

                if (doc != null) {
                    System.out.println(doc.toJson());

                    boolean coupe = Boolean.parseBoolean(doc.toJson().split(",")[1].split(":")[1].substring(1));
                    String car_company = doc.toJson().split(",")[2].split(":")[1].split("\"")[1];
                    String color = doc.toJson().split(",")[3].split(":")[1].split("\"")[1];
                    int quantity = Integer.parseInt(doc.toJson().split(",")[4].split(":")[1].substring(1));
                    int price = Integer.parseInt(doc.toJson().split(",")[5].split(":")[1].substring(1));
                    String picture_name = doc.toJson().split(",")[6].split(":")[1].split("\"")[1];
                    String pic_address = doc.toJson().split(",")[7];
                    String picture_address = pic_address.substring(21,pic_address.length()-1);
                    String id = doc.toJson().split(",")[8].split(":")[1].split("\"")[1];

                    c = new Backend.Car(price, quantity, 0, id, color, car_company, getText(), "SUV", coupe, new Backend.Picture(0, picture_address, picture_name));

                } else {
                    doc = Static.db.getCollection("Sports").find(filter).projection(projection).first();
                    if (doc != null) {
                        boolean coupe = Boolean.parseBoolean(doc.toJson().split(",")[1].split(":")[1].substring(1));
                        String car_company = doc.toJson().split(",")[2].split(":")[1].split("\"")[1];
                        String color = doc.toJson().split(",")[3].split(":")[1].split("\"")[1];
                        int quantity = Integer.parseInt(doc.toJson().split(",")[4].split(":")[1].substring(1));
                        int price = Integer.parseInt(doc.toJson().split(",")[5].split(":")[1].substring(1));
                        String picture_name = doc.toJson().split(",")[6].split(":")[1].split("\"")[1];
                        String pic_address = doc.toJson().split(",")[7];
                        String picture_address = pic_address.substring(21,pic_address.length()-1);
                        String id = doc.toJson().split(",")[8].split(":")[1].split("\"")[1];

                        c = new Backend.Car(price, quantity, 0, id, color, car_company, getText(), "SUV", coupe, new Backend.Picture(0, picture_address, picture_name));

                    } else {
                        doc = Static.db.getCollection("Sedan").find(filter).projection(projection).first();
                        if (doc != null) {
                            boolean coupe = Boolean.parseBoolean(doc.toJson().split(",")[1].split(":")[1].substring(1));
                            String car_company = doc.toJson().split(",")[2].split(":")[1].split("\"")[1];
                            String color = doc.toJson().split(",")[3].split(":")[1].split("\"")[1];
                            int quantity = Integer.parseInt(doc.toJson().split(",")[4].split(":")[1].substring(1));
                            int price = Integer.parseInt(doc.toJson().split(",")[5].split(":")[1].substring(1));
                            String picture_name = doc.toJson().split(",")[6].split(":")[1].split("\"")[1];
                            String pic_address = doc.toJson().split(",")[7];
                            String picture_address = pic_address.substring(21,pic_address.length()-1);
                            String id = doc.toJson().split(",")[8].split(":")[1].split("\"")[1];

                            c = new Backend.Car(price, quantity, 0, id, color, car_company, getText(), "Sedan", coupe, new Backend.Picture(0, picture_address, picture_name));

                        } else {
                            doc = Static.db.getCollection("Jeep").find(filter).projection(projection).first();
                            if (doc != null) {
                                boolean coupe = Boolean.parseBoolean(doc.toJson().split(",")[1].split(":")[1].substring(1));
                                String car_company = doc.toJson().split(",")[2].split(":")[1].split("\"")[1];
                                String color = doc.toJson().split(",")[3].split(":")[1].split("\"")[1];
                                int quantity = Integer.parseInt(doc.toJson().split(",")[4].split(":")[1].substring(1));
                                int price = Integer.parseInt(doc.toJson().split(",")[5].split(":")[1].substring(1));
                                String picture_name = doc.toJson().split(",")[6].split(":")[1].split("\"")[1];
                                String pic_address = doc.toJson().split(",")[7];
                                String picture_address = pic_address.substring(21,pic_address.length()-1);
                                String id = doc.toJson().split(",")[8].split(":")[1].split("\"")[1];

                                c = new Backend.Car(price, quantity, 0, id, color, car_company, getText(), "Jeep", coupe, new Backend.Picture(0, picture_address, picture_name));

                            } else {
                                doc = Static.db.getCollection("Hatch_Back").find(filter).projection(projection).first();
                                if (doc != null) {
                                    boolean coupe = Boolean.parseBoolean(doc.toJson().split(",")[1].split(":")[1].substring(1));
                                    String car_company = doc.toJson().split(",")[2].split(":")[1].split("\"")[1];
                                    String color = doc.toJson().split(",")[3].split(":")[1].split("\"")[1];
                                    int quantity = Integer.parseInt(doc.toJson().split(",")[4].split(":")[1].substring(1));
                                    int price = Integer.parseInt(doc.toJson().split(",")[5].split(":")[1].substring(1));
                                    String picture_name = doc.toJson().split(",")[6].split(":")[1].split("\"")[1];
                                    String pic_address = doc.toJson().split(",")[7];
                                    String picture_address = pic_address.substring(21,pic_address.length()-1);
                                    String id = doc.toJson().split(",")[8].split(":")[1].split("\"")[1];

                                    c = new Backend.Car(price, quantity, 0, id, color, car_company, getText(), "Hatch Back", coupe, new Backend.Picture(0, picture_address, picture_name));

                                }
                            }
                        }
                    }
                }

            }
            catch (Exception ex){
                System.out.println("Error  Car Products....");
            }

            Pages.Main.closeInstance(Static.route.peek());
            Pages.Add_Product add_product_page = new Pages.Add_Product(Pages.Main.screen_Width, Pages.Main.screen_Height, Pages.Main.screen_Title, Pages.Main.screen_Image_Location, "Modify Product", Static.current_user);
            add_product_page.getP_name().setText(c.getCar_name());
            add_product_page.getP_name().disable();

            add_product_page.getP_price().setText(c.getCar_price()+"");
            add_product_page.getP_color().setText(c.getCar_color());
            add_product_page.getP_qty().setText(c.getCar_quantity()+"");
            add_product_page.getP_type().setText(c.getType());
            add_product_page.setSelectedPic(c.getCar_picture());
            add_product_page.addPic();
            add_product_page.addCoupe();
            Add_Product.pg_modify = true;
            add_product_page.setVisible(true);

            Static.route.push(add_product_page);
        }
        else if(e.getSource() == this.button && this.button.getText().equalsIgnoreCase("Back")){
            Pages.Main.closeInstance(Static.route.pop());
            Pages.Main.openInstance(Static.route.peek());
        }

    }

}
