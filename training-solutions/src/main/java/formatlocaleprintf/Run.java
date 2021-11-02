package formatlocaleprintf;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Run {

    private String name;
    private List<Double> odometer;

    public Run(String name) {
        this.name = name;
        this.odometer = new ArrayList<>();
    }

    public void addRun(double km) {
        odometer.add(km);
    }

    public String printFormattedRunText() {
        String text = "Dear %s! Today's date is %s. This is your %d. run this week. You have run %4.1f km this time. Keep it up!";
        int count = odometer.size();
        double distance = odometer.get(odometer.size() - 1);
        return String.format(text, name, LocalDate.now(), count, distance);
    }

    public static void main(String[] args) {
        Run run = new Run("U. Bolt");
        run.addRun(8.7);
        System.out.println(run.printFormattedRunText());
        run.addRun(10.1);
        System.out.println(run.printFormattedRunText());
        run.addRun(6.2);
        System.out.println(run.printFormattedRunText());
        run.addRun(10.7);
        System.out.println(run.printFormattedRunText());
    }

}
