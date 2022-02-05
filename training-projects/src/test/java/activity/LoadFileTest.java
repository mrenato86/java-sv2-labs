package activity;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoadFileTest {

    @Test
    void testLoadGpx() {
        Track track = new Track();
//        try (InputStream is = LoadFileTest.class.getResourceAsStream("/track.gpx")) {
//            track.loadFromGpx(is);
//        }
        track.loadFromGpx(Path.of("src/test/resources/track.gpx"));

        assertEquals(2801, track.getTrackPoints().size());
        assertEquals(18.541194, track.getTrackPoints().get(0).getCoordinate().getLongitude(), 0.000005);
        assertEquals(47.218102, track.getTrackPoints().get(0).getCoordinate().getLatitude(), 0.000005);
        assertEquals(134.2, track.getTrackPoints().get(0).getElevation(), 0.05);

    }
}
