package training;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by ChristinaAntoniuk on 28-Nov-16.
 */
public class DisabilityDataBaseBuilder extends DataBaseBuilder {

    SQLServerDataSource serverDataSource = new SQLServerDataSource();
    Connection connection;
    Statement naturalCausesStatement;
    Statement accidentStatement;
    ResultSet naturalCausesResultSet;
    ResultSet accidentResultSet;


    public DisabilityDataBaseBuilder() {
        try {
            serverDataSource.setIntegratedSecurity(true);
            serverDataSource.setPortNumber(1433);
            serverDataSource.setDatabaseName("InsuranceData");
            connection = serverDataSource.getConnection();
            naturalCausesStatement = connection.createStatement();
            accidentStatement = connection.createStatement();
            naturalCausesResultSet = naturalCausesStatement.executeQuery(naturalCausesSqlQuery);
            accidentResultSet = accidentStatement.executeQuery(accidentSqlQuery);
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void buildAccidentProbability() {
        SortedMap<Integer,Float> accidentProbability = new TreeMap<>();
        try {
            while(accidentResultSet.next()){
                accidentProbability.put(accidentResultSet.getInt("Age"),
                        accidentResultSet.getFloat("DisabilityProbability"));
            }
            dataBase.setAccidentProbability(accidentProbability);
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void buildNaturalCausesProbability() {
        SortedMap<Integer,Float> naturalCausesProbability = new TreeMap<>();
        try{
            while(naturalCausesResultSet.next()){
                naturalCausesProbability.put(naturalCausesResultSet.getInt("Age"),
                        naturalCausesResultSet.getFloat("DisabilityProbability"));
            }
            dataBase.setNaturalCausesProbability(naturalCausesProbability);
        } catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }
}
