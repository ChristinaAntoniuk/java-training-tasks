package training;

/**
 * Created by ChristinaAntoniuk on 28-Nov-16.
 */
public class View {
    public static String INPUT_MESSAGE = "Input age of policy holder: ";
    public static String DEATH_PRICE_MESSAGE = "Price of the death insurance: ";
    public static String DISABILITY_PRICE_MESSAGE = "Price of the disability insurance: ";
    public static String DERIVATIVE_PRICE_MESSAGE = "Price of the derivative: ";
    public static String ERROR_MESSAGE = "Error. Policy holder's age can't be more than 100 or less than 0";

    /**
     * Method prints different value of string messages.
     * @param message
     */
    public static void showMessage(String... message){
        for (String mes : message){
            System.out.print(mes + " ");
        }
        System.out.println();
    }
}
