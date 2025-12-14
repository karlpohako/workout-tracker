package ee.karl.workouttracker.infrastructure.rest.exception;

public class DatabaseNameConflictException extends RuntimeException {
    public DatabaseNameConflictException(String message) {
        super(message);
    }
}
