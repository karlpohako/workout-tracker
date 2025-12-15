package ee.karl.workouttracker.service.exercise;

import ee.karl.workouttracker.controller.exercise.dto.ExerciseDto;
import ee.karl.workouttracker.controller.exercise.dto.ExerciseInfoDto;
import ee.karl.workouttracker.infrastructure.rest.error.Error;
import ee.karl.workouttracker.infrastructure.rest.exception.DataNotFoundException;
import ee.karl.workouttracker.infrastructure.rest.exception.DatabaseNameConflictException;
import ee.karl.workouttracker.presistence.category.Category;
import ee.karl.workouttracker.presistence.category.CategoryRepository;
import ee.karl.workouttracker.presistence.equipmenttype.EquipmentType;
import ee.karl.workouttracker.presistence.equipmenttype.EquipmentTypeRepository;
import ee.karl.workouttracker.presistence.exercise.Exercise;
import ee.karl.workouttracker.presistence.exercise.ExerciseMapper;
import ee.karl.workouttracker.presistence.exercise.ExerciseRepository;
import ee.karl.workouttracker.presistence.musclegroup.MuscleGroup;
import ee.karl.workouttracker.presistence.musclegroup.MuscleGroupRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;
    private final ExerciseMapper exerciseMapper;
    private final CategoryRepository categoryRepository;
    private final MuscleGroupRepository muscleGroupRepository;
    private final EquipmentTypeRepository equipmentTypeRepository;

    public void addExercise(ExerciseDto exerciseDto) {
        Category category = getCategoryOrThrow(exerciseDto.getCategory());
        MuscleGroup muscleGroup = getMuscleGroupOrThrow(exerciseDto.getMuscleGroup());
        EquipmentType equipmentType = getEquipmentTypeOrThrow(exerciseDto.getEquipmentType());
        Exercise exercise = createExerciseOrThrowIfAlreadyExists(exerciseDto);

        exercise.setMuscleGroup(muscleGroup);
        exercise.setCategory(category);
        exercise.setEquipmentType(equipmentType);

        exerciseRepository.save(exercise);
    }

    public ExerciseDto findExercise(Integer exerciseId) {
        Exercise exercise = exerciseRepository.findById(exerciseId)
                .orElseThrow(() -> new DataNotFoundException(Error.EXERCISE_NOT_FOUND.getMessage()));
        return exerciseMapper.toExerciseDto(exercise);
    }

    public List<ExerciseInfoDto> findAllExercises() {
        return exerciseMapper.toExerciseInfoDtos(exerciseRepository.findAll());
    }

    public void updateExercise(Integer exerciseId, ExerciseDto exerciseDto) {
        Exercise exercise = getExerciseByIdOrThrow(exerciseId);
        Category category = getCategoryOrThrow(exerciseDto.getCategory());
        MuscleGroup muscleGroup = getMuscleGroupOrThrow(exerciseDto.getMuscleGroup());
        EquipmentType equipmentType = getEquipmentTypeOrThrow(exerciseDto.getEquipmentType());

        exercise.setCategory(category);
        exercise.setMuscleGroup(muscleGroup);
        exercise.setEquipmentType(equipmentType);
        exerciseMapper.updateExercise(exerciseDto, exercise);
        exerciseRepository.save(exercise);
    }

    private Exercise getExerciseByIdOrThrow(Integer exerciseId) {
        return exerciseRepository.findById(exerciseId)
                .orElseThrow(() -> new DataNotFoundException(Error.EXERCISE_NOT_FOUND.getMessage()));
    }

    private Category getCategoryOrThrow(String categoryName) {
        return categoryRepository.findCategoryByName(categoryName)
                .orElseThrow(() -> new DataNotFoundException(Error.CATEGORY_NOT_FOUND.getMessage()));
    }

    private MuscleGroup getMuscleGroupOrThrow(String muscleGroupName) {
        return muscleGroupRepository.findMuscleGroupByName(muscleGroupName)
                .orElseThrow(() -> new DataNotFoundException(Error.MUSCLE_GROUP_NOT_FOUND.getMessage()));
    }

    private EquipmentType getEquipmentTypeOrThrow(String equipmentTypeName) {
        return equipmentTypeRepository.findEquipmentTypeByName(equipmentTypeName)
                .orElseThrow(() -> new DataNotFoundException(Error.EQUIPMENT_TYPE_NOT_FOUND.getMessage()));
    }

    private Exercise createExerciseOrThrowIfAlreadyExists(ExerciseDto exerciseDto) {
        String name = exerciseDto.getName();
        String category = exerciseDto.getCategory();

        boolean exists = exerciseRepository.findExerciseByNameAndCategory(name, category);
        if (exists) {
            throw new DatabaseNameConflictException(Error.EXERCISE_ALREADY_EXISTS.getMessage());
        }

        return exerciseMapper.toExercise(exerciseDto);
    }
}
