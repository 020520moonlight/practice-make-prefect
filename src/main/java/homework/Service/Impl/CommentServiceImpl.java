package homework.Service.Impl;

import homework.Dao.CommentDao;
import homework.Do.CommentDo;
import homework.Model.Comment;
import homework.Model.Result;
import homework.Service.CommentService;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;
    @Override
    public Result<Comment> post(String refId, long parentId, long userId, String content) {
        Result<Comment> result = new Result<>();
        if (refId.equals("") || refId ==null || parentId ==0 || userId==0 || content.equals("")){
            result.setCode(500);
            result.setMessage("refid,parentid,userid can not be null");
            return result;
        }
        String body = StringEscapeUtils.escapeHtml4(content);

        CommentDo commentDo = new CommentDo();
        commentDo.setRefId(refId);
        commentDo.setUserId(userId);
        commentDo.setParentId(parentId);
        commentDo.setContent(body);

        commentDao.insert(commentDo);
        result.setMessage("post success");
        result.setCode(501);
        result.setData(commentDo.convertToModel(commentDo));
        return result;
    }

    @Override
    public Result<List<Comment>> query(String refId) {
        Result<List<Comment>> result = new Result<>();
        List<Comment> comments = commentDao.findByRefId(refId);

        Map<Long,Comment> commentMap = new HashMap<>();
        Comment comment1 = new Comment();
        commentMap.put(0L,comment1);

        comments.forEach(comment -> commentMap.put(comment.getId(),comment));
        for (Comment comment :comments){
            Comment parent = commentMap.get(comment.getParentId());
            if (parent != null){
                if (parent.getChildren() == null){
                    parent.setChildren(new ArrayList<>());
                }
                parent.getChildren().add(comment);
            }
        }
        List<Comment> data = commentMap.get(0L).getChildren();
        result.setSuccess(true);
        result.setData(data);
        return result;
    }
}
