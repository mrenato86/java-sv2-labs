package interfacedependencyinversion.amount;

public class BankAtm implements Payable {

    @Override
    public int getPayableAmount(int amount) {
        int thousand = amount / 1000;
        return ++thousand * 1000;
    }
}
