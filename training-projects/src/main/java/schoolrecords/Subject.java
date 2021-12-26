package schoolrecords;

public class Subject {

    private String subjectName;

    public Subject(String subjectName) {
        if (isEmpty(subjectName)) {
            throw new IllegalArgumentException("Subject name must not be null or empty!");
        }
        this.subjectName = subjectName.strip();
    }

    public String getSubjectName() {
        return subjectName;
    }

    public boolean equalTo(Subject other) {
        if (other == null) {
            throw new NullPointerException("Subject must not be null!");
        }
        return this.subjectName.equals(other.subjectName);
    }

    @Override
    public String toString() {
        return subjectName;
    }

    private boolean isEmpty(String value) {
        return value == null || value.isBlank();
    }
}
