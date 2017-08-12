package trials.minimusicplayers;// Created by natha on 8/12/2017.

// Author: Nathaniel Ben. Moody
// Initial Date: 8/12/2017
// Filename: MiniMusicPlayer2.java
// Project: BeatBox
// Notes: This is still missing some encapsulation, but works as a trial-run.


// Imports:

import main.MIDIevent;
import javax.sound.midi.*;
import javax.swing.*;


public class MiniMusicPlayer3 {

    //Attributes:
    static JFrame frame = new JFrame("Rectangles with Music!");
    static MiniMusicGUI m1;

    // Methods:
    public static void main(String args[]){
        MiniMusicPlayer3 mini = new MiniMusicPlayer3();
        mini.go();
    }

    public void go() {

        setupGUI();

        try{
            //Create a sequencer and open it:
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            // This interger array allows me to collect the event #'s I want to listen to:
            int[] eventsIWant = {127}; // I only want event #127

            // Register the custom DrawPanel, MiniMusicGUI, with the sequencer,
            // tuned to events with #127 (all the MIDIevent ControllerEvents
            // created in the loop below).
            sequencer.addControllerEventListener(m1, eventsIWant);

            // Create a new sequence and use it to make a new track:
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            /* Add progressive MidiEvents to the track
            note-on(144),
            ControllerEvent(176),
            note-off(128) */
            for(int i = 5; i < 60; i += 2){

                // Add a note-on, ControllerEvent, and note-off MidiEvent to the track:
                track.add(MIDIevent.makeEvent(144,1, i,100, i));
                track.add(MIDIevent.makeEvent(176,1,127,0, i));
                track.add(MIDIevent.makeEvent(128,1,i,100,i+2));
            }

            //Pass the sequence with its track to the sequencer, and start it:
            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);
            sequencer.start();
        }catch(Exception ex){ex.printStackTrace();}
    }//end of go()

    public void setupGUI(){

        // Create a new instance of the MiniMusicGUI and assign it to m1.
        // Then setup the JFrame attribute, frame. This creates/adds the custom draw-panel
        // to the JFrame's content pane. Since it IS-A ControllerEventListener, registered
        // with the sequencer, it will pick up any ControllerEvents fired by the sequencer.
        m1 = new MiniMusicGUI();
        frame.setContentPane(m1);
        frame.setBounds(30,30,1000,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }//close setupGUI()

}//end of head class
