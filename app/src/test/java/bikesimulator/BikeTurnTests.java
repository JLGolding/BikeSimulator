package bikesimulator;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import bikesimulator.Types.Directions;


@RunWith(Parameterized.class)
public class BikeTurnTests {

    private Bike bike;
    Directions startDirection;
    Directions newDirection;
    Directions expectedFinalDirection;
    
    public BikeTurnTests(Directions startingDirection, Directions newDirection, Directions expectedDirection){
        this.startDirection = startingDirection;
        this.newDirection = newDirection;
        expectedFinalDirection = expectedDirection;
    }

    @Parameters(name = "starting {0}, new {1}, final {2}")
    public static Collection<Object[]> inputs(){
        return Arrays.asList(new Object[][]{
            {Directions.NORTH, Directions.LEFT, Directions.WEST},
            {Directions.NORTH, Directions.RIGHT, Directions.EAST},
            {Directions.EAST, Directions.RIGHT, Directions.SOUTH},
            {Directions.EAST, Directions.LEFT, Directions.NORTH},
            {Directions.SOUTH, Directions.RIGHT, Directions.WEST},
            {Directions.SOUTH, Directions.LEFT, Directions.EAST},
            {Directions.WEST, Directions.RIGHT, Directions.NORTH},
            {Directions.WEST, Directions.LEFT, Directions.SOUTH},

        });
    }

    
    @Test
    public void WhenBikeIsTurnedDirectionIsUpdated(){
        bike = new Bike(startDirection);
        bike.turn(newDirection);

        assertEquals(expectedFinalDirection, bike.getFacingDirection());

    }

    

        
}
