package yeolmok.rest.domain.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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

@Tag(name = "User", description = "회원 API")
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "회원가입", description = "이메일/비밀번호/이름으로 회원가입합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "VALIDATION_ERROR"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "409", description = "DUPLICATE_EMAIL")
    })
    @PostMapping
    public ResponseEntity<ApiResponse<UserResponseDto>> signUp(@Valid @RequestBody UserSignUpRequestDto request) {
        UserResponseDto response = userService.signUp(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(response));
    }

    @Operation(summary = "회원 조회", description = "id로 회원 정보를 조회합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "USER_NOT_FOUND")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponseDto>> getUser(
            @Parameter(description = "회원 id", example = "1") @PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success(userService.getUser(id)));
    }

    @Operation(summary = "회원 정보 수정", description = "이름을 수정합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "VALIDATION_ERROR"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "USER_NOT_FOUND")
    })
    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponseDto>> updateUser(
            @Parameter(description = "회원 id", example = "1") @PathVariable Long id,
            @Valid @RequestBody UserUpdateRequestDto request) {
        return ResponseEntity.ok(ApiResponse.success(userService.updateUser(id, request)));
    }

    @Operation(summary = "회원 탈퇴", description = "회원을 탈퇴 처리합니다. 개인정보는 익명화되고 탈퇴 이력이 별도로 남습니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "USER_NOT_FOUND")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> withdraw(
            @Parameter(description = "회원 id", example = "1") @PathVariable Long id,
            @RequestBody(required = false) UserWithdrawRequestDto request) {
        userService.withdraw(id, request != null ? request : new UserWithdrawRequestDto());
        return ResponseEntity.ok(ApiResponse.success(null));
    }
}
