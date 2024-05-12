package Items.Mouse;

import Display.Window;
import Interactable.Event;

public class Mouse {
    private static Window window;
    private static byte status;
    private static final byte PRESSED = 1;
    private static final byte RELEASED = 0;
    private static boolean threadRunning = false;
    /**
     *
     * @param win
     */
    public static void setWindow(Window win){
        window = win;
    }
    /**
     *
     * @return
     */
    public static boolean pressed(){
        return window.mousePressed;
    }

    public static boolean notPressed() {
        return !pressed();
    }

    /**
     * Function to wait for the press and release of the mouse to perfomr an action
     * @param event is the event that will be performed upon the release of the mouse button
     */
    public static void waitRelease(Event event){
        if(!threadRunning){
            Task task = new Task(() -> {
                while(!pressed()){
                    System.out.print("");
                }
                while(pressed()){
                    System.out.print("");
                }
                event.action();
                threadRunning = false;
            });
            task.start();
            threadRunning = true;
        }
    }

    private static class Task extends Thread {
        //Event to be run
        private Event event;

        /**
         * Constructor
         *
         * @param event
         */
        public Task(Event event) {
            System.out.println("Thread running");
            this.event = event;
        }

        /**
         *
         */
        @Override
        public void run() {
            event.action();
        }

    }

}
