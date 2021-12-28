package schoolrecords.outputenums;

public enum CommunicationItem {

    ASK_SELECT("Választott menüpont: "),
    ASK_STUDENT("Adja meg a diák nevét: "),
    ASK_SUBJECT("Adja meg a tantárgy sorszámát: "),
    ASK_CONTINUE("Visszatérés a menübe: Enter"),
    TELL_BYE("Viszontlátásra!"),
    ASK_NAME("Diák neve: "),
    TELL_SUCCESS("Sikeres művelet!"),
    TELL_FAILURE("Sikertelen művelet!"),
    TELL_RESULT("A kért adat: "),
    TELL_WRONG_MENU("Nem létező menüpont!"),
    TELL_WRONG_INPUT("Hibás bevitel!");

    private final String text;

    CommunicationItem(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
