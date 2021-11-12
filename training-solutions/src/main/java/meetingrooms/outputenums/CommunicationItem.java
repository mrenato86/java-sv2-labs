package meetingrooms.outputenums;

public enum CommunicationItem {

    ASK_SELECT("Választott menüpont: "),
    ASK_PARAMETER("Adja meg a keresési paramétert: "),
    ASK_CONTINUE("Visszatérés a menübe: Enter"),
    TELL_LISTING("Kért adatok listázása: "),
    TELL_BYE("Viszontlátásra!"),
    ASK_NAME("Tárgyaló neve: "),
    ASK_LENGTH("Tárgyaló hossza (méter): "),
    ASK_WIDTH("Tárgyaló szélessége (méter): "),
    TELL_SUCCESS("Tárgyaló hozzáadva!"),
    TELL_FAILURE("Tárgyaló hozzáadása sikertelen!"),
    TELL_WRONG_MENU("Nem létező menüpont!"),
    TELL_WRONG_INPUT("Hibás adat!");

    private final String text;

    CommunicationItem(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
