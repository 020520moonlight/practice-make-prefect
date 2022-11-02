package homework.Service;

import homework.Model.Comment;
import homework.Model.Result;

import java.util.List;

public interface CommentService {
    /**
     * 提交评论
     * @param refId
     * @param parentId
     * @param userId
     * @param content
     * @return
     */
    public Result<Comment> post(String refId,long parentId,long userId,String content);

    /**
     * 查询评论
     * @param refId
     * @return
     */
    public Result<List<Comment>> query(String refId);
}
