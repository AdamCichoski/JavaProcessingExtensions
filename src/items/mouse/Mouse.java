package items.mouse;

import displacement.Coordinates;
import display.Window;
import interactable.Event;

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
    public static void clickEvent(Event event){
        runThread(() -> {
            while(!pressed()){
                System.out.print("");
            }
            while(pressed()){
                System.out.print("");
            }
            event.action();
            threadRunning = false;
        });
    }

    /**
     * Performs inputted action while the mouse is clicker is being pressed
     * @param event
     */
    public static void whilePressed(Event event){
        runThread(()-> {
            while(Mouse.pressed()){
                event.action();
            }
            threadRunning = false;
        });
    }


    public static int getX(){
        return window.mouseX;
    }
    public static int getY(){
        return window.mouseY;
    }
    public static Coordinates getCoordinates(){
        return new Coordinates(window.mouseX,window.mouseY);
    }

    private static void runThread(Event event){
        if(!threadRunning){
            Task t = new Task(event);
            t.start();
            threadRunning = true;
        }
    }

    private static class Task extends Thread {
        //Event to be run
        private Event event;

        public Task(){
            this(null);
        }
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
