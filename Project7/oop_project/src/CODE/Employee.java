package CODE;

public class Employee {
	private static int EmployeeIDCounter = 0;
	private int employeeID;
	private String name;
	private String surname;
	private String email;
	private int age;
	private char gender;
	private int salary;
	private String field;
	private String identityNumber;
	private String password;

	public Employee(String name, String surname, String email, int age, char gender, int salary, String field,
			String identityNumber) {
		EmployeeIDCounter++;
		employeeID = EmployeeIDCounter;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.age = age;
		this.gender = gender;
		this.salary = salary;
		this.field = field;
		this.identityNumber = identityNumber;
		this.password = name + surname;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", surname=" + surname + ", age=" + age + ", gender=" + gender
				+ ", employeeID=" + employeeID + ", Salary=" + salary + ", email=" + email + ", Working Field=" + field
				+ "]";
	}

	public boolean control(int idNo) {
		if (getEmployeeID() == idNo) {
			return true;
		}
		return false;
	}

	public boolean control(String idNo) {
		if (getIdentityNumber().equals(identityNumber)) {
			return false;
		}
		return true;
	}

	public String getIdentityNumber() {
		return identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

}
