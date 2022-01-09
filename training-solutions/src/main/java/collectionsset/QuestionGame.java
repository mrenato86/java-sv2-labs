package collectionsset;

import java.util.*;

public class QuestionGame {

    private List<RightAnswer> answers;

    public QuestionGame(List<RightAnswer> answers) {
        this.answers = answers;
    }

    public List<RightAnswer> getAnswers() {
        return new ArrayList<>(answers);
    }

    public Set<String> drawWinners() {
        Set<String> result = new HashSet<>();
        Random random = new Random();
        while (result.size() < 5) {
            if (answers.size() == 0) {
                throw new IllegalArgumentException("Not enough right answers!");
            }
            RightAnswer picked = answers.get(random.nextInt(answers.size()));
            result.add(picked.getName());
            answers.remove(picked);
        }
        return result;
    }
}
