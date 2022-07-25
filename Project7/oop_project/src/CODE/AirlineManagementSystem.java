package CODE;

import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import GUI.*;

public class AirlineManagementSystem {
	static AirlineManager manager = AirlineManager.getInstance();

	public static int readPassenger() throws FileNotFoundException {
		Scanner sc = new Scanner(new File("passenger.txt"), "UTF-8");

		String line;
		int counter = 1;
		while (sc.hasNextLine()) {
			line = sc.nextLine();
			String[] input = line.split(",");
			manager.addPassenger(input[0], input[1], Integer.parseInt(input[2]), input[3].charAt(0), input[4], input[5],
					input[6]);
			counter++;
		}
		sc.close();
		return counter;
	}

	public static void writeFilePassenger(String fileName, int length) throws IOException {

		FileWriter myWriter = new FileWriter(fileName);
		for (int i = 0; i < length - 2; i++) {
			myWriter.write(manager.getPassengerList().get(i).getName() + ","
					+ manager.getPassengerList().get(i).getSurname() + "," + manager.getPassengerList().get(i).getAge()
					+ "," + manager.getPassengerList().get(i).getGender() + ","
					+ manager.getPassengerList().get(i).getEmail() + ","
					+ manager.getPassengerList().get(i).getIdentityNumber() + "\n");
		}
		myWriter.write(manager.getPassengerList().get(length - 2).getName() + ","
				+ manager.getPassengerList().get(length - 2).getSurname() + ","
				+ manager.getPassengerList().get(length - 2).getAge() + ","
				+ manager.getPassengerList().get(length - 2).getGender() + ","
				+ manager.getPassengerList().get(length - 2).getEmail() + ","
				+ manager.getPassengerList().get(length - 2).getIdentityNumber());
		myWriter.close();
	}

	public static int readAirport() throws FileNotFoundException {
		Scanner scn = new Scanner(new File("airport.txt"), "UTF-8");

		String line;
		int counter = 1;

		while (scn.hasNextLine()) {
			line = scn.nextLine();
			manager.addAirport(line);
			counter++;
		}

		return counter;
	}

	public static void writeFileAirport(String fileName, int length) throws IOException {

		FileWriter myWriter = new FileWriter(fileName);
		for (int i = 0; i < length - 2; i++) {
			myWriter.write(manager.getAirportList().get(i).getAirportName() + "\n");
		}
		myWriter.write(manager.getAirportList().get(length - 2).getAirportName());
		myWriter.close();
	}

	public static int readPlane() throws FileNotFoundException {
		Scanner sc = new Scanner(new File("plane.txt"), "UTF-8");

		String line;
		int counter = 1;
		while (sc.hasNextLine()) {
			line = sc.nextLine();
			String[] input = line.split(",");
			manager.addPlane(Integer.parseInt(input[0]), Integer.parseInt(input[1]), input[2]);
			counter++;
		}
		sc.close();
		return counter;
	}

	public static void writeFilePlane(String fileName, int length) throws IOException {

		FileWriter myWriter = new FileWriter(fileName);
		for (int i = 0; i < length - 2; i++) {
			myWriter.write(
					manager.getPlaneList().get(i).getAge() + "," + manager.getPlaneList().get(i).getSeats().length + ","
							+ manager.getPlaneList().get(i).getType() + "\n");
		}
		myWriter.write(manager.getPlaneList().get(length - 2).getAge() + ","
				+ manager.getPlaneList().get(length - 2).getSeats().length + ","
				+ manager.getPlaneList().get(length - 2).getType());
		myWriter.close();
	}

	public static int readFlight() throws FileNotFoundException {
		Scanner sc = new Scanner(new File("flight.txt"), "UTF-8");

		String line;
		int counter = 1;
		while (sc.hasNextLine()) {
			line = sc.nextLine();
			String[] input = line.split(",");
			
			manager.addFlight(Integer.parseInt(input[2]),10, input[3], input[4], input[5],
					input[6], input[7], Integer.parseInt(input[8]));
			counter++;
		}
		sc.close();
		System.out.println(counter);
		return counter;
	}

