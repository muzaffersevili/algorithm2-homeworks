import java.io.*;
import java.util.Scanner;
import java.io.IOException;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		Company comp = new Company();
		Date date = new Date(1,1,2021);
		Scanner scanner = new Scanner(System.in);
		while(true) {
		String cmd = scanner.nextLine(); 
		System.out.println(">>>"+cmd);
		String[] q = cmd.split(";");
		if(q[0].equals("load")) {
		try {
			FileInputStream fis = new FileInputStream(
					"D:\\Bussiness\\Eðitim\\Ceng 1\\CME 1252 PROJECT BASED LEARNING II\\Proje 1\\"+q[1]);
			Scanner scan = new Scanner(fis);		
			while (scan.hasNextLine()) {
				String str = scan.nextLine();
				System.out.println(">" + str);
				if (str.startsWith("addOffice") == true) {
					String[] i = str.split(";");
					Office off2 = new Office(i[1], i[2], i[3]);
					comp.addOffice(off2);

				} else if (str.startsWith("addEmployee") == true) {
					String[] i = str.split(";");
					if (comp.addEmp(Integer.parseInt(i[5]))) {
						Employee emp1 = new Employee(i[1], i[2], i[3], i[4], Integer.parseInt(i[5]));
						comp.addEmployee(emp1);
					} else
						System.out.println("You have already 3 employees in this office!");
				} else if (str.startsWith("addCustomer") == true) {
					String[] i = str.split(";");
					Customer cust = new Customer(i[1], i[2]);
					comp.addCustomer(cust);

				} else if (str.startsWith("addCarRequestRandom") == true) {
					String[] i = str.split(";");
					int end_d = date.getDay() + 3;
					Date startDate = new Date(date.getDay(), date.getMonth(), date.getYear());
					Date endDate = new Date(end_d, date.getMonth(), date.getYear());
					Car[] cr;
					cr = new Car[1];
					cr[0] = comp.GenerateRandomCar(Integer.parseInt(i[1]), i[2]);
					if (cr[0] != null) {
						int cID = comp.GenerateRandomCustomer();
						Car_Request crq = new Car_Request(Integer.parseInt(i[1]), cID, cr[0].getCarBrand(),
								cr[0].getCarModel(), i[2], startDate, endDate);
						comp.addCarRequest(crq);
						String EA = comp.EmplooyeeAvailable(crq);
						String[] k = EA.split(";");
						if (k[0].equals("true")) {
							cr[0].setCarAv(false);
							Contract ct = new Contract(Integer.parseInt(k[1]), cID, cr[0].getCarID(), startDate,
									endDate);
							comp.addContract(ct);
						} else
							System.out.println("Error: No employee available");
					} else
						System.out.println("Error: No car available");
				} else if (str.startsWith("addCarRequest") == true) {
					String[] i = str.split(";");
					Date StartDate = new Date(i[6]);
					Date EndDate = new Date(i[7]);
					Car_Request creq = new Car_Request(Integer.parseInt(i[1]), Integer.parseInt(i[2]), i[3], i[4], i[5],
							StartDate, EndDate);
					comp.addCarRequest(creq);
					if (StartDate.DateControl(StartDate, EndDate)) {
						String CA[] = comp.CarAvailable(creq);
						String[] j = CA[0].split(";");
						String[] k = CA[1].split(";");
						if (j[0].equals("true") && k[0].equals("true")) {
							int carID = Integer.parseInt(j[1]);
							Contract ct = new Contract(Integer.parseInt(k[1]), Integer.parseInt(i[2]), carID, StartDate,
									EndDate);
							comp.addContract(ct);
						} else if (j[0].equals("false"))
							System.out.println("Error:No Car");
						else if (j[0].equals("Err3"))
							System.out.println("Error: Car not avaiable");
						else if (k[0].equals("error2"))
							System.out.println("Error: No emplooyee available");
					} else
						System.out.println("Error:Car requests must be for 1-4 days");
				} else if (str.startsWith("listEmployee") == true) {

					String[] i = str.split(";");
					if (comp.lO(Integer.parseInt(i[1])))
						comp.listEmployee(Integer.parseInt(i[1]));

				} else if (str.startsWith("addCar") == true) {
					String[] i = str.split(";");
					Car car1 = new Car(i[1], i[2], i[3], Integer.parseInt(i[4]), Integer.parseInt(i[5]));
					comp.addCar(car1);
				} else if (str.startsWith("listCarRequest") == true) {
					comp.listCarRequest();
				} else if (str.startsWith("listCar") == true) {
					String[] i = str.split(";");
					comp.listCar(Integer.parseInt(i[1]));

				} else if (str.startsWith("deleteOffice") == true) {
					String[] i = str.split(";");
					comp.deleteOffice(Integer.parseInt(i[1]));
					comp.deleteEmpOf(Integer.parseInt(i[1]));

				} else if (str.startsWith("deleteEmployee") == true) {
					String[] i = str.split(";");
					comp.deleteEmployee(Integer.parseInt(i[1]), Integer.parseInt(i[2]));
				} else if (str.startsWith("listContracts") == true) {
					comp.listContract();
				}

				else if (str.startsWith("listOffice") == true) {
					comp.listOffice();
				} else if (str.startsWith("listCustomer") == true) {
					comp.listCustomer();
				} else if (str.startsWith("nextday")) {
					comp.setCarKM();
					System.out.println("--- Office Profits ---");
					for (int j = 0; j < Company.getCount(); j++) {
						Car[] c = comp.rented_car_off(j + 1);
						System.out.println("Office " + (j + 1) + " incomes " + comp.office_income(c));
						for (int k = 0; k < 100; k++) {
							if (c[k] != null) {
								System.out.println("    Car" + c[k].getCarID() + ":  " + c[k].getCar_Cost());
							}
						}
						int car_maint=0;
						for (int m = 0; m < 100; m++) {
							if (c[m] != null) car_maint +=c[m].getCarMaintenance();
						}
						int emp_sal =comp.employeeSalary(j+1);
						int emp_bonus = comp.EmployeeBonus((j+1), date);
						System.out.println("Office " + (j + 1) + " expenses "+(comp.getOfficeRent(j+1)+emp_sal+emp_bonus+car_maint));
						System.out.println("    Office rent: 100 ");
						System.out.println("    Employee salaries: "+emp_sal);
						System.out.println("    Employee performance bonuses: "+emp_bonus);
						for (int l = 0; l < 100; l++) {
							if (c[l] != null) {
								
								System.out.println(
										"    Car" + c[l].getCarID() + " maintenance: " + c[l].getCarMaintenance());
							}
						}
						System.out.println("Office"+(j+1)+" profit: "+(comp.office_income(c)-(comp.getOfficeRent(j+1)+emp_sal+emp_bonus+car_maint)));
					}
					System.out.println("--- Office Statistics of all time ---");
					for (int k = 0; k < Company.getCount(); k++) {
						System.out.println("--- Office"+(k+1)+" ---");
						comp.statistics(k+1);
						int m_r_c;
						int m_r_car=-1;
						m_r_c=comp.f_car[0];
						int m_c_p;
						int m_c_profit=-1;
						m_c_p=comp.f_car_profit[0];
						int m_c;
						int m_cust=-1;
						m_c=comp.f_customer[0];
						int m_e;
						int m_employee=-1;
					    m_e = comp.f_employee[0];
					    int m_c_c;
					    int m_c_class=-1;
					    m_c_c=comp.f_car_class[0];
					    int m_class_p;
					    int m_class_profit=-1;
					    m_class_p=comp.f_class_profit[0];
					    int m_r_d;
					    int m_r_day=-1;
					    m_r_d=comp.f_rent_day[0];
						for(int z=1;z<100;z++) {
							if(comp.f_car[z]>m_r_c) {
								m_r_c = comp.f_car[z];
								m_r_car=z;
							}
							else m_r_car=0;
							if(comp.f_car_profit[z]>m_c_p) {
								m_c_p = comp.f_car[z];
								m_c_profit=z;
							}
							else m_c_profit=0;
							if(comp.f_customer[z]>m_c) {
								m_c = comp.f_car[z];
								m_cust=z;
							}
							else m_cust=0;
							if(comp.f_car[z]>m_e) {
								m_e = comp.f_car[z];
								m_employee=z;
							}
							else m_employee=0;
						}
						for(int i=0;i<3;i++) {
							if(comp.f_car_class[i]>m_c_c) {
								m_c_c = comp.f_car_class[i];
								m_c_class=i;
							}
							else m_c_class=0;
							if(comp.f_class_profit[i]>m_class_p) {
								m_class_p = comp.f_class_profit[i];
								m_class_profit=i;
							}
							else m_class_profit=0;
						}
						for(int i=0;i<4;i++) {
							if(comp.f_rent_day[i]>m_r_d) {
								m_r_d = comp.f_rent_day[i];
								m_r_day=i;

						}
							else m_r_day=0;
						}
						System.out.println("The most rented car: "+ comp.cars[m_r_car].getCarID()+";"+comp.cars[m_r_car].getCarBrand()+";"+comp.cars[m_r_car].getCarModel());
						System.out.print("The most rented car class: ");
						if(m_c_class==0)System.out.println("Economy");
						else if(m_c_class==1)System.out.println("Sports");
						else if(m_c_class==2)System.out.println("Luxury");
						System.out.println("The car with the highest profit: "+comp.cars[m_c_profit].getCarID()+";"+comp.cars[m_c_profit].getCarBrand()+";"+comp.cars[m_c_profit].getCarModel());
						System.out.print("The car class with the highest profit: ");
						if(m_class_profit==0)System.out.println("Economy");
						else if(m_class_profit==1)System.out.println("Sports");
						else if(m_class_profit==2)System.out.println("Luxury");
						System.out.print("The most rented day: ");
						if(m_r_day==0)System.out.print("1 day");
						else if(m_r_day==1)System.out.println("2 day");
						else if(m_r_day==2)System.out.println("3 day");
						if(m_r_day==3)System.out.println("4 day");
						System.out.println("The customer who rented most: Customer"+comp.customers[m_cust].getCustomerID()+";"+comp.customers[m_cust].getName()+";"+comp.customers[m_cust].getSurname());
						System.out.println("The employee who rented most: Employee"+comp.employees[m_employee].getEmployeeID()+";"+comp.employees[m_employee].getFirstName()+";"+comp.employees[m_employee].getLastName());	
					}
					//Employeeler için contract sayacý sýfýrlama
					for(int i=0;i<Company.cEmp;i++) {
						if(comp.employees[i]!=null) comp.employees[i].setDailyCont(false);
					}
					//Contractlarýn tarihi bittiyse sonlandýrma
					for(int i=0;i<Company.cCont;i++) {
						if(comp.contracts[i].getEndDate().getDay()==date.getDay())comp.cars[comp.contracts[i].getCarID()-1].setCarAv(true);
					}
					date.setDay((date.getDay()+1));
				}
			}
			scan.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		else {
			if (q[0].equals("addOffice")) {
				Office off2 = new Office(q[1], q[2], q[3]);
				comp.addOffice(off2);

			} else if (q[0].equals("addEmployee")) {
				if (comp.addEmp(Integer.parseInt(q[5]))) {
					Employee emp1 = new Employee(q[1], q[2], q[3], q[4], Integer.parseInt(q[5]));
					comp.addEmployee(emp1);
				} else
					System.out.println("You have already 3 employees in this office!");
			} else if (q[0].equals("addCustomer")) {
				Customer cust = new Customer(q[1], q[2]);
				comp.addCustomer(cust);

			} else if (q[0].equals("addCarRequestRandom")) {
				int end_d = date.getDay() + 3;
				Date startDate = new Date(date.getDay(), date.getMonth(), date.getYear());
				Date endDate = new Date(end_d, date.getMonth(), date.getYear());
				Car[] cr;
				cr = new Car[1];
				cr[0] = comp.GenerateRandomCar(Integer.parseInt(q[1]), q[2]);
				if (cr[0] != null) {
					int cID = comp.GenerateRandomCustomer();
					Car_Request crq = new Car_Request(Integer.parseInt(q[1]), cID, cr[0].getCarBrand(),
							cr[0].getCarModel(), q[2], startDate, endDate);
					comp.addCarRequest(crq);
					String EA = comp.EmplooyeeAvailable(crq);
					String[] k = EA.split(";");
					if (k[0].equals("true")) {
						cr[0].setCarAv(false);
						Contract ct = new Contract(Integer.parseInt(k[1]), cID, cr[0].getCarID(), startDate,
								endDate);
						comp.addContract(ct);
					} else
						System.out.println("Error: No employee available");
				} else
					System.out.println("Error: No car available");
			} else if (q[0].equals("addCarRequest")) {
				Date StartDate = new Date(q[6]);
				Date EndDate = new Date(q[7]);
				Car_Request creq = new Car_Request(Integer.parseInt(q[1]), Integer.parseInt(q[2]), q[3], q[4], q[5],
						StartDate, EndDate);
				comp.addCarRequest(creq);
				if (StartDate.DateControl(StartDate, EndDate)) {
					String CA[] = comp.CarAvailable(creq);
					String[] j = CA[0].split(";");
					String[] k = CA[1].split(";");
					if (j[0].equals("true") && k[0].equals("true")) {
						int carID = Integer.parseInt(j[1]);
						Contract ct = new Contract(Integer.parseInt(k[1]), Integer.parseInt(q[2]), carID, StartDate,
								EndDate);
						comp.addContract(ct);
					} else if (j[0].equals("false"))
						System.out.println("Error:No Car");
					else if (j[0].equals("Err3"))
						System.out.println("Error: Car not avaiable");
					else if (k[0].equals("error2"))
						System.out.println("Error: No emplooyee available");
				} else
					System.out.println("Error:Car requests must be for 1-4 days");
			} else if (q[0].equals("listEmployee")) {
				if (comp.lO(Integer.parseInt(q[1])))
					comp.listEmployee(Integer.parseInt(q[1]));

			} else if (q[0].equals("addCar")) {
				Car car1 = new Car(q[1], q[2], q[3], Integer.parseInt(q[4]), Integer.parseInt(q[5]));
				comp.addCar(car1);
			} else if (q[0].equals("listCarRequest")) {
				comp.listCarRequest();
			} else if (q[0].equals("listCar")) {
				comp.listCar(Integer.parseInt(q[1]));

			} else if (q[0].equals("deleteOffice")) {
				comp.deleteOffice(Integer.parseInt(q[1]));
				comp.deleteEmpOf(Integer.parseInt(q[1]));

			} else if (q[0].equals("deleteEmployee")) {
				comp.deleteEmployee(Integer.parseInt(q[1]), Integer.parseInt(q[2]));
			} else if (q[0].equals("listContracts")) {
				comp.listContract();
			}

			else if (q[0].equals("listOffice")) {
				comp.listOffice();
			} else if (q[0].equals("listCustomer")) {
				comp.listCustomer();
			} else if (q[0].equals("nextday")) {
				comp.setCarKM();
				System.out.println("--- Office Profits ---");
				for (int j = 0; j < Company.getCount(); j++) {
					Car[] c = comp.rented_car_off(j + 1);
					System.out.println("Office " + (j + 1) + " incomes " + comp.office_income(c));
					for (int k = 0; k < 100; k++) {
						if (c[k] != null) {
							System.out.println("    Car" + c[k].getCarID() + ":  " + c[k].getCar_Cost());
						}
					}
					int car_maint=0;
					for (int m = 0; m < 100; m++) {
						if (c[m] != null) car_maint +=c[m].getCarMaintenance();
					}
					int emp_sal =comp.employeeSalary(j+1);
					int emp_bonus = comp.EmployeeBonus((j+1), date);
					System.out.println("Office " + (j + 1) + " expenses "+(comp.getOfficeRent(j+1)+emp_sal+emp_bonus+car_maint));
					System.out.println("    Office rent: 100 ");
					System.out.println("    Employee salaries: "+emp_sal);
					System.out.println("    Employee performance bonuses: "+emp_bonus);
					for (int l = 0; l < 100; l++) {
						if (c[l] != null) {
							
							System.out.println(
									"    Car" + c[l].getCarID() + " maintenance: " + c[l].getCarMaintenance());
						}
					}
					System.out.println("Office"+(j+1)+" profit: "+(comp.office_income(c)-(comp.getOfficeRent(j+1)+emp_sal+emp_bonus+car_maint)));
				}
				System.out.println("--- Office Statistics of all time ---");
				for (int k = 0; k < Company.getCount(); k++) {
					System.out.println("--- Office"+(k+1)+" ---");
					comp.statistics(k+1);
					int m_r_c;
					int m_r_car=-1;
					m_r_c=comp.f_car[0];
					int m_c_p;
					int m_c_profit=-1;
					m_c_p=comp.f_car_profit[0];
					int m_c;
					int m_cust=-1;
					m_c=comp.f_customer[0];
					int m_e;
					int m_employee=-1;
				    m_e = comp.f_employee[0];
				    int m_c_c;
				    int m_c_class=-1;
				    m_c_c=comp.f_car_class[0];
				    int m_class_p;
				    int m_class_profit=-1;
				    m_class_p=comp.f_class_profit[0];
				    int m_r_d;
				    int m_r_day=-1;
				    m_r_d=comp.f_rent_day[0];
					for(int z=1;z<100;z++) {
						if(comp.f_car[z]>m_r_c) {
							m_r_c = comp.f_car[z];
							m_r_car=z;
						}
						else m_r_car=0;
						if(comp.f_car_profit[z]>m_c_p) {
							m_c_p = comp.f_car[z];
							m_c_profit=z;
						}
						else m_c_profit=0;
						if(comp.f_customer[z]>m_c) {
							m_c = comp.f_car[z];
							m_cust=z;
						}
						else m_cust=0;
						if(comp.f_car[z]>m_e) {
							m_e = comp.f_car[z];
							m_employee=z;
						}
						else m_employee=0;
					}
					for(int i=0;i<3;i++) {
						if(comp.f_car_class[i]>m_c_c) {
							m_c_c = comp.f_car_class[i];
							m_c_class=i;
						}
						else m_c_class=0;
						if(comp.f_class_profit[i]>m_class_p) {
							m_class_p = comp.f_class_profit[i];
							m_class_profit=i;
						}
						else m_class_profit=0;
					}
					for(int i=0;i<4;i++) {
						if(comp.f_rent_day[i]>m_r_d) {
							m_r_d = comp.f_rent_day[i];
							m_r_day=i;

					}
						else m_r_day=0;
					}
					System.out.println("The most rented car: "+ comp.cars[m_r_car].getCarID()+";"+comp.cars[m_r_car].getCarBrand()+";"+comp.cars[m_r_car].getCarModel());
					System.out.print("The most rented car class: ");
					if(m_c_class==0)System.out.println("Economy");
					else if(m_c_class==1)System.out.println("Sports");
					else if(m_c_class==2)System.out.println("Luxury");
					System.out.println("The car with the highest profit: "+comp.cars[m_c_profit].getCarID()+";"+comp.cars[m_c_profit].getCarBrand()+";"+comp.cars[m_c_profit].getCarModel());
					System.out.print("The car class with the highest profit: ");
					if(m_class_profit==0)System.out.println("Economy");
					else if(m_class_profit==1)System.out.println("Sports");
					else if(m_class_profit==2)System.out.println("Luxury");
					System.out.print("The most rented day: ");
					if(m_r_day==0)System.out.print("1 day");
					else if(m_r_day==1)System.out.println("2 day");
					else if(m_r_day==2)System.out.println("3 day");
					if(m_r_day==3)System.out.println("4 day");
					System.out.println("The customer who rented most: Customer"+comp.customers[m_cust].getCustomerID()+";"+comp.customers[m_cust].getName()+";"+comp.customers[m_cust].getSurname());
					System.out.println("The employee who rented most: Employee"+comp.employees[m_employee].getEmployeeID()+";"+comp.employees[m_employee].getFirstName()+";"+comp.employees[m_employee].getLastName());	
				}
				//Employeeler için contract sayacý sýfýrlama
				for(int i=0;i<Company.cEmp;i++) {
					if(comp.employees[i]!=null) comp.employees[i].setDailyCont(false);
				}
				//Contractlarýn tarihi bittiyse sonlandýrma
				for(int i=0;i<Company.cCont;i++) {
					if(comp.contracts[i].getEndDate().getDay()==date.getDay())comp.cars[comp.contracts[i].getCarID()-1].setCarAv(true);
				}
				date.setDay((date.getDay()+1));
			}
		}
		}
	}
}