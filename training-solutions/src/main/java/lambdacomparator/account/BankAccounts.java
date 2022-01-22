package lambdacomparator.account;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class BankAccounts {

    private final List<BankAccount> accounts;

    public BankAccounts(List<BankAccount> accounts) {
        this.accounts = new ArrayList<>(accounts);
    }

    public List<BankAccount> listBankAccountsByAccountNumber() {
        List<BankAccount> sorted = new ArrayList<>(accounts);
        sorted.sort(Comparator.naturalOrder());
        return sorted;
    }

    public List<BankAccount> listBankAccountsByBalance() {
        List<BankAccount> sorted = new ArrayList<>(accounts);
        sorted.sort(Comparator.comparingDouble(v -> Math.abs(v.getBalance())));
        return sorted;
    }

    public List<BankAccount> listBankAccountsByBalanceDesc() {
        List<BankAccount> sorted = new ArrayList<>(accounts);
        sorted.sort(Comparator.comparing(BankAccount::getBalance).reversed());
        return sorted;
    }

    public List<BankAccount> listBankAccountsByNameThenAccountNumber() {
        List<BankAccount> sorted = new ArrayList<>(accounts);
        Collator collator = Collator.getInstance(new Locale("hu", "HU"));
        sorted.sort(Comparator.comparing(BankAccount::getNameOfOwner, Comparator.nullsFirst(collator))
                .thenComparing(BankAccount::getAccountNumber));
        return sorted;
    }
}
