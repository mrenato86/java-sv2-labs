package activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleBinaryOperator;
import java.util.function.ToDoubleFunction;
import java.util.stream.IntStream;

public class Track {

    private final List<TrackPoint> trackPoints = new ArrayList<>();

    public void addTrackPoint(TrackPoint trackPoint) {
        trackPoints.add(trackPoint);
    }

    public List<TrackPoint> getTrackPoints() {
        return List.copyOf(trackPoints);
    }

    public Coordinate findMaximumCoordinate() {
        double latMax = findCustomCoordinatePart(tp -> tp.getCoordinate().getLatitude(), Double::max);
        double lonMax = findCustomCoordinatePart(tp -> tp.getCoordinate().getLongitude(), Double::max);
        return new Coordinate(latMax, lonMax);
    }

    public Coordinate findMinimumCoordinate() {
        double latMin = findCustomCoordinatePart(tp -> tp.getCoordinate().getLatitude(), Double::min);
        double lonMin = findCustomCoordinatePart(tp -> tp.getCoordinate().getLongitude(), Double::min);
        return new Coordinate(latMin, lonMin);
    }

    private double findCustomCoordinatePart(ToDoubleFunction<TrackPoint> converter, DoubleBinaryOperator reducer) {
        return trackPoints.stream()
                .mapToDouble(converter)
                .reduce(reducer)
                .orElseThrow(() -> new IllegalStateException("Not found!"));
    }

    public double getFullElevation() {
        return IntStream.range(1, trackPoints.size())
                .mapToDouble(i -> trackPoints.get(i).getElevation() - trackPoints.get(i - 1).getElevation())
                .filter(v -> v > 0)
                .sum();
    }

    public double getFullDecrease() {
        double absoluteDecrease = trackPoints.get(trackPoints.size() - 1).getElevation() - trackPoints.get(0).getElevation();
        return getFullElevation() - absoluteDecrease;
    }

    public double getDistance() {
        return IntStream.range(1, trackPoints.size())
                .mapToDouble(i -> trackPoints.get(i - 1).getDistanceFrom(trackPoints.get(i)))
                .sum();
    }

    public double getRectangleArea() {
        Coordinate minCoo = findMinimumCoordinate();
        Coordinate maxCoo = findMaximumCoordinate();
        return (maxCoo.getLatitude() - minCoo.getLatitude()) * (maxCoo.getLongitude() - minCoo.getLongitude());
    }

    public void loadFromGpx(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            while (br.ready()) {
                String line = br.readLine().strip();
                if (line.startsWith("<trkpt")) {
                    parseAndAddTrackPoint(line, br.readLine().strip());
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Reading file error!", ioe);
        } catch (NumberFormatException nfe) {
            throw new IllegalStateException("Wrong file format!", nfe);
        }
    }

    private void parseAndAddTrackPoint(String trackLine, String elevLine) {
        double lat = Double.parseDouble(trackLine.substring(12, 22));
        double lon = Double.parseDouble(trackLine.substring(29, 39));
        double elevation = Double.parseDouble(elevLine.substring(5, 10));
        trackPoints.add(new TrackPoint(new Coordinate(lat, lon), elevation));
    }
}
//---------------Alternative Solution for Max/Min Coordinate search--------------------------------------------
//    public Coordinate findMinimumCoordinate() {
//        return findCustomCoordinate(Math::min);
//    }
//    public Coordinate findMaximumCoordinate(){
//        return findCustomCoordinate(Math::max);
//    }
//    private Coordinate findCustomCoordinate(DoubleBinaryOperator operator){
//        return trackPoints.stream()
//                .map(TrackPoint::getCoordinate)
//                .reduce(
//                        (c1, c2) -> new Coordinate(
//                                operator.applyAsDouble(c1.getLatitude(), c2.getLatitude()),
//                                operator.applyAsDouble(c1.getLongitude(), c2.getLongitude())
//                        ))
//                .orElseThrow(()->new IllegalStateException("Not Found!"));
//    }
