package trials.minimusicplayers;// Created by natha on 8/12/2017.

// Author: Nathaniel Ben. Moody
// Initial Date: 8/12/2017
// Filename: MiniMusicPlayer1.java
// Project: BeatBox


// Imports:
import javax.sound.midi.*;
import main.MIDIevent;


public class MiniMusicPlayer1 {

    // Methods:
    public static void main(String args[]){
        try{
            // Create a new sequencer, sequence, and a track for the sequence:
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            Sequence seq = new Sequence(Sequence.PPQ,4);
            Track track = seq.createTrack();

            // Add MidiEvents to the sequence's track using MIDIevent.makeEvent():
            for(int i = 5; i < 61; i+= 4){
                track.add(MIDIevent.makeEvent(144,1,i,100,i));
                track.add(MIDIevent.makeEvent(128,1,i,100,i+2));
            }

            // Pass the sequence to the sequencer, set the tempo, then start the sequencer:
            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);
            sequencer.start();
        } catch(Exception ex){ex.printStackTrace();}
    }//end of main()

}//end of head class
