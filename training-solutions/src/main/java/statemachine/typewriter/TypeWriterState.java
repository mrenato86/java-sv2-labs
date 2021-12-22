package statemachine.typewriter;

public enum TypeWriterState {

    UPPERCASE {
        @Override
        public TypeWriterState next() {
            return TypeWriterState.LOWERCASE;
        }
    },
    LOWERCASE {
        @Override
        public TypeWriterState next() {
            return TypeWriterState.UPPERCASE;
        }
    };

    public abstract TypeWriterState next();

}
