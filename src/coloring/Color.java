package coloring;

import display.Window;

public enum Color {
    WHITE(new short[]{255,255,255}),
    BLACK(new short[]{0,0,0}),
    RED(new short[]{255,0,0}),
    YELLOW(new short[]{255,255,0}),
    BLUE(new short[]{0,0,255}),
    GREEN(new short[]{0,255,0}),
    DARK_GREEN(new short[]{0,43,13});

    public final short COLOR[];
    static Window window;
    private static final short TOTAL = 7;
    Color(short COLOR[]){
        this.COLOR = COLOR;
    }

    /**
     * Set the static window to be used by the color enum
     * @param newWindow
     */
    public static void setWindow(Window newWindow){
        window = newWindow;
    }

    public static Color randomizeColor(){
        short rand = (short)(Math.random()*TOTAL);
        switch(rand){
            case 0: return WHITE;
            case 1: return BLACK;
            case 2: return RED;
            case 3: return YELLOW;
            case 4: return BLUE;
            case 5: return GREEN;
            case 6: return DARK_GREEN;
        }
        return null;
    }
}
