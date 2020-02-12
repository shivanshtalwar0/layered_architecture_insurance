package service;

public class EmployeeServiceImplementor implements EmployeeService {
	private static EmployeeServiceImplementor instance = null;

	public String getInsuranceScheme(double salary, String designation) {
		if (salary < 5000 && designation.equalsIgnoreCase("Clerk")) {
			return "No Scheme";
		} else if ((salary > 5000 && salary < 20000) && designation.equalsIgnoreCase("System Associate")) {
			return "Scheme C";
		} else if ((salary >= 20000 && salary < 40000) && designation.equalsIgnoreCase("Programmer")) {
			return "Scheme B";
		} else if (salary >= 40000 && designation.equalsIgnoreCase("Manager")) {
			return "Scheme A";
		} else {
			return "No Scheme";
		}

	}

	public static EmployeeServiceImplementor getInstance() {
		if (instance == null) {
			instance = new EmployeeServiceImplementor();
			return instance;
		} else {
			return instance;
		}

	}

}
