package bikesimulator;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import bikesimulator.Types.Directions;

@RunWith(Parameterized.class)
public class AreaMoveVerticalBikeTest {
    private Area area = new Area(3, 3);

    private Directions direction;
    private int expectedPosition;

    public AreaMoveVerticalBikeTest(Directions dir, int expectedPos){
        direction = dir;
        expectedPosition = expectedPos;
    }

    @Parameters
    public static Collection<Object[]> inputs(){
        return Arrays.asList(new Object[][]{
            {Directions.NORTH, 2},
            {Directions.SOUTH, 0},
        });
    }

    @Before
    public void setUp(){
        area.placeBike(1, 1);
    }

    @Test
    public void BikeMovesOnePointInVerticalDirectons(){
        var bike = new Bike(direction);
        area.moveBike(bike);
        assertEquals(expectedPosition, area.getBikePosition().getYPosition());
    }
    
}
