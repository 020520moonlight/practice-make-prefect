package homework.Dao;

import homework.Do.CommentDo;
import homework.Do.UserDo;
import homework.Model.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentDao {
    /**
     * 增加一条评论数据
     * @param commentDo
     * @return
     */
    int insert(CommentDo commentDo);

    /**
     * 根据id值删除一条评论数据
     * @param id
     * @return
     */
    int delete(@Param("id") long id);

    /**
     * 更新一条评论数据
     * @param commentDo
     * @return
     */
    int update(CommentDo commentDo);

    /**
     * 找到所有评论
     * @return
     */
    List<UserDo> findAll();

    /**
     * 批量添加评论数据
     * @param userDos
     * @return
     */
    int batchAdd(@Param("list") List<CommentDo> userDos);

    /**
     * 根据评论id 返回评论模型列表
     * @param refId
     * @return
     */
    List<Comment> findByRefId(@Param("refId") String refId);

    /**
     * 根据用户ids集合 返回评论模型列表
     * @param ids
     * @return
     */
    List<CommentDo> findByUserIds(@Param("userIds") List<Long> ids);

}
