package Items.Geometry;

import Coloring.Color;
import Displacement.Coordinates;
import Display.DisplayItem;
import Display.Renderable;
import Display.Window;

public abstract class Shape implements Renderable {
    protected Window window;
    protected Coordinates coordinates = new Coordinates(0,0);
    private Color color = null;

    /**
     * Constructor
     * @param window
     * @param coordinates
     */
    public Shape(Window window, Coordinates coordinates){
        this.window = window;
        this.coordinates = (coordinates.validate())? coordinates : this.coordinates;
    }

    /**
     * Abstract method to render a shape
     */
    public void render(DisplayItem di){
        if(window.isValid()){
            fill();
            di.display();
        }
        window.fill(Window.DEFAULT_COLOR);
    }

    protected void fill(){
        window.fill(color);
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

    public void setColor(Color color){
        this.color = color;
    }

    public void removeColor(){
        this.color = null;
    }

}
