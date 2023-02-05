package bikesimulator;

import java.text.MessageFormat;

import bikesimulator.Types.Directions;
import bikesimulator.UserInteraction.InputReader;
import bikesimulator.UserInteraction.Writer;
import bikesimulator.Validators.Validate;

public class Simulator {

    private Area area;
    private InputReader reader;
    private Writer writer;
    private Validate inputValidator;
    private Bike bike;

    public Simulator(Area area, InputReader reader, Writer writer, Validate validator, Bike bike){
        this.area = area;
        this.reader = reader;
        this.writer = writer;
        this.inputValidator = validator;
        this.bike = bike;
    }

    public void run(){
        boolean running = true;
        boolean bikePlacedInitially = false;
        while(running){
            var input = reader.readInput();
            if(input.equals("q")) running = false;
            var elements = input.split(" ");
            var command = elements[0];
            if(inputValidator.validate(command)){
                if(command.equals("PLACE")){
                    var points = elements[1].split(",");
                    area.placeBike(Integer.parseInt(points[0]), Integer.parseInt(points[1]));
                    bike.setDirection(Directions.valueOf(points[2]));
                    if(bikePlacedInitially == false) bikePlacedInitially = true;
                }
                if(bikePlacedInitially){
                    if(command.equals("GPS_REPORT")){
                        var bikePosition = area.getBikePosition();
                        String output = MessageFormat.format("({0},{1}), {2}", 
                        bikePosition.getXPosition(), bikePosition.getYPosition(), bike.getFacingDirection().toString());
                        writer.Print(output);
                    }
                    if(command.contains("TURN")){
                        var direction = command.split("_")[1];
                        bike.turn(Directions.valueOf(direction));    
                    }
                    if(command.equals("FORWARD")){
                        area.moveBike(bike);
                    }
                }
                
            }
        }
    }
    
}
