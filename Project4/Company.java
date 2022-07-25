import java.util.Random;

public class Company {
	// Attributes
	public Office[] offices;
	public Customer[] customers;
	public Car_Request[] carrequests;
	public Contract[] contracts;
	public Car[] cars;
	public Employee[] employees;
	public static int cEmp = 0;
	public static int cCar = 0;
	public static int count2 = 0;
	public static int count = 0;
	public static int cCarReq = 0;
	public static int cCont = 0;
	public int[] f_car;
	public int[] f_car_class = { 0, 0, 0 };
	public int[] f_car_profit;
	public int[] f_class_profit = { 0, 0, 0 };
	public int[] f_rent_day = { 0, 0, 0, 0 };
	public int[] f_customer;
	public int[] f_employee;
	// Constructor
	public Company() {
		offices = new Office[50];
		count = 0;
		customers = new Customer[300];
		count2 = 0;
		carrequests = new Car_Request[500];
		cCarReq = 0;
		contracts = new Contract[500];
		cCont = 0;
		employees = new Employee[200];
		cars = new Car[200];
		cEmp = 0;
		cCar = 0;
		f_car = new int[100];
		f_car_profit = new int[100];
		f_customer = new int[100];
		f_employee = new int[100];
		for(int i=0;i<100;i++) {
			f_car[i]=0;
			f_car_profit[i]=0;
			f_customer[i]=0;
			f_employee[i]=0;
		}	
	}

	public void statistics(int offID) {
		for (int i = 0; i < cCont; i++) {
			 if(cars[contracts[i].getCarID() - 1]!=null&&cars[contracts[i].getCarID() - 1].getOfficeID()==offID&&offices[offID-1]!=null) {
			f_car[contracts[i].getCarID() - 1]++; // Most Rented Car
			f_employee[contracts[i].getEmployeeID() - 1]++; // most rent emp
			f_customer[contracts[i].getCustomerID() - 1]++; // most rent cust
			// Most Rented Class
			if (cars[contracts[i].getCarID() - 1].getCarClass().equals("economy"))
				f_car_class[0]++;
			else if (cars[contracts[i].getCarID() - 1].getCarClass().equals("sports"))
				f_car_class[1]++;
			else if (cars[contracts[i].getCarID() - 1].getCarClass().equals("luxury"))
				f_car_class[2]++;
			// Most Rent Day
			if ((contracts[i].getEndDate().getDay() - contracts[i].getStartDate().getDay()) == 0)
				f_rent_day[0]++;
			else if ((contracts[i].getEndDate().getDay() - contracts[i].getStartDate().getDay()) == 1)
				f_rent_day[1]++;
			else if ((contracts[i].getEndDate().getDay() - contracts[i].getStartDate().getDay()) == 2)
				f_rent_day[2]++;
			else if ((contracts[i].getEndDate().getDay() - contracts[i].getStartDate().getDay()) == 3)
				f_rent_day[3]++;
			}	
		}
		// Car Profit and Class Profit
		for (int j = 0; j < 100; j++) {
			if (cars[j]!=null&&cars[j].getOfficeID()==offID&&f_car[j] != 0&&cars[j].getOfficeID()==offID&&offices[offID-1]!=null) {
				if (cars[j].getCarClass().equals("economy")) {
					f_class_profit[0] += 100;
					f_car_profit[j] += 100;
				}
				if (cars[j].getCarClass().equals("sports")) {
					f_car_profit[j] += 200;
					f_class_profit[1] +=200;
				}
				if (cars[j].getCarClass().equals("luxury")) {
					f_car_profit[j] +=300;
					f_class_profit[2] +=300;
				}
			}
		}
		
	}

	public Office[] getOffices() {
		return offices;
	}

	public void setOffices(Office[] offices) {
		this.offices = offices;
	}

	public Customer[] getCustomers() {
		return customers;
	}

	public void setCustomers(Customer[] customers) {
		this.customers = customers;
	}

	public Car_Request[] getCarrequests() {
		return carrequests;
	}

	public void setCarrequests(Car_Request[] carrequests) {
		this.carrequests = carrequests;
	}

	public Contract[] getContracts() {
		return contracts;
	}

	public void setContracts(Contract[] contracts) {
		this.contracts = contracts;
	}

	public Car[] getCars() {
		return cars;
	}

	public void setCars(Car[] cars) {
		this.cars = cars;
	}

	public Employee[] getEmployees() {
		return employees;
	}

	public void setEmployees(Employee[] employees) {
		this.employees = employees;
	}

	public static int getcEmp() {
		return cEmp;
	}

