package SimulatorCode;

public class ConsoleReader implements InputReader{
    
    public String readInput(){
        return System.console().readLine();
    }
}
