public class Car {

	// Attributes

	String carBrand;
	String carModel;
	String carClass;
	int carKilometers;
	int car_Cost;
	private int officeID;
	int CarID;
	static int idCounter = 1;
	boolean CarAv;
	boolean CA = true;

	// Constructor
	public Car(String inputCarBrand, String inputCarModel, String inputCarClass, int inputCarKilometers,
			int inpofficeID) {
		carBrand = inputCarBrand;
		carModel = inputCarModel;
		carClass = inputCarClass;
		carKilometers = inputCarKilometers;
		officeID = inpofficeID;
		CarAv = CA;
		CarID = idCounter;
		idCounter++;
		if ("economy".equals(carClass))
			car_Cost = 100;
		else if ("sports".equals(carClass))
			car_Cost = 200;
		else
			car_Cost = 300;
	}

	// Getters

	public int getCar_Cost() {
		return car_Cost;
	}

	public void setCar_Cost(int car_Cost) {
		this.car_Cost = car_Cost;
	}

	public boolean getCarAv() {
		return CarAv;
	}

	public void setCarAv(boolean carAv) {
		CarAv = carAv;
	}

	public String getCarBrand() {
		return carBrand;
	}

	public int getCarID() {
		return CarID;
	}

	public void setCarID(int carID) {
		CarID = carID;
	}

	public String getCarModel() {
		return carModel;
	}

	public String getCarClass() {
		return carClass;
	}

	public int getCarKilometers() {
		return carKilometers;
	}

	public int getOfficeID() {
		return officeID;
	}
    public int getCarMaintenance() {
    	if (car_Cost==100)
			return 20 + (carKilometers * 5 / 100);
		else if (car_Cost==200)
			return 70 + (carKilometers * 10 / 100);
		else
			return 120 + (carKilometers * 15 / 100);
    }
	// Setters

	public void setCarBrand(String inputCarBrand) {
		carBrand = inputCarBrand;
	}

	public void setCarModel(String inputCarModel) {
		carModel = inputCarModel;
	}

	public void setCarClass(String inputCarClass) {
		carClass = inputCarClass;
	}

	public void setCarKilometers(int inputCarKilometers) {
		carKilometers = inputCarKilometers;
	}

	// CarCost
	public String CarCost() {
		if ("economy".equals(carClass) || "Economy".equals(carClass)) {
			return "100cp";
		} else if ("sports".equals(carClass) || "Sports".equals(carClass)) {
			return "200cp";
		} else if ("luxury".equals(carClass) || "Luxury".equals(carClass)) {
			return "300cp";
		} else {
			return "100cp";
		}
	}

}