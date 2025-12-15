package ee.karl.workouttracker.infrastructure.rest.exception;

public class ExerciseInUseException extends RuntimeException {
    public ExerciseInUseException(String message) {
        super(message);
    }
}
