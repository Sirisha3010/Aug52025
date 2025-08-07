package pack2;

	import java.time.LocalDate;
	import java.util.Scanner;

	public class Lab13 {

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.println("Enter product purchase date:");
	        System.out.print("Year (yyyy): ");
	        int year = sc.nextInt();

	        System.out.print("Month (1-12): ");
	        int month = sc.nextInt();

	        System.out.print("Day (1-31): ");
	        int day = sc.nextInt();

	       
	        System.out.println("\nEnter warranty period:");
	        System.out.print("Years: ");
	        int warrantyYears = sc.nextInt();

	        System.out.print("Months: ");
	        int warrantyMonths = sc.nextInt();

	        
	        LocalDate purchaseDate = LocalDate.of(year, month, day);

	       
	        LocalDate expiryDate = calculateWarrantyExpiryDate(purchaseDate, warrantyYears, warrantyMonths);

	       
	        System.out.println("\nWarranty Expiry Date: " + expiryDate);
	    }
	    public static LocalDate calculateWarrantyExpiryDate(LocalDate purchaseDate, int years, int months) {
	        return purchaseDate.plusYears(years).plusMonths(months);
	    }
	}
