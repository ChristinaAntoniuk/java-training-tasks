package training.insurance;

import java.sql.SQLException;

public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException
    {
        // Initialization
        Controller controller = new Controller();
        // Run
        controller.process();
    }
}
