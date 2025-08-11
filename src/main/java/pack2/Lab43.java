package pack2;
	import java.util.*;

	public class Lab43 {
	    public static void main(String[] args) {
	        EmployeeService service = new EmployeeService();

	    
	        List<Employee> employees = new ArrayList<>();
	        Employee.add(new Employee1(101, "Ravi", 50000));
	        Employee.add(new Employee1(102, "Sita", 60000));
	        Employee.add(new Employee1(103,"siri",30000));

	        String filename = "employees.dat";
	        service.writeEmployeesToFile(employees, filename);

	        List<Employee> readList = service.readEmployeesFromFile(filename);

	        if (readList != null) {
	            for (Employee emp : readList) {
	                System.out.println(emp);
	            }
	        }
	    }
	}


