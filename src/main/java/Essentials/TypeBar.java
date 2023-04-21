package Essentials;
import javax.swing.*;

public class TypeBar {
    protected Button button;
    
    public TypeBar(JFrame frame, int x, int y, String imgName, String typeName){
        
        // Adding Side Image
        new Picture(frame, "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Cars\\"+imgName, x, y, 245, 95);
        
        // Creating a new button
        this.button = new Button(false);
        frame.add(button.newButton(x+245, y, 600, 95, typeName, "C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 20f));
        button.setLightColor();
        

    }

    // Get Text of Company
    public String getText() {
        return this.button.getText();        
    }  
}
