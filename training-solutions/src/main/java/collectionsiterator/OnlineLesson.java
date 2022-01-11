package collectionsiterator;

import java.time.LocalDateTime;

public class OnlineLesson {

    private String tutorName;
    private String subject;
    private LocalDateTime start;

    public OnlineLesson(String tutorName, String subject, LocalDateTime start) {
        this.tutorName = tutorName;
        this.subject = subject;
        this.start = start;
    }

    public String getTutorName() {
        return tutorName;
    }

    public String getSubject() {
        return subject;
    }

    public LocalDateTime getStart() {
        return start;
    }
}
