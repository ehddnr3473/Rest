package yeolmok.rest.domain.user.service;

import yeolmok.rest.domain.user.dto.request.UserSignUpRequestDto;
import yeolmok.rest.domain.user.dto.request.UserUpdateRequestDto;
import yeolmok.rest.domain.user.dto.request.UserWithdrawRequestDto;
import yeolmok.rest.domain.user.dto.response.UserResponseDto;

public interface UserService {

    UserResponseDto signUp(UserSignUpRequestDto request);

    UserResponseDto getUser(Long id);

    UserResponseDto updateUser(Long id, UserUpdateRequestDto request);

    void withdraw(Long id, UserWithdrawRequestDto request);
}
