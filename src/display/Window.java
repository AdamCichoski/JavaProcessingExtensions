package display;
import coloring.Color;
import displacement.Coordinates;
import processing.core.PApplet;
import processing.core.PImage;

public class Window extends PApplet{
    public final int WIDTH = 1200;
    public final int HEIGHT = 800;
    public static final Color DEFAULT_COLOR = Color.WHITE;

    public boolean isValid(){
        return this!=null;
    }

    /**
     * Adapted fill method to add ease of use, only requiring the color to fill from Color enum
     * @param color
     */
    public void fill(Color color){
        if(color != null ){
            fill(color.COLOR[0], color.COLOR[1], color.COLOR[2]);
        }
    }

    public void background(Color color){
        background(color.COLOR[0],color.COLOR[1],color.COLOR[2]);
    }

    public void image(PImage image, Coordinates coordinates){
        float[] c = coordinates.toArray();
        image(image, c[0], c[1]);
    }
}
