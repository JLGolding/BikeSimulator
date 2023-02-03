package SimulatorCode;
import SimulatorCode.Types.*;

public class Area {
    
    private Coordinate bikePosition = new Coordinate();
    
    public void placeBike(int x, int y){
        if(isLessThanMaxGridSize(x, y) && isNotNegativeValue(x, y)){
            
            bikePosition.setX(x);
            bikePosition.setY(y);
        }
    }

    public Coordinate getBikePosition(){
        return bikePosition;
    }

    private boolean isLessThanMaxGridSize(int x, int y){
        final int MAX_X = 7;
        final int MAX_Y = 7;

        return x < MAX_X && y < MAX_Y;
    }

    private boolean isNotNegativeValue(int x, int y){
        return  !(x<= 0 && y <= 0);
    }
}
