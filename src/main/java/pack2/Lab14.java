package pack2;


	import java.time.ZonedDateTime;
	import java.time.ZoneId;
	import java.time.format.DateTimeFormatter;
	import java.util.Scanner;

	public class Lab14 {

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.println("Enter Zone ID (e.g., America/New_York, Europe/London, Asia/Tokyo, US/Pacific, Africa/Cairo, Australia/Sydney):");
	        String zoneInput = sc.nextLine();

	        displayZoneDateTime(zoneInput);
	    }

	    public static void displayZoneDateTime(String zoneId) {
	        try {
	            ZoneId zone = ZoneId.of(zoneId);
	            ZonedDateTime dateTime = ZonedDateTime.now(zone);

	            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
	            System.out.println("Current date and time in " + zoneId + ": " + dateTime.format(formatter));
	        } catch (Exception e) {
	            System.out.println("Invalid Zone ID. Please enter a valid one (e.g., Asia/Tokyo).");
	        }
	    }
	}


