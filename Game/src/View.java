import java.util.ArrayList;

public class View {
    // Text's constants
    public final String INPUT_INT_DATA = "Input your value:";
    public final String WRONG_INPUT_INT_DATA = "Wrong input! Repeat please! ";
    public final String WIN_MESSAGE = "BING0!";
    public final String MORE_MESSAGE = "You need more!";
    public final String LESS_MESSAGE = "You need less!";
    public final String REPEAT_MESSAGE = "This number has already been entered!";

    /**
     * method outputs message to console
     * @param message
     */
    public void printMessage(String message){
        System.out.println(message);
    }
    
    
    /**
     * method outputs range and history to console
     * @param currentMin
     * @param currentMax
     * @param history
     */  
    public void printHistoryAndRange(int currentMin, int currentMax, ArrayList<Integer> history){
    	for(int num : history){  
            System.out.print(num + " ");
        }
    	System.out.println();
    	System.out.println("[" + currentMin + "," + currentMax + "]");
    }

}
