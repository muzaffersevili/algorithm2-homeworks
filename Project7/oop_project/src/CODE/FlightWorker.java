package CODE;

import java.util.ArrayList;
import java.util.Iterator;

public class FlightWorker extends Employee {

	private boolean available;
	private ArrayList<Flight> flightList;
	
	public FlightWorker(String name, String surname, String email, int age, char gender, int salary, 
			String field, String identityNumber, ArrayList<Flight> flights) {
		super(name, surname, email, age, gender, salary, field, identityNumber);
		available = true;
		flightList = flights;
	}	
	
	public Passenger[] printPassengersInfo(int flightID) {
		return flightList.get(flightID-1).getPassengerList();
	}
	
	@Override
	public String getName() {
		return super.getName();
	}
	
	@Override
	public String getSurname() {
		return super.getSurname();
	}
	
	@Override
	public String getEmail() {
		return super.getEmail();
	}
	
	@Override
	public int getAge() {
		return super.getAge();
	}
	
	@Override
	public char getGender() {
		return super.getGender();
	}
	
	@Override
	public int getSalary() {
		return super.getSalary();
	}
	
	@Override
	public int getEmployeeID() {
		return super.getEmployeeID();
	}
	
	@Override
	public String getField() {
		return super.getField();
	}
	
	@Override
	public void setName(String name) {
		super.setName(name);
	}
	
	
	@Override
	public void setSurname(String surname) {
		super.setSurname(surname);
	}
	
	@Override
	public void setEmail(String email) {
		super.setEmail(email);
	}
	
	@Override
	public void setAge(int age) {
		super.setAge(age);
	}
	
	@Override
	public void setGender(char gender) {
		super.setGender(gender);
	}
	
	@Override
	public void setSalary(int salary) {
		super.setSalary(salary);
	}
	
	@Override
	public void setEmployeeID(int employeeID) {
		super.setEmployeeID(employeeID);
	}
	
	@Override
	public void setField(String field) {
		super.setField(field);
	}
}
