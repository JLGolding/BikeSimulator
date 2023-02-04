package bikesimulator.UserInteraction;

public class ConsoleReader implements InputReader{

    public String readInput(){
        return System.console().readLine();
    }
}
