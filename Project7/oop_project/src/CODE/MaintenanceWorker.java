package CODE;
import java.util.ArrayList;

public class MaintenanceWorker extends Employee {

	ArrayList<String> checkMaintenance = new ArrayList<String>();
	ArrayList<Plane> planes = new ArrayList<Plane>();

	public MaintenanceWorker(String name, String surname, String email, int age, char gender, int salary, String field,
			String idNo, ArrayList<Plane> plane) {
		super(name, surname, email, age, gender, salary, field, idNo);
		planes = plane;
	}

	public void listReqTreatmens() {
		checkMaintenance.add("1-wing maintenance");
		checkMaintenance.add("2-engine maintenance");
		checkMaintenance.add("3-oil maintenance");
		checkMaintenance.add("4-part change");
		checkMaintenance.add("5-reparation");
		checkMaintenance.add("6-damage removal");
	}

	public void reportMaintenance(String maintenance, int planeID) {
		listReqTreatmens();
		while (true) {
			for (String string : checkMaintenance) {
				if (string.equals(maintenance))
					checkMaintenance.remove(string);
			}
			if (maintenance.equalsIgnoreCase("DONE") && checkMaintenance.size() > 0);
				planes.get(planeID-1).setAvailable(false);
		}
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
