package yeolmok.rest.common.exception;

import lombok.Getter;
import yeolmok.rest.common.response.ResponseCode;

@Getter
public class BusinessException extends RuntimeException {

    private final ResponseCode errorCode;

    public BusinessException(ResponseCode errorCode) {
        super(errorCode.getDefaultMessage());
        this.errorCode = errorCode;
    }

    public BusinessException(ResponseCode errorCode, String detail) {
        super(errorCode.getDefaultMessage() + ": " + detail);
        this.errorCode = errorCode;
    }
}
