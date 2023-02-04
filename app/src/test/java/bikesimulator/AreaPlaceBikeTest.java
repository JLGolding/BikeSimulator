package bikesimulator;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import bikesimulator.Types.Constants;

@RunWith(Parameterized.class)
public class AreaPlaceBikeTest {

    private Area area = new Area(Constants.MAX_X, Constants.MAX_Y);
    private int x;
    private int y;

    public AreaPlaceBikeTest(int xInput, int yInput){
        x = xInput;
        y = yInput;
    }

    @Parameters(name = "x input {0}, y input {1}")
    public static Collection<Object[]> inputs(){
        return Arrays.asList(new Object[][]{
            {0,0},
            {1,1},
            {6,6},
            {2,3},
            {6,4},
            {7,7},
            {-1,-2}
        });
    }

    @Test 
    public void BikeCanBePlacedAnywhereOnGrid(){
        area.placeBike(x, y);

        var result = area.getBikePosition();

        assertTrue(result.getXPosition() >= 0 && result.getXPosition() < Constants.MAX_X);
        assertTrue(result.getYPosition() >= 0 && result.getYPosition() < Constants.MAX_Y);
    }

       
}
