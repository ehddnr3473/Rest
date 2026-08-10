package yeolmok.rest.domain.user.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import yeolmok.rest.domain.user.entity.User;

@Getter
@NoArgsConstructor
@Schema(description = "회원가입 요청")
public class UserSignUpRequestDto {

    @Schema(description = "이메일", example = "user@example.com")
    @NotBlank
    @Email
    private String email;

    @Schema(description = "비밀번호 (8~100자)", example = "password123")
    @NotBlank
    @Size(min = 8, max = 100)
    private String password;

    @Schema(description = "이름", example = "홍길동")
    @NotBlank
    private String name;

    public User toEntity() {
        return User.builder()
                .email(email)
                .password(password)
                .name(name)
                .build();
    }
}
