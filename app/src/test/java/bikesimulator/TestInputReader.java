package bikesimulator;

import java.util.Stack;

import bikesimulator.UserInteraction.InputReader;

public class TestInputReader implements InputReader {
    private Stack<String> stack;

    public TestInputReader(Stack<String> inputs){
        stack = inputs;
    }

    public String readInput(){
        
        return stack.pop();
    }
}
