package training.model;

import training.model.entity.Derivative;

/**
 * Created by ChristinaAntoniuk on 28-Nov-16.
 */
public abstract class DerivativeBuilder {
    /**
     * Main insurance value.
     */
    public static final float LIFE_RATE = 100000f;
    /**
     * Specific coefficient, that uses in probability calculation.
     */
    public static final float RATE_COEFFICIENT = 100f;
    protected Derivative derivative = new Derivative();

    public Derivative getDerivative(){
        return derivative;
    }

    public abstract void buildPrice();
    public abstract void setNaturalCausesProbability();
    public abstract void setAccidentProbability();
}
