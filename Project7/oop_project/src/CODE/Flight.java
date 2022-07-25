package CODE;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Flight {

	private static int flightIDCounter = 0;
	private int flightID;
	private FlightWorker[] workerList;
	private Passenger[] passengerList; // iki tane airport eklenecek
	private String source;
	private char destinationType;
	private String destination;
	private String flightDate;
	private String departureTime;
	private String arrivalTime;
	private int flightGate;
	private String flightTime;
	private String flightCode;
	private Plane plane;

	// plane random seçilecek
	public Flight(int planeSeat, int flightWorkerNumber, String source, String destination,
			String flightTime, String departureTime, String arrivalTime, int flightGate) {
		
		flightIDCounter++;
		flightID = flightIDCounter;
		this.plane = plane;
		this.workerList = new FlightWorker[flightWorkerNumber];
		this.passengerList = new Passenger[planeSeat];
		this.source = source;
		this.destination = destination;
		this.flightDate = flightDate;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		// this.flightTime = this.arrivalTime-this.departureTime;
		this.flightGate = flightGate;
		flightCode = source.substring(0, 2).toUpperCase() + destination.substring(0, 2).toUpperCase();
	}

	@Override
	public String toString() {
		return "Flight [flightID=" + flightID + ", source=" + source + ", destination="
				+ destination + ", flightDate=" + flightDate + ", departureTime=" + departureTime + ", arrivalTime="
				+ arrivalTime + ", flightGate=" + flightGate + ", flightTime=" + flightTime + "]";
	}
	
	public int getFlightID() {
		return flightID;
	}

	public void setFlightID(int flightID) {
		this.flightID = flightID;
	}

	public Plane getPlane() {
		return plane;
	}

	public void setPlane(Plane plane) {
		this.plane = plane;
	}

	public Passenger[] getPassengerList() {
		return passengerList;
	}

	public void setPassengerList(Passenger[] passengerList) {
		this.passengerList = passengerList;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	
	public char getDestinationType() {
		return destinationType;
	}

	public void setDestinationType(char destinationType) {
		this.destinationType = destinationType;
	}
	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}

	public int getFlightGate() {
		return flightGate;
	}

	public void setFlightGate(int flightGate) {
		this.flightGate = flightGate;
	}

	public String getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}

	public FlightWorker[] getWorkerList() {
		return workerList;
	}

	public void setWorkerList(FlightWorker[] workerList) {
		this.workerList = workerList;
	}

	public String getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

}
