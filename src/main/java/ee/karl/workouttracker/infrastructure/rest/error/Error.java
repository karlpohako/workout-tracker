package ee.karl.workouttracker.infrastructure.rest.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Error {

    EXERCISE_NOT_FOUND("Exercise not found");

    private final String message;
}
