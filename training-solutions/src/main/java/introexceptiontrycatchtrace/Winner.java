package introexceptiontrycatchtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Winner {

    private List<String> names = new ArrayList<>(Arrays.asList("John Doe", "Jane Doe", null, "Black Jack"));

    public String getWinner() {
        Random random = new Random();
        return names.get(random.nextInt(names.size())).toUpperCase();
    }

}
