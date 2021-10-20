package localvariables;

import java.util.Scanner;

public class DistanceMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Distance in km: ");
        double distance = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Is it exact(true/false)?: ");
        boolean exact = scanner.nextBoolean();

        Distance distanceInstance = new Distance(distance,exact);
        System.out.println("Distance is a " + distanceInstance.isExact() + " " + distanceInstance.getDistanceInKm() + "km");

        int shredded = (int) distanceInstance.getDistanceInKm();
        System.out.println("Shredded value: " + shredded + "km");

    }
}
