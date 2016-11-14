
import java.util.Scanner;

public class Controller {
    Model model;
    View  view;
    
	int minBarrier;
    int maxBarrier;

    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    // The Work method
    public void processUser(){
    	Scanner sc = new Scanner(System.in);
        minBarrier = inputMinBarrierWithScanner(sc);
        maxBarrier = inputMaxBarrierWithScanner(sc);
        checkInputRange (minBarrier, maxBarrier);    	
        model.setPrimaryBarrier(minBarrier,maxBarrier);
        model.setSecretValue();
        //System.out.println(model.getSecretValue());
        while (!model.compareValues(inputIntValueWithScanner(sc))){}
        view.printMessage(View.WIN_MESSAGE);
    }

    
    // The Utility methods
    /**
     * method checks the user's input data
     * @param sc
     * @return
     */
    public int inputIntValueWithScanner(Scanner sc) {
        int res = 0;
        view.printHistoryAndRange(model.getMinBarrier(), model.getMaxBarrier(), model.getHistory());
        view.printMessage(View.INPUT_INT_DATA);
        while( true ) {
            while (!checkInt(sc)) {
                view.printMessage(View.WRONG_INPUT_INT_DATA
                        + View.INPUT_INT_DATA);
                sc.next();
            }
            res = sc.nextInt();
            if (!checkRange(res)) {
                view.printMessage(View.WRONG_RANGE_DATA
                        + View.INPUT_INT_DATA);
                continue ;
            }
            break;
        }
        model.createHistory(res);
        return res;
    }
    
    /**
     * method inputs the value of min barrier and checks it for integer type
     * @param sc
     * @return
     */
    public int inputMinBarrierWithScanner(Scanner sc) {
        view.printMessage(View.INPUT_MIN_RANGE);
        while (!checkInt(sc)) {
            view.printMessage(View.WRONG_INPUT_INT_DATA
                      + View.INPUT_INT_DATA);
            sc.next();
        }
        return sc.nextInt();
    }
    
    /**
     * method inputs the value of max barrier and checks it for integer type
     * @param sc
     * @return
     */
    public int inputMaxBarrierWithScanner(Scanner sc) {
        view.printMessage(View.INPUT_MAX_RANGE);
        while (!checkInt(sc)) {
            view.printMessage(View.WRONG_INPUT_INT_DATA
                      + View.INPUT_INT_DATA);
            sc.next();
        }
        return sc.nextInt();
   }
    
    /**
     * method checks the type of input value
     * @param sc
     * @return
     */
    public boolean checkInt (Scanner sc){
    	if (!sc.hasNextInt()) {
            return false;
        }
    	return true;
    }
    
    /**
     * method checks the range of input value
     * @param res
     * @return
     */
    public boolean checkRange (int res){
    	if (res <= model.getMinBarrier() ||
                res >= model.getMaxBarrier()) {
            return false;
        }
    	return true;
    }
    
    /**
     * method swaps min and max ranges if necessary
     * @param minBarrier
     * @param */
    public void checkInputRange (int minBarrier, int maxBarrier){
    	int temp = 0;
    	if (minBarrier > maxBarrier){
    		temp = minBarrier;
    		this.minBarrier = maxBarrier;
    		this.maxBarrier = temp;
    	}
    }
}
