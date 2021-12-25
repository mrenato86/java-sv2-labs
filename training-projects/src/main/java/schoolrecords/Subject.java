package schoolrecords;

public class Subject {

    private String subjectName;

    public Subject(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public boolean equalTo(Subject other){
        return this.subjectName.equals(other.subjectName);
    }
}
