package aslist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sequence {

    public static void main(String[] args) {
        List<Integer> elements = new ArrayList<>(Arrays.asList(1, 2));
        int startSize = elements.size();
        int targetSize = startSize + 5;

        for (int i = startSize; i < targetSize; i++) {
            elements.add(i, elements.get(i - 1) * elements.get(i - 2));
        }
        System.out.println(elements);
    }

}
