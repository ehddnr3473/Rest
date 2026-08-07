package yeolmok.rest.common.response;

import lombok.Getter;

@Getter
public class ValidationError {

    private final String field;
    private final String reason;

    public ValidationError(String field, String reason) {
        this.field = field;
        this.reason = reason;
    }
}
