package items.geometry;
import displacement.Coordinates;
import display.Window;

public class Ellipse extends Shape{
    protected float width,height;

    /**
     * Constructor
     * @param width
     * @param height
     * @param coordinates
     */
    public Ellipse(Window window, Coordinates coordinates, float width, float height) {
        super(window, coordinates);
        this.width = width;
        this.height = height;
    }

    /**
     *
     */
    @Override
    public void render(){
        render(()->{
            window.ellipse(coordinates.toArray()[0], coordinates.toArray()[1], width, height);
        });
    }

    public float getX(){
        return coordinates.getX();
    }

    public float getY(){
        return coordinates.getY();
    }

    public float[] top(){
        return new float[]{getX(), getY()+(height)/2f};
    }

    public float[] bottom(){
        return new float[]{getX(), getY()-(height)/2f};
    }

    public float[] left(){
        return new float[]{getX()+(width)/2f, getY()};
    }
    public float[] right(){
        return new float[]{getX()-(width)/2f, getY()};
    }
    public float getWidth(){
        return width;
    }

    public float getHeight(){
        return height;
    }

    public float getRWidth(){
        return getWidth()/2;
    }

    public float getRHeight(){
        return getHeight()/2;
    }

}
