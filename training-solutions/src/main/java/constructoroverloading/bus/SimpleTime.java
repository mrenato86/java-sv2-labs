package constructoroverloading.bus;

public class SimpleTime {

    private int hours;
    private int minutes;

    public SimpleTime(int hours) {
        this.hours = hours;
    }

    public SimpleTime(int hours, int minutes) {
        this(hours);
        this.minutes = minutes;
    }

    public SimpleTime(SimpleTime time) {
        this(time.hours, time.minutes);
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getDifference(SimpleTime time) {
        return this.timeInMinutes() - time.timeInMinutes();
    }

    private int timeInMinutes() {
        return 60 * hours + minutes;
    }

    public String toString() {
        return hours + ":" + minutes;
    }

}
