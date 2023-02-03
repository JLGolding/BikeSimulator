package SimulatorTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import SimulatorCode.Bike;
import SimulatorCode.Types.Directions;

public class BikeTests {
    
    @Test
    public void getFacingDirectionReturnsBikeCurrentDirection(){
        var expectedDirection = Directions.NORTH;
        var bike = new Bike(Directions.NORTH);

        assertEquals(expectedDirection, bike.getFacingDirection());

    }

    @Test
    public void whenFacingNorthAndTurnLeftDirectionIsUpdatedToWest(){
        var expectedDirection = Directions.WEST;
        var bike = new Bike(Directions.NORTH);

        bike.turn(Directions.LEFT);

        assertEquals(expectedDirection, bike.getFacingDirection());
    }
    
}
