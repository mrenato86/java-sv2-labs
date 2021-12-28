package schoolrecords.entiteswithvalidity;

import schoolrecords.SchoolStatistics;

import java.util.ArrayList;
import java.util.List;

public class Student implements HasValidity {

    private final String name;
    private final List<Mark> marks = new ArrayList<>();

    public Student(String name) {
        HasValidity.forEmptiness(name, "Student name");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void grading(Mark mark) {
        HasValidity.forNullity(mark, "Mark");
        marks.add(mark);
    }

    public double calculateAverage() {
        List<Double> grades = new ArrayList<>();
        for (Mark mark : marks) {
            grades.add((double) mark.getMarkType().getGrade());
        }
        return SchoolStatistics.getAvg(grades);
    }

    public double calculateSubjectAverage(Subject subject) {
        List<Double> grades = new ArrayList<>();
        for (Mark mark : marks) {
            if (mark.getSubject().equalTo(subject)) {
                grades.add((double) mark.getMarkType().getGrade());
            }
        }
        return SchoolStatistics.getAvg(grades);
    }

    public boolean equalTo(Student other) {
        HasValidity.forNullity(other, "Student");
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
