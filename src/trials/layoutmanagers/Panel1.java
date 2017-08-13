package trials.layoutmanagers;// Created by natha on 8/13/2017.

// Author: Nathaniel Ben. Moody
// Initial Date: 8/13/2017
// Filename: Panel1.java
// Project: BeatBox


// Imports:
import javax.swing.*;
import java.awt.*;

public class Panel1 {

    // Methods:
    public static void main(String args[]){
        Panel1 gui = new Panel1();
        gui.go();
    }

    public void go(){
        JFrame frame = new JFrame("Testing layout managers");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.darkGray);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JButton button = new JButton("button1");
        JButton button2 = new JButton("button2");
        JButton button3 = new JButton("button3");
        panel.add(button);
        panel.add(button2);
        panel.add(button3);

        JPanel textIn = new JPanel();
        panel.setBackground(Color.darkGray);

        JTextField field = new JTextField(20);
        textIn.add(field);


        frame.getContentPane().add(BorderLayout.CENTER, textIn);
        frame.getContentPane().add(BorderLayout.EAST, panel);
        frame.setSize(600,600);
        frame.setVisible(true);

    }


    // Setters and Getters:

}//end of head class
