package interfacedependencyinversion.vaccine;

import java.util.ArrayList;
import java.util.List;

public class FirstVaccine implements Vaccine {

    private List<Person> vaccinationList = new ArrayList<>();

    @Override
    public List<Person> getVaccinationList() {
        return vaccinationList;
    }

    @Override
    public void generateVaccinationList(List<Person> registered) {
        List<Person> pregnant = new ArrayList<>();
        List<Person> elderly = new ArrayList<>();
        List<Person> others = new ArrayList<>();

        for (Person person : registered) {
            if (person.getPregnant() == Pregnancy.YES) {
                pregnant.add(person);
            } else if (person.getAge() > 65) {
                elderly.add(person);
            } else {
                others.add(person);
            }
        }
        vaccinationList.addAll(pregnant);
        vaccinationList.addAll(elderly);
        vaccinationList.addAll(others);
    }
}
