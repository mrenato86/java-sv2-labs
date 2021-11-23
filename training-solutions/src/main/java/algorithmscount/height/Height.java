package algorithmscount.height;

import java.util.List;

public class Height {

    public int countChildrenWithHeightGreaterThan(List<Integer> heights, int limit) {
        int count = 0;
        for (int height : heights) {
            if (height > limit) {
                count++;
            }
        }
        return count;
    }
}
