package clock;

import displacement.Coordinates;
import display.Window;
import items.text.Text;

public class Clock {
    private static int time;
    public static boolean ticking, threadRunning;
    private Window window;
    private TimeThread tThread = new TimeThread();
    private Text printableTime;

    /**
     * Constructor
     */
    public Clock(){
        this(null, (Text)null);
    }
    /**
     * Constructor
     * @param window
     */
    public Clock(Window window){
        this(window, (Text)null);
    }
    public Clock(Window window, Coordinates coordinates){
        this(window, new Text(window, coordinates));
    }
    public Clock(Window window, Text printableTime){
        this.window = window;
        time = 0;
        this.printableTime = printableTime;
    }

    public Float getSize(){
        return (printableTime != null) ? printableTime.getSize() : null;
    }


    public String getTime(){
        return ((time - (time % 60)) / 60) + " : " + ((time% 60 < 10)? "0"+ time%60 : time%60);
    }

    public void render(){
        printableTime.setMessage(getTime());
        printableTime.render();
    }

    public void tick(){
        if(!threadRunning ){
            play();
            tThread.start();
        }
    }

    public void pause(){
        ticking = false;
    }

    public void play(){
        ticking = true;
    }

    public void reset(){
        time =0;
    }

    /**
     * Private thread class meant for the tick method, counting the time passed
     */
    private class TimeThread extends Thread{

        @Override
        public void run(){
            int  counter =0;
            while(ticking){
                try {
                    Thread.sleep(100);
                    counter++;
                    if(counter == 10){
                        time++;
                        counter =0;
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
