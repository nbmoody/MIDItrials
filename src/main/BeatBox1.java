package main;// Created by natha on 8/13/2017.

// Author: Nathaniel Ben. Moody
// Initial Date: 8/13/2017
// Filename: BeatBox1.java
// Project: BeatBox


// Imports:
import java.awt.*;
import javax.swing.*;
import javax.sound.midi.*;
import java.util.*;
import java.awt.event.*;

public class BeatBox1 {

    // Attributes:
    JPanel mainPanel;
    ArrayList<JCheckBox> checkboxList;
    Sequencer sequencer;
    Sequence sequence;
    Track track;
    JFrame theFrame;

    String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustic Snare", "Crash Cymbal",
    "Hand Clap", "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga", "Cowbell", "Vibraslap", "Low-mid Tom",
    "High Agogo", "Open Hi Conga"};
    int[] instruments = {35,42,46,38,49,39,50,60,70,72,64,56,58,47,67,63};

    // Methods:
    public static void main(String[] args){
        new BeatBox1().buildGUI();
    }

    public void buildGUI(){
        theFrame = new JFrame("Cyber BeatBox");
        theFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        BorderLayout layout = new BorderLayout();
        JPanel background = new JPanel(layout);
        background.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        checkboxList = new ArrayList<JCheckBox>();
        Box buttonBox = new Box(BoxLayout.Y_AXIS);

        JButton start = new JButton("Start");
        start.addActionListener(new MyStartListener());
        buttonBox.add(start);

        JButton stop = new JButton("Stop");
        stop.addActionListener(new MyStopListener());
        buttonBox.add(stop);

        JButton upTempo = new JButton("Tempo Up");
        upTempo.addActionListener(new MyUpTempoListener());
        buttonBox.add(upTempo);

        JButton downTempo = new JButton("Tempo Down");
        downTempo.addActionListener(new MyDownTempoListener());
        buttonBox.add(downTempo);

        Box nameBox = new Box(BoxLayout.Y_AXIS);
        for(String name: instrumentNames){
            nameBox.add(new Label(name));
        }

        background.add(BorderLayout.EAST, buttonBox);
        background.add(BorderLayout.WEST, nameBox);

        theFrame.getContentPane().add(background);

        GridLayout grid = new GridLayout(16,16);
        grid.setVgap(1);
        grid.setHgap(2);
        mainPanel = new JPanel(grid);
        background.add(BorderLayout.CENTER, mainPanel);

        for(int i=0; i<256; i++){
            JCheckBox c = new JCheckBox();
            c.setSelected(false);
            checkboxList.add(c);
            mainPanel.add(c);
        }

        setUpMidi();

        theFrame.setBounds(50,50,300,300);
        theFrame.pack();
        theFrame.setVisible(true);
    }//end go()

    public void setUpMidi(){
        try{
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequence = new Sequence(Sequence.PPQ, 4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(120);
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }//end setUpMidi()

    public void buildTrackAndStart(){
        int[] trackList = null;

        sequence.deleteTrack(track);
        track = sequence.createTrack();

        for(int i=0; i<16; i++){
            trackList = new int[16];

            int key = instruments[i];

            for(int j =0; j<16; j++){
                JCheckBox jc = checkboxList.get(j+16*i);
                if(jc.isSelected()){
                    trackList[j] = key;
                } else{
                    trackList[j] = 0;
                }
            }

            makeTracks(trackList);
            track.add(MIDIevent.makeEvent(176,1,127,0,16));
        }

        track.add(MIDIevent.makeEvent(192,9,1,0,15));
        try{
            sequencer.setSequence(sequence);
            sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
            sequencer.start();
            sequencer.setTempoInBPM(120);
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }//end buildTrackAndStart()

    public void makeTracks(int[] list){
        for(int i=0; i<16; i++){
            int key = list[i];

            if(key!=0){
                track.add(MIDIevent.makeEvent(144,9,key,100,i));
                track.add(MIDIevent.makeEvent(128,9,key,100,i+1));
            }
        }
    }

    // Inner classes and listeners:
    public class MyStartListener implements ActionListener{
        public void actionPerformed(ActionEvent a){
            buildTrackAndStart();
        }
    }

    public class MyStopListener implements ActionListener{
        public void actionPerformed(ActionEvent a){
            sequencer.stop();
        }
    }

    public class MyUpTempoListener implements ActionListener{
        public void actionPerformed(ActionEvent a){
            float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor((float)(tempoFactor * 1.03));
        }
    }

    public class MyDownTempoListener implements ActionListener{
        public void actionPerformed(ActionEvent a){
            float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor((float)(tempoFactor * .97));
        }
    }
    //End inner classes.

}//end of head class
