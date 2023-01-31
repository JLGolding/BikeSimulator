package SimulatorCode;

import SimulatorCode.enums.Directions;

public class Bike {
    private Directions direction;

    public Bike(Directions direction){
        this.direction = direction;
    }

    public Directions getFacingDirection(){
        return direction;
    }
}
