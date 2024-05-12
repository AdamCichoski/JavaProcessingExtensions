package Coloring;

import Display.Window;
import processing.core.PApplet;

public enum Color {
    WHITE(new short[]{255,255,255}),
    BLACK(new short[]{0,0,0}),
    RED(new short[]{255,0,0}),
    YELLOW(new short[]{255,255,0}),
    BLUE(new short[]{0,0,255}),
    GREEN(new short[]{0,255,0});

    public final short COLOR[];
    static Window window;
    Color(short COLOR[]){
        this.COLOR = COLOR;
    }

    /**
     * Set the static window to be used by the color enum
     * @param newWindow
     */
    public static void setWindow(Window newWindow){
        window = newWindow;
    }

}
