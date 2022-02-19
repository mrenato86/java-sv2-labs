package activitytracker;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Activity {

    private final int id;
    private final LocalDateTime startTime;
    private final String desc;
    private final Type type;
    private List<TrackPoint> trackPoints;

    public Activity(int id, LocalDateTime startTime, String desc, Type type) {
        this.id = id;
        this.startTime = startTime;
        this.desc = desc;
        this.type = type;
    }

    public Activity(LocalDateTime startTime, String desc, Type type) {
        this(0, startTime, desc, type);
    }

    public Activity(int id, LocalDateTime startTime, String desc, Type type, List<TrackPoint> trackPoints) {
        this.id = id;
        this.startTime = startTime;
        this.desc = desc;
        this.type = type;
        this.trackPoints = new ArrayList<>(trackPoints);
    }

    public Activity(LocalDateTime startTime, String desc, Type type, List<TrackPoint> trackPoints) {
        this(0, startTime, desc, type, trackPoints);
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public String getDesc() {
        return desc;
    }

    public Type getType() {
        return type;
    }

    public List<TrackPoint> getTrackPoints() {
        return List.copyOf(trackPoints);
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", desc='" + desc + '\'' +
                ", type=" + type +
                ", trackPoints=" + trackPoints +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity activity = (Activity) o;
        return Objects.equals(startTime, activity.startTime) && Objects.equals(desc, activity.desc) && type == activity.type && Objects.equals(trackPoints, activity.trackPoints);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startTime, desc, type, trackPoints);
    }
}
