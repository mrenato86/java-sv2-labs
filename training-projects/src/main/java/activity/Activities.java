package activity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Activities {

    private final List<Activity> activities;

    public Activities(List<Activity> activities) {
        this.activities = new ArrayList<>(activities);
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public int numberOfTrackActivities() {
        return numberOfActivitiesByClass(ActivityWithTrack.class);
    }

    public int numberOfWithoutTrackActivities() {
        return numberOfActivitiesByClass(ActivityWithoutTrack.class);
    }

    private int numberOfActivitiesByClass(Class<? extends Activity> activityType) {
        return (int) activities.stream()
                .filter(a -> a.getClass() == activityType)
                .count();
    }

    public List<Report> distancesByTypes() {
        Map<ActivityType, Double> summaries = activities.stream()
                .collect(Collectors.groupingBy(
                        Activity::getType,
                        Collectors.summingDouble(Activity::getDistance)));
        return Arrays.stream(ActivityType.values())
                .map(at -> new Report(at, summaries.getOrDefault(at, 0.)))
                .collect(Collectors.toList());
    }

    public List<Activity> getActivities() {
        return List.copyOf(activities);
    }
}
