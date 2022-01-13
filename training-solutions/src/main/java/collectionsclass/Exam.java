package collectionsclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exam {

    private List<ExamResult> results;

    public Exam(List<ExamResult> results) {
        this.results = new ArrayList<>(results);
    }

    public List<String> getNamesOfSucceededPeople(int places) {
        if (places > results.size()) {
            places = results.size();
        }
        List<ExamResult> orderedResults = new ArrayList<>(results);
        Collections.sort(orderedResults);
        Collections.reverse(orderedResults);
        return getNames(orderedResults, places);
    }

    private List<String> getNames(List<ExamResult> results, int places) {
        List<String> names = new ArrayList<>();
        for (int i = 0; i < places; i++) {
            names.add(results.get(i).getName());
        }
        return names;
    }

}
