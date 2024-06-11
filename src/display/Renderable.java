package display;
import coloring.Color;
import displacement.Coordinates;
import items.text.fonts.Font;
import physics.Physics;
import processing.core.PFont;

import java.util.ArrayList;

public abstract class Renderable {
    protected Window window;
    protected Coordinates coordinates = new Coordinates(0,0);
    protected Color color;
    protected Physics physics;
    protected short opacity;
    /**
     * Constructor
     * @param window
     */
    protected Renderable(Window window){
        this(window, null);
    }
    protected Renderable(Window window, Coordinates coordinates){
        this.window = window;
        this.coordinates = coordinates;
    }
    public abstract void render();
    public void render(DisplayItem di){
        if(window.isValid()){
            fill();
            updatePhysics();
            di.display();
        }
        resetScreenChanges();
    }

    private void resetScreenChanges(){
        window.fill(Window.DEFAULT_COLOR);
        window.textFont(Window.DEFAULT_FONT);
    }
    public void fill(){
        window.fill(color);
    }

    /**
     * Sets the color for the renderable item
     * @param color
     */
    public void setColor(Color color){
        this.color = color;
    }

    /**
     * Removes the renderable item color
     */
    public void removeColor(){
        this.color = null;
    }

    /**
     * Render method for an array of shapes
     * @param r
     */
    public static <R extends Renderable> void renderArray(R[] r){
        for(int i=0; i<r.length; i++){
            r[i].render();
        }
    }

    /**
     * Render mehtod for an ArrayList of renderable items
     * @param arr
     * @param <R> is a generic renderable object
     */
    public static <R extends Renderable> void renderArray(ArrayList<R> arr){
        for(int i=0; i<arr.size(); i++){
            arr.get(i).render();
        }
    }

    /**
     *
     */
    private void updatePhysics(){
        if(physics != null){

        }
    }

    /**
     * Adds physics to the object, altering the way the Shape interacts with its environment
     */
    public void addPhysics(){
        this.physics = new Physics();
    }

    /**
     * Method to determine if the Shape object has physics applied to it
     * @return
     */
    public boolean hasPhysics(){
        return this.physics != null;
    }

    public void setOpacity(short opacity){
        this.opacity = opacity;
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
        float newX = (x>=0 && x<=window.WIDTH)?x: coordinates.getX();
        float newY = (y>=0 && y<= window.HEIGHT)? y: coordinates.getY();
        this.updatePosition(new Coordinates(newX, newY));
    }

    public Coordinates getCoordinates(){
        return coordinates;
    }
}
