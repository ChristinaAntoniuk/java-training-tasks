package training.validation.model;

/**
 * This class contains all information about user address
 * @author Christina
 * @version 1.0.0.0
 */
public class Address {
	private String postcode;
	private String city;
	private String street;
	private String homeNumber;
	private String apartmentNumber;
	private String fullAddress;
	
	public String getPostcode(){
		return postcode;
	}
	
	public String getCity(){
		return city;
	}
	
	public String getStreet(){
		return street;
	}
	
	public String getHomeNumber(){
		return homeNumber;
	}
	
	public String getApartmentNumber(){
		return apartmentNumber;
	}
	
	public void setPostcode(String postcode){
		this.postcode = postcode;
	}
	
	public void setCity(String city){
		this.city = city;
	}
	
	public void setStreet(String street){
		this.street = street;
	}
	
	public void setHomeNumber(String homeNumber){
		this.homeNumber = homeNumber;
	}
	
	public void setApartmentNumber(String apartmentNumber){
		this.apartmentNumber = apartmentNumber;
	}
	
	public void setFullAddress(){
		this.fullAddress = postcode +" "+ city +" "+ street +" "
    			+ homeNumber +" "+ apartmentNumber;
	}
	
    @Override
    public String toString() {
        return "POSTCODE = '" + postcode + '\'' +
                ", CITY ='" + city + '\'' +
                ", STREET ='" + street + '\'' +
                ", HOME NUMBER ='" + homeNumber + '\'' +
                ", APARTMENT NUMBER ='" + apartmentNumber + '\'' +
                ", FULL ADDRESS ='" + fullAddress + '\'';
    }
	
}
