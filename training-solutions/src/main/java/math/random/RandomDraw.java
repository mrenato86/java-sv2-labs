package math.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomDraw {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of(
                "Little John", "Joe Doe", "Jane Doe", "Tom Bombadil", "Big Pete",
                "Longboat Ragnar", "Cortney Kreiger", "Yoshiko Mills", "Orion Oberbrunner",
                "Euna Gottlieb", "Nyah Russel")
        );

        Random random = new Random();
        System.out.println("The winners are:");
        System.out.println(names.get(random.nextInt(5)));
        System.out.println(names.get(random.nextInt(5) + 5));

        System.out.println();

        Random randomSeed = new Random(172);
        System.out.println("The cheaters are:");
        System.out.println(names.get(randomSeed.nextInt(5)));
        System.out.println(names.get(randomSeed.nextInt(5) + 5));
    }

}