	public static void setcEmp(int cEmp) {
		Company.cEmp = cEmp;
	}

	public static int getcCar() {
		return cCar;
	}

	public static void setcCar(int cCar) {
		Company.cCar = cCar;
	}

	public static int getCount2() {
		return count2;
	}

	public static void setCount2(int count2) {
		Company.count2 = count2;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Company.count = count;
	}

	public static int getcCarReq() {
		return cCarReq;
	}

	public static void setcCarReq(int cCarReq) {
		Company.cCarReq = cCarReq;
	}

	public static int getcCont() {
		return cCont;
	}

	public static void setcCont(int cCont) {
		Company.cCont = cCont;
	}

	public void addContract(Contract ct) {
		contracts[cCont] = ct;
		cCont++;
	}

	public void addOffice(Office o) {
		offices[count] = o;
		count++;
	}

	public void addCarRequest(Car_Request cr) {
		carrequests[cCarReq] = cr;
		cCarReq++;
	}

	public void listCarRequest() {
		if (cCarReq == 0)
			System.out.println("Error: There are no contracts");
		else {
			for (int i = 0; i < cCarReq; i++) {
				{
					System.out.println("    " + (i + 1) + ". CarRequest" + ";" + carrequests[i].getRequestOfficeID()
							+ ";" + carrequests[i].getRequestCustomerID() + ";" + carrequests[i].getRequestBrand() + ";"
							+ carrequests[i].getRequestModel() + ";" + carrequests[i].getRequestClass() + ";"
							+ carrequests[i].getRequestStartDate() + ";" + carrequests[i].getRequestEndDate());
				}
			}
		}
	}

	public void listContract() {
		if (cCont == 0)
			System.out.println("Error: There are no contracts");
		else {
			for (int i = 0; i < cCont; i++) {
				{
					System.out.println("    " + (i + 1) + ". Contract" + ";" + "Employee" + contracts[i].getEmployeeID()
							+ ";" + "Customer" + contracts[i].getCustomerID() + ";" + "Car" + contracts[i].getCarID()
							+ ";" + contracts[i].getStartDate() + ";" + contracts[i].getEndDate());
				}
			}
		}
	}

	// listOffice
	public void listOffice() {
		if (count == 0)
			System.out.println("There no office available");
		else {
			for (int i = 0; i < count; i++) {
				if (offices[i] != null) {
					System.out.println("    " + (i + 1) + ". Office" + ";" + offices[i].getPhoneNumber() + ";"
							+ offices[i].getAddress() + ";" + offices[i].getCity());
				}
			}
		}
	}

	public int GenerateRandomCustomer() {
		Random rand = new Random();
		int rC = rand.nextInt(count2);
		return customers[rC].getCustomerID();
	}

	public boolean lO(int OfficeID) {
		if (offices[OfficeID - 1] == null)
			return false;
		else
			return true;
	}

	public void addCustomer(Customer c) {
		customers[count2] = c;
		count2++;
	}

	// ListCustomer
	public void listCustomer() {
		if (count2 == 0)
			System.out.println("There no customer available");
		else {
			for (int i = 0; i < count2; i++) {
				System.out.println("    " + (i + 1) + ". Customer" + ";" + customers[i].getName() + ";"
						+ customers[i].getSurname());
			}
		}
	}

	// deleteOffice
	public void deleteOffice(int officeID) {
		if (((officeID - 1) > count) || ((officeID - 1) < 0)) {
			System.out.println("The office ID you entered is wrong!!");
		} else {
			offices[officeID - 1] = null;
			System.out.println("Office " + officeID + " successfully deleted");
		}
	}

	public String[] CarAvailable(Car_Request c) {
		String[] ret = { "false", "false" };
		int ind = -1;
		for (int i = 0; i < cCar; i++) {
			if (cars[i] != null && cars[i].getOfficeID() == c.getRequestOfficeID()) {
				if (c.getRequestBrand().equals(cars[i].getCarBrand())
						&& c.getRequestClass().equals(cars[i].getCarClass())
						&& c.getRequestModel().equals(cars[i].getCarModel())) {
					if (cars[i].getCarAv()) {
						ret[0] = "true;" + cars[i].getCarID();
						ind = i;
						break;
					} else
						ret[0] = "Err3";
				} else if (c.requestBrand.equals("*") && c.requestModel.equals("*")) {
					if (c.getRequestClass().equals(cars[i].getCarClass())) {
						if (cars[i].getCarAv()) {
							ret[0] = "true;" + cars[i].getCarID();
							ind = i;
							break;
						} else
							ret[0] = "Err3";
					}
				} else if (c.requestClass.equals("*") && c.requestModel.equals("*")) {
					if (c.getRequestBrand().equals(cars[i].getCarBrand())) {
						if (cars[i].getCarAv()) {
							ret[0] = "true;" + cars[i].getCarID();
							ind = i;
							break;
						} else
							ret[0] = "Err3";
					}
				}
			}
		}
		for (int j = 0; j < cEmp; j++) {
			if (employees[j] != null && ind != -1 && employees[j].getDailyCont() == false
					&& employees[j].getOfficeID() == c.getRequestOfficeID()) {
				ret[1] = "true;" + employees[j].getEmployeeID();
				employees[j].setDailyCont(true);
				cars[ind].setCarAv(false);
				break;
			} else {
				ret[1] = "error2";
			}
		}
		return ret;
	}

