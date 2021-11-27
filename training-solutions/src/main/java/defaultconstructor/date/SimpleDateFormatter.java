package defaultconstructor.date;

public class SimpleDateFormatter {

    private CountryCode defaultCountry;

    public SimpleDateFormatter() {
        this.defaultCountry = CountryCode.HU;
    }

    public String formatDateString(SimpleDate simpleDate) {
        return formatDateStringByCountryCode(defaultCountry, simpleDate);
    }

    public String formatDateStringByCountryCode(CountryCode countryCode, SimpleDate simpleDate) {
        switch (countryCode) {
            case EN:
                return String.format("%1$d-%2$d-%3$d", simpleDate.getDay(), simpleDate.getMonth(), simpleDate.getYear());
            case US:
                return String.format("%2$d-%1$d-%3$d", simpleDate.getDay(), simpleDate.getMonth(), simpleDate.getYear());
            default:
                return String.format("%3$d-%2$d-%1$d", simpleDate.getDay(), simpleDate.getMonth(), simpleDate.getYear());
        }
    }
}
