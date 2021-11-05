package controliteration.fibonacci;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Length of Fibonacci-series: ");
        int length = scanner.nextInt();
        if (length <= 0 || length > 93) {
            System.out.println("Invalid range!");
            return;
        }
        length -= 2;

        long[] fibonacci = new long[2];
        fibonacci[1] = 1;
        System.out.print(fibonacci[0]);
        //While
        int index = 0;
        while (index++ <= length) {
            System.out.print(", " + fibonacci[1]);
            long temp = fibonacci[1];
            fibonacci[1] = fibonacci[0] + fibonacci[1];
            fibonacci[0] = temp;
        }

        //For
//        for (int index = 0; index <= length; index++) {
//            System.out.print(", " + fibonacci[1]);
//            long temp = fibonacci[1];
//            fibonacci[1] = fibonacci[0] + fibonacci[1];
//            fibonacci[0] = temp;
//        }

        //Do
//        int index = 1;
//        do{
//            System.out.print(", " + fibonacci[1]);
//            long temp = fibonacci[1];
//            fibonacci[1] = fibonacci[0] + fibonacci[1];
//            fibonacci[0] = temp;
//        } while(index++ <= length);

    }

}
