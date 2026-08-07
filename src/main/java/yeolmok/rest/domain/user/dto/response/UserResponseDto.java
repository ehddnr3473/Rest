package yeolmok.rest.domain.user.dto.response;

import lombok.Getter;
import yeolmok.rest.domain.user.entity.User;

@Getter
public class UserResponseDto {

    private final Long id;
    private final String email;
    private final String name;

    private UserResponseDto(Long id, String email, String name) {
        this.id = id;
        this.email = email;
        this.name = name;
    }

    public static UserResponseDto from(User user) {
        return new UserResponseDto(user.getId(), user.getEmail(), user.getName());
    }
}
