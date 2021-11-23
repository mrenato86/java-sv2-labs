package algorithmsmax.trainer;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;

class MaxAgeCalculatorTest {

    @Test
    void testGetTrainerWithMaxAge() {
        List<Trainer> trainers = List.of(
                new Trainer("John Doe", 65),
                new Trainer("Jane Doe", 52),
                new Trainer("Jack Doe", 19),
                new Trainer("Jonathan Doe", 72),
                new Trainer("Jessie Doe", 33)
        );
        assertSame(trainers.get(3), new MaxAgeCalculator().getTrainerWithMaxAge(trainers));
    }
}