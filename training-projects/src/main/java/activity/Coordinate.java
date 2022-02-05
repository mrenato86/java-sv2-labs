package activity;

public class Coordinate {

    private static final double LATITUDE_BOUNDARY = 90;
    private static final double LONGITUDE_BOUNDARY = 180;

    private final double latitude;
    private final double longitude;

    public Coordinate(double latitude, double longitude) {
        validateParameters(latitude, longitude);
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    private void validateParameters(double latitude, double longitude) {
        if (Math.abs(latitude) > LATITUDE_BOUNDARY) {
            throw new IllegalArgumentException("Invalid latitude: " + latitude);
        }
        if (Math.abs(longitude) > LONGITUDE_BOUNDARY) {
            throw new IllegalArgumentException("Invalid longitude: " + longitude);
        }
    }
}
