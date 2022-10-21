package templatemethod.bank;

public class YieldProduct extends GeneralProduct {
    public YieldProduct(int price) {
        super(price);
    }

    @Override
    protected int round(double newPrice) {
        return (int) Math.floor(newPrice);
        //return (int) newPrice;
    }
}
