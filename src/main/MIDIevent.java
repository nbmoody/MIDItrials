package main;// Created by natha on 8/12/2017.

// Author: Nathaniel Ben. Moody
// Initial Date: 8/12/2017
// Filename: MIDIevent.java
// Project: BeatBox


// Imports:
import javax.sound.midi.*;


public class MIDIevent {

    // Methods:
    public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick){
        MidiEvent event = null;
        try{
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        }catch(Exception e){
            e.printStackTrace();
        }

        return event;
    }//end of makeEvent()

}//end of head class
