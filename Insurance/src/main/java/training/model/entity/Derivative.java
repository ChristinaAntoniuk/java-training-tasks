package training.model.entity;

/**
 * Class includes the information about all possible insurance types.
 */
public class Derivative {
    /**
     * Derivative price, that includes prices of all insurance types.
     */
    private float price;

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }
}
