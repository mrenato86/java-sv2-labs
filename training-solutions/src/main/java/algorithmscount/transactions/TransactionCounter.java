package algorithmscount.transactions;

import java.util.List;

public class TransactionCounter {

    public int countEntryLessThan(List<Transaction> transactions, int max) {
        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction.isCredit() && transaction.getAmount() < max) {
                count++;
            }
        }
        return count;
    }

}
