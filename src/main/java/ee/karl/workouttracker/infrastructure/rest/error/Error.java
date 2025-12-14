package ee.karl.workouttracker.infrastructure.rest.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Error {

    EXERCISE_NOT_FOUND("Exercise not found"),
    EXERCISE_ALREADY_EXISTS("Exercise already exists"),

    CATEGORY_NOT_FOUND("Category not found"),

    MUSCLE_GROUP_NOT_FOUND("Muscle group not found"),

    EQUIPMENT_TYPE_NOT_FOUND("Equipment type not found");

    private final String message;
}
