package exceptionclass.bank;

public class Account {

    private static final double MAX_SUBTRACT_DEFAULT = 100000;

    private final String accountNumber;
    private double balance;
    private double maxSubtract;

    public Account(String accountNumber, double balance) {
        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException("Account number should not be null!");
        }
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.maxSubtract = MAX_SUBTRACT_DEFAULT;
    }

    public void subtract(double amount) {
        if (amount > maxSubtract || amount <= 0) {
            throw new InvalidAmountBankOperationException("Invalid amount!");
        }
        if (this.balance < amount) {
            throw new LowBalanceBankOperationException("Low balance!");
        }
        this.balance -= amount;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new InvalidAmountBankOperationException("Invalid amount!");
        }
        this.balance += amount;
    }

    public void setMaxSubtract(double maxSubtract) {
        if (maxSubtract < 0) {
            throw new InvalidAmountBankOperationException("Invalid amount!");
        }
        this.maxSubtract = maxSubtract;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public double getMaxSubtract() {
        return maxSubtract;
    }
}
