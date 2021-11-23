package algorithmsmax.hill;

import java.util.List;

public class Hill {

    public int getMax(List<Integer> mountainHeights) {
        int max = mountainHeights.get(0);
        for (int height : mountainHeights) {
            if (height > max) {
                max = height;
            }
        }
        return max;
    }
}
