package ee.karl.workouttracker.presistence.user;

import ee.karl.workouttracker.controller.user.dto.*;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(target = "username", source = "username")
    @Mapping(target = "email", source = "email")
    UserDto toUserDto(User user);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "username", source = "username")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "updatedAt", source = "updatedAt")
    UserInfo toUserInfoDto(User user);

    List<UserInfo> toUserInfoDtos(List<User> users);

    @Mapping(target = "username", source = "username")
    @Mapping(target = "email", source = "email")
    User toUser(UserDto userDto);

    @InheritConfiguration(name = "toUser")
    @Mapping(target = "password", source = "password")
    User createToUser(UserCreationDto userCreationDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "email", source = "email")
    User emailUpdate(EmailUpdateDto emailUpdateDto, @MappingTarget User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "password", source = "password")
    User passwordUpdate(PasswordUpdateDto passwordUpdateDto, @MappingTarget User user);
}
