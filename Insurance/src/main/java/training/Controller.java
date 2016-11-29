package training;

import training.model.Model;
import training.model.entity.PolicyHolder;

import java.util.Scanner;

/**
 * Created by ChristinaAntoniuk on 28-Nov-16.
 */
public class Controller {
    private Model model;
    private View view;
    private PolicyHolder policyHolder;

    public Controller(View view){
        this.view = view;
    }

    /**
     * Main program process.
     */
    public void process() {
        Scanner sc = new Scanner(System.in);
        policyHolder = new PolicyHolder(inputAgeWithScanner(sc));
        model = new Model(policyHolder);
        model.setDeathDerivativePrice();
        model.setDisabilityDerivativePrice();
        model.setDerivativePrice();
        view.showMessage(View.DEATH_PRICE_MESSAGE + model.getDeathDerivativePrice());
        view.showMessage(View.DISABILITY_PRICE_MESSAGE + model.getDisabilityDerivativePrice());
        view.showMessage(View.DERIVATIVE_PRICE_MESSAGE + model.getDerivativePrice());
    }

    /**
     * Method inputs the value of age.
     * @param sc
     * @return
     */
    public int inputAgeWithScanner(Scanner sc) {
        int res = 0;
        view.showMessage(View.INPUT_MESSAGE);
        while( true ) {
            while (!checkInt(sc)) {
                view.showMessage(View.INPUT_MESSAGE);
                sc.next();
            }
            res = sc.nextInt();
            if (!checkAge(res)) {
                view.showMessage(View.ERROR_MESSAGE);
                view.showMessage(View.INPUT_MESSAGE);
                continue ;
            }
            break;
        }
        return res;
    }

    /**
     * Method checks the age's range.
     * @param age
     * @return
     */
    public boolean checkAge(int age){
        if (age > 100) return false;
        else return true;
    }

    /**
     * Method checks the type of input value.
     * @param sc
     * @return
     */
    public boolean checkInt (Scanner sc){
        if (!sc.hasNextInt()) {
            return false;
        }
        return true;
    }
}
