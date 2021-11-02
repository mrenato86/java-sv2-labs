package stringseparate;

import java.util.ArrayList;
import java.util.List;

public class IceCream {

    public static void main(String[] args) {
        List<String> flavors = new ArrayList<>(List.of(new String[]{"chocolate", "vanilla", "strawberry", "lemon", "punch"}));
        String promotion = "Half price for kids!";

        StringBuilder sb = new StringBuilder("Available today: ");
        sb.append(flavors.get(0));
        for (int i = 1; i < flavors.size(); i++) {
            sb.append(", ").append(flavors.get(i));
        }
        sb.append(". ").append(promotion);

        System.out.println(sb);
    }

}
