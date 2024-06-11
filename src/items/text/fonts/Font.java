package items.text.fonts;
import display.Window;
import processing.core.PFont;
public enum Font {
    ARIAL("fontFiles\\arial-font\\arial.ttf"),
    ARIAL_NARROW("fontFiles\\arial-font\\Arialn.ttf"),
    ARIAL_THICK("ArialTh.ttf"),
    TIMES_NEW_ROMAN("TimesNewRoman.ttf"),
    VEGAN("Vegan.ttf");

    private final String font;
    Font(String s){
        font = s;
    }

    public String getFont(){
        return this.font;
    }
}
