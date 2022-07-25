package CODE;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Ticket {

	private String passengerNameSurname;
	private String ticketClass; // ?????
	private int passengerID;
	private static int ticketIDCounter = 0;
	private int ticketID;
	private char ticketType;
	private char destinationType; // yurtiçi, yurtdýþý
	private String source;
	private String destination;
	private double price;
	private String paymentType;
	private boolean checkIn;
	private String date;
	private int seat;
	private Flight flight;

	Ticket(Flight flight, String passengerNameSurname, int passengerID, String ticketClass, double price,
			String paymentType, String date, int seat) {
		this.passengerNameSurname = passengerNameSurname;
		this.ticketClass = ticketClass;
		this.price = price;
		this.paymentType = paymentType;
		this.passengerID = passengerID;
		ticketIDCounter++;
		this.ticketID = ticketIDCounter;
		checkIn = false;

		this.date = date;
		this.seat = seat;
		this.flight = flight;

	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	@Override
	public String toString() {
		return "Ticket [passengerNameSurname=" + passengerNameSurname + ", ticketClass=" + ticketClass
				+ ", passengerID=" + passengerID + ", ticketID=" + ticketID + ", ticketType=" + ticketType
				+ ", destinationType=" + destinationType + ", source=" + source + ", destination=" + destination
				+ ", price=" + price + ", paymentType=" + paymentType + ", checkIn=" + checkIn + ", date=" + date + "]";
	}

	public int calculationLuggWeight(int luggageWeight) {
		if (ticketClass.equals("Business"))
			return (luggageWeight - 40) * 10;
		else {
			return (luggageWeight - 20) * 10;
		}
	}

	public String getPassengerNameSurname() {
		return passengerNameSurname;
	}

	public void setPassengerNameSurname(String passengerNameSurname) {
		this.passengerNameSurname = passengerNameSurname;
	}

	public String getTicketClass() {
		return ticketClass;
	}

	public void setTicketClass(String ticketClass) {
		this.ticketClass = ticketClass;
	}

	public int getPassengerID() {
		return passengerID;
	}

	public void setPassengerID(int passengerID) {
		this.passengerID = passengerID;
	}

	public int getTicketID() {
		return ticketID;
	}

	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}

	public char getTicketType() {
		return ticketType;
	}

	public void setTicketType(char ticketType) {
		this.ticketType = ticketType;
	}

	public char getDestinationType() {
		return destinationType;
	}

	public void setDestinationType(char destinationType) {
		this.destinationType = destinationType;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public boolean isCheckIn() {
		return checkIn;
	}

	public void setCheckIn(boolean checkIn) {
		this.checkIn = checkIn;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
