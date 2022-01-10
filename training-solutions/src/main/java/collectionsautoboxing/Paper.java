package collectionsautoboxing;

import java.util.HashMap;
import java.util.Map;

public class Paper {

    private Map<String, Integer> paperByClass = new HashMap<>();

    public Map<String, Integer> getPaperByClass() {
        return new HashMap<>(paperByClass);
    }

    public void putFurtherPaper(String className, int kilograms) {
        if (kilograms == 0) {
            return;
        }
        int actualKg = paperByClass.getOrDefault(className, 0);
        paperByClass.put(className, actualKg + kilograms);
    }

    public String getWinnerClass() {
        String winner = "";
        int maxKg = Integer.MIN_VALUE;
        for (String name : paperByClass.keySet()) {
            int kg = paperByClass.get(name);
            if (kg > maxKg) {
                maxKg = kg;
                winner = name;
            }
        }
        return winner;
    }

    public int getTotalWeight() {
        int total = 0;
        for (int kg : paperByClass.values()) {
            total += kg;
        }
        return total;
    }
}
