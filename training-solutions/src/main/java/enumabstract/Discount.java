package enumabstract;

public enum Discount {
    SPECIAL_OFFER {
        @Override
        public double getAmountToPay(int price, int pieces) {
            return 0.80 * price * pieces;
        }
    },
    BLACK_FRIDAY_OFFER {
        @Override
        public double getAmountToPay(int price, int pieces) {
            if (pieces < 3) {
                return 0.75 * price * pieces;
            } else {
                return 0.75 * price * (pieces - 1) + 0.50 * price;
            }
        }
    };

    public abstract double getAmountToPay(int price, int pieces);
}
