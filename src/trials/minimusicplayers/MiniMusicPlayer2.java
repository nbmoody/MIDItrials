package trials.minimusicplayers;// Created by natha on 8/12/2017.

// Author: Nathaniel Ben. Moody
// Initial Date: 8/12/2017
// Filename: MiniMusicPlayer2.java
// Project: BeatBox


// Imports:
import javax.sound.midi.*;
import main.MIDIevent;


public class MiniMusicPlayer2 implements ControllerEventListener{

    // Methods:
    public static void main(String args[]){
        MiniMusicPlayer2 mini = new MiniMusicPlayer2();
        mini.go();
    }

    public void go() {
        try{
            //Create a sequencer and open it:
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            // This interger array allows me to collect the event #'s I want to listen to:
            int[] eventsIWant = {127}; // I only want event #127
            sequencer.addControllerEventListener(this, eventsIWant);

            // Create a new sequence and use it to make a new track:
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            //Add progressive MidiEvents to the track:
            for(int i = 5; i < 60; i += 4){

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

    @Override
    public void controlChange(ShortMessage event){
        //Do something really simple when the event is fired:
        System.out.println("la");
    }

}//end of head class
