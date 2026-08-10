package yeolmok.rest.common.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Schema(description = "공통 응답 코드")
public enum CommonResponseCode implements ResponseCode {

    @Schema(description = "성공")
    SUCCESS("OK"),

    @Schema(description = "요청 값 검증 실패")
    VALIDATION_ERROR("요청 값이 올바르지 않습니다"),

    @Schema(description = "서버 내부 오류")
    INTERNAL_ERROR("서버 오류가 발생했습니다");

    private final String defaultMessage;
}
