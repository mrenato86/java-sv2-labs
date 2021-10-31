package enumtype.position;

public class PositionMain {

    public static void main(String[] args) {
        for (Position position : Position.values()) {
            System.out.println(position + ": Salary= " + position.getSalary() + " (with " + position.getBenefit() + ")");
        }
    }
}
