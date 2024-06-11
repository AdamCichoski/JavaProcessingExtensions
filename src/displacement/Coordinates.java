package displacement;

public class Coordinates {
    public float coordinates[] = new float[2];

    /**
     * Constructor
     * @param x
     * @param y
     */
    public Coordinates(float x, float y){
//        coordinates = (validateCoordinates(new float[]{x,y}))? new float []{x,y} : null;
        coordinates = new float[]{x,y};
    }


    /**
     * Constructor
     * @param coordinates
     */
    public Coordinates(float[] coordinates){
        this.coordinates = (validateLength(coordinates))? coordinates : null;
    }

    /**
     * @return {x, y}
     */
    public float[] toArray(){
        return coordinates;
    }

    public void updateCoordinates(Coordinates newCoordinates){
        if(this!=null){
            if(!validateLength(newCoordinates)){
                System.out.println("Invalid Coordinate Scheme");
            }
            this.coordinates = newCoordinates.toArray();
        }
    }

    private boolean validateLength(Coordinates coordinates){
        return validateLength(coordinates.toArray());
    }

    private boolean validateLength(float[] coordinates){
        return coordinates.length == 2;
    }

    private boolean validateCoordinates(Coordinates coordinates){
        return validateCoordinates(coordinates.toArray());
    }

    private boolean validateCoordinates(float[] coordinates){
        return coordinates[0]>=0 && coordinates[1] >= 0;
    }

    public float getX(){
        return this.toArray()[0];
    }

    public float getY(){
        return this.toArray()[1];
    }
}
