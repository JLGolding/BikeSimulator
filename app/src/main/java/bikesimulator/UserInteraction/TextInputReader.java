package bikesimulator.UserInteraction;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextInputReader implements InputReader{
    private File fileRef;
    private List<String> inputs = new ArrayList<String>();
    private boolean isFirstInput = true;

    public TextInputReader(File file){
        fileRef = file;
    }

    public String readInput(){
        if(isFirstInput){
            try{
                Scanner scanner = new Scanner(fileRef);
                scanner.useDelimiter(";");
                
                while(scanner.hasNext()){
                    inputs.add(scanner.next());  
                } 
                scanner.close();
                
            }catch(Exception ex){
                return "ERROR";
            }
        }  

        if(inputs.isEmpty()){
            return "";
        }
        var input = inputs.get(0);
        inputs.remove(0);   
        return input;
    }
}
