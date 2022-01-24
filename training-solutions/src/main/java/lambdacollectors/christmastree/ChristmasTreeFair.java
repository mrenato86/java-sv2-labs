package lambdacollectors.christmastree;

import java.util.*;
import java.util.stream.Collectors;

public class ChristmasTreeFair {

    private final List<ChristmasTree> christmasTrees;

    public ChristmasTreeFair(List<ChristmasTree> christmasTrees) {
        this.christmasTrees = new ArrayList<>(christmasTrees);
    }

    public Map<PineTreeType, Long> getCountByType() {
        return christmasTrees.stream()
                .collect(Collectors.groupingBy(ChristmasTree::getType, Collectors.counting()));
    }

    public double getMaxHeightByType(PineTreeType type) {
        Optional<ChristmasTree> result = christmasTrees.stream()
                .filter(tree -> tree.getType() == type)
                .collect(Collectors.maxBy(Comparator.comparing(ChristmasTree::getHeight)));
        return result.map(ChristmasTree::getHeight).orElse(0.);
    }

    public double getAveragePrice() {
        return christmasTrees.stream()
                .collect(Collectors.averagingDouble(ct -> ct.getHeight() * ct.getType().getPricePerMeter()));
    }
}
