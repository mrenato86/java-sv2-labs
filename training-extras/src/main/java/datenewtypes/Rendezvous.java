package datenewtypes;

import java.time.DateTimeException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Rendezvous {

    private LocalTime rendezvous;

    public Rendezvous(int hour, int minute) {
        this.rendezvous = LocalTime.of(hour, minute);
    }

    public Rendezvous(String timeString, String pattern) {
        validateString(pattern);
        try {
            this.rendezvous = LocalTime.parse(timeString, DateTimeFormatter.ofPattern(pattern));
        } catch (DateTimeException dte) {
            throw new IllegalArgumentException("Illegal time string: " + timeString);
        }
    }

    public LocalTime getRendezvous() {
        return rendezvous;
    }

    public String toString(String pattern) {
        validateString(pattern);
        return DateTimeFormatter.ofPattern(pattern).format(rendezvous);
    }

    public long countMinutesLeft(LocalTime base) {
        long diff = ChronoUnit.MINUTES.between(base, rendezvous);
        if (diff <= 0) {
            throw new MissedOpportunityException("Too late!");
        }
        return diff;
    }

    public void pushLater(int hours, int minutes) {
        this.rendezvous = rendezvous.plusHours(hours).plusMinutes(minutes);
    }

    public void pullEarlier(int hours, int minutes) {
        this.rendezvous = rendezvous.minusHours(hours).minusMinutes(minutes);
    }

    private void validateString(String str) {
        if (str == null || str.isBlank()) {
            throw new IllegalArgumentException("Empty pattern string!");
        }
    }

    public static class MissedOpportunityException extends RuntimeException {
        public MissedOpportunityException(String message) {
            super(message);
        }
    }

}
