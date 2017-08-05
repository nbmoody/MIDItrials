
import javax.sound.midi.*;

public class SimpleMusicApp {

    public static void main(String args[]){
        SimpleMusicApp app = new SimpleMusicApp();
        app.play();


    }//end main()

    public void play(){

        try{
            //Create and open a new player.
            Sequencer player = MidiSystem.getSequencer();
            player.open();

            //Create a new sequence and use it to create a new track.
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            //Add some MidiEvents to the track.
            ShortMessage a = new ShortMessage();
            a.setMessage(144, 1, 44, 100);
            MidiEvent noteA = new MidiEvent(a, 2);
            track.add(noteA);

            ShortMessage b = new ShortMessage();
            b.setMessage(144, 2, 46, 100);
            MidiEvent noteB = new MidiEvent(b, 6);
            track.add(noteB);

            ShortMessage c = new ShortMessage();
            c.setMessage(144,3,48,100);
            MidiEvent noteC = new MidiEvent(c, 10);
            track.add(noteC);

            ShortMessage d = new ShortMessage();
            d.setMessage(144,3,50,100);
            MidiEvent noteD = new MidiEvent(d, 10);
            track.add(noteD);

            ShortMessage e = new ShortMessage();
            e.setMessage(144,3,24,100);
            MidiEvent noteE = new MidiEvent(e, 18);
            track.add(noteE);

            //Pass the sequence (with its track?) to the sequencer, and use the sequencer to play it.
            player.setSequence(seq);
            player.start(); //TODO: This is not terminating after playing.

        } catch(Exception ex){
            ex.printStackTrace();
        }
        return;
    }//end play()
}
