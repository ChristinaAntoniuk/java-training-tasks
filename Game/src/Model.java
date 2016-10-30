import java.util.Random;
import java.util.ArrayList;


public class Model {
	// Class finalized variables
	public final int MIN_VALUE = 0;
	public final int MAX_VALUE = 100;
	
	//Variables
	public int value;
    public int currentMin;
    public int currentMax;
    
    //Object ArrayList
    public ArrayList<Integer> history = new ArrayList<Integer>();

    //Constructor
    public Model(){
    	
    	currentMin = MIN_VALUE;
    	currentMax = MAX_VALUE;
    }
    
    public void setValue(int value) {
        this.value = value;
    }
    
    /**
     * method compare user's value with program random value
     * @param num
     */  
    
    public int compareValues(int num) {
    	if (num < value) {
    		currentMin = num;
    		return 1;
    	}
    	if (num > value) {
    		currentMax = num;
    		return 2;
    	}
    	else return 0;		
    }
    
    /**
     * method creates random number in specifically range
     */  
    public int getRandomNumber(int MIN_VALUE, int MAX_VALUE){
    	Random random = new Random();
    	return (random.nextInt(MAX_VALUE) + MIN_VALUE);
    }
    
    //Creating history with new user's numbers
    public int createHistory (int num){
    	if (!history.contains(num)){
    		history.add(num);
    		return 0;
    	}
    	return 1;
    }
}
