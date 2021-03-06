package schoolrecords.entitieswithvalidity;

public class Mark implements HasValidity {

    private final MarkType markType;
    private final Subject subject;
    private final Tutor tutor;

    public Mark(MarkType markType, Subject subject, Tutor tutor) {
        HasValidity.forArgumentNullity("Both subject and tutor must be provided!", subject, tutor);
        HasValidity.forArgumentNullity("MarkType must not be null!", markType);
        this.markType = markType;
        this.subject = subject;
        this.tutor = tutor;
    }

    public Mark(String markType, Subject subject, Tutor tutor) {
        this(MarkType.valueOf(markType), subject, tutor);
    }

    public MarkType getMarkType() {
        return markType;
    }

    public Subject getSubject() {
        return subject;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public String toStringWithSubject() {
        return String.format("%s: %s", subject, markType);
    }

    @Override
    public String toString() {
        return markType.toString();
    }

}
