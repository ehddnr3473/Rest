package yeolmok.rest.domain.user.mapper;

import yeolmok.rest.domain.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    int insert(User user);

    User selectById(Long id);

    User selectByEmail(String email);

    int existsByEmail(String email);

    int updateName(User user);

    int withdraw(User user);

    int deleteById(Long id);
}
