package items.geometry;

import coloring.Color;
import displacement.Coordinates;
import display.DisplayItem;
import display.Window;
import display.Renderable;
import physics.Physics;

import java.util.ArrayList;

public abstract class Shape extends Renderable{
    protected Coordinates coordinates = new Coordinates(0,0);

    /**
     * Constructor
     * @param window
     * @param coordinates
     */
    public Shape(Window window, Coordinates coordinates){
        super(window);
        this.window = window;
        this.coordinates = (coordinates.validate())? coordinates : this.coordinates;
    }



    /**
     * Update Position
     * @param newCoordinates
     */
    public void updatePosition(Coordinates newCoordinates){
        this.coordinates.updateCoordinates(newCoordinates);
    }

    /**
     * Update Position
     * @param x
     * @param y
     */
    public void updatePosition(float x, float y){
        this.updatePosition(new Coordinates(x,y));
    }

}
