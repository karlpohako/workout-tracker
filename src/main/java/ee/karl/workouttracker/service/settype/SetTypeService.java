package ee.karl.workouttracker.service.settype;

import ee.karl.workouttracker.controller.settype.dto.SetTypeDto;
import ee.karl.workouttracker.controller.settype.dto.SetTypeInfo;
import ee.karl.workouttracker.infrastructure.rest.error.Error;
import ee.karl.workouttracker.infrastructure.rest.exception.DataInUseException;
import ee.karl.workouttracker.infrastructure.rest.exception.DataNotFoundException;
import ee.karl.workouttracker.presistence.exerciseset.ExerciseSetRepository;
import ee.karl.workouttracker.presistence.settype.SetType;
import ee.karl.workouttracker.presistence.settype.SetTypeMapper;
import ee.karl.workouttracker.presistence.settype.SetTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SetTypeService {

    private final SetTypeMapper setTypeMapper;
    private final SetTypeRepository setTypeRepository;
    private final ExerciseSetRepository exerciseSetRepository;

    public void saveSetType(SetTypeDto setTypeDto) {
        SetType setType = createSetType(setTypeDto);
        setTypeRepository.save(setType);
    }

    public List<SetTypeInfo> findAllSetTypes() {
        return setTypeMapper.toInfoDtos(setTypeRepository.findAll());
    }

    public SetTypeDto findSetTypeById(Integer setTypeId) {
        SetType setType = getSetType(setTypeId);
        return setTypeMapper.toDto(setType);
    }

    public void updateSetType(Integer setTypeId, SetTypeDto setTypeDto) {
        SetType setType = getSetType(setTypeId);
        setTypeMapper.updateSetType(setTypeDto, setType);
        setTypeRepository.save(setType);
    }

    public void deleteSetType(Integer setTypeId) {
        assertSetTypeExistsAndNotInUse(setTypeId);
        setTypeRepository.deleteById(setTypeId);
    }

    private void assertSetTypeExistsAndNotInUse(Integer setTypeId) {
        boolean exists = setTypeRepository.existsById(setTypeId);
        boolean usedInExerciseSet = exerciseSetRepository.isSetTypeUsedInExerciseSetBy(setTypeId);
        if (!exists) {
            throw new DataNotFoundException(Error.SET_TYPE_NOT_FOUND.getMessage());
        }
        if (usedInExerciseSet) {
            throw new DataInUseException(Error.SET_TYPE_IN_USE.getMessage());
        }
    }

    private SetType getSetType(Integer setTypeId) {
        return setTypeRepository.findById(setTypeId).orElseThrow(
                () -> new DataNotFoundException(Error.SET_TYPE_NOT_FOUND.getMessage())
        );
    }

    private SetType createSetType(SetTypeDto setTypeDto) {
        boolean existsByName = setTypeRepository.existsByName(setTypeDto.getName());
        if (existsByName) {
            throw new DataInUseException(Error.SET_TYPE_ALREADY_EXISTS.getMessage());
        }
        return setTypeMapper.toEntity(setTypeDto);
    }
}
