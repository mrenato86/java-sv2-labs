package formatlocaleprintf;

import java.util.ArrayList;
import java.util.List;

public class Thanks {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of("Jack", "Julia", "Peter"));

        for (String name : names) {
            System.out.printf("Dear %s! We are so glad that you chose our product!\n", name);
        }
    }
}
