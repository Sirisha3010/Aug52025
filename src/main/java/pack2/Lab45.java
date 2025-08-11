
	package pack2;

	import java.util.HashMap;
	import java.util.Map;
	import java.util.Scanner;


	class Maps{
	    int id;
	    String name;
	    double salary;
	    String insuranceScheme;

	    public Maps(int id, String name, double salary, String insuranceScheme) {
	        this.id = id;
	        this.name = name;
	        this.salary = salary;
	        this.insuranceScheme = insuranceScheme;
	    }

	    @Override
	    public String toString() {
	        return "ID: " + id + ", Name: " + name + ", Salary: " + salary + ", Scheme: " + insuranceScheme;
	    }
	}

	public class Lab45 {
	    private static final HashMap<Integer, Employee> SchemeMap = null;

		public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        HashMap<Integer, Employee> employeeMap = new HashMap<>();

	        while (true) {
	            System.out.println("\nMenu:");
	            System.out.println("1. Add Employee");
	            System.out.println("2. Display by Insurance Scheme");
	            System.out.println("3. Delete Employee");
	            System.out.println("4. Display All");
	            System.out.println("5. Exit");
	            System.out.print("Enter choice: ");
	            int choice = sc.nextInt();
	            sc.nextLine();

	            switch (choice) {
	                case 1: 
	                    System.out.print("Enter Employee ID: ");
	                    int id = sc.nextInt();
	                    sc.nextLine();

	                    System.out.print("Enter Employee Name: ");
	                    String name = sc.nextLine();

	                    System.out.print("Enter Salary: ");
	                    double salary = sc.nextDouble();
	                    sc.nextLine();

	                    System.out.print("Enter Insurance Scheme: ");
	                    String scheme = sc.nextLine();

	                    Maps emp = new Maps(id, name, salary, scheme);
	                    MapsMap.put(id, emp);
	                    System.out.println("Employee added successfully!");
	                    break;

	                case 2: 
	                    System.out.print("Enter Insurance Scheme to search: ");
	                    String searchScheme = sc.nextLine();
	                    boolean found = false;
	                    for (Map.Entry<Integer, Employee> entry : employeeMap.entrySet()) {
	                        if (((String) entry.getValue().insuranceScheme).equalsIgnoreCase(searchScheme)) {
	                            System.out.println(entry.getValue());
	                            found = true;
	                        }
	                    }
	                    if (!found) {
	                        System.out.println("No employees found for scheme: " + searchScheme);
	                    }
	                    break;

	                case 3: 
	                    System.out.print("Enter Employee ID to delete: ");
	                    int deleteId = sc.nextInt();
	                    if (employeeMap.remove(deleteId) != null) {
	                        System.out.println("Employee deleted successfully!");
	                    } else {
	                        System.out.println("Employee ID not found.");
	                    }
	                    break;

	                case 4: 
	                    if (employeeMap.isEmpty()) {
	                        System.out.println("No employees to display.");
	                    } else {
	                        for (Employee e : employeeMap.values()) {
	                            System.out.println(e);
	                        }
	                    }
	                    break;

	                case 5: 
	                    System.out.println("Exiting...");
	                    sc.close();
	                    return;

	                default:
	                    System.out.println("Invalid choice!");
	            }
	        }
	    }
	}
	


