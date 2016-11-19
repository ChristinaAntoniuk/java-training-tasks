package training.insurance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeMap;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
/**
 * Class, that connects to SQL data base.
 */
public class DataBaseConnection {
	
	TreeMap<Integer,Float> deathNaturalCausesProbability = new TreeMap<Integer,Float>();
	TreeMap<Integer,Float> disabilityNaturalCausesProbability = new TreeMap<Integer,Float>();
	TreeMap<Integer,Float> deathAccidentProbability = new TreeMap<Integer,Float>();
	TreeMap<Integer,Float> disabilityAccidentProbability = new TreeMap<Integer,Float>();
	SQLServerDataSource serverDataSource;
	Connection connection;
	String NCsqlQuery;
	String AsqlQuery;
	Statement NCstatement;
	Statement Astatement;
	ResultSet NCresultSet;
	ResultSet AresultSet;
	
	public DataBaseConnection() throws SQLException{
		serverDataSource = new SQLServerDataSource();
		serverDataSource.setIntegratedSecurity(true);
		serverDataSource.setPortNumber(1433); 
		serverDataSource.setDatabaseName("InsuranceData");
		connection = serverDataSource.getConnection();
		NCsqlQuery = "SELECT * FROM LifeInsuranceNCProbability";
		AsqlQuery =  "SELECT * FROM LifeInsuranceAProbability";
		NCstatement = connection.createStatement();
		Astatement = connection.createStatement();
		NCresultSet = NCstatement.executeQuery(NCsqlQuery);
		AresultSet = Astatement.executeQuery(AsqlQuery);
	}

	public TreeMap<Integer, Float> getDeathNaturalCausesProbability() {
		return deathNaturalCausesProbability;
	}

	public void setDeathNaturalCausesProbability() throws SQLException {
		while(NCresultSet.next()){
			deathNaturalCausesProbability.put(NCresultSet.getInt("Age"), NCresultSet.getFloat("DeathProbability"));
		}
	}

	public TreeMap<Integer, Float> getDisabilityNaturalCausesProbability() {
		return disabilityNaturalCausesProbability;
	}

	public void setDisabilityNaturalCausesProbability() throws SQLException {
		while(NCresultSet.next()){
			disabilityNaturalCausesProbability.put(NCresultSet.getInt("Age"), NCresultSet.getFloat("DisabilityProbability"));
		}
	}

	public TreeMap<Integer, Float> getDeathAccidentProbability() {
		return deathAccidentProbability;
	}

	public void setDeathAccidentProbability() throws SQLException {
		while(AresultSet.next()){
			deathAccidentProbability.put(AresultSet.getInt("Age"), AresultSet.getFloat("DeathProbability"));
		}
	}

	public TreeMap<Integer, Float> getDisabilityAccidentProbability() {
		return disabilityAccidentProbability;
	}

	public void setDisabilityAccidentProbability() throws SQLException {
		while(AresultSet.next()){
			disabilityAccidentProbability.put(AresultSet.getInt("Age"), AresultSet.getFloat("DisabilityProbability"));
		}
	}
}
