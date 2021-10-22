package statements;

import java.util.Scanner;

public class TimeMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("First time sequence: ");
        String[] in = scanner.nextLine().split(":");

        Time time1 = new Time(Integer.parseInt(in[0]),Integer.parseInt(in[1]),Integer.parseInt(in[2]));

        System.out.print("Second time sequence: ");
        in = scanner.nextLine().split(":");

        Time time2 = new Time(Integer.parseInt(in[0]),Integer.parseInt(in[1]),Integer.parseInt(in[2]));

        System.out.println("First time: " + time1.toString() + " = " + time1.getInMinutes() + " minutes");
        System.out.println("Second time: " + time2.toString() + " = " + time2.getInSeconds() + " seconds");
        System.out.println("First is earlier: " + time1.earlierThan(time2));

    }

}
