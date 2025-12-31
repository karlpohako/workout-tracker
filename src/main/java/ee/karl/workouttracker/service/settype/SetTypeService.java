package ee.karl.workouttracker.service.settype;

import ee.karl.workouttracker.controller.settype.dto.SetTypeDto;
import ee.karl.workouttracker.controller.settype.dto.SetTypeInfo;
import ee.karl.workouttracker.infrastructure.rest.error.Error;
import ee.karl.workouttracker.infrastructure.rest.exception.DataInUseException;
import ee.karl.workouttracker.infrastructure.rest.exception.DataNotFoundException;
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
