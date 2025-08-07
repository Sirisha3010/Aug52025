package pack2;


	import java.util.Scanner;
	import com.cg.eis.service.EmployeeException;

	public class Lab33 {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        try {
	            System.out.print("Enter Employee ID: ");
	            int id = sc.nextInt();
	            sc.nextLine();

	            System.out.print("Enter Employee Name: ");
	            String name = sc.nextLine();

	            System.out.print("Enter Employee Salary: ");
	            double salary = sc.nextDouble();

	            if (salary < 3000) {
	                throw new EmployeeException("Salary must be at least 3000.");
	            }

	            EmployeeException emp = new EmployeeException(name);
	            System.out.println("\n=== Employee Details ===");
	            System.out.println(emp);

	        } catch (EmployeeException e) {
	            System.out.println("Exception: " + e.getMessage());
	        }
	    }
	}


