package SimulatorCode;
import SimulatorCode.Types.*;

public class Area {
    private final int maxX = 7;
    private final int maxY = 7;
    private Coordinate bikePosition = new Coordinate();
    
    public void placeBike(int x, int y){
        if(x < maxX && y < maxY){
            
            bikePosition.setX(x);
            bikePosition.setY(y);
        }
    }

    public Coordinate getBikePosition(){
        return bikePosition;
    }
}
