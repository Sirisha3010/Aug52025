package pack2;

public class SavingsAccount extends Account {
    private final double minimumBalance = 500;

    public SavingsAccount(Person accHolder, double balance) {
        super(accHolder, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= minimumBalance) {
            balance -= amount;
        } else {
            System.out.println("Cannot withdraw. Minimum balance of INR " + minimumBalance + " should be maintained.");
        }
    }
}
