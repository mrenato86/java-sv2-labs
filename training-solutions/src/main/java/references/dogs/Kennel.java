package references.dogs;

import java.util.ArrayList;
import java.util.List;

public class Kennel {

    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();

        Dog dog1 = new Dog("Skipper", 5, "brown");
        Dog dog2 = new Dog("Rex", 8, "black");
        Dog dog3 = new Dog("Daisy", 3, "white");
        dogs.add(dog1);
        dogs.add(dog2);
        dogs.add(dog3);
        System.out.println(dogs);

        Dog dog4 = dogs.get(1);
        dog4.setColour("blue");
        System.out.println(dogs);

        Dog dog5 = new Dog("Simba", 12, "light brown");
        System.out.println(dog5);

        dog5 = dogs.get(1);
        System.out.println(dog5);

        dogs.add(dog5);
        System.out.println(dogs);

        Dog dog6 = dog4;
        dog6.setColour("red");

        System.out.println(dogs);

        List<Dog> dogs2 = dogs;

        Dog dog7 = dog4;
        dog7.setColour("green");
        System.out.println(dogs2);

        dog2.setColour("violet");
        System.out.println(dogs2);

        dog2 = null;
        System.out.println(dogs2);

        Dog dog8 = dogs.get(1);
        dog8 = null;
        System.out.println(dogs2);

        Dog dog9 = dogs.get(1);
        dog9.setColour("metal gold");
        System.out.println(dogs2);

    }

}
