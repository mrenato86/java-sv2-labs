package schoolrecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassRecords {

    private String className;
    private Random random;
    private List<Student> students = new ArrayList<>();

    public ClassRecords(String className, Random random) {
        validateArgs(className, random);
        this.className = className;
        this.random = random;
    }

    public String getClassName() {
        return className;
    }

    public boolean addStudent(Student student) {
        if (student == null) {
            throw new NullPointerException("Student must not be null!");
        }
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
        if (student == null) {
            throw new NullPointerException("Student must not be null!");
        }
        try {
            Student sought = findStudentByName(student.getName());
            return students.remove(sought);
        } catch (IllegalArgumentException iae) {
            return false;
        }
    }

    public double calculateClassAverage() {
        if (students.isEmpty()) {
            throw new ArithmeticException("No student in the class, average calculation aborted!");
        }
        double sum = 0;
        for (Student student : students) {
            sum += student.calculateAverage();
        }
        if (sum == 0) {
            throw new ArithmeticException("No marks present, average calculation aborted!");
        }
        return Math.round(100 * sum / students.size()) / 100.;
    }

    public double calculateClassAverageBySubject(Subject subject) {
        if (students.isEmpty()) {
            throw new ArithmeticException("No student in the class, average calculation aborted!");
        }
        double sum = 0;
        int count = 0;
        for (Student student : students) {
            double studentAvg = student.calculateSubjectAverage(subject);
            if (studentAvg > 0) {
                sum += studentAvg;
                count++;
            }
        }
        if (sum == 0) {
            throw new ArithmeticException("No marks present, average calculation aborted!");
        }
        return Math.round(100 * sum / count) / 100.;
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

    private void validateArgs(String className, Random random) {
        if (random == null) {
            throw new NullPointerException("Random must not be null!");
        }
        if (isEmpty(className)) {
            throw new IllegalArgumentException("Classname must not be null or empty!");
        }
    }

    private boolean isEmpty(String value) {
        return value == null || value.isBlank();
    }

}
