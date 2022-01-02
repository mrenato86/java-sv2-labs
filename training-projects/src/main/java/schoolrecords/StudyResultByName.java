package schoolrecords;

import schoolrecords.entiteswithvalidity.HasValidity;

public class StudyResultByName {

    private String studentName;
    private double studyAverage;

    public StudyResultByName(String studentName, double studyAverage) {
        HasValidity.forEmptiness("Student name must not be empty!", studentName);
        this.studentName = studentName;
        this.studyAverage = studyAverage;
    }

    public String getStudentName() {
        return studentName;
    }

    public double getStudyAverage() {
        return studyAverage;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", studentName, studyAverage);
    }

}
