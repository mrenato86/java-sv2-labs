package finalmodifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Week {

    public static final List<String> DAYS_OF_WEEK = new ArrayList<>(Arrays.asList("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"));

    public static void main(String[] args) {
        System.out.println(DAYS_OF_WEEK);
        DAYS_OF_WEEK.set(1, "Wed");
        DAYS_OF_WEEK.add("FunDay");
        DAYS_OF_WEEK.remove("Mon");
        System.out.println(DAYS_OF_WEEK);
    }

}
