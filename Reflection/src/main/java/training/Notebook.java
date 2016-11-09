package training;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by Christina on 08-Nov-16.
 */
public class Notebook extends Date {

    private String name;
    private String surname;
    private String patronymic;
    private String phoneNumber;
    private LocalDate dateOfBirth;

    /**
     * Formatter for getting user's birthday date in the right format.
     */
    DateTimeFormatter formatter;

    /**
     * Constructor that creates the pattern for setting user's birthday date in LocalDate format.
     */
    public Notebook() {
        formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
        dateOfBirth = LocalDate.of(1970, 1, 1);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = LocalDate.parse(dateOfBirth, formatter);
    }

    /**
     * Method counts the days before the user's birthday.
     *
     * @return
     */
    @MethodInfo(comment = "Counts the days before the user's birthday")
    public int calculationOfDaysToTheBirth() {
        int daysToTheBirth;
        daysToTheBirth = super.getDate().getDayOfYear() - dateOfBirth.getDayOfYear();
        if (super.getDate().isAfter(dateOfBirth)) {
            daysToTheBirth = 365 - daysToTheBirth;
        }
        return daysToTheBirth;
    }

    @Override
    @MethodInfo(comment = "Overrides of toString() method")
    public String toString() {
        return "Notebook{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
