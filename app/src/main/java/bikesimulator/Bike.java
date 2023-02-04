package bikesimulator;

import bikesimulator.Types.Directions;

public class Bike {
    private Directions direction;

    public Bike(Directions direction){
        this.direction = direction;
    }

    public void setDirection(Directions direction){
        this.direction = direction;
    }

    public Directions getFacingDirection(){
        return direction;
    }

    public void turn(Directions changingDirection){
        if(direction == Directions.NORTH && changingDirection == Directions.LEFT){
            direction = Directions.WEST;
        }
    }
}
