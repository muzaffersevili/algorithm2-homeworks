package CODE;
import java.util.ArrayList;

public class TicketOfficeWorker extends Employee {

	ArrayList<Flight> flights;
	ArrayList<Ticket> tickets;
	 
	public TicketOfficeWorker(String name, String surname, String email, int age, char gender, int salary,
			String field, String idNo, ArrayList<Flight> flights, ArrayList<Ticket> tickets) {
		super(name, surname, email, age, gender, salary, field, idNo);
		this.flights = flights;
	}

	public void sellTicket(int flightID) {
		flights.get(flightID-1).getPlane().getSeat(); // koltuk dolu artýk
	}

	public boolean ticketControl(int ticketID) {
		return true;
	}
	
	
	public void cancelTicket(ArrayList<Plane> planes,ArrayList<Ticket> tickets) {
		
	}
	
	public int ticketRefund(ArrayList<Plane> planes,ArrayList<Ticket> tickets) {
		return 1;
	}

	@Override
	public String getName() {
		return this.getName();
	}

	@Override
	public String getSurname() {
		return this.getSurname();
	}

	@Override
	public String getEmail() {
		return this.getEmail();
	}

	@Override
	public int getAge() {
		return this.getAge();
	}

	@Override
	public char getGender() {
		return this.getGender();
	}

	@Override
	public int getSalary() {
		return this.getSalary();
	}

	@Override
	public int getEmployeeID() {
		return this.getEmployeeID();
	}

	@Override
	public String getField() {
		return this.getField();
	}

	@Override
	public void setName(String name) {
		this.setName(name);
	}

	@Override
	public void setSurname(String surname) {
		this.setSurname(surname);
	}

	@Override
	public void setEmail(String email) {
		this.setEmail(email);
	}

	@Override
	public void setAge(int age) {
		this.setAge(age);
	}

	@Override
	public void setGender(char gender) {
		this.setGender(gender);
	}

	@Override
	public void setSalary(int salary) {
		this.setSalary(salary);
	}

	@Override
	public void setEmployeeID(int employeeID) {
		this.setEmployeeID(employeeID);
	}

	@Override
	public void setField(String field) {
		this.setField(field);
	}
	
}
