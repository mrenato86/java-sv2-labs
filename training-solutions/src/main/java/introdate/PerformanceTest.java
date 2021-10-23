package introdate;

import java.time.LocalDate;
import java.time.LocalTime;

public class PerformanceTest {

    public static void main(String[] args) {
        Performance performance = new Performance("Queen", LocalDate.of(1989, 6, 2), LocalTime.of(18, 0), LocalTime.of(20, 0));

        System.out.println("Artist: " + performance.getArtist());
        System.out.println("On: " + performance.getDate());
        System.out.println("From: " + performance.getStartTime());
        System.out.println("Till: " + performance.getEndTime());

        System.out.println("\n" + performance.getInfo());

    }

}
