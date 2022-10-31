package homework.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import homework.Do.UserDo;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface UserDao {
    /**
     * 添加用户
     * @param userDo
     * @return
     */
    int add(UserDo userDo);

    /**
     * 更新用户
     * @param userDo
     * @return
     */
    int updateUser(UserDo userDo);

    /**
     * 查找用户名
     * @param username
     * @return
     */
    UserDo findByUserName(@Param("username") String username);

    ////////////////////////////////////

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    int delete(@Param("id") long id);

    /**
     * 批量添加
     * Param 注解的string类型 list 映射 List<UserDo>
     * param 传参都是list类型
     * @return
     */
    int batchadd(@Param("list") List<UserDo> userDos);

    /**
     * 根据ids列表找到所有满足条件的用户
     * @param ids
     * @return
     */
    List<UserDo> findByIds (@Param("ids") List<Long> ids);

    /**
     * 找到所有用户
     * @return
     */
    List<UserDo> findAll();

    /**
     * 模糊查询
     * @param keyword
     * @return
     */
    List<UserDo> quert(@Param("keyword") String keyword);

    /**
     * 查询在某个时间段注册的用户
     * @param keyword
     * @param startTime
     * @param endTime
     * @return
     */
    List<UserDo> search(@Param("keyword") String keyword,
                        @Param("startTime")LocalDateTime startTime,
                        @Param("endTime")LocalDateTime endTime);
}
