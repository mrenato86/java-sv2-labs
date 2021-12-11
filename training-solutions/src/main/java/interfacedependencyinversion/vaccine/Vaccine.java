package interfacedependencyinversion.vaccine;

import java.util.List;

public interface Vaccine {

    List<Person> getVaccinationList();

    void generateVaccinationList(List<Person> registered);
}
