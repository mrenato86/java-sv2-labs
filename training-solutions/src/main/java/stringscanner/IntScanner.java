package stringscanner;

import java.util.Scanner;

public class IntScanner {

    public String convertInts(String ints) {
        if (ints.length() == 0) {
            return "";
        }

        Scanner scannerInt = new Scanner(ints).useDelimiter(";");
        StringBuilder sb = new StringBuilder();
        while (scannerInt.hasNextInt()) {
            int number = scannerInt.nextInt();
            if (number > 100) {
                sb.append(",").append(number);
            }
        }
        if (sb.length() == 0) {
            return "";
        }
        return sb.substring(1);
    }

    public static void main(String[] args) {
        IntScanner intScanner = new IntScanner();
        System.out.println(intScanner.convertInts("5;3;107;12;123;18;198"));
        System.out.println(intScanner.convertInts("5;3;17;12;23;18;98"));
        System.out.println(intScanner.convertInts(""));
        System.out.println(intScanner.convertInts("107"));
    }

}
