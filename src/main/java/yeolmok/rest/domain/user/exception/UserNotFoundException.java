package yeolmok.rest.domain.user.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super(UserErrorCode.USER_NOT_FOUND.getDefaultMessage() + ": " + id);
    }
}