	public String EmplooyeeAvailable(Car_Request c) {
		String ret = "*";
		for (int j = 0; j < cEmp; j++) {
			if (employees[j] != null && employees[j].getDailyCont() == false
					&& employees[j].getOfficeID() == c.getRequestOfficeID()) {
				ret = "true;" + employees[j].getEmployeeID();
				employees[j].setDailyCont(true);
				break;
			} else
				ret = "error2";
		}
		return ret;
	}

	public Car GenerateRandomCar(int OfID, String cl) {
		boolean bl = false;
		boolean bl1 = false;
		boolean bl2 = false;
		int c = 0;
		int c2 = 0;
		int c3 = 0;
		int c4 = 0;
		int[] arr1 = new int[500];
		int[] arr2 = new int[500];
		int[] arr3 = new int[500];
		int[] arr4 = new int[500];
		Random rand = new Random();
		for (int i = 0; i < cCar; i++) {
			if (cars[i] != null && cars[i].getCarAv()) {
				if (cars[i].getOfficeID() == OfID && cars[i].getCarClass().equals(cl)) {
					arr1[c] = i;
					c++;
				} else if (OfID == -1 && cl.equals("*")) {
					bl = true;
					arr2[c2] = i;
					c2++;
				} else if (OfID == -1 && cars[i].getCarClass().equals(cl)) {
					bl1 = true;
					arr3[c3] = i;
					c3++;
				} else if (cars[i].getOfficeID() == OfID && cl.equals("*")) {
					bl2 = true;
					arr4[c4] = i;
					c4++;
				}
			}
		}
		if (bl) {
			int rC = rand.nextInt(c2);
			return cars[arr2[rC]];
		} else if (bl1) {
			int rC = rand.nextInt(c3);
			return cars[arr3[rC]];
		} else if (bl2) {
			int rC = rand.nextInt(c4);
			return cars[arr4[rC]];
		} else {
			int rC = rand.nextInt(c);
			return cars[arr1[rC]];
		}
	}

	public boolean addEmp(int OfficeID) {
		int count = 0;
		for (int i = 0; i < cEmp; i++) {
			if (employees[i].getOfficeID() == OfficeID)
				count++;
		}
		if (count < 3)
			return true;
		else
			return false;

	}

	// addEmployee
	public void addEmployee(Employee e) {
		employees[cEmp] = e;
		cEmp++;
	}

	// listEmployee
	public void listEmployee(int OfficeID) {

		if (cEmp == 0)
			System.out.println("There no employee available");
		else {
			for (int i = 0; i < cEmp; i++) {
				if (employees[i].getOfficeID() == OfficeID) {
					System.out.println("    " + (i + 1) + ". Employee" + ";" + employees[i].getFirstName() + ";"
							+ employees[i].getLastName() + ";" + employees[i].getGender() + ";"
							+ employees[i].getBirthDate());
				}
			}
		}
	}

	// deleteEmployee
	public void deleteEmployee(int officeID, int employeeID) {
		employees[employeeID - 1] = null;
		System.out.println("Employee " + employeeID + " successfully deleted");
	}

	public void deleteEmpOf(int officeID) {
		for (int i = 0; i < cEmp; i++) {
			if (employees[i] != null && employees[i].getOfficeID() == officeID)
				employees[i] = null;
		}
	}

	// addCar
	public void addCar(Car c) {
		cars[cCar] = c;
		cCar++;
	}

	// listCar
	public void listCar(int OfficeID) {
		if (cCar == 0)
			System.out.println("There no car available");
		else {
			for (int i = 0; i < cCar; i++) {
				if (cars[i].getOfficeID() == OfficeID) {
					System.out.println("    " + (i + 1) + ". Car" + ";" + cars[i].getCarBrand() + ";"
							+ cars[i].getCarModel() + ";" + cars[i].getCarClass() + ";" + cars[i].getCarKilometers()
							+ ";" + cars[i].getOfficeID());
				}
			}
		}
	}

