package items.geometry;

import displacement.Coordinates;
import display.Window;

public class Circle extends Ellipse{
    /**
     * Constructor
     * @param window
     * @param coordinates
     * @param diameter
     */
    public Circle(Window window, Coordinates coordinates, float diameter){
        super(window, coordinates, diameter, diameter);
    }

    public float getRadius(){
        return getRWidth();
    }


}
