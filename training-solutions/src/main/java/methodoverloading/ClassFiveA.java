package methodoverloading;

import java.util.ArrayList;
import java.util.List;

public class ClassFiveA {

    private final List<String> studentNames;

    public ClassFiveA(String... studentNames) {
        this.studentNames = new ArrayList<>(List.of(studentNames));
    }

    public String getTodayReferringStudent(int number) {
        return studentNames.get(number - 1);
    }

    public String getTodayReferringStudent(Number number) {
        return studentNames.get(number.getValue() - 1);
    }

    public String getTodayReferringStudent(String numberName) {
        return studentNames.get(Number.valueOf(numberName.toUpperCase()).getValue() - 1);
    }

}
