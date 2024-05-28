package items.text;


import displacement.Coordinates;
import display.Renderable;
import display.Window;
import items.text.fonts.Font;
import processing.core.PFont;

public class Text extends Renderable {
    private PFont font;
    private Coordinates coordinates;
    private String message = "";
    /**
     * Constructor
     * @param window
     */
    public Text(Window window, Coordinates coordinates){
        this(window, coordinates, Font.ARIAL);
    }

    /**
     * Constructor
     * @param window
     * @param coordinates
     * @param font
     */
    public Text(Window window, Coordinates coordinates, Font font){
        super(window);
        this.coordinates = coordinates;
//        this.font = window.loadFont(font);
    }

    /**
     *
     */
    public void render(){
        render(()->{
            window.text(message, coordinates.getX(), coordinates.getY());
        });
    }

    public void setMessage(Object message){
        this.message  = message.toString();
    }
}
