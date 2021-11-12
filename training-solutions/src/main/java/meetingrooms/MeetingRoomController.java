package meetingrooms;

import meetingrooms.outputenums.CommunicationItem;
import meetingrooms.outputenums.MenuItem;

import java.util.Scanner;

public class MeetingRoomController {

    private final Office office = new Office();

    {//TODO Remove test data
        office.addMeetingRoom(new MeetingRoom("Test1", 23, 23));
        office.addMeetingRoom(new MeetingRoom("Test2", 10, 10));
        office.addMeetingRoom(new MeetingRoom("Test3", 20, 20));
        office.addMeetingRoom(new MeetingRoom("Test4", 3, 3));
        office.addMeetingRoom(new MeetingRoom("Test4", 30, 33));
    }

    public void runMenu() {
        while (true) {
            printMenu();
            Scanner scanner = new Scanner(System.in);
            System.out.print(CommunicationItem.ASK_SELECT);
            int selected = 0;
            if (scanner.hasNextInt()) {
                selected = scanner.nextInt();
            }
            scanner.nextLine();
            System.out.println();
            switch (selected) {
                case 1:
                    readOffice();
                    break;
                case 2:
                    System.out.println(CommunicationItem.TELL_LISTING);
                    office.printNames();
                    break;
                case 3:
                    System.out.println(CommunicationItem.TELL_LISTING);
                    office.printNamesReverse();
                    break;
                case 4:
                    System.out.println(CommunicationItem.TELL_LISTING);
                    office.printEvenNames();
                    break;
                case 5:
                    System.out.println(CommunicationItem.TELL_LISTING);
                    office.printAreas();
                    break;
                case 6:
                    System.out.print(CommunicationItem.ASK_PARAMETER);
                    String parameter = scanner.nextLine();
                    System.out.println(CommunicationItem.TELL_LISTING);
                    office.printMeetingRoomsWithName(parameter);
                    break;
                case 7:
                    System.out.print(CommunicationItem.ASK_PARAMETER);
                    parameter = scanner.nextLine();
                    System.out.println(CommunicationItem.TELL_LISTING);
                    office.printMeetingRoomsContains(parameter);
                    break;
                case 8:
                    System.out.print(CommunicationItem.ASK_PARAMETER);
                    if (!scanner.hasNextInt()) {
                        System.out.println(CommunicationItem.TELL_WRONG_INPUT + scanner.nextLine());
                        break;
                    }
                    parameter = scanner.nextLine();
                    System.out.println(CommunicationItem.TELL_LISTING);
                    office.printAreasLargerThan(Integer.parseInt(parameter));
                    break;
                case 9:
                    System.out.println(CommunicationItem.TELL_BYE);
                    return;
                default:
                    System.out.println(CommunicationItem.TELL_WRONG_MENU);
            }
            System.out.println(CommunicationItem.ASK_CONTINUE);
            scanner.nextLine();
        }

    }

    private void printMenu() {
        for (MenuItem item : MenuItem.values()) {
            System.out.println(item);
        }
    }

    private void readOffice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(CommunicationItem.ASK_NAME);
        String name = scanner.nextLine();
        System.out.print(CommunicationItem.ASK_LENGTH);
        if (!scanner.hasNextInt()) {
            System.out.println(CommunicationItem.TELL_WRONG_INPUT + scanner.nextLine());
            System.out.println(CommunicationItem.TELL_FAILURE);
            return;
        }
        int length = scanner.nextInt();
        System.out.print(CommunicationItem.ASK_WIDTH);
        if (!scanner.hasNextInt()) {
            System.out.println(CommunicationItem.TELL_WRONG_INPUT + scanner.nextLine());
            System.out.println(CommunicationItem.TELL_FAILURE);
            return;
        }
        int width = scanner.nextInt();

        office.addMeetingRoom(new MeetingRoom(name, length, width));
        System.out.println(CommunicationItem.TELL_SUCCESS);
    }

    public static void main(String[] args) {
        MeetingRoomController meetingRoomController = new MeetingRoomController();
        meetingRoomController.runMenu();
    }

}
