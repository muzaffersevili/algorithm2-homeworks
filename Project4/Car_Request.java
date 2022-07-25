
public class Car_Request {

	// Attributes
	 int requestOfficeID;
	 int requestCustomerID;
	String requestBrand;
	String requestModel;
	String requestClass;
	Date requestStartDate;
	Date requestEndDate;

	// Constructor
	Car_Request(int inputRequestOfficeID, int inputRequestCustomerID, String Brand, String Model, String Class, Date StartDate,
			Date EndDate) {
		requestOfficeID = inputRequestOfficeID;
		requestCustomerID = inputRequestCustomerID;
		requestStartDate=StartDate;
		requestEndDate=EndDate;
		requestBrand = Brand;
		requestModel = Model;
		requestClass = Class;
	}
	
	// Getters
	
	public String getRequestBrand() {
		return requestBrand;
	}

	public  int getRequestOfficeID() {
		return requestOfficeID;
	}

	public void setRequestOfficeID(int irequestOfficeID) {
		requestOfficeID = irequestOfficeID;
	}

	public  int getRequestCustomerID() {
		return requestCustomerID;
	}

	public  void setRequestCustomerID(int irequestCustomerID) {
		requestCustomerID = irequestCustomerID;
	}

	public Date getRequestStartDate() {
		return requestStartDate;
	}

	public void setRequestStartDate(Date requestStartDate) {
		this.requestStartDate = requestStartDate;
	}

	public Date getRequestEndDate() {
		return requestEndDate;
	}

	public void setRequestEndDate(Date requestEndDate) {
		this.requestEndDate = requestEndDate;
	}

	public String getRequestModel() {
		return requestModel;
	}

	public String getRequestClass() {
		return requestClass;
	}

	// Setters	
	public void setRequestBrand(String inputRbrand) {
		requestBrand = inputRbrand;
	}

	public void setRequestModel(String inputRmodel) {
		requestModel = inputRmodel;
	}

	public void setRequestClass(String inputRclass) {
		requestClass = inputRclass;
	}

}
