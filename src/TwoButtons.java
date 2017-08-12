// Author: Nathaniel Ben. Moody
// Initial Date: 8/9/2017
// Filename: TwoButtons.java
// Project: BeatBox


// Imports:
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class TwoButtons {

    // Attributes:
    JFrame frame;
    JLabel label;


    // Methods:
    public static void main(String argts[]){
        TwoButtons gui = new TwoButtons();
        gui.go();
    } // end main()


    public void go(){

        // Create and setup a JFrame:
        this.frame = new JFrame();
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(500,500);

        // Create two new buttons, and register an instance of the appropriate ActionListener object:
        JButton labelButton = new JButton("Change Label");
        labelButton.addActionListener(new LabelListener());
        JButton colorButton = new JButton("Change Circle");
        colorButton.addActionListener(new ColorListener());

        // Instantiate a JLabel object for the label ref var, then create a custom widget:
        this.label = new JLabel("I'm a label.");
        MyDrawPanel drawPanel = new MyDrawPanel();

        // Add all widgets to the JFrame's content pane:
        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.NORTH, labelButton);
        frame.getContentPane().add(BorderLayout.WEST, this.label);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);

        frame.setVisible(true);
    } // end go()

    // Inner Listener Classes:
    class LabelListener implements ActionListener {
        public void actionPerformed(ActionEvent event){
            label.setText("That was totally wicked!");
        }
    } //end LabelListener()

    class ColorListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            frame.repaint();
        }
    } //end ColorListener()
}//end of head class
