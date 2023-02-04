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
            setDirection(Directions.WEST);
        }
        else if(direction == Directions.NORTH && changingDirection == Directions.RIGHT){
            setDirection(Directions.EAST);
        }
        else if(direction == Directions.EAST && changingDirection == Directions.RIGHT){
            setDirection(Directions.SOUTH);
        }
        else if(direction == Directions.EAST && changingDirection == Directions.LEFT){
            setDirection(Directions.NORTH);
        }
        else if(direction == Directions.SOUTH && changingDirection == Directions.RIGHT){
            setDirection(Directions.WEST);
        }
        else if(direction == Directions.SOUTH && changingDirection == Directions.LEFT){
            setDirection(Directions.EAST);
        }
        else if(direction == Directions.WEST && changingDirection == Directions.RIGHT){
            setDirection(Directions.NORTH);
        }
        else if(direction == Directions.WEST && changingDirection == Directions.LEFT){
            setDirection(Directions.SOUTH);
        }
    }
}
