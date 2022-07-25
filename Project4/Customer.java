
public class Customer {

	// Attributes
	String customerName;
	String customerSurname;
	int customerID;
	static int idCounter=1;

	// Constructor
	Customer(String inputName, String inputSurname) {		
		customerName = inputName;
		customerSurname = inputSurname;
		customerID = idCounter;
		idCounter++;
	}

	// Getters
	
	public String getName() {
		return customerName;
	}

	public String getSurname() {
		return customerSurname;
	}
	public int getCustomerID() {
		return customerID;
	}
	

	// Setters
	public void setName(String inputName) {
		customerName = inputName;
	}

	public void setSurname(String inputSurname) {
		customerSurname = inputSurname;
	}
}
