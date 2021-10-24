package introcontrol;

import java.util.Scanner;

public class BoatRental {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Size of the group: ");
        int groupSize = scanner.nextInt();
        if (groupSize < 1){
            System.out.println("No boat was taken");
            return;
        }
        int freeSpace = 10;
        System.out.print(groupSize > freeSpace ? "No space for everyone, waiting: " + (groupSize - freeSpace) + "\n" : "" );

        if(groupSize > 3){
            System.out.println("Boat for 5 people was taken");
            freeSpace -= 5;
        }
        if(groupSize == 3 || groupSize > 7){
            System.out.println("Boat for 3 people was taken");
            freeSpace -=3;
        }
        if(groupSize > 8 || (groupSize > 5 && groupSize < 8) || groupSize < 3){
            System.out.println("Boat for 2 people was taken");
            freeSpace -=2;
        }
        System.out.println("Free Space left: " + freeSpace);
    }

}
