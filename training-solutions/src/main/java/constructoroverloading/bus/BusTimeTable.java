package constructoroverloading.bus;

import java.util.ArrayList;
import java.util.List;

public class BusTimeTable {

    private final List<SimpleTime> timeTable;

    public BusTimeTable(List<SimpleTime> timeTable) {
        this.timeTable = timeTable;
    }

    public BusTimeTable(int firstHour, int lastHour, int everyMinute) {
        timeTable = new ArrayList<>();
        for (int hour = firstHour; hour <= lastHour; hour++) {
            timeTable.add(new SimpleTime(hour, everyMinute));
        }
    }

    public List<SimpleTime> getTimeTable() {
        return timeTable;
    }

    public SimpleTime getNextBus(SimpleTime actual) {
        for (SimpleTime time : timeTable) {
            if (time.getDifference(actual) >= 0) {
                return time;
            }
        }
        throw new IllegalStateException("There's no more bus for today!");
    }

}
