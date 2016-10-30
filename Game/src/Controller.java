
import java.util.Scanner;

public class Controller {
	
    Model model;
    View view;
    boolean win;
    int num;
    boolean repeat_indicator;

    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    // The Work method
    public void process(){
        Scanner sc = new Scanner(System.in);
        win = false;
        model.setValue(model.getRandomNumber(model.MIN_VALUE, model.MAX_VALUE));
        while (!win){
            num = inputIntValueWithScanner(sc);
        	if (model.createHistory(num) == 1){
        		view.printMessage(view.REPEAT_MESSAGE);
        	}
        	if (model.compareValues(num) == 0){
        		view.printMessage(view.WIN_MESSAGE);
        		win = true;
        		break;
        	}
        	if (model.compareValues(num) == 1) view.printMessage(view.MORE_MESSAGE);
        	if (model.compareValues(num) == 2) view.printMessage(view.LESS_MESSAGE);   	
        	view.printHistoryAndRange(model.currentMin, model.currentMax, model.history);
        }
    }

    // The Utility methods
    public int inputIntValueWithScanner(Scanner sc) {
        view.printMessage(view.INPUT_INT_DATA);
        while( ! sc.hasNextInt()) {
            view.printMessage(view.WRONG_INPUT_INT_DATA + view.INPUT_INT_DATA);
            sc.next();
        }
        return sc.nextInt();
    }
}
