package training.validation.model;

import java.util.ArrayList;

public class Model {
	/**
	 * Array of records
	 */
    private ArrayList<Record> notebook = new ArrayList<Record>();

    /**
     * Creating of the new record
     * @param record
     */
    public void addRecord(Record record){
    	notebook.add(record);
    }

    public ArrayList<Record> getNotebook() {
        return notebook;
    }
}
