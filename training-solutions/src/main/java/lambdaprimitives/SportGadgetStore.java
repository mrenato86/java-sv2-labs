package lambdaprimitives;

import java.util.IntSummaryStatistics;
import java.util.List;

public class SportGadgetStore {

    private final List<Product> products;

    public SportGadgetStore(List<Product> products) {
        this.products = products;
    }

    public int getNumberOfProducts() {
        return products.stream()
                .mapToInt(Product::getPieces)
                .sum();
    }

    public double getAveragePrice() {
        return products.stream()
                .mapToDouble(Product::getPrice)
                .average()
                .orElse(0.);
    }

    public String getExpensiveProductStatistics(double minPrice) {
        IntSummaryStatistics stats = products.stream()
                .filter(p -> p.getPrice() > minPrice)
                .mapToInt(Product::getPieces)
                .summaryStatistics();
        if (stats.getCount() > 0) {
            return String.format(
                    "Összesen %d féle termék, amelyekből minimum %d db, maximum %d db, összesen %d db van.",
                    stats.getCount(), stats.getMin(), stats.getMax(), stats.getSum());

        }
        return "Nincs ilyen termék.";
    }
}
