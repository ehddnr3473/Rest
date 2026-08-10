package yeolmok.rest.domain.user.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Schema(description = "회원 탈퇴 요청")
public class UserWithdrawRequestDto {

    @Schema(description = "사유")
    private String reason;
}
