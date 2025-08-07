package com.cg.eis.pl;

	import java.util.Scanner;

import com.cg.eis.bean.Employee;

	public class Main {
	    public static void main (String[] args) {
	        try (Scanner sc = new Scanner(System.in)) {
				System.out.print("Enter Employee ID: ");
				int id = sc.nextInt();
				sc.nextLine(); 

				System.out.print("Enter Employee Name: ");
				String name = sc.nextLine();

				System.out.print("Enter Employee Salary: ");
				double salary = sc.nextDouble();
				sc.nextLine();

				System.out.print("Enter Designation (Manager/Lead/Developer): ");
				String designation = sc.nextLine();

				Employee emp = new Employee(id, name, salary, designation);
				String scheme = ("service.findInsuranceScheme(salary, designation)");
				emp.setInsuranceScheme(scheme);

				System.out.println("\n=== Employee Details ===");
				System.out.println(emp);
			}
	    }
	}


