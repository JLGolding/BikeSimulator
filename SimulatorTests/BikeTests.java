package SimulatorTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import SimulatorCode.enums.Directions;
import SimulatorCode.Bike;

public class BikeTests {
    
    @Test
    public void getFacingDirectionReturnsBikeCurrentDirection(){
        var expectedDirection = Directions.NORTH;
        var bike = new Bike(Directions.NORTH);

        assertEquals(expectedDirection, bike.getFacingDirection());

    }
    
}
