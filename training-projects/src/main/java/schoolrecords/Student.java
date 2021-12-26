package schoolrecords;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private final List<Mark> marks = new ArrayList<>();

    public Student(String name) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void grading(Mark mark) {
        if (mark == null) {
            throw new NullPointerException("Mark must not be null!");
        }
        marks.add(mark);
    }

    public double calculateAverage() {
        double sum = 0;
        for (Mark mark : marks) {
            sum += mark.getMarkType().getGrade();
        }
        return Math.round(100 * sum / marks.size()) / 100.;
    }

    public double calculateSubjectAverage(Subject subject) {
        double sum = 0;
        int count = 0;
        for (Mark mark : marks) {
            if (mark.getSubject().equalTo(subject)) {
                sum += mark.getMarkType().getGrade();
                count++;
            }
        }
        return Math.round(100 * sum / count) / 100.;
    }

    public boolean equalTo(Student other) {
        if (other == null) {
            throw new NullPointerException("Student must not be null!");
        }
        return this.name.equals(other.name);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name);
        sb.append(" marks: ");
        for (Mark mark : marks) {
            sb.append(mark.toStringWithSubject());
            sb.append(";");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    private boolean isEmpty(String value) {
        return value == null || value.isBlank();
    }
}
