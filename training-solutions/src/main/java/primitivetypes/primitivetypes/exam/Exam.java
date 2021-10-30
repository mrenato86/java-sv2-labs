package primitivetypes.primitivetypes.exam;

import java.util.ArrayList;
import java.util.List;

public class Exam {

    private List<Person> attendees = new ArrayList<>();

    public List<Person> getAttendees() {
        return attendees;
    }

    public void addPerson(Person person) {
        attendees.add(person);
    }
}
