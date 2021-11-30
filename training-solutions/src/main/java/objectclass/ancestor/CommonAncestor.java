package objectclass.ancestor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CommonAncestor {

    public static void main(String[] args) {
        List<Object> objectList = new ArrayList<>();
        objectList.add(new Fruit());
        objectList.add(new Apple());
        objectList.add(new Starking());
        objectList.add(new Vegetable());
        objectList.add("alma");
        objectList.add(12);
        objectList.add('x');
        objectList.add(LocalDate.now());
        objectList.add(new int[]{1, 2, 3, 4, 5});
        objectList.add(List.of("one", "two", "three"));

        System.out.println(objectList);
    }
}
