package meetingrooms.outputenums;

public enum MenuItem {

    ADD("Tárgyaló rögzítése"),
    LIST_ORDERED("Tárgyalók sorrendben"),
    LIST_REVERSED("Tárgyalók visszafele sorrendben"),
    LIST_SECONDS("Minden második tárgyaló"),
    LIST_AREAS("Területek"),
    SEARCH_EXACT("Keresés pontos név alapján"),
    SEARCH_PART("Keresés névtöredék alapján"),
    SEARCH_AREA("Keresés terület alapján"),
    EXIT("Kilépés");

    private final String menuText;

    MenuItem(String menuText) {
        this.menuText = menuText;
    }

    @Override
    public String toString() {
        return String.format("%d %s", this.ordinal() + 1, menuText);
    }
}
