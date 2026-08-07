package yeolmok.rest.common.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CommonResponseCode implements ResponseCode {

    SUCCESS("OK"),
    VALIDATION_ERROR("요청 값이 올바르지 않습니다"),
    INTERNAL_ERROR("서버 오류가 발생했습니다");

    private final String defaultMessage;
}
