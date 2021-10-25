package looptypes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudyGroup {

    public void printStudyGroups(List<String> students) {
        List<String> class1 = new ArrayList<>();
        List<String> class2 = new ArrayList<>();

        for (String student : students) {
            if (student.length() <= 10) {
                class1.add(student);
            } else {
                class2.add(student);
            }
        }
        System.out.println("Class 1: " + class1);
        System.out.println("Class 2: " + class2);
    }

    public static void main(String[] args) {
        StudyGroup group = new StudyGroup();
        List<String> students = Arrays.asList("Little John", "Joe Doe", "Jane Doe", "Tom Bombadil", "Big Pete", "Longboat Ragnar");

        group.printStudyGroups(students);
    }

}
