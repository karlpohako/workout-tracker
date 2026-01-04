package ee.karl.workouttracker.infrastructure.rest.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Error {

    EXERCISE_NOT_FOUND("Exercise not found"),
    EXERCISE_ALREADY_EXISTS("Exercise already exists"),
    EXERCISE_IN_USE("Exercise is used in workout"),

    SET_TYPE_NOT_FOUND("Set type not found"),
    SET_TYPE_ALREADY_EXISTS("Set type already exists"),
    SET_TYPE_IN_USE("Set type is used in exercises"),

    CATEGORY_NOT_FOUND("Category not found"),
    CATEGORY_ALREADY_EXISTS("Category already exists"),
    CATEGORY_IN_USE("Category is used in exercises"),

    MUSCLE_GROUP_NOT_FOUND("Muscle group not found"),
    MUSCLE_GROUP_ALREADY_EXISTS("Muscle group already exists"),
    MUSCLE_GROUP_IN_USE("Muscle group is used in exercises"),

    EQUIPMENT_TYPE_NOT_FOUND("Equipment type not found"),
    EQUIPMENT_TYPE_ALREADY_EXISTS("Equipment type already exists"),
    EQUIPMENT_TYPE_IN_USE("Equipment type is used in exercises"),

    WORKOUTEXERCISE_NOT_FOUND("Workout exercise not found"),

    USER_NOT_FOUND("User not found"),
    USER_ALREADY_EXISTS("User already exists"),

    WORKOUT_NOT_FOUND("Workout not found");

    private final String message;
}
