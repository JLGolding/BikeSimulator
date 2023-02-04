package bikesimulator;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Stack;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import bikesimulator.Types.Coordinate;
import bikesimulator.Types.Directions;
import bikesimulator.UserInteraction.ConsoleOutput;
import bikesimulator.UserInteraction.InputReader;
import bikesimulator.Validators.InputValidator;


@RunWith(MockitoJUnitRunner.class)
public class SimulatorTest {
   
    @Mock
    private Area area;



    @Mock
    private InputValidator validator;

    @Mock
    private ConsoleOutput writer;

    @Mock
    private Bike bike;

    
    @Test
    public void WhenUserInputsPlaceCommandTheBikesPositionIsChanged(){
        Stack<String> inputs = new Stack<String>();
        inputs.push("q");
        inputs.push("GPS_REPORT");
        inputs.push("PLACE 4,1,EAST");
        
        InputReader reader = new TestInputReader(inputs);
        Coordinate expectedCoordinate = new Coordinate(4, 1);

        when(validator.validate("PLACE")).thenReturn(true);
        when(validator.validate("GPS_REPORT")).thenReturn(true);
      
        when(area.getBikePosition()).thenReturn(expectedCoordinate);
        when(bike.getFacingDirection()).thenReturn(Directions.EAST);

        
        Simulator sim = new Simulator(area, reader, writer, validator, bike);

        sim.run();

        verify(bike, times(1)).setDirection(Directions.EAST);
        verify(writer).Print("(4,1), EAST");
    }

    // @Test
    // public void WhenAValidPlaceCommandIsGivenGPS_REPORTCommandGivesTheUpdatedPositionAndDirection(){
    //     //input
    //     //area
    //     //input gps
    //     //expect
    //     var expectedResponse = "2,3 WEST";

    //     assertEquals(expectedResponse, mockconsoleOutput);
    // }
}
