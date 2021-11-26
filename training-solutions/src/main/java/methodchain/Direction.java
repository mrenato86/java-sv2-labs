package methodchain;

public enum Direction {
    POSITIVE(1), NEGATIVE(-1);

    private final int value;

    Direction(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
