package pl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Random;

import bean.Employee;
import service.EmployeeServiceImplementor;

public class AppExecutor {
	static HashMap<Long, Employee> data = new HashMap<Long, Employee>();
	InputStreamReader isr = null;
	BufferedReader buff = null;
	public AppExecutor(InputStreamReader isr, BufferedReader buff) {
		this.buff = buff;
		this.isr = isr;
		this.initUi();
		// TODO Auto-generated constructor stub
	}

	public void displayUsers() {
		AppExecutor.data.forEach((key, employee) -> {
			System.out.println(employee.toString());
		});
	}

	public long uuid() {
		return Long.parseLong(String.format("%s%s%s%s%s%s%s%s", new Random().nextInt(9), new Random().nextInt(9),
				new Random().nextInt(9), new Random().nextInt(9), new Random().nextInt(9), new Random().nextInt(9),
				new Random().nextInt(9), new Random().nextInt(9)));
	}

	public void addEmployee(String name, double salary, String designation) {
		long uid = uuid();
		Employee emp = new Employee(uid, name, salary, designation,
				EmployeeServiceImplementor.getInstance().getInsuranceScheme(salary, designation));
		AppExecutor.data.put(uid, emp);
	}

	public void initUi() {
		int i = 0;
		while (i != 9) {
			System.out.println("Insurance menu\n1)Add Employee\n2)Get Insurance Scheme\n3)Display Users\n");
			try {
				i = Integer.parseInt(buff.readLine());
				String name;
				String designation;
				double salary;
				switch (i) {
				case 1:
					System.out.println("Enter Name");
					name = buff.readLine();
					System.out.println("Enter Salary");
					salary = Double.parseDouble(buff.readLine());
					System.out.println("Enter Designation");
					designation = buff.readLine();
					addEmployee(name, salary, designation);
					System.out.println("Employee Added");
					break;
				case 2:
					System.out.println("Enter Salary");
					salary = Double.parseDouble(buff.readLine());
					System.out.println("Enter Designation");
					designation = buff.readLine();
					System.out
							.println(EmployeeServiceImplementor.getInstance().getInsuranceScheme(salary, designation));
					break;
				case 3:
					System.out.println("all users details:\n");
					displayUsers();
					break;
				case 4:
					i = 9;
					break;
				default:
					System.out.println("invalid option");
					break;

				}

			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		

	}

}
