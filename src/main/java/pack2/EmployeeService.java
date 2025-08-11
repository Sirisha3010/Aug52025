package pack2;
	import java.io.*;
	import java.util.*;

	public class EmployeeService {

	    public void writeEmployeesToFile(List<Employee> employees, String filename) {
	        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
	            oos.writeObject(employees);
	            System.out.println("Employees written to file successfully.");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    @SuppressWarnings("unchecked")
	    public List<Employee> readEmployeesFromFile(String filename) {
	        List<Employee> employees = null;
	        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
	            employees = (List<Employee>) ois.readObject();
	            System.out.println("Employees read from file successfully.");
	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	        return employees;
	    }
	}


