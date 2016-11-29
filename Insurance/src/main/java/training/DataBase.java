package training;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by ChristinaAntoniuk on 29-Nov-16.
 */
public class DataBase {

    SortedMap<Integer,Float> naturalCausesProbability;
    SortedMap<Integer,Float> accidentProbability;

    public void setNaturalCausesProbability(SortedMap<Integer, Float> naturalCausesProbability) {
        this.naturalCausesProbability = naturalCausesProbability;
    }

    public void setAccidentProbability(SortedMap<Integer, Float> accidentProbability) {
        this.accidentProbability = accidentProbability;
    }

    public SortedMap<Integer, Float> getNaturalCausesProbability() {
        return naturalCausesProbability;
    }

    public SortedMap<Integer, Float> getAccidentProbability() {
        return accidentProbability;
    }
}
