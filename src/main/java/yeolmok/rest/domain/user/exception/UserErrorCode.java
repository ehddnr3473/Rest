package yeolmok.rest.domain.user.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import yeolmok.rest.common.response.ResponseCode;

@Getter
@RequiredArgsConstructor
public enum UserErrorCode implements ResponseCode {

    DUPLICATE_EMAIL("이미 존재하는 이메일입니다"),
    USER_NOT_FOUND("사용자를 찾을 수 없습니다");

    private final String defaultMessage;
}
