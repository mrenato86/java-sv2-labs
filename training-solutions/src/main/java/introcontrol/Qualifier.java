package introcontrol;

import java.util.Scanner;

public class Qualifier {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number: ");
        int number = scanner.nextInt();
        if (number > 100){
            System.out.println("Bigger than hundred");
        } else{
            System.out.println("Hundred or less");
        }

    }
}
