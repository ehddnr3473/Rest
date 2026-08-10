package yeolmok.rest.domain.user.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Schema(description = "회원 정보 수정 요청")
public class UserUpdateRequestDto {

    @Schema(description = "이름", example = "홍길동")
    @NotBlank
    private String name;
}
