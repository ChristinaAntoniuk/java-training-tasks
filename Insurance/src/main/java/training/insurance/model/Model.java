package training.insurance.model;

import training.insurance.model.entity.Death;
import training.insurance.model.entity.Derivative;
import training.insurance.model.entity.Disability;
import training.insurance.model.entity.PolicyHolder;

import java.sql.SQLException;
import java.util.Collections;
import java.util.TreeMap;

/**
 * Created by ChristinaAntoniuk on 18-Nov-16.
 */
public class Model {

    /**
     * Field, which contains all possible probabilities.
     */
    private TreeMap<Float, String> allProbabilities;


    public Model(){
        allProbabilities = new TreeMap<>(Collections.reverseOrder());
    }

    public void createSortedProbabilities(float probability, String name){
        this.allProbabilities.put(probability,name);
    }

    public float getMaxProbability(){
        return allProbabilities.firstKey();
    }

    public float getMinProbability(){ return allProbabilities.lastKey(); }

    public TreeMap<Float, String> getAllProbabilities() {
        return allProbabilities;
    }
}
