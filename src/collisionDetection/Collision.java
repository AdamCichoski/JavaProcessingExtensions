package collisionDetection;

import items.geometry.Ellipse;
import items.geometry.Rectangle;
import displacement.Coordinates;
import items.mouse.Mouse;

import java.util.ArrayList;

public abstract class Collision {
    /**
     * Rectangle collision with two points
     *
     * @param rect
     * @param x
     * @param y
     * @param <R>
     * @return true if collision found
     */
    public static <R extends Rectangle> boolean collision(R rect, float x, float y) {
        return rect.left() <= x && rect.right() >= x && rect.top() <= y && rect.bottom() >= y;
    }

    /**
     * @param rect
     * @param xy
     * @param <R>
     * @return
     */
    public static <R extends Rectangle> boolean collision(R rect, float[] xy) {
        if (xy.length != 2) {
            System.out.println("Invalid length for collision: Rectangle to float[] xy");
            return false;
        }
        return collision(rect, xy[0], xy[1]);
    }

    /**
     * Rectangle collision with coordinates
     *
     * @param rect
     * @param coordinates
     * @param <R>
     * @return true if collision found
     */
    public static <R extends Rectangle> boolean collision(R rect, Coordinates coordinates) {
        float[] c = coordinates.toArray();
        return rect.left() <= c[0] && rect.right() >= c[0] && rect.top() <= c[1] && rect.bottom() >= c[1];
    }

    /**
     * Ellipse collision with two points
     *
     * @param ellipse
     * @param x
     * @param y
     * @param <E>
     * @return true if collision found
     */
    public static <E extends Ellipse> boolean collision(E ellipse, float x, float y) {
        float a = Math.abs(ellipse.getX() - x);
        float b = Math.abs(ellipse.getY() - y);
        float c = (float) Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        return c <= ellipse.getRWidth() && c <= ellipse.getRHeight();
    }

    /**
     * @param ellipse
     * @param xy
     * @param <E>
     * @return
     */
    public static <E extends Ellipse> boolean collision(E ellipse, float[] xy) {
        if (xy.length != 2) {
            System.out.println("Invalid length for collision: Ellipse to float[] xy");
            return false;
        }
        return collision(ellipse, xy[0], xy[1]);
    }

    /**
     * Ellipse collision with another ellipse
     *
     * @param e1
     * @param e2
     * @param <E>
     * @return true if collision found
     */
    public static <E extends Ellipse> boolean collision(E e1, E e2) {
        float a = Math.abs(e1.getX() - e2.getX());
        float b = Math.abs(e1.getY() - e2.getY());
        float c = (float) Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        return c <= e1.getWidth() && c <= e1.getHeight();
    }

    /**
     * Ellipse collision with Coordinates
     *
     * @param ellipse
     * @param coordinates
     * @param <E>
     * @return
     */
    public static <E extends Ellipse> boolean collision(E ellipse, Coordinates coordinates) {
        float[] c = coordinates.toArray();
        return Math.abs(ellipse.getX() - c[0]) <= ellipse.getRWidth() && Math.abs(ellipse.getY() - c[1]) <= ellipse.getRHeight();
    }

    /**
     * @param ellipse
     * @param rect
     * @param <E>
     * @param <R>
     * @return
     */
    public static <E extends Ellipse, R extends Rectangle> boolean collision(E ellipse, R rect) {
        float[][] r = rect.getCorners();
        for (byte i = 0; i < r.length; i++) {
            if (collision(ellipse, r[i])) {
                return true;
            }
        }
        return collision(rect, ellipse.top()) || collision(rect, ellipse.bottom()) || collision(rect, ellipse.left()) || collision(rect, ellipse.right());
    }

    /**
     * @param rect
     * @param ellipse
     * @param <E>
     * @param <R>
     * @return
     */
    public static <E extends Ellipse, R extends Rectangle> boolean collision(R rect, E ellipse) {
        return collision(ellipse, rect);
    }

    /**
     *
     */
    public static <R extends Rectangle> boolean collision(R[] r, Coordinates c) {
        for (int i = 0; i < r.length; i++) {
            if(collision(r[i], c)){
                return true;
            }
        }
        return false;
    }


    /**
     *
     */
    public static <E extends Ellipse> boolean collision(E[] e, Coordinates c) {
        for (int i = 0; i < e.length; i++) {
            if(collision(e[i], c)){
                return true;
            }
        }
        return false;
    }
    /**
     *
     */
    public static <E extends Ellipse> boolean collision(ArrayList<E> e,  Coordinates c) {
        for (int i = 0; i < e.size(); i++) {
            if(collision(e.get(i), c)){
                return true;
            }
        }
        return false;
    }

    /************************************************************************************************
     * Methods to return elements in an array or an ArrayList that have been selected
     ************************************************************************************************/

    /**
     *
     * @param e
     * @param c
     * @return
     * @param <E>
     */
    public static <E extends Ellipse> ArrayList<E> selectedArray(ArrayList<E> e, Coordinates c){
        ArrayList<E> selected = new ArrayList<>();
        for(int i=0; i<e.size(); i++){
            if(collision(e.get(i), c)){
                selected.add(e.get(i));
            }
        }
        return selected;
    }

    public static <E extends Ellipse> E selectedItem(ArrayList<E> e, Coordinates c){
        E element = null;
        for(int i=0; i<e.size(); i++){
            if(collision(e.get(i), c)){
                element = e.get(i);
            }
        }
        return element;
    }

    public static <E extends Ellipse> boolean isSelected(E e, Coordinates c){
        return collision(e, c) && Mouse.pressed();
    }
}
