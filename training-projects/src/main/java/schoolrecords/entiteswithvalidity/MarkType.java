package schoolrecords.entiteswithvalidity;

public enum MarkType implements HasValidity {

    A(5, "excellent"),
    B(4, "very good"),
    C(3, "improvement needed"),
    D(2, "close fail"),
    F(1, "fail");

    MarkType(int grade, String interpretation) {
        this.grade = grade;
        this.interpretation = interpretation;
    }

    private final int grade;
    private final String interpretation;

    public int getGrade() {
        return grade;
    }

    public String getInterpretation() {
        return interpretation;
    }

    @Override
    public String toString() {
        return String.format("%s(%d)", interpretation, grade);
    }
}
