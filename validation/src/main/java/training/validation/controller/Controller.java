package training.validation.controller;

import training.validation.IPattern;
import training.validation.model.Address;
import training.validation.model.Group;
import training.validation.model.Model;
import training.validation.model.Record;
import training.validation.view.View;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {

    private Model model;
    private View view;
    private Record record;
    private Address address;

    public Controller(Model model, View view, Record record, Address address) {
        this.model = model;
        this.view = view;
        this.record = record;
        this.address = address;
    }
    
    /**
     * The main logic of the program
     */
    public void process(){
    	Scanner sc = new Scanner(System.in);
        record.setSurname(input(sc,View.SURNAME,IPattern.NAME_PATTERN));
        record.setName(input(sc,View.NAME,IPattern.NAME_PATTERN));
        record.setPatronymic(input(sc,View.PATRONYMIC,IPattern.NAME_PATTERN));
        record.setNickname(input(sc,View.NICKNAME,IPattern.NICKNAME_PATTERN));
        record.setComment(input(sc,View.COMMENT));
        record.setGroup(Group.valueOf(input(sc,View.GROUP,IPattern.GROUP_PATTERN)));
        record.setMobilePhone(input(sc,View.MOBILE_PHONE,IPattern.PHONE_PATTERN));
        record.setHomePhone(input(sc,View.HOME_PHONE,IPattern.PHONE_PATTERN));
        if (input(sc, View.ADDITIONALLY_PHONE_ASK, IPattern.ANSWER_PATTERN).equals("y")){
        	record.setAdditionallyPhone(input(sc,View.ADDITIONALLY_PHONE,IPattern.PHONE_PATTERN));
        }
        else {
        	record.setAdditionallyPhone(null);
        }
        record.setEmail(input(sc,View.EMAIL,IPattern.MAIL_PATTERN));
        record.setSkype(input(sc,View.SKYPE));
        
        address.setPostcode(input(sc,View.POSTCODE,IPattern.POSTCODE_PATTERN));
        address.setCity(input(sc,View.CITY));
        address.setStreet(input(sc,View.STREET));
        address.setHomeNumber(input(sc,View.HOME_NUMBER,IPattern.NUMBER_PATTERN));
        address.setApartmentNumber(input(sc,View.APARTMENT_NUMBER,IPattern.NUMBER_PATTERN));
        
        record.setDateOfCreating();
        record.setDateOfUpdating();
        record.setShortName();
        address.setFullAddress();

        model.addRecord(record);
        view.printNotebook(model.getNotebook());
    }

    /**
     * Creating of one field of the record with using of regular expression
     * @param sc
     * @param question
     * @param regex
     * @return
     */
    public String input(Scanner sc, String question, String regex){
        view.printMessage(question);
        String input = sc.nextLine();
        while(!validation(input,regex)){
        	view.printMessage(View.ERROR);
        	view.printMessage(question);
        	input = sc.nextLine();
        }
        return input;
    }

    /**
     * Creating of one field of the record without using of regular expression
     * @param sc
     * @param question
     * @return
     */
    public String input(Scanner sc, String question){
        view.printMessage(question);
        String input = sc.nextLine();
        return input;
    }
    
    /**
     * Method validates input information
     * @param input
     * @param regex
     * @return
     */
    public boolean validation(String input, final String regex){

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
        return m.matches();
    }

}
