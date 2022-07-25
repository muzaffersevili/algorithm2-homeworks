public class Employee {

	private String firstName;
	private String lastName;
	private String birthDate;
	private String gender;
	private int OfficeID;
    private int EmployeeID;
    private static int idCounter=1;
    private boolean DailyCont;
    private boolean DC = false;
	public Employee(String firstName, String lastName, String birthDate, String gender, int OfficeID) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.gender = gender;
		this.OfficeID = OfficeID;
		this.EmployeeID=idCounter;
		this.DailyCont= DC;
		idCounter++;
	}
	public boolean getDailyCont() {
		return DailyCont;
	}
	public void setDailyCont(boolean dailyCont) {
		DailyCont = dailyCont;
	}
	//get
	public int getEmployeeID() {
		return EmployeeID;
	}
	public String getGender() {
		return gender;
	}

	public int getOfficeID() {
		return OfficeID;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	// set
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}