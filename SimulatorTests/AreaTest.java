package SimulatorTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;


import SimulatorCode.*;

public class AreaTest {

    private Area area = new Area();


    @Test //TODO: parametiseTest
    public void BikeCanBePlacedAnywhereOnGrid(){
        area.placeBike( 0, 0);

        var result = area.getBikePosition();

        assertEquals(0, result.getXPosition());
        assertEquals(0, result.getYPosition());
    }

    @Test
    public void BikeCannotBePlacedOutsideGridBounds(){
        area.placeBike(8, 8);

        var result = area.getBikePosition();

        assertFalse(result.getXPosition() > 7);
    }

    @Test
    public void BikePlacementCoordinateMustBeGreaterThanZero(){
        area.placeBike(-1, -1);

        var result = area.getBikePosition();

        assertFalse(result.getXPosition() < 0);
    }
    
}
