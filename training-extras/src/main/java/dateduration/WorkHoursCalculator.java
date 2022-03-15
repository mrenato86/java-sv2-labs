package dateduration;

import java.time.Duration;
import java.time.format.DateTimeParseException;

public class WorkHoursCalculator {

    private Duration workDuration = Duration.ZERO;

    public void addWorkTime(Duration duration) {
        workDuration = workDuration.plus(duration);
    }

    public void addWorkTime(int days, int hours, int minutes) {
        workDuration = workDuration.plusDays(days).plusHours(hours).plusMinutes(minutes);
    }

    public void addWorkTime(String durationString) {
        if (isEmpty(durationString)) {
            throw new IllegalArgumentException("Parameter must not be empty!");
        }
        try {
            addWorkTime(Duration.parse(durationString));
        } catch (DateTimeParseException ex) {
            throw new IllegalArgumentException("Parameter must match PnDTnHnM pattern, but found: " + durationString);
        }
    }

    public long calculateWorkHours() {
        return workDuration.toHours();
    }

    public Duration getWorkDuration() {
        return workDuration;
    }

    @Override
    public String toString() {
        return String.format("Days: %d, hours: %d, minutes: %d",
                workDuration.toDaysPart(), workDuration.toHoursPart(), workDuration.toMinutesPart());
    }

    private boolean isEmpty(String durationString) {
        return durationString == null || durationString.isBlank();
    }

}
