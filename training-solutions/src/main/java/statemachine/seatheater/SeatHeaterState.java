package statemachine.seatheater;

public enum SeatHeaterState {

    OFF {
        @Override
        public SeatHeaterState next() {
            return SeatHeaterState.THREE;
        }
    },
    THREE {
        @Override
        public SeatHeaterState next() {
            return SeatHeaterState.TWO;
        }
    },
    TWO {
        @Override
        public SeatHeaterState next() {
            return SeatHeaterState.ONE;
        }
    },
    ONE {
        @Override
        public SeatHeaterState next() {
            return SeatHeaterState.OFF;
        }
    };

    public abstract SeatHeaterState next();

}
