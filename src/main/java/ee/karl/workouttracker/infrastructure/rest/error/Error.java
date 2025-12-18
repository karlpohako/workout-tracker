package ee.karl.workouttracker.infrastructure.rest.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Error {

    EXERCISE_NOT_FOUND("Exercise not found"),
    EXERCISE_ALREADY_EXISTS("Exercise already exists"),

    CATEGORY_NOT_FOUND("Category not found"),
    CATEGORY_ALREADY_EXISTS("Category already exists"),
    CATEGORY_IN_USE("Category is used in exercises"),

    MUSCLE_GROUP_NOT_FOUND("Muscle group not found"),

    EQUIPMENT_TYPE_NOT_FOUND("Equipment type not found"),
    EQUIPMENT_TYPE_ALREADY_EXISTS("Equipment type already exists"),

    WORKOUT_EXERCISE_IN_USE("Exercise is used in workout");

    private final String message;
}
