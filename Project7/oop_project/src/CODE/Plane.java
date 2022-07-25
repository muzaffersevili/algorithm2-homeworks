package CODE;
import java.util.*;

public class Plane {
	private static int planeIDCounter = 0;
	private int planeID;
	private int age;
	private boolean[] seats;
	private String type;
	private boolean available;

	public Plane(int age, int seatCount, String type) {
		planeIDCounter++;
		planeID = planeIDCounter;
		this.age = age;
		seats = new boolean[seatCount];
		this.type = type;
		this.available = true;
	}

	public boolean control(int idNo) {
		if (getPlaneID() == (idNo)) {
			return false;
		}
		return true;
	}

	public int getSeat() {
		Random rnd = new Random();
		while (true) {
			int seat = rnd.nextInt(seats.length);
			if (seats[seat]) {
				seats[seat] = false;
				return seat;
			}
		}
	}

	public void ticketCancellation(int seatID) {
		seats[seatID] = true;
	}
	
	public int getPlaneID() {
		return planeID;
	}

	public void setPlaneID(int planeID) {
		this.planeID = planeID;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean[] getSeats() {
		return seats;
	}

	public void setSeats(boolean[] seats) {
		this.seats = seats;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	// BECEREMEDÝM SEATLERÝ YAZDIRMAYI :(((
	/*
	 * @Override public String toString() { return "Plane [ID=" + planeID + ", Age="
	 * + age + ", type=" + type + ", Ready to Fly? =" + available + "Seats:" seats.
	 * }
	 * 
	 * 
	 * public boolean Maintenance() {
	 * 
	 * }
	 */

}
