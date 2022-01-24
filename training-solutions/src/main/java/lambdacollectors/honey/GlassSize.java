package lambdacollectors.honey;

public enum GlassSize {
    BIG(1.0), SMALL(0.5), TASTER_SIZE(0.05);

    private final double amountByKg;

    GlassSize(double amountByKg) {
        this.amountByKg = amountByKg;
    }

    public double getAmountByKg() {
        return amountByKg;
    }
}
