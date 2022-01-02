package schoolrecords.entiteswithvalidity;

public class Subject implements HasValidity {

    private final String subjectName;

    public Subject(String subjectName) {
        HasValidity.forEmptiness("Subject name must not be empty!", subjectName);
        this.subjectName = subjectName.strip();
    }

    public String getSubjectName() {
        return subjectName;
    }

    public boolean equalTo(Subject other) {
        HasValidity.forArgumentNullity("Subject must not be null!", other);
        return this.subjectName.equals(other.subjectName);
    }

    @Override
    public String toString() {
        return subjectName;
    }

}
