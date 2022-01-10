package collectionsmap;

import java.util.Map;

public class Casting {

    public String callNextApplicant(int lastNumber, Map<Integer, String> applicants) {
        int next = Integer.MAX_VALUE;
        for (int key : applicants.keySet()) {
            if (key > lastNumber && key < next) {
                next = key;
            }
        }
        return applicants.get(next);
    }
}
