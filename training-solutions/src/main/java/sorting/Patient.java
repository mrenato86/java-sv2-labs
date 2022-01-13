package sorting;

import java.time.LocalDateTime;

public class Patient {
    private String name;
    private String ssn;
    private LocalDateTime reservation;

    public Patient(String name, String ssn, LocalDateTime reservation) {
        this.name = name;
        this.ssn = ssn;
        this.reservation = reservation;
    }

    public String getName() {
        return name;
    }

    public String getSsn() {
        return ssn;
    }

    public LocalDateTime getReservation() {
        return reservation;
    }
}
