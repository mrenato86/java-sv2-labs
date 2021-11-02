package stringscanner;

import java.util.Scanner;

public class StringScanner {

    public static void main(String[] args) {
        Scanner scannerIn = new Scanner(System.in);
        System.out.println("Give a complex sentence:");
        String sentence = scannerIn.nextLine();

        Scanner scannerDefault = new Scanner(sentence);
        while (scannerDefault.hasNext()) {
            System.out.println(scannerDefault.next());
        }

        System.out.println();
        System.out.println("Give another complex sentence:");
        sentence = scannerIn.nextLine();

        Scanner scannerDelimiter = new Scanner(sentence).useDelimiter(", ");
        while (scannerDelimiter.hasNext()) {
            System.out.println(scannerDelimiter.next());
        }

    }

}
