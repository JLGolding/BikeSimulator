package SimulatorTests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import SimulatorCode.Validators.*;

@RunWith(Parameterized.class)
public class InputValidatorValidCommandsTest{

    String input; 
    InputValidator validator = new InputValidator();

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> inputCommands(){
        

        return Arrays.asList(new Object[][]{
            {"PLACE 0,0 NORTH"},
            {"FORWARD"},
            {"TURN_LEFT"},
            {"TURN_RIGHT"},
            {"GPS_REPORT"},
            {"forward"},
            
        });
    }

    public InputValidatorValidCommandsTest(String input){
        this.input = input;
        
    }
    
    @Test
    public void InputValidatorChecksForValidCommands(){
        
        var result = validator.validate(input);
        assertTrue(result);
    }
}
