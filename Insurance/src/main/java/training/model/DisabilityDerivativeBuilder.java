package training.model;

import training.DataBaseBuilder;
import training.DisabilityDataBaseBuilder;
import training.model.entity.PolicyHolder;

/**
 * Created by ChristinaAntoniuk on 28-Nov-16.
 */
public class DisabilityDerivativeBuilder extends DerivativeBuilder {
    private DataBaseBuilder dataBaseBuilder = new DisabilityDataBaseBuilder();
    private float naturalCausesProbability;
    private float accidentProbability;
    private int age;

    public DisabilityDerivativeBuilder(PolicyHolder policyHolder){
        this.age = policyHolder.getAge();
        dataBaseBuilder.buildNaturalCausesProbability();
        dataBaseBuilder.buildAccidentProbability();
    }

    @Override
    public void setNaturalCausesProbability() {
        for (int age : dataBaseBuilder.getDataBase().getNaturalCausesProbability().keySet()){
            if (this.age <= age){
                this.naturalCausesProbability = dataBaseBuilder.getDataBase().getNaturalCausesProbability().get(age);
                break;
            }
            this.naturalCausesProbability = dataBaseBuilder.getDataBase().getNaturalCausesProbability().get(age);
        }
    }

    @Override
    public void setAccidentProbability() {
        for (int age : dataBaseBuilder.getDataBase().getAccidentProbability().keySet()){
            if (this.age <= age){
                this.accidentProbability = dataBaseBuilder.getDataBase().getAccidentProbability().get(age);
                break;
            }
            this.accidentProbability = dataBaseBuilder.getDataBase().getAccidentProbability().get(age);
        }
    }

    @Override
    public void buildPrice() {
        derivative.setPrice(LIFE_RATE - (LIFE_RATE * (naturalCausesProbability + accidentProbability) * RATE_COEFFICIENT));
    }
}
