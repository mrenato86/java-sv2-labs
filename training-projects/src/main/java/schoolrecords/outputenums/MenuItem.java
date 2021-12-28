package schoolrecords.outputenums;

public enum MenuItem {

    LIST_STUDENTS("Diákok nevének listázása"),
    SEARCH_STUDENT("Diák név alapján keresése"),
    ADD_STUDENT("Diák létrehozása"),
    DELETE_STUDENT("Diák név alapján törlése"),
    REPETITION("Diák feleltetése"),
    CALC_CLASS_AVG("Osztályátlag kiszámolása"),
    CALC_SUBJECT_AVG("Tantárgyi átlag kiszámolása"),
    LIST_ALL_AVG("Diákok átlagának megjelenítése"),
    LIST_AVG_STUDENT("Diák átlagának kiírása"),
    LIST_AVG_STUDENT_SUBJECT("Diák tantárgyhoz tartozó átlagának kiírása"),
    EXIT("Kilépés");

    private final String menuText;

    MenuItem(String menuText) {
        this.menuText = menuText;
    }

    @Override
    public String toString() {
        return String.format("%2d %s", this.ordinal() + 1, menuText);
    }
}
