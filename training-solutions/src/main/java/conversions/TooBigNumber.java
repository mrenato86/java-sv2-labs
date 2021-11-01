package conversions;

public class TooBigNumber {

    public long getRightResult(int number) {
        return 2_147_483_647 + (long) number;
    }

    public static void main(String[] args) {
        TooBigNumber tooBigNumber = new TooBigNumber();

        System.out.println("Look how round it is! : " + tooBigNumber.getRightResult(852_516_353));
    }

}
