
public class Contract {
	
	//Attributes
	int contractID;
	int idCounter=1;
	int customerID;
	int carID;
	int employeeID;
	Date startDate;
	Date endDate;
	public Contract(int EmployeeID,int customerID, int carID, Date startDate, Date endDate) {	
		this.contractID = idCounter;
		idCounter++;
		this.customerID = customerID;
		this.carID = carID;
		this.startDate = startDate;
		this.endDate = endDate;
		this.employeeID = EmployeeID;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public int getContractID() {
		return contractID;
	}
	public void setContractID(int contractID) {
		this.contractID = contractID;
	}
	public int getIdCounter() {
		return idCounter;
	}
	public void setIdCounter(int idCounter) {
		this.idCounter = idCounter;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public int getCarID() {
		return carID;
	}
	public void setCarID(int carID) {
		this.carID = carID;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
}
