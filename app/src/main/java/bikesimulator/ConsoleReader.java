package bikesimulator;

public class ConsoleReader implements InputReader{

    public String readInput(){
        return System.console().readLine();
    }
}
