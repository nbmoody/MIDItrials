package trials;// Author: Nathaniel Ben. Moody
// Initial Date: 8/10/2017
// Filename: SimpleCircleAnimation.java
// Project: BeatBox


// Imports:
import javax.swing.*;
import java.awt.*;


public class SimpleCircleAnimation {

    // Attributes:
    int x = 70;
    int y = 70;


    // Methods:
    public static void main(String args[]){
        SimpleCircleAnimation gui = new SimpleCircleAnimation();
        gui.go();
    }//end of main()

    public void go() {

        // Make a new JFrame.
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        MyDrawPanel2 drawPanel = new MyDrawPanel2();

        frame.getContentPane().add(drawPanel);
        frame.setVisible(true);

        // Animate MyDrawPanel by updating the head class x/y that it uses.
        int speed = 25;
        for(int i = 0; i < 6; i++){
            for (int x = 0; x < 130; x++) {
                this.x++;
                this.y++;
                drawPanel.repaint();

                // Slow down the animation a bit.
                try {
                    Thread.sleep(speed);
                } catch (Exception ex) {
                }
            }
            for (int y = 0; y < 130; y++) {
                this.x++;
                this.y--;
                drawPanel.repaint();

                // Slow down the animation a bit.
                try {
                    Thread.sleep(speed);
                } catch (Exception ex) {
                }
            }
            for (int z = 0; z < 130; z++) {
                this.x--;
                drawPanel.repaint();

                // Slow down the animation a bit.
                try {
                    Thread.sleep(speed);
                } catch (Exception ex) {
                }
            }
        }

    }//end of go()

    class MyDrawPanel2 extends JPanel{
        public void paintComponent(Graphics g){
            g.setColor(Color.white);
            g.fillRect(0,0, this.getWidth(), this.getHeight());

            g.setColor(Color.green);
            g.fillOval(x,y,40,40);
        }
    }//end of MyDrawPanel inner class

}//end of head class
