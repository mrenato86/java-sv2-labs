package schoolrecords;

public class StudyResultByName {

    private String studentName;
    private double studyAverage;

    public StudyResultByName(String studentName, double studyAverage) {
        if (isEmpty(studentName)) {
            throw new IllegalArgumentException("Student name must not be null or empty.");
        }
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

    private boolean isEmpty(String value) {
        return value == null || value.isBlank();
    }
}
