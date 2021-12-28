package schoolrecords.entiteswithvalidity;

public class Subject implements HasValidity {

    private final String subjectName;

    public Subject(String subjectName) {
        HasValidity.forEmptiness(subjectName);
        this.subjectName = subjectName.strip();
    }

    public String getSubjectName() {
        return subjectName;
    }

    public boolean equalTo(Subject other) {
        HasValidity.forNullity(other, "Subject");
        return this.subjectName.equals(other.subjectName);
    }

    @Override
    public String toString() {
        return subjectName;
    }

}
