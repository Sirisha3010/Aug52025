package pack2;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Lab12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

      
        System.out.println("Enter the first date:");
        System.out.print("Year (yyyy): ");
        int year1 = sc.nextInt();

        System.out.print("Month (1-12): ");
        int month1 = sc.nextInt();

        System.out.print("Day (1-31): ");
        int day1 = sc.nextInt();

        System.out.println("\nEnter the second date:");
        System.out.print("Year (yyyy): ");
        int year2 = sc.nextInt();

        System.out.print("Month (1-12): ");
        int month2 = sc.nextInt();

        System.out.print("Day (1-31): ");
        int day2 = sc.nextInt();

        // Create LocalDate objects
        LocalDate date1 = LocalDate.of(year1, month1, day1);
        LocalDate date2 = LocalDate.of(year2, month2, day2);

        // Ensure earlier date is first
        if (date1.isAfter(date2)) {
            LocalDate temp = date1;
            date1 = date2;
            date2 = temp;
        }

        
        Period period = Period.between(date1, date2);

        
        System.out.println("\n Duration Between Dates");
        System.out.println("From: " + date1);
        System.out.println("To  : " + date2);
        System.out.println("Years : " + period.getYears());
        System.out.println("Months: " + period.getMonths());
        System.out.println("Days  : " + period.getDays());
    }
}
