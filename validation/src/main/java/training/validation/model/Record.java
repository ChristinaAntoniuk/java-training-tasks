package training.validation.model;
import training.validation.model.Address;
import training.validation.model.Group;

import java.time.LocalDateTime;

/**
 * This class describes all parameters of one record in our notebook
 * @author Christina
 * @version 1.0.0.0
 */
public class Record {
	private String surname;
	private String name;
	private String patronymic;
	private String nickname;
	private String comment;
	private Group group;
	private String mobilePhone;
	private String homePhone;
	private String additionallyPhone;
	private String email;
	private String skype;
	private Address address;
    private LocalDateTime dateOfCreating;
    private LocalDateTime dateOfUpdating;
    
    //Output parameter
    private String shortName;
    
    
    public Record(Group group, Address address){
    	this.group = group;
    	this.address = address;
    }
    
    public void setSurname(String surname){
    	this.surname = surname;
    }
    
    public void setName(String name){
    	this.name = name;
    }
    
    public void setPatronymic(String patronymic){
    	this.patronymic = patronymic;
    }
    
    public void setNickname(String nickname){
    	this.nickname = nickname;
    }
    
    public void setComment(String comment){
    	this.comment = comment;
    }
    
    public void setGroup(Group group){
    	this.group = group;
    }
    
    public void setMobilePhone(String mobilePhone){
    	this.mobilePhone = mobilePhone;
    }
    
    public void setHomePhone(String homePhone){
    	this.homePhone = homePhone;
    }
    
    public void setAdditionallyPhone(String additionallyPhone){
    	this.additionallyPhone = additionallyPhone;
    }
    
    public void setEmail(String email){
    	this.email = email;
    }
    
    public void setSkype(String skype){
    	this.skype = skype;
    }
    
    public void setAddress(Address address){
    	this.address = address;
    }
    
    public void setDateOfCreating(){
    	this.dateOfCreating = LocalDateTime.now();
    }
    
    public void setDateOfUpdating(){
    	this.dateOfUpdating = LocalDateTime.now();
    }
    
    public void setShortName(){
    	this.shortName = surname + " "+ name.charAt(0) + ".";
    }
    
    @Override
    public String toString() {
        return "Record{" +
                "SURNAME = '" + surname + '\'' +
                ", NAME ='" + name + '\'' +
                ", PATRONYMIC ='" + patronymic + '\'' +
                ", SHORT NAME ='" + shortName + '\'' +
                ", NICKNAME ='" + nickname + '\'' +
                ", COMMENT ='" + comment + '\'' +
                ", GROUP =" + group +
                ", HOME PHONE ='" + homePhone + '\'' +
                ", MOBILE PHONE ='" + mobilePhone + '\'' +
                ", ADDITIONALLY PHONE ='" + additionallyPhone + '\'' +
                ", EMAIL ='" + email + '\'' +
                ", SKYPE ='" + skype + '\'' +
                ", ADDRESS =" + address +
                ", DATE OF CREATING =" + dateOfCreating +
                ", DATE OF UPDATING =" + dateOfUpdating +
                '}';
    }
}
