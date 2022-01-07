package schoolrecords.entitieswithvalidity;

import java.util.List;

public class Tutor implements HasValidity {

    private String name;
    private List<Subject> taughtSubjects;

    public Tutor(String name, List<Subject> taughtSubjects) {
        HasValidity.forEmptiness("Tutor name must not be empty!", name);
        HasValidity.forGeneralNullity("Taught subjects must not be null!", taughtSubjects);
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

}
