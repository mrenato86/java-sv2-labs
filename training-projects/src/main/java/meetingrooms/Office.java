package meetingrooms;

import java.util.ArrayList;
import java.util.List;

public class Office {

    private final List<MeetingRoom> meetingRooms = new ArrayList<>();

    public void addMeetingRoom(MeetingRoom meetingRoom) {
        meetingRooms.add(meetingRoom);
    }

    public boolean hasAnyMeetingRoom() {
        return !meetingRooms.isEmpty();
    }

    public void printNames() {
        for (MeetingRoom room : meetingRooms) {
            System.out.println("\t" + room.getName());
        }
    }

    public void printNamesReverse() {
        for (int i = meetingRooms.size() - 1; i >= 0; i--) {
            System.out.println("\t" + meetingRooms.get(i).getName());
        }
    }

    public void printEvenNames() {
        for (int i = 0; i < meetingRooms.size(); i += 2) {
            System.out.println("\t" + meetingRooms.get(i).getName());
        }
    }

    public void printAreas() {
        for (MeetingRoom room : meetingRooms) {
            System.out.println("\t" + room);
        }
    }

    public void printMeetingRoomsWithName(String name) {
        for (MeetingRoom room : meetingRooms) {
            if (room.getName().equalsIgnoreCase(name)) {
                System.out.println("\t" + room);
            }
        }
    }

    public void printMeetingRoomsContains(String part) {
        for (MeetingRoom room : meetingRooms) {
            if (room.getName().toLowerCase().contains(part.toLowerCase())) {
                System.out.println("\t" + room);
            }
        }
    }

    public void printAreasLargerThan(int area) {
        for (MeetingRoom room : meetingRooms) {
            if (room.getArea() > area) {
                System.out.println("\t" + room);
            }
        }
    }
}
