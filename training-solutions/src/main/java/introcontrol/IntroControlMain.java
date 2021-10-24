package introcontrol;

public class IntroControlMain {

    public static void main(String[] args) {
        IntroControl ic = new IntroControl();

        System.out.println("subtractTenIfGreaterThanTen");
        System.out.println("With 5: " + ic.subtractTenIfGreaterThanTen(5));
        System.out.println("With 15: " + ic.subtractTenIfGreaterThanTen(15));

        System.out.println("describeNumber");
        System.out.println("With 0: " + ic.describeNumber(0));
        System.out.println("With 5: " + ic.describeNumber(5));

        System.out.println("greetingToJoe");
        System.out.println("With Joe: " + ic.greetingToJoe("Joe"));
        System.out.println("With NoJoe: " + ic.greetingToJoe("NoJoe"));

        System.out.println("calculateBonus");
        System.out.println("Sale=900000: " + ic.calculateBonus(900000));
        System.out.println("Sale=1000000: " + ic.calculateBonus(1000000));
        System.out.println("Sale=2000000: " + ic.calculateBonus(2000000));

        System.out.println("calculateConsumption");
        System.out.println("With 300,1000: " + ic.calculateConsumption(300, 1000));
        System.out.println("With 9500,150: " + ic.calculateConsumption(9500, 150));

        System.out.println("printNumbers to 10");
        ic.printNumbers(10);

        System.out.println("printNumbersBetween 5 and 10");
        ic.printNumbersBetween(5, 10);

        System.out.println("printNumbersBetweenAnyDirection: 5 to 10");
        ic.printNumbersBetweenAnyDirection(5, 10);
        System.out.println("printNumbersBetweenAnyDirection: 10 to 5");
        ic.printNumbersBetweenAnyDirection(10, 5);

        System.out.println("printOddNumbers to 8");
        ic.printOddNumbers(8);
        System.out.println("printOddNumbers to 13");
        ic.printOddNumbers(13);
    }

}
