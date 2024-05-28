package display;
import coloring.Color;
import displacement.Coordinates;
import items.text.fonts.Font;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class Window extends PApplet{
    public static final int WIDTH = 1200;
    public static final int HEIGHT = 800;
    public static final Color DEFAULT_COLOR = Color.WHITE;
    public boolean isValid(){
        return this!=null;
    }
    public final PFont STANDARD_FONT = loadFont(Font.ARIAL);

    /**
     * Adapted fill method to add ease of use, only requiring the color to fill from Color enum
     * @param color
     */
    public void fill(Color color){
        if(color != null ){
            fill(color.COLOR[0], color.COLOR[1], color.COLOR[2]);
        }
    }

    public void fill(short[] rgb){
        if(rgb.length != 3){
            System.out.println("Invalid rgb length for fill color");
            return;
        }
        fill(rgb[0],rgb[1],rgb[2]);
    }

    public void background(Color color){
        background(color.COLOR[0],color.COLOR[1],color.COLOR[2]);
    }

    public void image(PImage image, Coordinates coordinates){
        float[] c = coordinates.toArray();
        image(image, c[0], c[1]);
    }

    public PFont loadFont(Font font){
        return loadFont(font.getFont());
    }

}
