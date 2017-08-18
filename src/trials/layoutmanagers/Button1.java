package trials.layoutmanagers;// Created by natha on 8/13/2017.

// Author: Nathaniel Ben. Moody
// Initial Date: 8/13/2017
// Filename: Button1.java
// Project: BeatBox


// Imports:
import javax.swing.*;
import java.awt.*;

public class Button1 {

    // Methods:
    public static void main (String args[]){
        Button1 gui = new Button1();
        gui.go();
    }

    public void go(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton button = new JButton("There is no spoon...");
        Font bigFont = new Font("serif", Font.BOLD, 28);
        button.setFont(bigFont);

        frame.getContentPane().add(BorderLayout.NORTH, button);
        frame.setSize(200,200);
        frame.setVisible(true);
    }

}//end of head class
