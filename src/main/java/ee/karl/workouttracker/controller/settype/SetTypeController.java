package ee.karl.workouttracker.controller.settype;

import ee.karl.workouttracker.controller.settype.dto.SetTypeInfo;
import ee.karl.workouttracker.service.settype.SetTypeService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/settype")
public class SetTypeController {

    private final SetTypeService setTypeService;

    @GetMapping("/settypes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns all set types")
    })
    public List<SetTypeInfo> getAllSetTypes() {
        return setTypeService.getAllSetTypes();
    }


}
