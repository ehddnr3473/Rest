package yeolmok.rest.domain.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import yeolmok.rest.domain.user.entity.UserWithdrawalLog;

@Mapper
public interface UserWithdrawalLogMapper {

    int insert(UserWithdrawalLog log);
}
