package datenewtypes;

import java.time.LocalTime;

public class DailyRoutine {

    private LocalTime startTime;

    public DailyRoutine(int hour, int minute) {
        this.startTime = LocalTime.of(hour, minute);
    }

    public DailyRoutine(String timeString) {
        this.startTime = LocalTime.parse(timeString);
    }

    public void setFutureTime(int minutes) {
        this.startTime = startTime.plusMinutes(minutes);
    }

    public boolean isBeforeNoon() {
        return startTime.isBefore(LocalTime.NOON);
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public static void main(String[] args) {
        DailyRoutine dr = new DailyRoutine(9, 0);
        System.out.println(dr.getStartTime());

        DailyRoutine dailyRoutine = new DailyRoutine("09:00");
        System.out.println(dailyRoutine.getStartTime());

        dr.setFutureTime(3 * 45 + 20);
        System.out.println(dr.getStartTime());
        System.out.println(dr.isBeforeNoon());
    }
}
