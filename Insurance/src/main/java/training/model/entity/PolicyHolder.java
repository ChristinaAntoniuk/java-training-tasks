package training.model.entity;

/**
 * Created by ChristinaAntoniuk on 28-Nov-16.
 */
/**
 * Class describes information about policy holder.
 */
public class PolicyHolder {
    /**
     * Age of policy holder.
     */
    private int age;

    public PolicyHolder(int age){
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
