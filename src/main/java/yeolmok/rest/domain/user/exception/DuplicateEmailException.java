package yeolmok.rest.domain.user.exception;

public class DuplicateEmailException extends RuntimeException {

    public DuplicateEmailException(String email) {
        super(UserErrorCode.DUPLICATE_EMAIL.getDefaultMessage() + ": " + email);
    }
}
