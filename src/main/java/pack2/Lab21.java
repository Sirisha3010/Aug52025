package pack2;

public class Lab21 {
	    public static void main(String[] args) {
	        Person smith = new Person("Smith", 35.0f);
	        Person kathy = new Person("Kathy", 28.0f);

	        Account smithAccount = new Account(smith, 2000.0);
	        Account kathyAccount = new Account(kathy, 3000.0);

	        smithAccount.deposit(2000.0);
	        kathyAccount.withdraw(2000.0);

	        System.out.println("\n--- Account Details After Transactions ---");
	        System.out.println(smithAccount);
	        System.out.println(kathyAccount);
	    }
	}
	


