package exceptionclass.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private final List<Account> accounts;

    public Bank(List<Account> accounts) {
        if (accounts == null) {
            throw new IllegalArgumentException("Account list should not be null!");
        }
        if (containsDuplicateAccount(accounts)) {
            throw new IllegalArgumentException("Duplicate account found!");
        }
        this.accounts = accounts;
    }

    public void withdraw(String accountNumber, double amount) {
        searchAccount(accountNumber).subtract(amount);
    }

    public void deposit(String accountNumber, double amount) {
        searchAccount(accountNumber).deposit(amount);

    }

    private boolean containsDuplicateAccount(List<Account> accounts) {
        List<String> accountNumbers = new ArrayList<>(accounts.size());
        for (Account account : accounts) {
            if (accountNumbers.contains(account.getAccountNumber())) {
                return true;
            }
            accountNumbers.add(account.getAccountNumber());
        }
        return false;
    }

    private Account searchAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        throw new InvalidAccountNumberBankOperationException("Invalid account number!");
    }

}
