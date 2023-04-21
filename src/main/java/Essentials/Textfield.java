package Essentials;

import java.awt.*;
import java.io.*;
import java.time.format.TextStyle;

import javax.swing.*;
import java.awt.event.*;

public class Textfield implements ActionListener{
    private JTextField textField;
    private JPasswordField pswdField;
    
    public JPasswordField pswdField (int x, int y, int width, int height, String text){

        // Means password field
        this.pswdField = new JPasswordField(15);
        this.pswdField.setBounds(x, y,  width, height);
        this.pswdField.setFont(Static.newFont("C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-Bold.ttf", 20f));
        this.pswdField.setText(text);
        this.pswdField.setEditable(true);
        this.pswdField.setBackground(new Color(203, 203, 203));
        this.pswdField.setCaretColor(Color.BLACK);
        this.pswdField.setHorizontalAlignment(JTextField.CENTER);
        this.pswdField.setBorder(BorderFactory.createEmptyBorder());
        this.pswdField.addActionListener(this);
    
        return this.pswdField;
    }

    public JTextField textField (int x, int y, int width, int height, String text){

        this.textField = new JTextField(25);
        this.textField.setBounds(x, y,  width, height);
        this.textField.setFont(Static.newFont("C:\\Users\\Abdullah\\Desktop\\DB Mongo\\src\\main\\Fonts\\Montserrat-SemiBold.ttf", 22f));
        this.textField.setText(text);
        this.textField.setEditable(true);
        this.textField.setBackground(new Color(203, 203, 203));
        this.textField.setCaretColor(Color.BLACK);
        this.textField.setHorizontalAlignment(JTextField.CENTER);
        this.textField.setBorder(BorderFactory.createEmptyBorder());
        //this.textField.setBorder(BorderFactory.createLoweredBevelBorder());
        this.textField.addActionListener(this);
    
        return this.textField;
    }

    // The text Field
    public void setInvert(){
        this.textField.setCaretColor(Color.WHITE);
        this.textField.setForeground(new Color(236, 236, 236));
        this.textField.setBackground(new Color(57, 57, 57));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }

    public String getText(){
        return textField.getText();
    }
    public void setText(String text){
        this.textField.setText(text);
    }
    public void disable(){
        this.textField.setEnabled(false);
        this.textField.setDisabledTextColor(Color.gray);
    }



    public char[] getPassword(){
        return pswdField.getPassword();
    }

    public void setBorder(Color c){
        
        if (textField != null) {
            textField.setBorder(BorderFactory.createLineBorder(c));
        }
        else if(pswdField != null){
            pswdField.setBorder(BorderFactory.createLineBorder(c));
        }
    }

}
