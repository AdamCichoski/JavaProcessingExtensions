package clock;

import display.Window;

public class Clock {
    private static int time;
    public static boolean ticking, threadRunning;
    private Window window;
    private TimeThread tThread = new TimeThread();

    /**
     * Constructor
     */
    public Clock(){
        this(null);
    }

    /**
     * Constructor
     * @param window
     */
    public Clock(Window window){
        this.window = window;
        time = 0;
    }

    public void tick(){
        if(!threadRunning ){
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
            while(ticking){
                try {
                    Thread.sleep(100);
                    time++;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