	public static void writeFileFlight(String fileName, int length) throws IOException {

		FileWriter myWriter = new FileWriter(fileName);
		for (int i = 0; i < length - 2; i++) {
			myWriter.write(manager.getFlightList().get(i).getPassengerList().length + ","
					+ manager.getFlightList().get(i).getWorkerList().length + ","
					+ manager.getFlightList().get(i).getSource() + "," + manager.getFlightList().get(i).getDestination()
					+ "," + manager.getFlightList().get(i).getFlightDate() + ","
					+ manager.getFlightList().get(i).getDepartureTime() + ","
					+ manager.getFlightList().get(i).getArrivalTime() + ","
					+ manager.getFlightList().get(i).getFlightGate() + "\n");
		}
		myWriter.write(manager.getFlightList().get(length - 2).getPassengerList().length + ","
				+ manager.getFlightList().get(length - 2).getWorkerList().length + ","
				+ manager.getFlightList().get(length - 2).getSource() + ","
				+ manager.getFlightList().get(length - 2).getDestination() + ","
				+ manager.getFlightList().get(length - 2).getFlightDate() + ","
				+ manager.getFlightList().get(length - 2).getDepartureTime() + ","
				+ manager.getFlightList().get(length - 2).getArrivalTime() + ","
				+ manager.getFlightList().get(length - 2).getFlightGate());

		myWriter.close();
	}

	public static int readEmployee() throws FileNotFoundException {
		Scanner sc = new Scanner(new File("employee.txt"), "UTF-8");

		String line;
		int counter = 1;
		while (sc.hasNextLine()) {
			line = sc.nextLine();
			String[] input = line.split(",");
			manager.addEmployee(input[0], input[1], input[2], Integer.parseInt(input[3]), input[4].charAt(0),
					Integer.parseInt(input[5]), input[6], input[7]);
			counter++;
		}
		sc.close();
		return counter;
	}

	public static void writeFileEmployee(String fileName, int length) throws IOException {

		FileWriter myWriter = new FileWriter(fileName);
		for (int i = 0; i < length - 2; i++) {
			myWriter.write(manager.getEmployeeList().get(i).getName() + ","
					+ manager.getEmployeeList().get(i).getSurname() + "," + manager.getEmployeeList().get(i).getEmail()
					+ "," + manager.getEmployeeList().get(i).getAge() + ","
					+ manager.getEmployeeList().get(i).getGender() + "," + manager.getEmployeeList().get(i).getSalary()
					+ "," + manager.getEmployeeList().get(i).getField() + ","
					+ manager.getEmployeeList().get(i).getIdentityNumber() + "\n");
		}
		myWriter.write(manager.getEmployeeList().get(length - 2).getName() + ","
				+ manager.getEmployeeList().get(length - 2).getSurname() + ","
				+ manager.getEmployeeList().get(length - 2).getEmail() + ","
				+ manager.getEmployeeList().get(length - 2).getAge() + ","
				+ manager.getEmployeeList().get(length - 2).getGender() + ","
				+ manager.getEmployeeList().get(length - 2).getSalary() + ","
				+ manager.getEmployeeList().get(length - 2).getField() + ","
				+ manager.getEmployeeList().get(length - 2).getIdentityNumber());
		myWriter.close();
	}

	public static void save() throws IOException {
		int passengerIDCount = readPassenger();
		int airportIDCount = readAirport();
		int flightIDCount = readFlight();
		int planeIDCount = readPlane();
		int employeeIDCount = readEmployee();

//		writeFilePlane("planes.txt", planeIDCount);
//		writeFileFlight("flights.txt", flightIDCount);
//		writeFileAirport("airports.txt", airportIDCount);
//		writeFilePassenger("passengers.txt", passengerIDCount);
//		writeFileEmployee("employees.txt", employeeIDCount);
	}

	public static void main(String[] args) throws IOException {

		save();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login(manager);
					frame.setTitle(" AIRLINE MANAGEMENT SYSTEM");
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
