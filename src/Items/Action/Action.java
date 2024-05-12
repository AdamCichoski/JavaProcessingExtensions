package Items.Action;

import Items.Geometry.Shape;

public class Action {
    /**
     *
     * @param shape
     * @return
     * @param <S>
     */
    public static <S extends Shape> S generate(S shape){
        return shape;
    }

}
