package ee.karl.workouttracker.infrastructure.rest.exception;

public class DataInUseException extends RuntimeException {
    public DataInUseException(String message) {
        super(message);
    }
}
