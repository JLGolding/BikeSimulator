package bikesimulator;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.File;
import java.util.Stack;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import bikesimulator.Types.Coordinate;
import bikesimulator.Types.Directions;
import bikesimulator.UserInteraction.ConsoleOutput;
import bikesimulator.UserInteraction.InputReader;
import bikesimulator.UserInteraction.TextInputReader;
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

    @Test
    public void CommandsAreOnlyDoneAfterAValidPlaceCommandIsDoneFirst(){
        Stack<String> inputs = new Stack<String>();
        inputs.push("q");
        inputs.push("GPS_REPORT");
        inputs.push("PLACE 4,1,EAST");
        inputs.push("TURN_RIGHT");

        InputReader reader = new TestInputReader(inputs);
        Coordinate expectedCoordinate = new Coordinate(4, 1);

        when(validator.validate("PLACE")).thenReturn(true);
        when(validator.validate("GPS_REPORT")).thenReturn(true);
        when(validator.validate("TURN_RIGHT")).thenReturn(true);
      
        when(area.getBikePosition()).thenReturn(expectedCoordinate);
        when(bike.getFacingDirection()).thenReturn(Directions.EAST);

        
        Simulator sim = new Simulator(area, reader, writer, validator, bike);

        sim.run();

        verify(bike, times(1)).setDirection(any());
        verify(writer).Print("(4,1), EAST");
        
    }

    @Test
    public void MoveCommandAfterPlaceUpdatesBikePosition(){
        Stack<String> inputs = new Stack<String>();
        inputs.push("q");
        inputs.push("GPS_REPORT");
        inputs.push("FORWARD");
        inputs.push("PLACE 4,1,EAST");
        

        InputReader reader = new TestInputReader(inputs);
        Coordinate expectedCoordinate = new Coordinate(5, 1);

        when(validator.validate("PLACE")).thenReturn(true);
        when(validator.validate("GPS_REPORT")).thenReturn(true);
        when(validator.validate("FORWARD")).thenReturn(true);
      
        when(area.getBikePosition()).thenReturn(expectedCoordinate);
        when(bike.getFacingDirection()).thenReturn(Directions.EAST);
        
        Simulator sim = new Simulator(area, reader, writer, validator, bike);

        sim.run();

        verify(bike, times(1)).setDirection(any());
        verify(area).moveBike(bike);
        verify(writer).Print("(5,1), EAST");
    }

    @Test
    public void TurnLeftCommandMakeTheBikeChangeDirection(){
        Stack<String> inputs = new Stack<String>();
        inputs.push("q");
        inputs.push("GPS_REPORT");
        inputs.push("TURN_LEFT");
        inputs.push("PLACE 4,1,EAST");
        

        InputReader reader = new TestInputReader(inputs);
        Coordinate expectedCoordinate = new Coordinate(4, 1);

        when(validator.validate("PLACE")).thenReturn(true);
        when(validator.validate("GPS_REPORT")).thenReturn(true);
        when(validator.validate("TURN_LEFT")).thenReturn(true);
      
        when(area.getBikePosition()).thenReturn(expectedCoordinate);
        when(bike.getFacingDirection()).thenReturn(Directions.NORTH);
        
        Simulator sim = new Simulator(area, reader, writer, validator, bike);

        sim.run();

        verify(bike, times(1)).setDirection(any());
        verify(bike).turn(Directions.LEFT);
        verify(writer).Print("(4,1), NORTH");
    }

    @Test
    public void TurnRightCommandMakeTheBikeChangeDirection(){
        Stack<String> inputs = new Stack<String>();
        inputs.push("q");
        inputs.push("GPS_REPORT");
        inputs.push("TURN_RIGHT");
        inputs.push("PLACE 4,1,EAST");
        

        InputReader reader = new TestInputReader(inputs);
        Coordinate expectedCoordinate = new Coordinate(4, 1);

        when(validator.validate("PLACE")).thenReturn(true);
        when(validator.validate("GPS_REPORT")).thenReturn(true);
        when(validator.validate("TURN_RIGHT")).thenReturn(true);
      
        when(area.getBikePosition()).thenReturn(expectedCoordinate);
        when(bike.getFacingDirection()).thenReturn(Directions.SOUTH);
        
        Simulator sim = new Simulator(area, reader, writer, validator, bike);

        sim.run();

        verify(bike, times(1)).setDirection(any());
        verify(bike).turn(Directions.RIGHT);
        verify(writer).Print("(4,1), SOUTH");
    }

    @Test
    public void InputsCanBeReadFromTextFile(){
        File file = new File("src/test/resources/test-data.text");
        InputReader reader = new TextInputReader(file);
        Coordinate expectedCoordinate = new Coordinate(4, 1);

        when(validator.validate("PLACE")).thenReturn(true);
        when(validator.validate("GPS_REPORT")).thenReturn(true);
        when(validator.validate("TURN_RIGHT")).thenReturn(true);
        when(validator.validate("FORWARD")).thenReturn(true);
      
        when(area.getBikePosition()).thenReturn(expectedCoordinate);
        when(bike.getFacingDirection()).thenReturn(Directions.EAST);
        
        Simulator sim = new Simulator(area, reader, writer, validator, bike);

        sim.run();

        verify(bike, times(1)).setDirection(any());
        verify(bike).turn(Directions.RIGHT);
        verify(writer).Print("(4,1), EAST");
    }
}
