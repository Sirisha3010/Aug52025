package pack2;

import java.util.Scanner;

public class Lab32 {



	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        try {
	            System.out.print("Enter Name: ");
	            String name = sc.nextLine();

	            System.out.print("Enter Age: ");
	            int age = sc.nextInt();

	            if (age <= 15) {
	                throw new AgeNotValid("Age must be above 15!");
	            }

	            Personpack2 p = new Personpack2(name, age);
	            System.out.println("\n=== Person Details ===");
	            System.out.println(p.getDetails());

	        } catch (AgeNotValid e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }
	}


