import java.util.ArrayList;

public class View {
    // Text's constants
    public final static String INPUT_INT_DATA = "Input your value:";
    public final static String WRONG_INPUT_INT_DATA = "You have to input an integer number! Repeat please! ";
    public final static String WIN_MESSAGE = "BING0!";
    public static final String WRONG_RANGE_DATA = "Wrong range! Repeat please! ";
    public static final String INPUT_MIN_RANGE = "Please, input min barrier of the range:";
    public static final String INPUT_MAX_RANGE = "Please, input max barrier of the range:";
    
    
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
    	printMessage("");
    	printMessage("(" + currentMin + "," + currentMax + ")");
    }

}
