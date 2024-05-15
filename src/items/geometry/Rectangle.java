package items.geometry;
import displacement.Coordinates;
import display.Window;

public class Rectangle extends Shape{
    public Float width, height;

    /**
     * Constructor
     * @param width
     * @param height
     * @param coordinates
     */
    public Rectangle(Window window, Coordinates coordinates, Float width, Float height){
        super(window, coordinates);
        this.width = width;
        this.height = height;
    }
    @Override
    public void render(){
        render(()->{
            if(window.isValid()){
                window.rect(coordinates.toArray()[0], coordinates.toArray()[1], width, height);
            }
        });
    }

    public void resize(float width, float height){
        this.width = width;
        this.height = height;
    }

    public float left(){
        return coordinates.getX();
    }

    public float right(){
        return coordinates.getX() + width;
    }

    public float top(){
        return coordinates.getY();
    }

    public float bottom(){
        return coordinates.getY() + height;
    }

    /**
     *
     * @return {top left, top right, bottom left, bottom right}
     */
    public float[][] getCorners(){
        return new float[][]{{left(), top()}, {right(),top()}, {left(),bottom()}, {right(),bottom()}};
    }
}
