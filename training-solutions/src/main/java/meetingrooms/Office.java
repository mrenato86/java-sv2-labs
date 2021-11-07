package meetingrooms;

import meetingrooms.outputenums.CommunicationItem;

import java.util.ArrayList;
import java.util.List;

public class Office {

    private final List<MeetingRoom> meetingRooms = new ArrayList<>();

    public void addMeetingRoom(MeetingRoom meetingRoom) {
        meetingRooms.add(meetingRoom);
    }

    //Ha a printX metódusoknak lenne visszatérési értéke, a kommunikáció a Controller osztályban maradhatna teljesen.
    private void printIfNotFoundOrEmpty(boolean notFound) {
        if (meetingRooms.size() == 0 || notFound) {
            System.out.println(CommunicationItem.TELL_NONE);
        }
    }

    public void printNames() {
        printIfNotFoundOrEmpty(false);
        for (MeetingRoom room : meetingRooms) {
            System.out.println(room.getName());
        }
    }

    public void printNamesReverse() {
        printIfNotFoundOrEmpty(false);
        for (int i = meetingRooms.size() - 1; i >= 0; i--) {
            System.out.println(meetingRooms.get(i).getName());
        }
    }

    public void printEvenNames() {
        printIfNotFoundOrEmpty(false);
        for (int i = 0; i < meetingRooms.size(); i += 2) {
            System.out.println(meetingRooms.get(i).getName());
        }
    }

    public void printAreas() {
        printIfNotFoundOrEmpty(false);
        for (MeetingRoom room : meetingRooms) {
            System.out.println(room);
        }
    }

    public void printMeetingRoomsWithName(String name) {
        boolean notFound = true;
        for (MeetingRoom room : meetingRooms) {
            if (room.getName().equalsIgnoreCase(name)) {
                notFound = false;
                System.out.println(room);
            }
        }
        printIfNotFoundOrEmpty(notFound);
    }

    public void printMeetingRoomsContains(String part) {
        boolean notFound = true;
        for (MeetingRoom room : meetingRooms) {
            if (room.getName().toLowerCase().contains(part.toLowerCase())) {
                notFound = false;
                System.out.println(room);
            }
        }
        printIfNotFoundOrEmpty(notFound);
    }

    public void printAreasLargerThan(int area) {
        boolean notFound = true;
        for (MeetingRoom room : meetingRooms) {
            if (room.getArea() > area) {
                notFound = false;
                System.out.println(room);
            }
        }
        printIfNotFoundOrEmpty(notFound);
    }
}
