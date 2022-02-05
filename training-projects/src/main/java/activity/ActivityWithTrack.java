package activity;

public class ActivityWithTrack implements Activity {

    private final Track track;
    private final ActivityType activityType;

    public ActivityWithTrack(Track track, ActivityType activityType) {
        if (track == null || activityType == null) {
            throw new NullPointerException("Track and Type must be provided!");
        }
        this.track = track;
        this.activityType = activityType;
    }

    @Override
    public double getDistance() {
        return track.getDistance();
    }

    @Override
    public ActivityType getType() {
        return activityType;
    }
}
