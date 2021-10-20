package conventions;

public class CarMain {

    public static void main(String[] args) {
        Car car = new Car("VW", "1.6 Turbo", 5, 5);

        System.out.println("Type: "+car.getCarType());
        System.out.println("Engine: "+car.getEngineType());
        System.out.println("Doors Num: "+car.getDoors());
        System.out.println("Persons Num: "+car.getPersons());

        System.out.println();

        car.setCarType("Ford");
        car.setEngineType("2.0 Turbo");
        car.setPersons(7);
        car.addModelName("Mustang");

        System.out.println("Type: "+car.getCarType());
        System.out.println("Engine: "+car.getEngineType());
        System.out.println("Doors Num: "+car.getDoors());
        System.out.println("Persons Num: "+car.getPersons());

    }
}
