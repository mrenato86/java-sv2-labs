package schoolrecords.entitieswithvalidity;

import schoolrecords.SchoolStatistics;

import java.util.ArrayList;
import java.util.List;

public class Student implements HasValidity {

    private final String name;
    private final List<Mark> marks = new ArrayList<>();

    public Student(String name) {
        HasValidity.forEmptiness("Student name must not be empty!", name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void grading(Mark mark) {
        HasValidity.forArgumentNullity("Mark must not be null!", mark);
        marks.add(mark);
    }

    private double calculateAverageGeneral(Subject subject) {
        List<Double> grades = new ArrayList<>();
        for (Mark mark : marks) {
            if (subject == null || mark.getSubject().equalTo(subject)) {
                grades.add((double) mark.getMarkType().getGrade());
            }
        }
        return SchoolStatistics.getAvg(grades);
    }

    public double calculateAverage() {
        return calculateAverageGeneral(null);
    }

    public double calculateSubjectAverage(Subject subject) {
        HasValidity.forArgumentNullity("Subject must not be null!", subject);
        return calculateAverageGeneral(subject);
    }

    public boolean equalTo(Student other) {
        HasValidity.forArgumentNullity("Student must not be null!", other);
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

}
