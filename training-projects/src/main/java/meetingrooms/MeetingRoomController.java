package meetingrooms;

import meetingrooms.outputenums.CommunicationItem;
import meetingrooms.outputenums.MenuItem;

import java.util.Scanner;

import static meetingrooms.outputenums.CommunicationItem.*;

public class MeetingRoomController {

    private final Office office = new Office();

    public void runMenu() {
        while (true) {
            printMenu();
            int selected = getNumberInput(ASK_SELECT);
            if (selected > 1 && selected < 9 && !office.hasAnyMeetingRoom()) {
                System.out.println(TELL_NO_ROOM);
                selected = 1;
            }
            System.out.println();
            switch (selected) {
                case 1:
                    readOffice();
                    break;
                case 2:
                    System.out.println(TELL_LISTING);
                    office.printNames();
                    break;
                case 3:
                    System.out.println(TELL_LISTING);
                    office.printNamesReverse();
                    break;
                case 4:
                    System.out.println(TELL_LISTING);
                    office.printEvenNames();
                    break;
                case 5:
                    System.out.println(TELL_LISTING);
                    office.printAreas();
                    break;
                case 6:
                    String parameter = getTextInput(ASK_PARAMETER);
                    System.out.println(TELL_LISTING);
                    office.printMeetingRoomsWithName(parameter);
                    break;
                case 7:
                    parameter = getTextInput(ASK_PARAMETER);
                    System.out.println(TELL_LISTING);
                    office.printMeetingRoomsContains(parameter);
                    break;
                case 8:
                    int numParam = getNumberInput(ASK_PARAMETER);
                    if (numParam < 0) {
                        System.out.println(TELL_WRONG_INPUT);
                        break;
                    }
                    System.out.println(TELL_LISTING);
                    office.printAreasLargerThan(numParam);
                    break;
                case 9:
                    System.out.println(TELL_BYE);
                    return;
                default:
                    System.out.println(TELL_WRONG_MENU);
            }
            getTextInput(ASK_CONTINUE);
            System.out.println();
        }
    }

    private void printMenu() {
        for (MenuItem item : MenuItem.values()) {
            System.out.println(item);
        }
    }

    private void readOffice() {
        String name = getTextInput(ASK_NAME);
        int length = getNumberInput(ASK_LENGTH);
        int width = getNumberInput(ASK_WIDTH);
        if (length <= 0 || width <= 0) {
            System.out.println(TELL_WRONG_INPUT);
            System.out.println(TELL_FAILURE);
            return;
        }
        office.addMeetingRoom(new MeetingRoom(name, length, width));
        System.out.println(TELL_SUCCESS);
    }

    private int getNumberInput(CommunicationItem question) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(question);
        if (!scanner.hasNextInt()) {
            return -1;
        }
        return scanner.nextInt();
    }

    private String getTextInput(CommunicationItem question) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(question);
        return scanner.nextLine().strip();
    }

    public static void main(String[] args) {
        MeetingRoomController meetingRoomController = new MeetingRoomController();
        meetingRoomController.runMenu();
    }

}
