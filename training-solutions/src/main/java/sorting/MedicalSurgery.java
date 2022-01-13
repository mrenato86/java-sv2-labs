package sorting;

import java.util.ArrayList;
import java.util.List;

public class MedicalSurgery {

    private List<Patient> patients;

    public MedicalSurgery(List<Patient> patients) {
        this.patients = new ArrayList<>(patients);
    }

    public List<Patient> getPatients() {
        return new ArrayList<>(patients);
    }

    public List<Patient> getPatientsInTimeOrder() {
        List<Patient> patientsInTimeOrder = new ArrayList<>(patients);
        patientsInTimeOrder.sort(new PatientComparator());
        return patientsInTimeOrder;
    }
}
