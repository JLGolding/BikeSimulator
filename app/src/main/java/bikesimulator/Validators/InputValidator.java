package bikesimulator.Validators;

import bikesimulator.Types.Commands;

public class InputValidator implements Validate {
    public boolean validate(String input){
        String[] sections = input.split(" ");
        String command = sections[0];

        boolean isPlaceCommand = command.equalsIgnoreCase(Commands.PLACE.toString());
        boolean isForwardCommand = command.equalsIgnoreCase(Commands.FORWARD.toString());
        boolean isTurnLeftCommand = command.equalsIgnoreCase(Commands.TURN_LEFT.toString());
        boolean isTurnRightCommand = command.equalsIgnoreCase(Commands.TURN_RIGHT.toString());
        boolean isGPSReportCommand = command.equalsIgnoreCase(Commands.GPS_REPORT.toString());

        if(isPlaceCommand || isForwardCommand || isTurnLeftCommand || isTurnRightCommand || isGPSReportCommand){
            return true;
        }
       
        return false;
    }
}
