package lambdastreams.baseoperations;

import java.util.*;

public class Operations {

    private final List<Integer> numbers;

    public Operations(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    public Optional<Integer> min() {
        return numbers.stream().min(Integer::compareTo);
    }

    public Integer sum() {
        return numbers.stream().reduce(0, Integer::sum);
    }

    public boolean isAllPositive() {
        return numbers.stream().allMatch(n -> n > 0);
    }

    public Set<Integer> getDistinctElements() {
        return numbers.stream().collect(HashSet::new, Set::add, Set::addAll);
    }

}
