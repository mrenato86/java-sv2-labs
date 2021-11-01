package stringconcat.nameconcat;

public enum Title {
    MR("Mr."), MRS("Mrs."), MS("Ms."), DR("Dr.");

    private String title;

    Title(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
