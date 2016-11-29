package training.model;

import training.model.entity.PolicyHolder;


/**
 * Created by ChristinaAntoniuk on 28-Nov-16.
 */
public class Model {

    private DerivativeBuilder deathDerivativeBuilder;
    private DerivativeBuilder disabilityDerivativeBuilder;
    private float derivativePrice;
    private float deathDerivativePrice;
    private float disabilityDerivativePrice;

    public Model(PolicyHolder policyHolder){

        deathDerivativeBuilder = new DeathDerivativeBuilder(policyHolder);
        disabilityDerivativeBuilder = new DisabilityDerivativeBuilder(policyHolder);
        deathDerivativeBuilder.setAccidentProbability();
        deathDerivativeBuilder.setNaturalCausesProbability();
        deathDerivativeBuilder.buildPrice();
        disabilityDerivativeBuilder.setAccidentProbability();
        disabilityDerivativeBuilder.setNaturalCausesProbability();
        disabilityDerivativeBuilder.buildPrice();
    }

    public float getDerivativePrice() {
        return derivativePrice;
    }

    public void setDerivativePrice() {
        this.derivativePrice = deathDerivativePrice + disabilityDerivativePrice;
    }

    public float getDeathDerivativePrice() {
        return deathDerivativePrice;
    }

    public void setDeathDerivativePrice() {
        this.deathDerivativePrice = deathDerivativeBuilder.getDerivative().getPrice();
    }

    public float getDisabilityDerivativePrice() {
        return disabilityDerivativePrice;
    }

    public void setDisabilityDerivativePrice() {
        this.disabilityDerivativePrice = disabilityDerivativeBuilder.getDerivative().getPrice();
    }
}
