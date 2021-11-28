package initializer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CreditCard {

    private static final List<Rate> ACTUAL_RATES;

    private long balance;

    static {
        List<String> rates;
        try {
            rates = Files.readAllLines(Path.of("src/main/resources/initializer/conversionrates.csv"));
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read actual rates", ioe);
        }
        ACTUAL_RATES = new ArrayList<>(rates.size());
        for (String rate : rates) {
            String[] pair = rate.split(";");
            ACTUAL_RATES.add(new Rate(Currency.valueOf(pair[0]), Double.parseDouble(pair[1])));
        }
    }

    public static double getCurrentRate(Currency currency) {
        for (Rate rate : ACTUAL_RATES) {
            if (rate.getCurrency() == currency) {
                return rate.getConversionFactor();
            }
        }
        return 1.0;
    }

    public CreditCard(long balance, Currency currency) {
        this.balance = Math.round(balance * getCurrentRate(currency));
    }

    public CreditCard(long balance) {
        this(balance, Currency.HUF);
    }

    public long getBalance() {
        return balance;
    }

    public boolean payment(long amount, Currency currency) {
        long value = Math.round(amount * getCurrentRate(currency));
        if (value <= balance) {
            balance -= value;
            return true;
        }
        return false;
    }

    public boolean payment(long amount) {
        return payment(amount, Currency.HUF);
    }

}
