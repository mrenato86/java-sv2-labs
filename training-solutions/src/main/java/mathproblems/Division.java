package mathproblems;

public class Division {

    public void getDivisors(int number) {
        System.out.println(number + "'s divisor: 1");
        System.out.println(number + "'s divisor: " + number);
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                System.out.println(number + "'s divisor: " + i);
                int div = number / i;
                if (i != div) {
                    System.out.println(number + "'s divisor: " + div);
                }
            }
        }
    }

    public void getRightNumbers(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] % i == 0) {
                System.out.print(numbers[i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        Division division = new Division();
        division.getDivisors(100);
        System.out.println();

        division.getRightNumbers(new int[]{2, 5, 23, 56, -36, 45, 78, 14, -8, 4, 10});
    }

}
