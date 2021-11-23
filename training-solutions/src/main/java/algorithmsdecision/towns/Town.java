package algorithmsdecision.towns;

import java.util.List;

public class Town {

    public boolean containsFewerHabitants(List<Integer> residents, int maxLimit) {
        for (int resident : residents) {
            if (resident < maxLimit) {
                return true;
            }
        }
        return false;
    }
}
