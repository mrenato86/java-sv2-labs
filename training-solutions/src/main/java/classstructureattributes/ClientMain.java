package classstructureattributes;

import java.util.Scanner;

public class ClientMain {

    public static void main(String[] args) {
        Client client = new Client();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        client.name= scanner.nextLine();
        System.out.print("Year of birth: ");
        client.year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Address: ");
        client.address = scanner.nextLine();

        System.out.println("\n" + client);
    }
}
