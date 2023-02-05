package bikesimulator.UserInteraction;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleReader implements InputReader{

    public String readInput(){
        String input;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            input = br.readLine();
        }catch(Exception ex){
            input = "ERROR";
        }
        return input;
    }
}
