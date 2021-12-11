package interfacedependencyinversion.vaccine;

import java.util.ArrayList;
import java.util.List;

public class SecondVaccine implements Vaccine {

    private List<Person> vaccinationList = new ArrayList<>();

    @Override
    public List<Person> getVaccinationList() {
        return vaccinationList;
    }

    @Override
    public void generateVaccinationList(List<Person> registered) {
        List<Person> youngHealthy = new ArrayList<>();
        List<Person> elderHealthy = new ArrayList<>();

        for (Person person : registered) {
            if (person.getPregnant() == Pregnancy.NO && person.getChronic() == ChronicDisease.NO) {
                if (person.getAge() <= 65) {
                    youngHealthy.add(person);
                } else {
                    elderHealthy.add(person);
                }
            }
        }
        vaccinationList.addAll(youngHealthy);
        vaccinationList.addAll(elderHealthy);
    }
}
