package bikesimulator.Validators;

import bikesimulator.Types.Commands;

public class InputValidator implements Validate {
    public boolean validate(String input){
        
        boolean isPlaceCommand = input.equals(Commands.PLACE.toString());
        boolean isForwardCommand = input.equals(Commands.FORWARD.toString());
        boolean isTurnLeftCommand = input.equals(Commands.TURN_LEFT.toString());
        boolean isTurnRightCommand = input.equals(Commands.TURN_RIGHT.toString());
        boolean isGPSReportCommand = input.equals(Commands.GPS_REPORT.toString());

        if(isPlaceCommand || isForwardCommand || isTurnLeftCommand || isTurnRightCommand || isGPSReportCommand){
            return true;
        }
       
        return false;
    }
}
