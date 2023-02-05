package bikesimulator;
import bikesimulator.Types.*;

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

    private boolean isLessThanMaxGridSize(int x, int y){
    
        return x < maxX && y < maxY;
    }

    private boolean isNotNegativeValue(int x, int y){
        return  !(x<= 0 && y <= 0);
    }

    public Coordinate getBikePosition(){
        return bikePosition;
    }

    public void moveBike(Bike bike){
        var direction = bike.getFacingDirection();
        var newCoordinate = getNewCoordinate(direction);
        if(canBikeMove(newCoordinate))updateBikePosition(newCoordinate);    
        
    }

    private Coordinate getNewCoordinate(Directions direction){

        if(direction.equals(Directions.NORTH)){
            return new Coordinate(bikePosition.getXPosition(), bikePosition.getYPosition() + 1);
        }
        else if(direction.equals(Directions.EAST)){
            return new Coordinate(bikePosition.getXPosition() + 1, bikePosition.getYPosition());
        }
        else if(direction.equals(Directions.SOUTH)){
            return new Coordinate(bikePosition.getXPosition(), bikePosition.getYPosition() - 1);
        }
        else {
            return new Coordinate(bikePosition.getXPosition() - 1, bikePosition.getYPosition());
        }
    }

    private boolean canBikeMove(Coordinate coord){
        if(isLessThanMaxGridSize(coord.getXPosition(), coord.getYPosition())){
            return true;
        }
        
        return false;
    }

    private void updateBikePosition(Coordinate newCoordinate){
        bikePosition = newCoordinate;
    }

    
}
