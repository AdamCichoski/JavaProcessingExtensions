import coloring.Color;
import display.Window;
import items.geometry.*;
import items.mouse.Mouse;
import items.text.Text;
import items.text.fonts.Font;
import processing.core.PApplet;
import displacement.*;
import collisionDetection.Collision;
import processing.core.PFont;

public class Main extends Window{
    Circle tester, player;
    Rectangle rect;
    Color back = Color.DARK_GREEN;
    Line line;
    Text text;
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
        tester.setColor(Color.RED);
        line = new Line(this, new Coordinates(100,100), new Coordinates(200,100));
        text = new Text(this, new Coordinates(100,200), Font.ARIAL_NARROW);
        text.setMessage("Butter");
        text.setSize(50);
    }

    public void draw(){
        background(back);
        if(Collision.collision(tester, Mouse.getCoordinates())){
            Mouse.clickEvent(()-> tester.setColor(Color.randomizeColor()));
        }
        tester.render();
        text.render();
    }


}