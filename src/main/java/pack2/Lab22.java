package pack2;

public class Lab22 {
	    public static void main(String[] args) {
	        SavingsAccount sa = new SavingsAccount(new Person("Alice", 28f), 5000);
	        sa.deposit(1000);
	        sa.withdraw(4500); 

	        CurrentAccount ca = new CurrentAccount(new Person("Bob", 30f), 4000);
	        ca.withdraw(4500); 
	    }
	}


