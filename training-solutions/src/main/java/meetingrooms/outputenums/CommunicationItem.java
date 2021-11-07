package meetingrooms.outputenums;

public enum CommunicationItem {

    ASK_SELECT("Választott menüpont: "),
    ASK_PARAMETER("Adja meg a keresési paramétert: "),
    ASK_CONTINUE("Folytatáshoz nyomjon Enter-t!"),
    TELL_LISTING("Kért adatok listázása: "),
    TELL_NONE("Nincs találat."),
    TELL_BYE("Viszontlátásra!"),
    ASK_NAME("Tárgyaló neve: "),
    ASK_LENGTH("Tárgyaló hossza (méter): "),
    ASK_WIDTH("Tárgyaló szélessége (méter): "),
    TELL_SUCCESS("Tárgyaló hozzáadva!");

    private final String text;

    CommunicationItem(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
