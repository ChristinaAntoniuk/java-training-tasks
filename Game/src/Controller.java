
import java.util.Scanner;

public class Controller {
    Model model;
    View  view;

    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    // The Work method
    public void processUser(){

    	Scanner sc = new Scanner(System.in);
        model.setPrimaryBarrier(GlobalConstants.PRIMARY_MIN_BARRIER,
                                GlobalConstants.PRIMARY_MAX_BARRIER);
        model.setSecretValue();
        //System.out.println(model.getSecretValue());
        while (!model.compareValues(inputIntValueWithScanner(sc))){       	
        	}

        view.printMessage(View.WIN_MESSAGE + model.getSecretValue());
    }

    
    // The Utility methods
    /**
     * method checks the user's input data
     * @param sc
     * @return
     */
    public int inputIntValueWithScanner(Scanner sc) {
        int res = 0;
        view.printHistoryAndRange(model.currentMin, model.currentMax, model.history);
        view.printMessage(View.INPUT_INT_DATA);
        while( true ) {
            while (!checkInt(sc)) {
                view.printMessage(View.WRONG_INPUT_INT_DATA
                        + View.INPUT_INT_DATA);
                sc.next();
            }
            res = sc.nextInt();
            if (res == 000){
            	view.printMessage(View.END_MESSAGE);
            	model.exitGame();
            }
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
}
