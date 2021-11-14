package introexceptionfirstexception;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Movie Title: ");
        String title = scanner.nextLine();
        System.out.print("Number of tickets: ");
        int numberOfTickets = Integer.parseInt(scanner.nextLine());
        System.out.print("Preferred row: ");
        String row = scanner.nextLine();

        StringBuilder sb = new StringBuilder("The details of the tickets purchased in the mozijegy.hu system are the following: ");
        sb.append("\nName: ").append(name).append("\nMovie Title: ").append(title).append("\nReservations: ");
        for (int i = 1; i <= numberOfTickets; i++) {
            sb.append(row).append(". row ").append(i).append(". chair");
            if (i < numberOfTickets) {
                sb.append(", ");
            }
        }
        sb.append("\nHave fun!");

        System.out.println(sb);
    }

}
