package bikesimulator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import bikesimulator.Types.Directions;

public class AreaMoveBikeTest {
    private Area area = new Area(3, 3);
    @Test
    public void WhenBikeIsFacingNorthForwardCommandMovesBikeUpOnePoint(){
        var bike = new Bike(Directions.NORTH);
        area.moveBike(bike);
        assertEquals(1, area.getBikePosition().getYPosition());
    }
    
}
