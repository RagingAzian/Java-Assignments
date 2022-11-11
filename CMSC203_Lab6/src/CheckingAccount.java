
public class CheckingAccount extends BankAccount {
	private static final double FEE = .15;

	public CheckingAccount(String name, int amount) {
		super(name, amount);
		setAccountNumber(getAccountNumber() + "-10");
	}

	@Override
	public boolean withdraw(double amount) {
		double totalAmount = FEE + amount;
		return super.withdraw(totalAmount);
	}
}
