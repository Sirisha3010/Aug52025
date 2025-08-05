package pack2;

	public class CurrentAccount extends Account {
	    private double overdraftLimit = 1000;

	    public CurrentAccount(Person accHolder, double balance) {
	        super(accHolder, balance);
	    }

	    @Override
	    public void withdraw(double amount) {
	        if (balance - amount >= -overdraftLimit) {
	            balance -= amount;
	        } else {
	            System.out.println("Overdraft limit reached. Withdrawal denied.");
	        }
	    }
	}


