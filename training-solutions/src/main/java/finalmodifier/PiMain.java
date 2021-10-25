package finalmodifier;

import static finalmodifier.CircleCalculator.PI;

public class PiMain {

    public static void main(String[] args) {
        System.out.println("PI value: " + PI + "\n");

        CircleCalculator circleClc = new CircleCalculator();
        System.out.println("Circle Area(r = 15): " + circleClc.calculateArea(15));
        System.out.println("Circle Perimeter(r = 15): " + circleClc.calculatePerimeter(15) + "\n");

        CylinderCalculator cylClc = new CylinderCalculator();
        System.out.println("Cylinder Volume(r = 15, h = 40): " + cylClc.calculateVolume(15, 40));
        System.out.println("Cylinder Surface Area(r = 15, h = 40): " + cylClc.calculateSurfaceArea(15, 40));

        System.out.println("\n" + "Based on circle: ");
        CylinderCalculatorBasedOnCircle cylClcOnCircle = new CylinderCalculatorBasedOnCircle();
        System.out.println("Cylinder Volume(r = 15, h = 40): " + cylClcOnCircle.calculateVolume(15, 40));
        System.out.println("Cylinder Surface Area(r = 15, h = 40): " + cylClcOnCircle.calculateSurfaceArea(15, 40));
    }
}
