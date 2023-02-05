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
public class BikePlacementTest {
    Bike bike = new Bike(Directions.NORTH);
    Directions newDirection;

    public BikePlacementTest(Directions updateDirection){
        newDirection = updateDirection;
    }

    @Parameters
    public static Collection<Object[]> inputs(){
        return Arrays.asList(new Object[][]{
            {Directions.NORTH},
            {Directions.SOUTH},
            {Directions.EAST},
            {Directions.WEST},
        });
    }

    @Test
    public void WhenSetDirectionisCalledBikeDirectionisUpdated(){
        bike.setDirection(newDirection);

        assertEquals(newDirection, bike.getFacingDirection());
    }
    
}
