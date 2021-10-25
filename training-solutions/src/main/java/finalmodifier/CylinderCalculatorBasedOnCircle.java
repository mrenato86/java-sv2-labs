package finalmodifier;

public class CylinderCalculatorBasedOnCircle {

    public double calculateVolume(double r, double h) {
        return new CircleCalculator().calculateArea(r) * h;
    }

    public double calculateSurfaceArea(double r, double h) {
        CircleCalculator cCalc = new CircleCalculator();
        return 2 * cCalc.calculateArea(r) + cCalc.calculatePerimeter(r) * h;
    }

}
