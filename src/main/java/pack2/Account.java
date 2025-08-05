package pack2;

public class Account {
	    private static long nextAccNum = 1000001;

	    private long accNum;
	    protected double balance;
	    private Person accHolder;

	    public Account(Person accHolder, double balance) {
	        this.accNum = nextAccNum++;
	        this.balance = balance;
	        this.accHolder = accHolder;
	    }

	    public void deposit(double amount) {
	        if (amount > 0) {
	            balance += amount;
	            System.out.println("₹" + amount + " deposited to account " + accNum);
	        } else {
	            System.out.println("Invalid deposit amount.");
	        }
	    }

	    public void withdraw(double amount) {
	        if (amount <= 0) {
	            System.out.println("Invalid withdrawal amount.");
	        } else if (balance - amount >= 500) {
	            balance -= amount;
	            System.out.println("₹" + amount + " withdrawn from account " + accNum);
	        } else {
	            System.out.println("Withdrawal denied. Minimum balance of ₹500 must be maintained.");
	        }
	    }

	    public double getBalance() {
	        return balance;
	    }

	    public long getAccNum() {
	        return accNum;
	    }

	    public Person getAccHolder() {
	        return accHolder;
	    }

	    @Override
	    public String toString() {
	        return "Account No: " + accNum + ", Balance: ₹" + balance + ", Holder: [" + accHolder + "]";
	    }
	}


