package training;

import java.time.LocalDate;

/**
 * Created by Christina on 08-Nov-16.
 */
public class Date {

    private LocalDate currentDate;

    /**
     * Constructor that sets the current date to the currentDate variable.
     */
    public Date() {
        currentDate = LocalDate.now();
    }

    @MethodInfo(comment = "Gets the current value of date")
    public LocalDate getDate() {
        return currentDate;
    }

    @Override
    @MethodInfo(comment = "Overrides of toString() method")
    public String toString() {
        return "Date{" +
                "currentDate=" + currentDate +
                '}';
    }
}