	// OfficeIncome
	public Car[] rented_car_off(int offID) {
		Car[] in_cars = new Car[100];
		int count = 0;
		for (int i = 0; i < cCar; i++) {
			if (cars[i] != null && cars[i].getCarAv() == false && cars[i].getOfficeID() == offID) {
				in_cars[count] = cars[i];
				count++;
			}
		}
		return in_cars;
	}

	public int office_income(Car[] c) {
		int off_income = 0;
		for (int i = 0; i < 100; i++) {
			if (c[i] != null)
				off_income += c[i].getCar_Cost();
		}
		return off_income;
	}

	// OfficeExpenses
	/*
	 * public int allexpenses(int offID) { return (c_m_off(offID) +
	 * employeeSalary(offID) + EmployeeBonus(offID) + offices[offID - 1].getRent());
	 * }
	 */

	// CarMaintenance
	public int car_maintenance(Car[] c) {
		int c_m_off = 0;
		for (int i = 0; i < cCar; i++) {
			if (c[i] != null) {
				c_m_off += c[i].getCarMaintenance();
			}
		}
		return c_m_off;
	}

	public int getOfficeRent(int offID) {
		return offices[offID - 1].getRent();
	}

	// EmployeesExpenseforOffice
	public int employeeSalary(int offID) {
		int expense = 0;
		for (int i = 0; i < cEmp; i++) {
			if (employees[i].getOfficeID() == offID) {
				expense += 30;
			}
		}
		return expense;
	}

	// EmployeeBonus
	public int EmployeeBonus(int offID, Date cur_date) {
		int bonus = 0;
		for (int i = 0; i < cCont; i++) {
			if (cars[contracts[i].getCarID() - 1].getOfficeID() == offID
					&& contracts[i].getStartDate().getDay() == cur_date.getDay()
					&& contracts[i].getStartDate().getMonth() == cur_date.getMonth()
					&& contracts[i].getStartDate().getYear() == cur_date.getYear()) {
				if (cars[contracts[i].getCarID() - 1].getCar_Cost() == 100) {
					bonus += 5;
				} else if (cars[contracts[i].getCarID() - 1].getCar_Cost() == 200) {
					bonus += 10;
				} else if (cars[contracts[i].getCarID() - 1].getCar_Cost() == 300) {
					bonus += 15;
				}
			}
		}
		return bonus;
	}

	public void setCarKM() {
		int[] randKM = { 100, 200, 300 };
		Random rand = new Random();
		for (int i = 0; i < cCar; i++) {
			if (cars[i] != null && cars[i].getCarAv() == false) {
				int RN = rand.nextInt(3);
				cars[i].setCarKilometers(randKM[RN]);
			}
		}
	}
	// MostRentedCar
	/*
	 * public void mostRentedCar(int offID) { int mostCar = -1; int carCounter = 0;
	 * for (int i = 0; i < cCont; i++) { if (contracts[i] != null &&
	 * contracts[i].getofficeID() == offID) { if (contracts[i].getCarID()) { // Most
	 * rented car == Model
	 * 
	 * } } } }
	 * 
	 * // MostRentedClass public void mostRentedClass(int offID) { int mostClass =
	 * -1; int carClassCounter = 0;
	 * 
	 * for (int i = 0; i < cCont; i++) { if (contracts[i] != null &&
	 * contracts[i].getofficeID() == offID) { if (contracts[i].get) { // Most rented
	 * car class == Class
	 * 
	 * } } } }
	 */

	// MostRenterCustomer
	/*
	 * public void mostRenterCustomer(int offID, int customerID) { int mostClass =
	 * -1; int carClassCounter = 0;
	 * 
	 * for (int i = 0; i < cCont; i++) { if (contracts[i] != null &&
	 * contracts[i].getOfficeID() == offID) { if (contracts[i] != null &&
	 * contracts[i].getEmployeeID() == employeeID) {
	 * 
	 * } } } }
	 */

	// MostRenterEmployee
	/*
	 * public void mostRenterEmployee(int offID, int employeeID) { int mostClass =
	 * -1; int carClassCounter = 0;
	 * 
	 * for (int i = 0; i < cCont; i++) { if (contracts[i] != null &&
	 * contracts[i].getofficeID() == offID) { if (contracts[i] != null &&
	 * contracts[i].getEmployeeID() == employeeID) {
	 * 
	 * } } } }
	 */

}
