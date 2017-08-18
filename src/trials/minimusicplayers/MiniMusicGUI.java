package trials.minimusicplayers;// Created by natha on 8/12/2017.

// Author: Nathaniel Ben. Moody
// Initial Date: 8/12/2017
// Filename: MiniMusicGUI.java
// Project: BeatBox


// Imports:
import java.awt.*;
import javax.swing.*;
import javax.sound.midi.*;


public class MiniMusicGUI extends JPanel implements ControllerEventListener {

    // Attributes:
    boolean msg = false;


    // Methods:
    public void controlChange(ShortMessage event){
        this.msg = true;
        this.repaint();
    }//end controlChange()

    @Override
    public void paintComponent(Graphics g){
        if(msg){

            // Downcast the Graphics object:
            Graphics2D g2 = (Graphics2D) g;

            // Generate a random color:
            int red = (int)(Math.random()*256);
            int green = (int)(Math.random()*256);
            int blue = (int)(Math.random()*256);
            g.setColor(new Color(red,green,blue));

            // Generate a random size and coordinates for a rectangle:
            int height = (int)((Math.random()*120) + 10);
            int width = (int)((Math.random()*120) + 10);
            int x = (int)((Math.random()*700)+10);
            int y = (int)((Math.random()*700)+10);
            g.fillRect(x,y,width,height);

            // Reset the flag so new rectangles are only drawn when the event fires:
            this.msg=false;
        }//close if

    }//end paintComponent()

}//end of head class
