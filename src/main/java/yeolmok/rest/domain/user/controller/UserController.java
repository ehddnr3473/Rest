package yeolmok.rest.domain.user.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yeolmok.rest.common.response.ApiResponse;
import yeolmok.rest.domain.user.dto.request.UserSignUpRequestDto;
import yeolmok.rest.domain.user.dto.request.UserUpdateRequestDto;
import yeolmok.rest.domain.user.dto.request.UserWithdrawRequestDto;
import yeolmok.rest.domain.user.dto.response.UserResponseDto;
import yeolmok.rest.domain.user.service.UserService;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<ApiResponse<UserResponseDto>> signUp(@Valid @RequestBody UserSignUpRequestDto request) {
        UserResponseDto response = userService.signUp(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(response));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponseDto>> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success(userService.getUser(id)));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponseDto>> updateUser(
            @PathVariable Long id,
            @Valid @RequestBody UserUpdateRequestDto request) {
        return ResponseEntity.ok(ApiResponse.success(userService.updateUser(id, request)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> withdraw(
            @PathVariable Long id,
            @RequestBody(required = false) UserWithdrawRequestDto request) {
        userService.withdraw(id, request != null ? request : new UserWithdrawRequestDto());
        return ResponseEntity.ok(ApiResponse.success(null));
    }
}
