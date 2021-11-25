package methodparam.sums;

public class Sums {

    private double sumOfPositives;
    private double sumOfNegatives;

    public Sums(double sumOfPositives, double sumOfNegatives) {
        this.sumOfPositives = sumOfPositives;
        this.sumOfNegatives = sumOfNegatives;
    }

    public double getSumOfPositives() {
        return sumOfPositives;
    }

    public double getSumOfNegatives() {
        return sumOfNegatives;
    }
}
