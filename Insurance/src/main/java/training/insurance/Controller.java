package training.insurance;

import training.insurance.model.Model;
import training.insurance.model.entity.Death;
import training.insurance.model.entity.Derivative;
import training.insurance.model.entity.Disability;
import training.insurance.model.entity.PolicyHolder;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by ChristinaAntoniuk on 18-Nov-16.
 */
public class Controller {

    Model model;
    View view;
    PolicyHolder policyHolder;
    Derivative derivative;
    Death death;
    Disability disability;
    DataBaseConnection dataBaseConnection;

    public Controller() throws SQLException {
        view = new View();
        model = new Model();
        derivative = new Derivative();
        dataBaseConnection = new DataBaseConnection();
    }

    /**
     * Main process.
     * @throws SQLException
     */
    public void process() throws SQLException {
        Scanner sc = new Scanner(System.in);
        policyHolder = new PolicyHolder(inputAgeWithScanner(sc));
        death = new Death(policyHolder);
        disability = new Disability(policyHolder);
        derivative.setPrice(death.getPrice());
        derivative.setPrice(disability.getPrice());
        setDataForSortedProbabilities();
        view.showMessage(View.DEATH_PRICE_MESSAGE + death.getPrice());
        view.showMessage(View.DISABILITY_PRICE_MESSAGE + disability.getPrice());
        view.showMessage(View.DERIVATIVE_PRICE_MESSAGE + derivative.getPrice());
        view.showMessage(View.SORTED_CASES_MESSAGE + model.getAllProbabilities().values());
        view.showFormatMessage(View.MAX_PROBABILITY_CASE_MESSAGE, model.getAllProbabilities().get(model.getMaxProbability()), model.getMaxProbability());
        view.showFormatMessage(View.MIN_PROBABILITY_CASE_MESSAGE, model.getAllProbabilities().get(model.getMinProbability()), model.getMinProbability());
    }

    /**
     * Methos sets the data for creating sorted probabilities map.
     */
    public void setDataForSortedProbabilities(){
        model.createSortedProbabilities(death.getAprobability(), "DeathAccident");
        model.createSortedProbabilities(death.getNCprobability(), "DeathNaturalCauses");
        model.createSortedProbabilities(disability.getAprobability(), "DisabilityAccident");
        model.createSortedProbabilities(disability.getNCprobability(), "DisabilityNaturalCauses");
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
