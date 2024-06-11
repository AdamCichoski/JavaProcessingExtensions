package items.geometry;

import coloring.Color;
import displacement.Coordinates;
import display.DisplayItem;
import display.Window;
import display.Renderable;
import physics.Physics;

import java.util.ArrayList;

public abstract class Shape extends Renderable{
    /**
     * Constructor
     * @param window
     * @param coordinates
     */
    public Shape(Window window, Coordinates coordinates){
        super(window);
        this.window = window;
        this.coordinates = (window.validate(coordinates))? coordinates : this.coordinates;
    }



}
