package schoolrecords;

import java.util.List;

public class Tutor {

    private String name;
    private List<Subject> taughtSubjects;

    public Tutor(String name, List<Subject> taughtSubjects) {
        validateArgs(name, taughtSubjects);
        this.name = name.strip();
        this.taughtSubjects = taughtSubjects;
    }

    public String getName() {
        return name;
    }

    public boolean tutorTeachingSubject(Subject subject) {
        for (Subject topic : taughtSubjects) {
            if (topic.equalTo(subject)) {
                return true;
            }
        }
        return false;
    }

    private void validateArgs(String name, List<Subject> taughtSubjects) {
        if (taughtSubjects == null) {
            throw new NullPointerException("Taught subjects must be provided!");
        }
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Tutor's name must not be null or empty!");
        }
    }

    private boolean isEmpty(String value) {
        return value == null || value.isBlank();
    }
}
