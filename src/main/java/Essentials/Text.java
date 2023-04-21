package Essentials;
import java.awt.*;
import javax.swing.*;

public class Text {
    protected JLabel text;
    
    public Text(JFrame frame, int x, int y, int width, int height, String text, String fontLocation, float fontSize){
        this.text = new JLabel(text);
        this.text.setFont(Static.newFont(fontLocation, fontSize));
        this.text.setBounds(x, y, width, height);
        this.text.setForeground(Color.WHITE);
        //this.text.setBackground(new Color(236, 236,236));
        this.text.setHorizontalTextPosition(JLabel.CENTER);
        this.text.setVerticalTextPosition(JLabel.BOTTOM);
        frame.add(this.text);
    }

    // getText
    public String getText() {
        return text.getText();
    }

    // Set Alignment
    public void setTextAlignment(){
        this.text.setHorizontalTextPosition(JLabel.LEADING);   
    }

    public void setInvertColor(){
        this.text.setForeground(new Color(57, 57,57));
        //this.text.setBackground(new Color(57, 57,57));        
    }
}
