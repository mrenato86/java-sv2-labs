package finalmodifier;

public class TaxCalculator {

    public static final double VAT = 27;

    public double tax(double price) {
        return price * (VAT / 100);
    }

    public double priceWithTax(double price) {
        return price + tax(price);
    }

    public static void main(String[] args) {
        TaxCalculator taxCalculator = new TaxCalculator();
        System.out.println("VAT: " + TaxCalculator.VAT);
        System.out.println("VAT for price(1900): " + taxCalculator.tax(1900));
        System.out.println("Price(1900) with VAT: " + taxCalculator.priceWithTax(1900));
    }

}
