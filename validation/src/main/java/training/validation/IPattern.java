package training.validation;
/**
 * There are all patterns for the data
 * @author Christina
 * @version 1.0.0.0
 */
public interface IPattern {
	String NAME_PATTERN = "^[A-Za-z--]{2,30}$";
	String NICKNAME_PATTERN = "^[A-Za-z0-9_-]{3,15}$";
    String PHONE_PATTERN = "^[0-9]{12}$";
    String MAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    String POSTCODE_PATTERN = "^[0-9]{5}$";
    String GROUP_PATTERN = "^(FIRST|SECOND|THIRD|FOURTH|FIFTH){1,5}$";
    String ANSWER_PATTERN = "^(y|n)$";
    String NUMBER_PATTERN = "^[0-9]{1,3}$";
}
