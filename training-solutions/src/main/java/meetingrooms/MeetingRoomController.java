package meetingrooms;

import meetingrooms.outputenums.CommunicationItem;
import meetingrooms.outputenums.MenuItem;

import java.util.Scanner;

public class MeetingRoomController {

    private final Office office = new Office();

    {
        office.addMeetingRoom(new MeetingRoom("Test1", 23, 23));
        office.addMeetingRoom(new MeetingRoom("Test2", 10, 10));
        office.addMeetingRoom(new MeetingRoom("Test3", 20, 20));
        office.addMeetingRoom(new MeetingRoom("Test4", 3, 3));
    }

    private void readOffice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(CommunicationItem.ASK_NAME);
        String name = scanner.nextLine();
        System.out.print(CommunicationItem.ASK_LENGTH);
        int length = scanner.nextInt();
        System.out.print(CommunicationItem.ASK_WIDTH);
        int width = scanner.nextInt();

        office.addMeetingRoom(new MeetingRoom(name,length,width));

    }

    private void printMenu() {
        for (MenuItem item : MenuItem.values()) {
            System.out.println(item);
        }
    }

    public void runMenu() {
        while (true) {
            printMenu();
            Scanner scanner = new Scanner(System.in);
            System.out.print(CommunicationItem.ASK_SELECT);
            int selected = scanner.nextInt();
            scanner.nextLine();
            switch (selected) {
                case 1:
                    readOffice();
                    System.out.println(CommunicationItem.TELL_SUCCESS);
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                    System.out.println(CommunicationItem.TELL_LISTING);
                    printSelect(selected);
                    break;
                case 6:
                case 7:
                case 8:
                    System.out.print(CommunicationItem.ASK_PARAMETER);
                    String parameter = scanner.nextLine();
                    System.out.println(CommunicationItem.TELL_LISTING);
                    printSearch(selected, parameter);
                    break;
                case 9:
                    System.out.println(CommunicationItem.TELL_BYE);
                    return;
            }
            System.out.print(CommunicationItem.ASK_CONTINUE);
            scanner.nextLine();
        }

    }

    private void printSelect(int selected) {
        if (selected == 2) {
            office.printNames();
            return;
        }
        if (selected == 3) {
            office.printNamesReverse();
            return;
        }
        if (selected == 4) {
            office.printEvenNames();
            return;
        }
        office.printAreas();
    }

    private void printSearch(int selected, String input) {
        if (selected == 6) {
            office.printMeetingRoomsWithName(input);
            return;
        }
        if (selected == 7) {
            office.printMeetingRoomsContains(input);
            return;
        }
        office.printAreasLargerThan(Integer.parseInt(input));
    }

    public static void main(String[] args) {
        MeetingRoomController meetingRoomController = new MeetingRoomController();
        meetingRoomController.runMenu();
    }

}
