package display;
import coloring.Color;
import items.text.fonts.Font;
import physics.Physics;
import processing.core.PFont;

import java.util.ArrayList;

public abstract class Renderable {
    protected Window window;
    protected Color color;
    protected Physics physics;
    protected short opacity;
    protected PFont font;
    protected float textSize = 0;
    /**
     * Constructor
     * @param window
     */
    protected Renderable(Window window){
        this.window = window;
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

    public void setFont(Font font){
        this.font = window.loadFont(font.getFont());
    }

    public void setTextSize(float textSize){
        this.textSize = textSize;
    }
}
