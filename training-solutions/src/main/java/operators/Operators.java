package operators;

public class Operators {

    public boolean isEven(int n) {
        return n % 2 == 0;
    }

    public String getResultOfDivision(int number, int divisor) {
        return number + " / " + divisor + " = " + (number / divisor) + ", remains: " + (number % divisor);
    }

    public String isNull(String s) {
        return s == null ? "null value" : "not null value";
    }

    public boolean isEmpty(String s) {
        return s == null || "".equals(s);
    }

}
