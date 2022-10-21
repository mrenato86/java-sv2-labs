package templatemethod.bank;

public abstract class GeneralProduct {

    private int price;

    protected abstract int round(double newPrice);

    public GeneralProduct(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void increase(double percent) {
        price += round(price * (percent / 100));
    }

}
