package lambdacomparator.cloud;

public class CloudStorage implements Comparable<CloudStorage> {

    private String provider;
    private int space;
    private double price;
    private PayPeriod period;

    public CloudStorage(String provider, int space) {
        this.provider = provider;
        this.space = space;
    }

    public CloudStorage(String provider, int space, PayPeriod period, double price) {
        this(provider, space);
        this.period = period;
        this.price = price;
    }

    public String getProvider() {
        return provider;
    }

    public int getSpace() {
        return space;
    }

    public double getPrice() {
        return price;
    }

    public PayPeriod getPeriod() {
        return period;
    }

    @Override
    public int compareTo(CloudStorage o) {
        double currentValue = this.period != null ? this.price * 12 / this.period.getLength() / this.space * 1000 : 0;
        double otherValue = o.period != null ? o.price * 12 / o.period.getLength() / o.space * 1000 : 0;
        return Double.compare(currentValue, otherValue);
    }
}
