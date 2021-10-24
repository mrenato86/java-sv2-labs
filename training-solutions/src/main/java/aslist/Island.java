package aslist;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Island {

    public static void main(String[] args) {
        List<String> importantThings = Arrays.asList("drinking water", "knife", "first aid kit");
        System.out.println("Three things to bring on a deserted island:");
        System.out.println(importantThings);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Change the one at: ");
        int changeNum = scanner.nextInt() - 1;
        scanner.nextLine();
        System.out.print("To: ");
        importantThings.set(changeNum, scanner.nextLine());

        System.out.println("\nThe new list is:");
        System.out.println(importantThings);

    }

}
