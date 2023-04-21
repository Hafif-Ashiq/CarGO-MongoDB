package Essentials;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import java.awt.*;
import java.io.*;
import javax.swing.*;

public class Static {

    protected static Font font;
    // Push stack
    public static Route_Stack route = new Route_Stack();
    public static String CNIC;
    public static String current_user;
    public static String current_company;
    public static MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

    // Get the "test" database
    public static MongoDatabase db = mongoClient.getDatabase("CarGo");

    //    public static Textfield p_name, p_qty, p_type, p_color, p_price;
    public static String picAddres = null;

    // Useful Static Methods
    public static ImageIcon resizeImageIcon(ImageIcon ii, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(ii.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        return imageIcon;
    }

    public static Font newFont(String fontLocation, Float fontSize) {

        // Creating a new custom font
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File(fontLocation)).deriveFont(fontSize);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            // register the font
            ge.registerFont(font);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }
        return font;
    }

    public static boolean isValid(long number) {
        return (getSize(number) >= 13 &&
                getSize(number) <= 16) &&
                (prefixMatched(number, 4) ||
                        prefixMatched(number, 5) ||
                        prefixMatched(number, 37) ||
                        prefixMatched(number, 6)) &&
                ((sumOfDoubleEvenPlace(number) +
                        sumOfOddPlace(number)) % 10 == 0);
    }

    // Get the result from Step 2
    private static int sumOfDoubleEvenPlace(long number) {
        int sum = 0;
        String num = number + "";
        for (int i = getSize(number) - 2; i >= 0; i -= 2)
            sum += getDigit(Integer.parseInt(num.charAt(i) + "") * 2);

        return sum;
    }

    // Return this number if it is a single digit, otherwise,
    // return the sum of the two digits
    private static int getDigit(int number) {
        if (number < 9)
            return number;
        return number / 10 + number % 10;
    }

    // Return sum of odd-place digits in number
    private static int sumOfOddPlace(long number) {
        int sum = 0;
        String num = number + "";
        for (int i = getSize(number) - 1; i >= 0; i -= 2)
            sum += Integer.parseInt(num.charAt(i) + "");
        return sum;
    }

    // Return true if the digit d is a prefix for number
    private static boolean prefixMatched(long number, int d) {
        return getPrefix(number, getSize(d)) == d;
    }

    // Return the number of digits in d
    private static int getSize(long d) {
        String num = d + "";
        return num.length();
    }

    // Return the first k number of digits from
    // number. If the number of digits in number
    // is less than k, return number.
    private static long getPrefix(long number, int k) {
        if (getSize(number) > k) {
            String num = number + "";
            return Long.parseLong(num.substring(0, k));
        }
        return number;
    }

}
