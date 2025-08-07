package pack2;
import java.util.Scanner;
public class Lab31 {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        try {
	            System.out.print("Enter First Name: ");
	            String firstName = sc.nextLine().trim();

	            System.out.print("Enter Last Name: ");
	            String lastName = sc.nextLine().trim();

	            if (firstName.isEmpty() || lastName.isEmpty()) {
	                throw new NameNotValid("First name or Last name should not be blank!");
	            }

	            Employee emp = new Employee(firstName, lastName);
	            System.out.println("Full Name: " + emp.getFullName());

	        } catch (NameNotValid e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }
	}


