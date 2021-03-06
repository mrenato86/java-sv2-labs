package schoolrecords;

import schoolrecords.entitieswithvalidity.HasValidity;
import schoolrecords.entitieswithvalidity.Student;
import schoolrecords.entitieswithvalidity.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassRecords {

    private String className;
    private Random random;
    private final List<Student> students = new ArrayList<>();

    public ClassRecords(String className, Random random) {
        HasValidity.forEmptiness("Class name must not be empty!", className);
        HasValidity.forGeneralNullity("Random must not be null!", random);
        this.className = className;
        this.random = random;
    }

    public String getClassName() {
        return className;
    }

    public boolean addStudent(Student student) {
        HasValidity.forArgumentNullity("Student must not be null!", student);
        if (students.isEmpty()) {
            return students.add(student);
        }
        try {
            findStudentByName(student.getName());
            return false;
        } catch (IllegalArgumentException iae) {
            return students.add(student);
        }
    }

    public boolean removeStudent(Student student) {
        HasValidity.forArgumentNullity("Student must not be null!", student);
        try {
            Student sought = findStudentByName(student.getName());
            return students.remove(sought);
        } catch (IllegalArgumentException iae) {
            return false;
        }
    }

    private double calculateAverageGeneral(Subject subject) {
        if (students.isEmpty()) {
            throw new ArithmeticException("No student in the class, average calculation aborted!");
        }
        List<Double> averages = new ArrayList<>();
        for (Student student : students) {
            double studentAvg = subject == null ? student.calculateAverage() : student.calculateSubjectAverage(subject);
            if (studentAvg > 0) {
                averages.add(studentAvg);
            }
        }
        if (averages.isEmpty()) {
            throw new ArithmeticException("No marks present, average calculation aborted!");
        }
        return SchoolStatistics.getAvg(averages);
    }

    public double calculateClassAverage() {
        return calculateAverageGeneral(null);
    }

    public double calculateClassAverageBySubject(Subject subject) {
        HasValidity.forArgumentNullity("Subject must not be null!", subject);
        return calculateAverageGeneral(subject);
    }

    public Student findStudentByName(String name) {
        if (students.isEmpty()) {
            throw new IllegalStateException("No students to search!");
        }
        Student sought = new Student(name);
        for (Student student : students) {
            if (student.equalTo(sought)) {
                return student;
            }
        }
        throw new IllegalArgumentException("Student by this name cannot be found! " + name);
    }

    public Student repetition() {
        if (students.isEmpty()) {
            throw new IllegalStateException("No students to select for repetition!");
        }
        return students.get(random.nextInt(students.size()));
    }

    public List<StudyResultByName> listStudyResults() {
        List<StudyResultByName> result = new ArrayList<>();
        for (Student student : students) {
            result.add(new StudyResultByName(student.getName(), student.calculateAverage()));
        }
        return result;
    }

    public String listStudentNames() {
        if (students.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder(students.get(0).getName());
        for (int i = 1; i < students.size(); i++) {
            sb.append(", ").append(students.get(i).getName());
        }
        return sb.toString();
    }

}
