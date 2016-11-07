package training.validation.view;

import training.validation.model.Record;

import java.util.ArrayList;

public class View {

    public static final String SURNAME="Surname (letters and '-'):";
    public static final String NAME="Name (letters and '-'):";
    public static final String PATRONYMIC="Patronymic (letters and '-'):";
    public static final String NICKNAME="Nickname (letters, numbers and '_'):";
    public static final String COMMENT="Comment:";
    public static final String GROUP="Group (FIRST, SECOND, THIRD, FOURTH, FIFTH (put one)):";
    public static final String MOBILE_PHONE="Mobile phone (+************) (input only 10 numbers):";
    public static final String HOME_PHONE="Home phone (+************) (input only 10 numbers):";
    public static final String ADDITIONALLY_PHONE_ASK="Do you want to add one more phone number? (y/n)";
    public static final String ADDITIONALLY_PHONE="Additionally phone (+************) (input only 10 numbers):";
    public static final String EMAIL="Email (yourmail@domain.com):";
    public static final String SKYPE="Skype:";

    public static final String POSTCODE="Postcode (*****):";
    public static final String CITY="City:";
    public static final String STREET="Street:";
    public static final String HOME_NUMBER="Home number:";
    public static final String APARTMENT_NUMBER="Apartment number:";

    public static final String ERROR = "Something wrong. Try again!";
    
    /**
     * Method prints some message
     * @param s
     */
    public void printMessage(String s){
        System.out.println(s);
    }
    
    /**
     * Method outputs on the screen all the data from notebook
     * @param notebook
     */
    public void printNotebook(ArrayList<Record> notebook){
        for (Record i : notebook){
            System.out.println(i);
        }
    }

}
