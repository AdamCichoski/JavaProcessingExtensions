package Interactable;
import Display.Window;
import Displacement.Coordinates;
import Items.Geometry.Rectangle;
import processing.core.PImage;

public abstract class Button extends Rectangle implements Event {
    PImage image;

    public Button(Window window, Coordinates coordinates, Float width, Float height){
        this(window, coordinates,width, height, null);
    }
    public Button(Window window, Coordinates coordinates, String imageFile){
        this(window, coordinates, null, null, imageFile);
    }
    public Button(Window window, Coordinates coordinates, Float width, Float height, String imageFile){
        super(window, coordinates, width, height);
        image = getPImage(imageFile);
    }

    /**
     *
     */
    @Override
    public void render(){
        render(() -> {
            if(validImage()){
                window.image(image, coordinates);
            }
        });
    }

    private PImage getPImage(String imageFile){
        return (imageFile != null)? window.loadImage(imageFile): null;
    }

    private boolean validImage(){
        return image != null;
    }
}
