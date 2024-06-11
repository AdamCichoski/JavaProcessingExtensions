package items.geometry;

import displacement.Coordinates;
import display.Renderable;
import display.Window;
import display.DisplayItem;

public abstract class Segment extends Renderable {
    protected Coordinates p1, p2;
    public Segment(Window window, Coordinates p1, Coordinates p2){
        super(window);
        this.window = window;
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public void render(DisplayItem di){
        if(window.isValid()){
            fill();
            update();
            di.display();
        }
        window.fill(Window.DEFAULT_COLOR);
    }

    public void update(){

    }
}
