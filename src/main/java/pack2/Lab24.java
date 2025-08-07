package pack2;


	import java.util.Scanner;
	import com.cg.eis.bean.Employee;
    import com.cg.eis.service.EmployeeService1;
	import com.cg.eis.pl.EmployeeServiceImpl;

	public class Lab24 {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        EmployeeServiceImpl service = new EmployeeServiceImpl();

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

	        
	        String scheme = service.findInsuranceScheme(salary, designation);
	        emp.setInsuranceScheme(scheme);

	        
	        service.showEmployeeDetails(emp);
	    }
	}
	


