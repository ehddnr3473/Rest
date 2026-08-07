package yeolmok.rest.domain.user.entity;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserWithdrawalLog {

    private Long id;
    private Long userId;
    private String email;
    private String name;
    private String reason;
    private LocalDateTime withdrawnAt;

    public static UserWithdrawalLog of(User user, String reason) {
        return UserWithdrawalLog.builder()
                .userId(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .reason(reason)
                .withdrawnAt(LocalDateTime.now())
                .build();
    }
}
