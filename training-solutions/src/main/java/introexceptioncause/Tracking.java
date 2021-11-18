package introexceptioncause;

import java.util.List;

public class Tracking {

    public static void main(String[] args) {
        TrackPoints trackPoints = new TrackPoints();
        List<String> coordinates = trackPoints.readCoordinates("src/main/resources/introexceptioncause/tracking.csv");
        trackPoints.printHeightDiff(trackPoints.getHeights(coordinates));
    }

}
