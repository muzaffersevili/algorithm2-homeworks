package CODE;

import java.util.ArrayList;
import java.util.Random;

public class AirlineManager {

	private String name;
	private String password;
	private ArrayList<Employee> employeeList;
	private ArrayList<Passenger> passengerList;
	private ArrayList<Plane> planeList;
	private ArrayList<Flight> flightList;
	private ArrayList<FlightWorker> flightWorkerList;
	private ArrayList<Airport> airportList;

	private static AirlineManager instance;

	public static AirlineManager getInstance() {
		if (instance == null) {
			instance = new AirlineManager();
		}
		return instance;
	}

	private AirlineManager() {
		name = "admin";
		password = "deuceng";
		employeeList = new ArrayList<Employee>();
		planeList = new ArrayList<Plane>();
		passengerList = new ArrayList<Passenger>();
		flightList = new ArrayList<Flight>();
		airportList = new ArrayList<Airport>();
		flightWorkerList = new ArrayList<FlightWorker>();
	}

	public boolean addEmployee(String name, String surname, String email, int age, char gender, int salary,
			String field, String idNo) {

		for (Employee employee : employeeList) {
			if (employee.control(idNo)) {
				return false;
			}
		}
		if (field.equals("FlightWorker")) {
			Employee employee = new FlightWorker(name, surname, email, age, gender, salary, field, idNo, flightList);
			employeeList.add(employee);
			return true;
		} else {
			Employee employee = new MaintenanceWorker(name, surname, email, age, gender, salary, field, idNo,
					planeList);
			employeeList.add(employee);
			return true;
		}
	}

	public boolean deleteEmployee(int idNo) {
		for (Employee employee : employeeList) {

			if (employee.control(idNo)) {
				employeeList.remove(employee);
				return true;
			}
		}
		return false;
	}

	public Passenger addPassenger(String name, String surname, int age, char gender, String email, String idNo,
			String password) { // sign
		for (Passenger passenger : passengerList) {
			if (!passenger.control(idNo))
				return null;
		}
		Passenger passenger = new Passenger(name, surname, age, gender, email, idNo, password);
		passengerList.add(passenger);
		return passenger;
	}

	public void addPlane(int age, int seatNumber, String type) {
		Plane plane = new Plane(age, seatNumber, type);
		planeList.add(plane);
	}

	public void deletePlane(int idNo) { // uçuþ iptali??
		if (!planeList.get(idNo - 1).isAvailable())
			planeList.remove(idNo - 1);
		else {
			for (Flight flight : flightList) {
				if (flight.getFlightID() == idNo)
					deleteFlight(idNo);
			}
		}
	}

	public boolean addFlight(int planeID, int planeSeat, String source, String destination, String flightTime,
			String departureTime, String arrivalTime, int flightGate) {

		Flight flight = new Flight(planeID, planeSeat, source, destination, flightTime, departureTime, arrivalTime,
				flightGate);
		flightList.add(flight);

		return true;

	}

	public boolean deleteFlight(int flightID) {
		if (flightList.get(flightID - 1) != null) {
			for (Passenger passenger : passengerList) {
				for (Ticket ticket : passenger.getTickets()) {
					if (ticket.getFlight().getFlightID() == flightID) {
						passenger.getTickets().remove(ticket);
						flightList.remove(flightID - 1);
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean addAirport(String airportName) {
		for (Airport airport : airportList) {
			if (!airport.control(airportName))
				return false;
		}
		Airport airport = new Airport(airportName);
		airportList.add(airport);
		return true;
	}

	public void deleteAirport(int airportID) {
		airportList.remove(airportID - 1);
	}

	public ArrayList<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(ArrayList<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public boolean controlLoginPassenger(String name, String password) {
		for (Passenger passenger : passengerList) {
			if (passenger.getName().equals(name) && passenger.getPassword().equals(password))
				return true;
		}
		return false;
	}

	public int controlWorker(String name) { // eger wroker adminse manager employee ise type
		if (!name.equals("admin"))
			for (Employee employee : employeeList) {
				if (employee.getName().equals(name) && employee.getPassword().equals(password))
					if (employee.getField() == "FlightWorker") {
						return 1;
					} else if (employee.getField() == "MaintanenceWorker")
						return -1;
			}
		return 0; // admin
	}

	public Employee getEmployee(String name, String password) {
		for (Employee employee : employeeList) {
			if (employee.getName().equals(name) && employee.getPassword().equals(password))
				return employee;
		}
		return null;
	}

	public Passenger getPassenger(String name, String password) {
		for (Passenger passenger : passengerList) {
			if (passenger.getName().equals(name) && passenger.getPassword().equals(password))
				return passenger;
		}
		return null;
	}

	public ArrayList<Passenger> getPassengerList() {
		return passengerList;
	}

	public void setPassengerList(ArrayList<Passenger> passengerList) {
		this.passengerList = passengerList;
	}

	public ArrayList<Plane> getPlaneList() {
		return planeList;
	}

	public void setPlaneList(ArrayList<Plane> planeList) {
		this.planeList = planeList;
	}

	public ArrayList<Flight> getFlightList() {
		return flightList;
	}

	public void setFlightList(ArrayList<Flight> flightList) {
		this.flightList = flightList;
	}

	public ArrayList<FlightWorker> getFlightWorkerList() {
		return flightWorkerList;
	}

	public void setFlightWorkerList(ArrayList<FlightWorker> flightWorkerList) {
		this.flightWorkerList = flightWorkerList;
	}

	public ArrayList<Airport> getAirportList() {
		return airportList;
	}

	public void setAirportList(ArrayList<Airport> airportList) {
		this.airportList = airportList;
	}

}
