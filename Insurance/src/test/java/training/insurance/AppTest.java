package training.insurance;

import junit.framework.TestCase;
import org.junit.Test;

import java.sql.SQLException;
import java.util.TreeMap;

/**
 * Unit test for DataBaseConnection class
 */
public class AppTest extends TestCase
{
    DataBaseConnection dataBaseConnection;

    @Test
    public void testDeathNaturalCausesProbability() throws SQLException {
        dataBaseConnection = new DataBaseConnection();
        TreeMap<Integer,Float> data;
        dataBaseConnection.setDeathNaturalCausesProbability();
        data = dataBaseConnection.getDeathNaturalCausesProbability();
        assertEquals(data.get(50), 0.002062f);
    }

    @Test
    public void testDeathAccidentCausesProbability() throws SQLException {
        dataBaseConnection = new DataBaseConnection();
        TreeMap<Integer,Float> data;
        dataBaseConnection.setDeathAccidentProbability();
        data = dataBaseConnection.getDeathAccidentProbability();
        assertEquals(data.get(50), 0.000768f);
    }

    @Test
    public void testDisabilityNaturalCausesProbability() throws SQLException {
        dataBaseConnection = new DataBaseConnection();
        TreeMap<Integer,Float> data;
        dataBaseConnection.setDisabilityNaturalCausesProbability();
        data = dataBaseConnection.getDisabilityNaturalCausesProbability();
        assertEquals(data.get(50), 0.0032f);
    }

    @Test
    public void testDisabilityAccidentProbability() throws SQLException {
        dataBaseConnection = new DataBaseConnection();
        TreeMap<Integer,Float> data;
        dataBaseConnection.setDisabilityAccidentProbability();
        data = dataBaseConnection.getDisabilityAccidentProbability();
        assertEquals(data.get(50), 0.00107f);
    }
}
