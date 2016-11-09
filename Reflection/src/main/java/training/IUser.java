package training;

import java.time.LocalDate;

/**
 * Created by Christina on 10-Nov-16.
 */
public interface IUser {

    LocalDate currentDate = LocalDate.now();

    String getName();
    String getSurname();
    String getPatronymic();
    String getPhoneNumber();
    LocalDate getDateOfBirth();

    void setName(String name);
    void setSurname(String surname);
    void setPatronymic(String patronymic);
    void setPhoneNumber(String phoneNumber);
    void setDateOfBirth(String dateOfBirth);
}
