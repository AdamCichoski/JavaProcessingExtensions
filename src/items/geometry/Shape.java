package items.geometry;

import coloring.Color;
import displacement.Coordinates;
import display.DisplayItem;
import display.Renderable;
import display.Window;
import physics.Physics;

import java.util.ArrayList;

public abstract class Shape implements Renderable {
    protected Window window;
    protected Coordinates coordinates = new Coordinates(0,0);
    private Color color = null;
    protected Physics physics;

    /**
     * Constructor
     * @param window
     * @param coordinates
     */
    public Shape(Window window, Coordinates coordinates){
        this.window = window;
        this.coordinates = (coordinates.validate())? coordinates : this.coordinates;
    }
    public abstract void render();

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

    /**
     * Render method for an array of shapes
     * @param s
     */
    public static <S extends Shape> void renderArray(S[] s){
        for(int i=0; i<s.length; i++){
            s[i].render();
        }
    }

    public static <S extends Shape> void renderArray(ArrayList<S> arr){
        for(int i=0; i<arr.size(); i++){
            arr.get(i).render();
        }
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

    public void addPhysics(){
        this.physics = new Physics();
    }
}
