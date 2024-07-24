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
    public final float DEFAULT_TEXT_SIZE = 20;
    private Float size = DEFAULT_TEXT_SIZE;
    /**
     * Constructor
     * @param window
     */
    public Text(Window window, Coordinates coordinates){
        this(window, coordinates, Window.DEFAULT_FONT.toString());
    }

    /**
     * Constructor
     * @param window
     * @param coordinates
     * @param font
     */
    public Text(Window window, Coordinates coordinates, String font){
        super(window);
        this.coordinates = coordinates;
        setFont(font);
        if(window != null && font == null){
            this.font = window.createFont("Georgia", DEFAULT_TEXT_SIZE);
        }
    }

    /**
     *
     */
    public void render(){
        render(()->{
            window.textFont(font);
            window.text(message, coordinates.getX(), coordinates.getY());
        });
    }

    public void setFont(String font){
        this.font = window.createFont(font, 50);
    }

    public Float getSize(){
        return size;
    }
    public void setFontSize(float size){
        this.size = size;
    }

    public void setMessage(Object message){
        this.message  = message.toString();
    }
}
