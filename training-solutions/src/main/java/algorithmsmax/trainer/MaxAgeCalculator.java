package algorithmsmax.trainer;

import java.util.List;

public class MaxAgeCalculator {

    public Trainer getTrainerWithMaxAge(List<Trainer> trainers) {
        Trainer trainerWithMaxAge = trainers.get(0);
        for (Trainer trainer : trainers) {
            if (trainer.getAge() > trainerWithMaxAge.getAge()) {
                trainerWithMaxAge = trainer;
            }
        }
        return trainerWithMaxAge;
    }
}
