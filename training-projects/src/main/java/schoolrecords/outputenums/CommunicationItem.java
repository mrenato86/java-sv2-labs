package schoolrecords.outputenums;

public enum CommunicationItem {

    ASK_SELECT("Választott menüpont: "),
    ASK_STUDENT("Adja meg a diák nevét: "),
    ASK_SUBJECT("Adja meg a tantárgy sorszámát: "),
    ASK_TUTOR("Adja meg az oktató sorszámát: "),
    ASK_MARK("Adja meg az érdemjegyet(A,B,C,D,F): "),
    ASK_CONTINUE("Visszatérés a menübe: Enter"),
    TELL_BYE("Viszontlátásra!"),
    TELL_SUCCESS("Sikeres művelet!"),
    TELL_FAILURE("Sikertelen művelet!"),
    TELL_RESULT("A sorsolás eredménye: "),
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
