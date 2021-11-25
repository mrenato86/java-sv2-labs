package methodstructure.bmi;

public class BodyMass {

    public static final double BMI_LOWER_LIMIT = 18.5;
    public static final double BMI_UPPER_LIMIT = 25.0;

    private double weight;
    private double height;

    public BodyMass(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    public double getBodyMassIndex() {
        return weight / Math.pow(height, 2);
    }

    public BmiCategory getBody() {
        double bmi = getBodyMassIndex();
        if (bmi < BMI_LOWER_LIMIT) {
            return BmiCategory.UNDERWEIGHT;
        }
        if (bmi > BMI_UPPER_LIMIT) {
            return BmiCategory.OVERWEIGHT;
        }
        return BmiCategory.NORMAL;
    }

    public boolean isThinnerThan(BodyMass other) {
        return getBodyMassIndex() < other.getBodyMassIndex();
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }
}
