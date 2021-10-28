package introconstructors;

import java.time.LocalDate;

public class CyclingTour {

    private String description;
    private LocalDate startTime;
    private int numberOfPeople;
    private double kms;

    public CyclingTour(String description, LocalDate startTime) {
        this.description = description;
        this.startTime = startTime;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public double getKms() {
        return kms;
    }

    public void registerPerson(int person) {
        numberOfPeople += person;
    }

    public void ride(double km) {
        kms += km;
    }

    @Override
    public String toString() {
        return  "The " + description +
                " started on " + startTime +
                " with " + numberOfPeople + " participants" +
                ", who rode " + kms + " kms altogether!";
    }

    public static void main(String[] args) {
        CyclingTour cyclingTour = new CyclingTour("Nicest Tour Ever", LocalDate.of(2021, 10, 28));
        System.out.println("Tour: " + cyclingTour.getDescription());
        System.out.println("Start Date: " + cyclingTour.getStartTime());
        System.out.println("Participants: " + cyclingTour.getNumberOfPeople());
        System.out.println("Kms: " + cyclingTour.getKms());

        cyclingTour.registerPerson(23);
        cyclingTour.ride(172.28);

        System.out.println();
        System.out.println(cyclingTour);
    }

}
