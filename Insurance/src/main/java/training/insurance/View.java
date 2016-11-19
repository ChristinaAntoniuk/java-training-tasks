package training.insurance;

/**
 * Created by ChristinaAntoniuk on 18-Nov-16.
 */
public class View {
    public static String INPUT_MESSAGE = "Input age of policy holder: ";
    public static String DEATH_PRICE_MESSAGE = "Price of the death insurance: ";
    public static String DISABILITY_PRICE_MESSAGE = "Price of the disability insurance: ";
    public static String DERIVATIVE_PRICE_MESSAGE = "Price of the derivative: ";
    public static String SORTED_CASES_MESSAGE = "Sorted insurance cases: ";
    public static String MAX_PROBABILITY_CASE_MESSAGE = "Case with max probability: ";
    public static String MIN_PROBABILITY_CASE_MESSAGE = "Case with min probability: ";

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

    /**
     * Method prints some messages and format float value.
     * @param message
     * @param name
     * @param arg
     */
    public static void showFormatMessage(String message, String name, Float arg){
        System.out.print(message);
        System.out.printf("%1$1.5f ", arg);
        System.out.println(name);
    }
}
