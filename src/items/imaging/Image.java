package items.imaging;

import displacement.Coordinates;
import display.Renderable;
import display.Window;
import items.geometry.Shape;
import processing.core.PImage;

public class Image <S extends Shape> extends Renderable {
    private PImage image;
    private S shape = null;
    private float width = window.WIDTH, height = window.HEIGHT;
    public Image(Window window, Coordinates coordinates){
        super(window, coordinates);
    }
    public Image(Window window, Coordinates coordinates, String imageFile){
        super(window, coordinates);
        image = (imageFile != null) ? window.loadImage(imageFile): null;
    }

    public void render(){
        render(()->{
            window.image(image, coordinates, width, height);
            if(window.validate(shape)){
                shape.updatePosition(this.getCoordinates());
            }
        });
    }

    public void setWidth(float width){
        this.width = width;
    }

    public void setHeight(float height){
        this.height = height;
    }
    public float getWidth(){
        return width;
    }
    public float getHeight(){
        return height;
    }

    public void setShape(S shape){
        this.shape = shape;
    }
    public S getShape(){
        return shape;
    }

}
