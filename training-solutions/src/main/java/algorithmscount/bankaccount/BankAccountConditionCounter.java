package algorithmscount.bankaccount;

import java.util.List;

public class BankAccountConditionCounter {

    public int countWithBalanceGreaterThan(List<BankAccount> accounts, int limit) {
        int count = 0;
        for (BankAccount account : accounts) {
            if (account.getBalance() > limit) {
                count++;
            }
        }
        return count;
    }

}
