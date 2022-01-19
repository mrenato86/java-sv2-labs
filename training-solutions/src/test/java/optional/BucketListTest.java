package optional;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BucketListTest {

    BucketList bucketList = new BucketList(List.of(
            new Destination("Koppenhága", "városnézés", 1300),
            new Destination("Tirol", "síelés", 720),
            new Destination("Lomnici-csúcs", "hegymászás, lanovkázás", 280),
            new Destination("Izland", "gleccserek, északi fény", 2900),
            new Destination("Szeged", "vadaspark", 175)
    ));

    @Test
    void getDestinationWithKeyword() {
        Optional<Destination> result = bucketList.getDestinationWithKeyword("sí");

        assertTrue(result.isPresent());
        assertEquals("Tirol", result.get().getName());
    }

    @Test
    void getDestinationWithKeywordNotFound() {
        assertEquals(Optional.empty(), bucketList.getDestinationWithKeyword("tenger"));
    }

    @Test
    void getDestinationNearerThanGiven() {
        Optional<Destination> result = bucketList.getDestinationNearerThanGiven(300);

        assertTrue(result.isPresent());
        assertEquals("Lomnici-csúcs", result.get().getName());
    }

    @Test
    void getDestinationNearerThanGivenNotFound() {
        assertEquals(Optional.empty(), bucketList.getDestinationNearerThanGiven(10));
    }

}