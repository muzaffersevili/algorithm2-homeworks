package CODE;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

public class Passenger{
	private String name;
	private String surname;
	private String password; // password nasýl eklenecek
	private int age;
	private char gender;
	private static int passengerIDCounter =0;
	private int passengerID;
	private double passengerPoint =0;
	private boolean memberShip;
	private ArrayList<Ticket> tickets;
	private String email;
	private String identityNumber;
	private double point;
	
	public Passenger(String name, String surname, int age, char gender, String email, String idNo, String password) { // age, gender kontrolü yapýlacak mainde
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.gender = gender;
		this.email = email;
		passengerIDCounter++;
		passengerID=passengerIDCounter;
		memberShip=false;
		tickets = new ArrayList<Ticket>();
		identityNumber = idNo;
		this.password = password;
		point = 0;
	}

	@Override
	public String toString() {
		return "Passenger [name=" + name + ", surname=" + surname + ", age=" + age + ", gender=" + gender
				+ ", passengerID=" + passengerID + ", passengerPoint=" + passengerPoint + ", memberShip=" + memberShip
				+ ", email=" + email + "]";
	}
	
	public void listTickets() {
		for (Ticket ticket : tickets) {
			System.out.println(ticket.toString());
		}
	}
	
	public int buyingticket(int flightID, String ticketClass) {
		AirlineManager mng = AirlineManager.getInstance();
		Flight flight = mng.getFlightList().get(flightID-1);
		Ticket ticket = new Ticket(flight, getName()+" "+getSurname(), getPassengerID(), 
				ticketClass, 500, "CreditCard", flight.getFlightDate(), flight.getPlane().getSeat());
		tickets.add(ticket);	
		setPoint(getPoint()+(500*0.05));
		if(flight.getDestinationType()=='D') {  // domestic
			if(getMemberShip())
				return 400;
			return 500;
		}
		else {
			if(getMemberShip())
				return 200;
			return 250;
		}
	}
	
	public int ticketExchange(Ticket ticket, Flight flight, String ticketClass) {
		ticket.setTicketClass(ticketClass);
		ticket.setSource(flight.getSource());
		ticket.setDestination(flight.getDestination());
		ticket.setDestinationType(flight.getDestinationType());
		if(flight.getDestinationType() == 'I' && ticket.getDestinationType() == 'D') {
			if(getMemberShip())
				return 200;
			return 250;
		}
		else if(flight.getDestinationType() == 'D' && ticket.getDestinationType() == 'I'){
			if(getMemberShip())
				return -200;
			return -250;
		}
		else
			return 0;
	}

	public double ticketCancellation(int ticketID) {
		tickets.get(ticketID-1).getFlight().getPlane().ticketCancellation(tickets.get(ticketID-1).getSeat());
		tickets.remove(ticketID-1);
		setPoint(getPoint()-(tickets.get(ticketID-1).getPrice()*0.05));
		return tickets.get(ticketID-1).getPrice();
	}

	public Ticket ticketInquiry(int ticketID) { // passenger a eklenecek
		return tickets.get(ticketID-1);
	}

	public void checkIn(int ticketID) {
//		Date today = new Date();
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(today);
//		if(today.compareTo(tickets.get(ticketID-1).getDate())==0) {  
//			tickets.get(ticketID-1).setCheckIn(true);
//		}
	}

	public boolean control(String idNo) {
		if (getIdentityNumber() == idNo) {
			return false; 
		}
		return true;
	}
	
	public void getClub() {
		setMemberShip(true);
	}
	
	public void leaveClub() {
		setMemberShip(false);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIdentityNumber() {
		return identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	public int getAge() {
		return age;
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

	public int getPassengerID() {
		return passengerID;
	}

	public void setPassengerID(int passengerID) {
		this.passengerID = passengerID;
	}

	public double getPassengerPoint() {
		return passengerPoint;
	}

	public void setPassengerPoint(double passengerPoint) {
		this.passengerPoint = passengerPoint;
	}

	public boolean getMemberShip() {
		return memberShip;
	}

	public void setMemberShip(boolean memberShip) {
		this.memberShip = memberShip;
	}

	public ArrayList<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(ArrayList<Ticket> tickets) {
		this.tickets = tickets;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static int getPassengerIDCounter() {
		return passengerIDCounter;
	}

	public static void setPassengerIDCounter(int passengerIDCounter) {
		Passenger.passengerIDCounter = passengerIDCounter;
	}
	
	
}
