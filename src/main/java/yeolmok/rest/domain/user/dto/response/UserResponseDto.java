package yeolmok.rest.domain.user.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import yeolmok.rest.domain.user.entity.User;

@Getter
@Schema(description = "회원 응답")
public class UserResponseDto {

    @Schema(description = "회원 id", example = "1")
    private final Long id;

    @Schema(description = "이메일", example = "user@example.com")
    private final String email;

    @Schema(description = "이름", example = "홍길동")
    private final String name;

    private UserResponseDto(Long id, String email, String name) {
        this.id = id;
        this.email = email;
        this.name = name;
    }

    public static UserResponseDto from(User user) {
        return new UserResponseDto(user.getId(), user.getEmail(), user.getName());
    }
}
