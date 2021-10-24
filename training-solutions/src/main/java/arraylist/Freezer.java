package arraylist;

import java.util.ArrayList;
import java.util.List;

public class Freezer {

    public static void main(String[] args) {
        List<String> shoppingList = new ArrayList<>();
        shoppingList.add("Banana");
        shoppingList.add("Milk");
        shoppingList.add("Chicken breast");
        shoppingList.add("Chocolate");
        shoppingList.add("Pear");

        System.out.println(shoppingList);
        System.out.println(shoppingList.size());

        shoppingList.remove(1);
        shoppingList.remove("Pear");
        System.out.println(shoppingList);
        System.out.println(shoppingList.size());
    }

}
