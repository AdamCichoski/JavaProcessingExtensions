package items.geometry;

import displacement.Coordinates;
import display.Window;

public class Line extends Segment{

    public Line(Window window, Coordinates p1, Coordinates p2){
        super(window, p1, p2);
    }


    @Override
    public void render(){
        render(()->{
            window.line(p1.getX(), p1.getY(), p2.getX(), p2.getY());
        });
    }
}
