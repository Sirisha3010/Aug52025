package pack2;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter First Name: ");
        String firstName = sc.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = sc.nextLine();

        System.out.print("Enter Birth Year: ");
        int year = sc.nextInt();

        System.out.print("Enter Birth Month: ");
        int month = sc.nextInt();

        System.out.print("Enter Birth Day: ");
        int day = sc.nextInt();

       
        LocalDate dob = LocalDate.of(year, month, day);

        
        Lab11 p = new Lab11();

        // Display info
        System.out.println("\n--- Person Details ---");
        p.displayLab11Details();
    }
}
