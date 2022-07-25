
public class Office {
	// Attributes

	private String phoneNumber;
	private String address;
	private String city;
	private int Rent;
	private final int r=100;
	public Office(String inputPhoneNumber, String inputOfficeAddress, String inputCity) {

		this.phoneNumber = inputPhoneNumber;
		this.address = inputOfficeAddress;
		this.city = inputCity;
		this.Rent = r;
	}
	public int getRent() {
		return Rent;
	}
	// Getters
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	// Setters

	public void setPhoneNumber(String inputPhoneNumber) {
		this.phoneNumber = inputPhoneNumber;
	}

	public void setOfficeAddress(String inputOfficeAddress) {
		this.address = inputOfficeAddress;
	}

	public void setCity(String inputCity) {
		this.city = inputCity;
	}

}
