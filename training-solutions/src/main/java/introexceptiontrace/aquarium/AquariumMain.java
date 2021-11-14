package introexceptiontrace.aquarium;

public class AquariumMain {

    public static void main(String[] args) {
        Aquarium aquarium = new Aquarium();

        Fish firstFish = new Fish("goldfish", "yellow");
        Fish secondFish = new Fish("neon-fish", "white");
        Fish thirdFish = new Fish("black-fish", "black");

        aquarium.addFish(firstFish);//Exception: List is null
        aquarium.addFish(secondFish);
        aquarium.addFish(thirdFish);

        System.out.println(aquarium.getNumberOfFish());
    }

}
