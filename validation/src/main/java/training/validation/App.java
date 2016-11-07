package training.validation;

import training.validation.model.Address;
import training.validation.model.Group;
import training.validation.model.Model;
import training.validation.model.Record;
import training.validation.view.View;
import training.validation.controller.Controller;

public class App 
{
    public static void main( String[] args )
    {
            // Initialization
            Model model = new Model();
            View view = new View();
            Group group = null;
            Address address = new Address();
            Record record = new Record(group, address);
            Controller controller = new Controller(model, view, record, address);
            // Run
            controller.process();
    }
}
