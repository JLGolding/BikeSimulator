package bikesimulator;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.net.URISyntaxException;
import org.junit.Test;

import bikesimulator.UserInteraction.TextInputReader;

public class TextInputReaderTest {
    
    @Test
    public void FirstFileReadReturnsFirstElement()throws URISyntaxException{
        
        var file = new File("src/test/resources/test-data.text");
        var expectedResult = "FORWARD";

        var reader = new TextInputReader(file);

        assertEquals(expectedResult, reader.readInput());
    }

    @Test
    public void CanReadAndReturnMultipleValuesFromFile()throws URISyntaxException{
        
        var file = new File("src/test/resources/test-data.text");
        var expectedFirstResult = "FORWARD";
        var expectedSecondResult = "PLACE 4,1,NORTH";

        var reader = new TextInputReader(file);
        var firstResult = reader.readInput();
        var secondResult = reader.readInput();

        assertEquals(expectedFirstResult, firstResult);
        assertEquals(expectedSecondResult, secondResult);
    }
}
