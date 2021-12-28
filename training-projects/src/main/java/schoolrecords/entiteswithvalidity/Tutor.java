package schoolrecords.entiteswithvalidity;

import java.util.List;

public class Tutor implements HasValidity {

    private String name;
    private List<Subject> taughtSubjects;

    public Tutor(String name, List<Subject> taughtSubjects) {
        HasValidity.forEmptiness(name);
        HasValidity.forGeneralNullity(taughtSubjects);
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
