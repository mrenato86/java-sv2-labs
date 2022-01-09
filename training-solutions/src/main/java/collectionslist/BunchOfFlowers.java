package collectionslist;

import java.util.LinkedList;
import java.util.List;

public class BunchOfFlowers {

    private List<String> bunch = new LinkedList<>();

    public List<String> getBunch() {
        return new LinkedList<>(bunch);
    }

    public void addFlower(String flower) {
        bunch.add(flower);
    }

    public void addFlowerInTheMiddle(String flower) {
        int index = bunch.size() / 2;
        if (bunch.size() % 2 != 0) {
            bunch.add(index + 1, flower);
        }
        bunch.add(index, flower);
    }

}
