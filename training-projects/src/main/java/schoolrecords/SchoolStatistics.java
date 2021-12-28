package schoolrecords;

import java.util.List;

public class SchoolStatistics {

    public static double roundToTwoPrecision(double number) {
        return Math.round(100 * number) / 100.;
    }

    public static double getAvg(List<Double> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0.;
        }
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        return roundToTwoPrecision(sum / numbers.size());
    }
}
