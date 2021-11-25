package methodparam.marriage;

import java.time.LocalDate;

public class Marriage {

    public void getMarried(Woman woman, Man man) {
        setWomanMarriedName(woman, man.getName());
        addRegisterDate(woman, man);
    }

    private void setWomanMarriedName(Woman woman, String husbandName) {
        String[] husbandNameParts = husbandName.split(" " );
        String husbandLastName = husbandNameParts[0];
        woman.setName(husbandLastName + "-" + woman.getName());
    }

    private void addRegisterDate(Woman woman, Man man) {
        woman.addRegisterDate(new RegisterDate("marriage date", LocalDate.now()));
        man.addRegisterDate(new RegisterDate("marriage date", LocalDate.now()));
    }

}
