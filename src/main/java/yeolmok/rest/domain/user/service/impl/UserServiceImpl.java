package yeolmok.rest.domain.user.service.impl;

import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yeolmok.rest.domain.user.dto.request.UserSignUpRequestDto;
import yeolmok.rest.domain.user.dto.request.UserUpdateRequestDto;
import yeolmok.rest.domain.user.dto.request.UserWithdrawRequestDto;
import yeolmok.rest.domain.user.dto.response.UserResponseDto;
import yeolmok.rest.domain.user.entity.User;
import yeolmok.rest.domain.user.entity.UserStatus;
import yeolmok.rest.domain.user.entity.UserWithdrawalLog;
import yeolmok.rest.domain.user.exception.DuplicateEmailException;
import yeolmok.rest.domain.user.exception.UserNotFoundException;
import yeolmok.rest.domain.user.mapper.UserMapper;
import yeolmok.rest.domain.user.mapper.UserWithdrawalLogMapper;
import yeolmok.rest.domain.user.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserWithdrawalLogMapper userWithdrawalLogMapper;

    @Override
    public UserResponseDto signUp(UserSignUpRequestDto request) {
        if (userMapper.existsByEmail(request.getEmail()) > 0) {
            throw new DuplicateEmailException(request.getEmail());
        }

        User user = request.toEntity();
        userMapper.insert(user);
        return UserResponseDto.from(user);
    }

    @Override
    public UserResponseDto getUser(Long id) {
        User user = userMapper.selectById(id);
        if (user == null) {
            throw new UserNotFoundException(id);
        }
        return UserResponseDto.from(user);
    }

    @Override
    public UserResponseDto updateUser(Long id, UserUpdateRequestDto request) {
        User user = userMapper.selectById(id);
        if (user == null) {
            throw new UserNotFoundException(id);
        }

        user.setName(request.getName());
        userMapper.updateName(user);
        return UserResponseDto.from(user);
    }

    @Override
    @Transactional
    public void withdraw(Long id, UserWithdrawRequestDto request) {
        User user = userMapper.selectById(id);
        if (user == null) {
            throw new UserNotFoundException(id);
        }

        userWithdrawalLogMapper.insert(UserWithdrawalLog.of(user, request.getReason()));

        user.setEmail("withdrawn_" + user.getId() + "@deleted.local");
        user.setName("탈퇴회원");
        user.setStatus(UserStatus.WITHDRAWN);
        user.setWithdrawnAt(LocalDateTime.now());
        userMapper.withdraw(user);
    }
}
