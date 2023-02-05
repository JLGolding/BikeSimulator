
package bikesimulator;

import bikesimulator.Types.Constants;
import bikesimulator.Types.Directions;
import bikesimulator.UserInteraction.ConsoleOutput;
import bikesimulator.UserInteraction.ConsoleReader;
import bikesimulator.Validators.InputValidator;

public class App {
    
    public static void main(String[] args) {
        var area = new Area(Constants.MAX_X, Constants.MAX_Y);
        var reader = new ConsoleReader();
        var writer = new ConsoleOutput();
        var inputValidator = new InputValidator();
        var bike = new Bike(Directions.EAST);
        var simualtor = new Simulator(area, reader, writer, inputValidator, bike);

        simualtor.run();
    }
}
