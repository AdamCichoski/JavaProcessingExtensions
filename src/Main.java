import coloring.Color;
import display.Window;
import items.geometry.*;
import items.imaging.Image;
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
    Image <Rectangle> image;
    public static void main(String[] args) {
        String[] AppletArgs = {"Main"};
        Window.main(AppletArgs);
    }
    public void setupList(){
        Color.setWindow(this);
        tester = new Circle(this, new Coordinates(600,400), 50);
        player = new Circle(this, new Coordinates(100, 200),  50);
        rect = new Rectangle(this, new Coordinates(600, 400), 100f,100f);
        Mouse.setWindow(this);
        tester.setColor(Color.RED);
        line = new Line(this, new Coordinates(100,100), new Coordinates(200,100));
        text = new Text(this, new Coordinates(100,200), "Arial");
        text.setMessage("Butter");
        text.setFontSize(50);
        image = new Image(this, new Coordinates(50,50), "items/imaging/images/elden_ring_castle.jpg");
        image.setWidth(200);
        image.setHeight(100);
        image.setShape(new Rectangle(this, image.getCoordinates(), image.getWidth(), image.getHeight()));
    }

    public void settings(){
        size(WIDTH,HEIGHT);
    }

    public void draw(){
        background(back);
        if(Collision.collision(image.getShape(), Mouse.getCoordinates())){
            Mouse.whilePressed(()-> image.updatePosition(Mouse.getX()-(image.getWidth()/2), Mouse.getY()-(image.getHeight()/2)));
        }
        Mouse.clickEvent(()-> tester.setColor(Color.randomizeColor()), ()-> Collision.collision(tester, Mouse.getCoordinates()));
        tester.render();
        text.render();
        image.render();
    }


}