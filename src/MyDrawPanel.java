// Author: Nathaniel Ben. Moody
// Initial Date: 8/8/2017
// Filename: MyDrawPanel.java
// Project: BeatBox


// Imports:
import java.awt.*;
import javax.swing.*;


public class MyDrawPanel extends JPanel {

    // Methods:
    public void paintComponent(Graphics g){

        // Add content to the panel.
        // Generate a random color, and use it to draw a circle.
        int red = (int) (Math.random() * 256);
        int green = (int) (Math.random() * 256);
        int blue = (int) (Math.random() * 256);
        Color randomColor = new Color(red, green, blue);
        g.setColor(randomColor);
        g.fillOval(70,70,100,100);

    }

}//end of head class
