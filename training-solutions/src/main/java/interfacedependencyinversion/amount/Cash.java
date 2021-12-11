package interfacedependencyinversion.amount;

public class Cash implements Payable {

    @Override
    public int getPayableAmount(int amount) {
        int number = Math.abs(amount);
        int delta = number % 5;
        number += (delta < 3) ? -delta : 5 - delta;
        return (amount < 0) ? -number : number;
    }
}
