package activity;

public class ActivityWithoutTrack implements Activity {

    private final ActivityType activityType;

    public ActivityWithoutTrack(ActivityType activityType) {
        if (activityType == null) {
            throw new NullPointerException("Type must be provided!");
        }
        this.activityType = activityType;
    }

    @Override
    public double getDistance() {
        return 0.;
    }

    @Override
    public ActivityType getType() {
        return activityType;
    }

}
