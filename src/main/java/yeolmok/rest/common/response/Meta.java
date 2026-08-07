package yeolmok.rest.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Meta {

    private final String code;
    private final String message;
    private final List<ValidationError> errors;

    public Meta(String code, String message) {
        this(code, message, null);
    }

    public Meta(String code, String message, List<ValidationError> errors) {
        this.code = code;
        this.message = message;
        this.errors = errors;
    }

    public static Meta of(ResponseCode code) {
        return new Meta(code.name(), code.getDefaultMessage());
    }
}
