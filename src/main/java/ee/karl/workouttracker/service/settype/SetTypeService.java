package ee.karl.workouttracker.service.settype;

import ee.karl.workouttracker.controller.settype.dto.SetTypeInfo;
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

    public List<SetTypeInfo> getAllSetTypes() {
        return setTypeMapper.toInfoDtos(setTypeRepository.findAll());
    }
}
