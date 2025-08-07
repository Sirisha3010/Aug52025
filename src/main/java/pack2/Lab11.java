package pack2;
	import java.time.LocalDate;
	import java.time.Period;
	import java.util.Scanner;
	public class Lab11 {

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter year (yyyy): ");
	        int year = sc.nextInt();

	        System.out.print("Enter month (1-12): ");
	        int month = sc.nextInt();

	        System.out.print("Enter day (1-31): ");
	        int day = sc.nextInt();

	        LocalDate inputDate = LocalDate.of(year, month, day);
	        LocalDate currentDate = LocalDate.now();
	        Period period = Period.between(inputDate, currentDate);

	        
	        System.out.println(" Duration");
	        System.out.println("Years: " + period.getYears());
	        System.out.println("Months: " + period.getMonths());
	        System.out.println("Days: " + period.getDays());
	    }

		public void displayLab11Details() {
			// TODO Auto-generated method stub
			
		}
	}


