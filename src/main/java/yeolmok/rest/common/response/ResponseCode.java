package yeolmok.rest.common.response;

import org.springframework.http.HttpStatus;

public interface ResponseCode {

    String name();

    String getDefaultMessage();

    HttpStatus getStatus();
}
