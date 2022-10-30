package p3examtest.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import p3examtest.Do.UserDo;

@Mapper
public interface UserDao {
    int addUser(UserDo userDo);
    int updateUser(UserDo userDo);
    UserDo findByUserName(@Param("userName") String name);
}
