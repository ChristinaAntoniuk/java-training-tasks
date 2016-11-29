package training;

import java.util.SortedMap;

/**
 * Created by ChristinaAntoniuk on 28-Nov-16.
 */
public abstract class DataBaseBuilder {

    public static final String naturalCausesSqlQuery = "SELECT * FROM LifeInsuranceNCProbability";
    public static final String accidentSqlQuery = "SELECT * FROM LifeInsuranceAProbability";
    protected DataBase dataBase = new DataBase();

    public DataBase getDataBase(){
        return dataBase;
    }

    public abstract void buildAccidentProbability();
    public abstract void buildNaturalCausesProbability();

}
