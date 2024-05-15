import coloring.Color;
import display.Window;
import items.geometry.*;
import items.mouse.Mouse;
import processing.core.PApplet;
import displacement.*;
import collisionDetection.Collision;

import java.util.ArrayList;

public class Main extends Window{
    Circle tester, player;
    Rectangle rect;
    Color back = Color.BLACK;
    ArrayList<Circle> circles = new ArrayList<>();
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
        if(Collision.collision(tester, Mouse.getCoordinates())){
            Mouse.whilePressed(() -> tester.updatePosition(Mouse.getX(), Mouse.getY()));
        }
        tester.render();

    }


}