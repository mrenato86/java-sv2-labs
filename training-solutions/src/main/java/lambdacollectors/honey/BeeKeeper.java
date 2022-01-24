package lambdacollectors.honey;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BeeKeeper {

    private List<Honey> honeys;

    public BeeKeeper(List<Honey> honeys) {
        this.honeys = new ArrayList<>(honeys);
    }

    public void addHoney(Honey honey) {
        if (honeys == null) {
            honeys = new ArrayList<>();
        }
        honeys.add(honey);
    }

    public int getTotalValueOfGivenGlasses(GlassSize size) {
        return honeys.stream()
                .filter(h -> h.getGlassSize() == size)
                .collect(Collectors.summingInt(h -> (int) (h.getGlassSize().getAmountByKg() * h.getHoneyType().getPricePerKg())));
    }

    public Map<GlassSize, Long> getAmountsOfGivenType(HoneyType type) {
        return honeys.stream()
                .filter(h -> h.getHoneyType() == type)
                .collect(Collectors.groupingBy(Honey::getGlassSize, Collectors.counting()));
    }

    public Map<Boolean, List<Honey>> getGroupsByGivenTypeAndSize(HoneyType type, GlassSize size) {
        return honeys.stream()
                .collect(Collectors.partitioningBy(h -> h.getHoneyType() == type && h.getGlassSize() == size));
    }
}
