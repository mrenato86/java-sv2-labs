package numbers;

import java.util.Scanner;

public class Percent {

    public double getValue(int number, int percent) {
        return number * (percent / 100.);
    }

    public double getBase(int number, int percent) {
        return number / (percent / 100.);
    }

    public double getPercent(int firstNumber, int secondNumber) {
        return 100. * secondNumber / firstNumber;
    }

    public static void main(String[] args) {

        Percent percent = new Percent();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Number: ");
        int firstNum = scanner.nextInt();
        System.out.print("Percent: ");
        int secNum = scanner.nextInt();
        System.out.println(secNum + "% of " + firstNum + " is " + percent.getValue(firstNum, secNum));
        System.out.println();

        System.out.print("Number: ");
        firstNum = scanner.nextInt();
        System.out.print("Percent: ");
        secNum = scanner.nextInt();
        System.out.println(firstNum + " is " + secNum + "% of " + percent.getBase(firstNum, secNum));
        System.out.println();

        System.out.print("First Number: ");
        firstNum = scanner.nextInt();
        System.out.print("Second Number: ");
        secNum = scanner.nextInt();
        System.out.println(secNum + " is " + percent.getPercent(firstNum, secNum) + "% of " + firstNum);

    }

}
