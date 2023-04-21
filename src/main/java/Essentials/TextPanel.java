package Essentials;
import java.awt.*;
import javax.swing.*;

public class TextPanel {
    protected JLabel text;
    protected JPanel panel;
    
    public TextPanel(JFrame frame, int x, int y, int width, int height, String text, String fontLocation, float fontSize){
        
        this.text = new JLabel();
        this.text.setText(text);
        this.text.setFont(Static.newFont(fontLocation, fontSize));
        this.text.setForeground(new Color(236, 236, 236));
       // this.text.setHorizontalTextPosition(JLabel.CENTER);
        //this.text.setVerticalTextPosition(JLabel.CENTER);
        
        this.panel = new JPanel();        
        this.panel.setBounds(x, y, width, height);
        this.panel.setBackground(new Color(57, 57,57));
        //this.panel.setLayout(new BorderLayout(20,5));
        this.panel.setLayout(new GridBagLayout());
        
        this.panel.add(this.text);
        
        
        frame.add(this.panel);
    }   

    // Set Left Alignment
    public void setLeftAlignment(){
        this.panel.setLayout(new BorderLayout(20,5));
        this.panel.add(this.text);
    }

    public void setRightAlignment(){
        this.panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 15, 5));
        //this.text.setHorizontalAlignment(SwingConstants.RIGHT);
        this.panel.add(this.text);
    }
    public void setInvertColor(){
        this.text.setForeground(new Color(57, 57,57));
        this.panel.setBackground(new Color(236, 236, 236));
        //this.text.setBackground(new Color(57, 57,57));        
    }

    public void setLightColor(){
        this.text.setForeground(new Color(57, 57,57));
        this.panel.setBackground(new Color(203, 203, 203));
        //this.text.setBackground(new Color(57, 57,57));        
    }

    public void setTransparent(){
        this.text.setForeground(new Color(57, 57,57));
        this.panel.setBackground(new Color(236, 236, 236));
        //this.text.setBackground(new Color(57, 57,57));
    }

    public String getText() {
        return text.getText();
    }
}
