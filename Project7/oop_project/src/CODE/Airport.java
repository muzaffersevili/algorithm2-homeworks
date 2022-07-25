package CODE;


public class Airport {
	private static int airportCodeCounter =0;
	private int airportCode;
	private String airportName;
	
	Airport(String airportName){
		this.airportName = airportName;
		airportCodeCounter++;
		airportCode=airportCodeCounter;
	}

	public boolean control(String name) {
		if(getAirportName().equals(name))
			return false;
		return true;
	}
	public int getAirportCode() {
		return airportCode;
	}

	public void setAirportCode(int airportCode) {
		this.airportCode = airportCode;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
	
	
}
