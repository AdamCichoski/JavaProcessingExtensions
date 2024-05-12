package CollisionDetection;

import Items.Geometry.Ellipse;
import Items.Geometry.Rectangle;
import Displacement.Coordinates;

public class Collision {
    /**
     * Rectangle collision with two points
     * @param rect
     * @param x
     * @param y
     * @return true if collision found
     * @param <R>
     */
    public static <R extends Rectangle> boolean collision(R rect, float x, float y){
        return rect.left() <= x && rect.right() >= x && rect.top() <= y && rect.bottom() >= y;
    }

    /**
     *
     * @param rect
     * @param xy
     * @return
     * @param <R>
     */
    public static <R extends Rectangle> boolean collision(R rect, float[] xy){
        if(xy.length!=2){
            System.out.println("Invalid length for collision: Rectangle to float[] xy");
            return false;
        }
        return collision(rect, xy[0], xy[1]);
    }

    /**
     * Rectangle collision with coordinates
     * @param rect
     * @param coordinates
     * @return true if collision found
     * @param <R>
     */
    public static <R extends Rectangle> boolean collision(R rect, Coordinates coordinates){
        float[] c = coordinates.toArray();
        return rect.left() <= c[0] && rect.right() >= c[0] && rect.top() <= c[1] && rect.bottom() >= c[1];
    }

    /**
     * Ellispe collison with two points
     * @param ellipse
     * @param x
     * @param y
     * @return true if collision found
     * @param <E>
     */
    public static <E extends Ellipse> boolean collision(E ellipse, float x, float y){
        float a = Math.abs(ellipse.getX() - x);
        float b = Math.abs(ellipse.getY() - y);
        float c = (float) Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        return c <= ellipse.getRWidth() && c <= ellipse.getRHeight();
    }

    /**
     *
     * @param ellipse
     * @param xy
     * @return
     * @param <E>
     */
    public static <E extends Ellipse> boolean collision(E ellipse, float[] xy){
        if(xy.length != 2){
            System.out.println("Invalid length for collision: Ellipse to float[] xy");
            return false;
        }
        return collision(ellipse, xy[0], xy[1]);
    }

    /**
     * Ellipse collision with another ellipse
     * @param e1
     * @param e2
     * @return true if collision found
     * @param <E>
     */
    public static <E extends Ellipse> boolean collision(E e1, E e2){
        float a = Math.abs(e1.getX() - e2.getX());
        float b = Math.abs(e1.getY() - e2.getY());
        float c = (float) Math.sqrt(Math.pow(a,2) + Math.pow(b,2));
        return c <= e1.getWidth() && c <= e1.getHeight();
    }

    /**
     * Ellipse collision with Coordinates
     * @param ellipse
     * @param coordinates
     * @return
     * @param <E>
     */
    public static <E extends Ellipse> boolean collision(E ellipse, Coordinates coordinates){
        float[] c = coordinates.toArray();
        return Math.abs(ellipse.getX() - c[0]) <= ellipse.getWidth() && Math.abs(ellipse.getY() - c[1]) <= ellipse.getHeight();
    }

    /**
     *
     * @param ellipse
     * @param rect
     * @return
     * @param <E>
     * @param <R>
     */
    public static <E extends Ellipse, R extends Rectangle> boolean collision(E ellipse, R rect){
        float[][] r = rect.getCorners();
        for(byte i=0;i<r.length;i++){
            if(collision(ellipse, r[i])){
                return true;
            }
        }
        return collision(rect, ellipse.top()) || collision(rect, ellipse.bottom()) || collision(rect, ellipse.left()) || collision(rect, ellipse.right());
    }

    /**
     *
     * @param rect
     * @param ellipse
     * @return
     * @param <E>
     * @param <R>
     */
    public static <E extends Ellipse, R extends Rectangle> boolean collision (R rect, E ellipse){
        return collision(ellipse, rect);
    }
}
