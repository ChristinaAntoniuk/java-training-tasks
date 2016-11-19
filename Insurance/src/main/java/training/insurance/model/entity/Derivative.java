package training.insurance.model.entity;

/**
 * Class includes the information about all possible insurance types.
 */
public class Derivative {

	/**
	 * Main insurance value.
	 */
	public static final float LIFE_RATE = 100000f;
	/**
	 * Specific coefficient, that uses in probability calculation.
	 */
	public static final float RATE_COEFFICIENT = 100f;

	/**
	 * Derivative price, that includes prices of all insurance types.
	 */
	private float price;

	public float getPrice(){
		return price;
	}

	public void setPrice(float price){
			this.price += price;
	}
}
