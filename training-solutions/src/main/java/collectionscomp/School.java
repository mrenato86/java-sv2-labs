package collectionscomp;

import java.text.Collator;
import java.util.*;

public class School {

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Úttörő Lajos", 135),
                new Student("Kiss József", 122),
                new Student("Molnár Irén", 144),
                new Student("Álmos Árpád", 118),
                new Student("Illyés Borbála", 138),
                new Student("Órás Eleonóra", 160)
        );

        Set<Student> studentsByHeight = new TreeSet<>(new StudentComparator());
        studentsByHeight.addAll(students);
        System.out.println(studentsByHeight);

        Map<String, Integer> studentsByName = new TreeMap<>(Collator.getInstance(new Locale("hu", "HU")));
        for (Student student : students) {
            studentsByName.put(student.getName(), student.getHeight());
        }
        System.out.println(studentsByName);
    }
}
