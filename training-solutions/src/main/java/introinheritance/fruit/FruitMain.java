package introinheritance.fruit;

public class FruitMain {

    public static void main(String[] args) {
        Fruit fruit = new Fruit();
        fruit.setName("fruit");
        fruit.setWeight(3.2);
        System.out.println(fruit.getName());
        System.out.println(fruit.getWeight());
        System.out.println();

        Grape grape = new Grape();
        grape.setName("grape");
        grape.setWeight(2.3);
        grape.setType("sweetest grape");
        System.out.println(grape.getName());
        System.out.println(grape.getWeight());
        System.out.println(grape.getType());
        System.out.println();

        Apple apple = new Apple();
        apple.setName("apple");
        apple.setWeight(1.2);
        apple.setPieces(5);
        System.out.println(apple.getName());
        System.out.println(apple.getWeight());
        System.out.println(apple.getPieces());
        System.out.println();

        GoldenDelicious golden = new GoldenDelicious();
        golden.setName("golden apple");
        golden.setWeight(1.3);
        golden.setPieces(6);
        System.out.println(golden.getName());
        System.out.println(golden.getWeight());
        System.out.println(golden.getPieces());
        System.out.println(golden.getColour());
        System.out.println();

        Starking starking = new Starking();
        starking.setName("starking apple");
        starking.setWeight(1.5);
        starking.setPieces(10);
        System.out.println(starking.getName());
        System.out.println(starking.getWeight());
        System.out.println(starking.getPieces());
        System.out.println(starking.getColour());
    }
}
