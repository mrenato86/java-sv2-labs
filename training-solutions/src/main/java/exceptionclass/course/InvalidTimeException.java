package exceptionclass.course;

public class InvalidTimeException extends RuntimeException {

    public InvalidTimeException() {
        super();
    }

    public InvalidTimeException(String message) {
        super(message);
    }

    public InvalidTimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
