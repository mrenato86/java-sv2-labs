package operators;

public class OperatorsMain {

    public static void main(String[] args) {

        Operators operators = new Operators();

        System.out.println(Integer.toBinaryString(3000));

        System.out.println(operators.isEven(3));
        System.out.println(operators.isEven(4));

        System.out.println(operators.getResultOfDivision(10, 3));
        System.out.println(operators.getResultOfDivision(14, 2));

        System.out.println(operators.isNull(null));
        System.out.println(operators.isNull("Not null"));

        System.out.println(operators.isEmpty(null));
        System.out.println(operators.isEmpty(""));
        System.out.println(operators.isEmpty("Not Empty"));

    }

}
