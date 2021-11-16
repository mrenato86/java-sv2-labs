package introexceptionthrowjunit5;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private final List<Integer> grades = new ArrayList<>();

    public void addNote(int note) {
        if (note < 1 || note > 5) {
            throw new IllegalArgumentException("Note must be between 1 and 5!");
        }
        grades.add(note);
    }

    public List<Integer> getGrades() {
        return grades;
    }

}
