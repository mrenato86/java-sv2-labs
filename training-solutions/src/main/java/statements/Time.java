package statements;

public class Time {

    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getInMinutes() {
        return 60 * hours + minutes;
    }

    public int getInSeconds(){
        return 60 * getInMinutes() + seconds;
    }

    public boolean earlierThan(Time otherTime){
        return this.getInSeconds() < otherTime.getInSeconds();
    }

    @Override
    public String toString() {
        return hours + ":" + minutes + ":" + seconds;
    }

}
