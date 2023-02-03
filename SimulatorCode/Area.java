package SimulatorCode;
import SimulatorCode.Types.*;

public class Area {
    
    private Coordinate bikePosition = new Coordinate();
    private int maxX;
    private int maxY;

    public Area(int x, int y){
        maxX = x;
        maxY = y;
    }
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
        

        return x < maxX && y < maxY;
    }

    private boolean isNotNegativeValue(int x, int y){
        return  !(x<= 0 && y <= 0);
    }
}
