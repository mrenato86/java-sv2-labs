package exceptionclass.course;

public class SimpleTime {

    private int hour;
    private int minute;

    public SimpleTime(int hour, int minute) {
        validateTime(hour, minute);
        this.hour = hour;
        this.minute = minute;
    }

    public SimpleTime(String time) {
        int[] converted = convertFormat(time);
        validateTime(converted[0], converted[1]);
        this.hour = converted[0];
        this.minute = converted[1];
    }

    private int[] convertFormat(String time) {
        if (time == null)
            throw new InvalidTimeException("Time is null");
        if (time.length() != "hh:mm".length() || time.indexOf(':') != 2)
            throw new InvalidTimeException("Time is not hh:mm");
        int hour;
        int minute;
        try {
            hour = Integer.parseInt(time.substring(0, 2));
            minute = Integer.parseInt(time.substring(3, 5));
        } catch (NumberFormatException nfe) {
            throw new InvalidTimeException("Time is not hh:mm", nfe);
        }
        return new int[]{hour, minute};
    }

    private void validateTime(int hour, int minute) {
        if (hour < 0 || hour > 23)
            throw new InvalidTimeException("Hour is invalid (0-23)");
        if (minute < 0 || minute > 59)
            throw new InvalidTimeException("Minute is invalid (0-59)");
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", hour, minute);
    }
}
