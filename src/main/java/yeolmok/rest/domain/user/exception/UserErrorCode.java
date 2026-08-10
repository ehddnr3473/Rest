package yeolmok.rest.domain.user.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import yeolmok.rest.common.response.ResponseCode;

@Getter
@RequiredArgsConstructor
@Schema(description = "user 도메인 에러 코드")
public enum UserErrorCode implements ResponseCode {

    @Schema(description = "이미 가입된 이메일로 회원가입을 시도함")
    DUPLICATE_EMAIL("이미 존재하는 이메일입니다"),

    @Schema(description = "존재하지 않거나 이미 탈퇴한 사용자를 조회/수정/탈퇴하려고 함")
    USER_NOT_FOUND("사용자를 찾을 수 없습니다");

    private final String defaultMessage;
}
