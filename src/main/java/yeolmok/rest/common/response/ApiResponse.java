package yeolmok.rest.common.response;

import java.util.List;
import lombok.Getter;

@Getter
public class ApiResponse<T> {

    private final Meta meta;
    private final T data;

    private ApiResponse(Meta meta, T data) {
        this.meta = meta;
        this.data = data;
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(Meta.of(CommonResponseCode.SUCCESS), data);
    }

    public static ApiResponse<Void> error(ResponseCode code) {
        return new ApiResponse<>(Meta.of(code), null);
    }

    public static ApiResponse<Void> error(ResponseCode code, String message) {
        return new ApiResponse<>(new Meta(code.name(), message), null);
    }

    public static ApiResponse<Void> validationError(ResponseCode code, List<ValidationError> errors) {
        return new ApiResponse<>(new Meta(code.name(), code.getDefaultMessage(), errors), null);
    }
}
