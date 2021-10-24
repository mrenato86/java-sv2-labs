package array;

import java.util.Arrays;

public class ArrayMain {

    public static void main(String[] args) {

        //1.
        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
        System.out.println(daysOfWeek[1] + " " + daysOfWeek.length);

        //2.
        int[] powersOfTwo = new int[5];
        powersOfTwo[0] = 1;
        System.out.print(powersOfTwo[0] + " ");
        for (int i = 1; i < powersOfTwo.length; i++) {
            powersOfTwo[i] = powersOfTwo[i - 1] * 2;
            System.out.print(powersOfTwo[i] + " ");
        }
        System.out.println();

        //3.
        boolean[] alternating = new boolean[6];
        for (int i = 1; i < alternating.length; i += 2) {
            alternating[i] = !alternating[i - 1];
            System.out.print(alternating[i - 1] + " " + alternating[i] + " ");
        }
        System.out.println();
    }
}
