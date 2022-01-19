package lambda;

import java.util.ArrayList;
import java.util.List;

public class TreeNursery {

    private List<Sapling> saplings;

    public TreeNursery(List<Sapling> saplings) {
        this.saplings = saplings;
    }

    public void prune(int maxHeight) {
        if (saplings != null && maxHeight > 0) {
            saplings.forEach(s -> s.cut(maxHeight));
        }
    }

    public void sell(String species, int minHeight) {
        if (saplings != null && minHeight > 0) {
            saplings.removeIf(s -> (s.getSpecies().equals(species) && s.getHeight() > minHeight));
        }
    }

    public List<Sapling> getSaplings() {
        return new ArrayList<>(saplings);
    }
}
