package collectionsset;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class PhysicalEducation {

    public Set<Integer> getOrderInLessons(List<Student> students) {
        Set<Integer> orderedHeights = new TreeSet<>();
        for (Student student : students) {
            orderedHeights.add(student.getHeight());
        }
        return orderedHeights;
    }

    public Set<Student> getOrderInLessonsComparable(List<Student> students) {
        return new TreeSet<>(students);
    }

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Kiss József", 123),
                new Student("Nagy Béla", 135),
                new Student("Szép Virág", 122),
                new Student("Szabó Noémi", 132),
                new Student("Vörös Valéria", 130)
        );
        PhysicalEducation physicalEducation = new PhysicalEducation();
        System.out.println(physicalEducation.getOrderInLessons(students));
        System.out.println(physicalEducation.getOrderInLessonsComparable(students));
    }

}
