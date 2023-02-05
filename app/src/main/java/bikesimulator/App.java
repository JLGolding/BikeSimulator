
package bikesimulator;

import java.io.File;

import bikesimulator.Types.Constants;
import bikesimulator.Types.Directions;
import bikesimulator.UserInteraction.ConsoleOutput;
import bikesimulator.UserInteraction.ConsoleReader;
import bikesimulator.UserInteraction.InputReader;
import bikesimulator.UserInteraction.TextInputReader;
import bikesimulator.Validators.InputValidator;

public class App {
    
    public static void main(String[] args) {
        var area = new Area(Constants.MAX_X, Constants.MAX_Y);
        InputReader reader;
        var writer = new ConsoleOutput();
        var inputValidator = new InputValidator();
        var bike = new Bike(Directions.EAST);
        if(args.length >0){
            reader = new TextInputReader(new File(args[0]));
        }else{
            reader = new ConsoleReader();
        }
        
        var simualtor = new Simulator(area, reader, writer, inputValidator, bike);

        simualtor.run();
    }
}
