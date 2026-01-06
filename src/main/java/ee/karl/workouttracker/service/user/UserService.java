package ee.karl.workouttracker.service.user;

import ee.karl.workouttracker.controller.user.dto.*;
import ee.karl.workouttracker.infrastructure.rest.error.Error;
import ee.karl.workouttracker.infrastructure.rest.exception.DataNotFoundException;
import ee.karl.workouttracker.infrastructure.rest.exception.DatabaseNameConflictException;
import ee.karl.workouttracker.presistence.user.User;
import ee.karl.workouttracker.presistence.user.UserMapper;
import ee.karl.workouttracker.presistence.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public void saveUser(UserCreationDto userCreationDto) {
        User user = createUser(userCreationDto);
        userRepository.save(user);
    }

    public UserDto findUserById(Integer userId) {
        User user = getUserBy(userId);
        return userMapper.toUserDto(user);
    }

    public List<UserInfo> findAllUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.toUserInfoDtos(users);
    }

    public void updateUserEmail(Integer userId, EmailUpdateDto emailUpdateDto) {
        User user = getUserBy(userId);
        userMapper.emailUpdate(emailUpdateDto, user);
        userRepository.save(user);

    }

    public void updateUserPassword(Integer userId, PasswordUpdateDto passwordUpdateDto) {
        User user = getUserBy(userId);
        userMapper.passwordUpdate(passwordUpdateDto, user);
        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(Integer userId) {
        doesUserExist(userId);
        userRepository.deleteById(userId);
    }

    private void doesUserExist(Integer userId) {
        if (!userRepository.existsById(userId)) {
            throw new DataNotFoundException(Error.USER_NOT_FOUND.getMessage());
        }
    }

    private User getUserBy(Integer userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new DataNotFoundException(Error.USER_NOT_FOUND.getMessage()));
    }

    private User createUser(UserCreationDto userCreationDto) {
        if (userRepository.existsByUsername(userCreationDto.getUsername())) {
            throw new DatabaseNameConflictException(Error.USER_ALREADY_EXISTS.getMessage());
        }
        return userMapper.createToUser(userCreationDto);
    }
}
