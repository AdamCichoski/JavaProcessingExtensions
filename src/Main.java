import Coloring.Color;
import Display.Window;
import Items.Geometry.*;
import Items.Mouse.Mouse;
import processing.core.PApplet;
import Displacement.*;

public class Main extends Window{
    Circle tester, player;
    Rectangle rect;
    Color back = Color.BLACK;
    public static void main(String[] args) {
        String[] AppletArgs = {"Main"};
        PApplet.main(AppletArgs);
    }

    public void setup(){}

    public void settings(){
        size(WIDTH,HEIGHT);
        Color.setWindow(this);
        tester = new Circle(this, new Coordinates(600,400), 50);
        player = new Circle(this, new Coordinates(100, 200),  50);
        rect = new Rectangle(this, new Coordinates(600, 400), 100f,100f);
        Mouse.setWindow(this);
    }

    public void draw(){
        background(back);
        Mouse.waitRelease(()-> back = (back == Color.RED)? Color.BLACK:Color.RED);
    }



}