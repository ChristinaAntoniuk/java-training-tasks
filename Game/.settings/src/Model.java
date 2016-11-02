import java.util.ArrayList;

public class Model {
	/**
	 * The secret value which comes up by random
	 */
	public int secretValue;
	/**
	 * Current value of min barrier
	 */
    public int currentMin;
    /**
     * Current value of max barrier
     */
    public int currentMax;
    
    /**
     * ArrayList which keeps the history of user's input values
     */
    public ArrayList<Integer> history = new ArrayList<Integer>();
    
    
    /**
     * method compare user's value with program random value
     * @param num
     * @return
     */  
    
    public boolean compareValues(int value) {
    	if(value == secretValue){
    		return true;
    	} else if (value < secretValue){
    		currentMin = value;
    	} else if (value > secretValue){
    		currentMax = value;
    	}
    	return false;
    }
    
    /**
     * method sets the values of primary barrier
     * @param currentMin
     * @param currentMax
     */
    
    public void setPrimaryBarrier(int currentMin, int currentMax){
        this.currentMin = currentMin;
        this.currentMax = currentMax;
    }
    /**
     * method creates a random number in the specifically range
     */
    public void setSecretValue(){
    	secretValue = (int)Math.ceil(Math.random() *
                (currentMax - currentMin -1) + currentMin);
    }
    
    /**
     * method creates the history of user's values
     * @param num
     * @return
     */
    public void createHistory (int value){
    	if (!history.contains(value)){
    		history.add(value);
    	}
    }
    
    /**
     * method closes the program
     */
    public void exitGame(){
    	System.exit(0);
    }
    
    public int getSecretValue() {
        return secretValue;
    }

    public int getMinBarrier() {
        return currentMin;
    }

    public int getMaxBarrier() {
        return currentMax;
    }
}
