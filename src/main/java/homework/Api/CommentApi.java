package homework.Api;

import homework.Dao.CommentDao;
import homework.Do.CommentDo;
import homework.Model.Comment;
import homework.Model.Result;
import homework.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class CommentApi {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private CommentService commentService;

    @PostMapping("comment/add")
    public CommentDo add(@RequestBody CommentDo commentDo){
        commentDao.insert(commentDo);
        return commentDo;
    }
    @PostMapping("comment/batchAdd")
    public List<CommentDo> batchAdd(@RequestBody List<CommentDo> commentDos){
        commentDao.batchAdd(commentDos);
        return commentDos;
    }
    @PostMapping("comment/update")
    public CommentDo update(@RequestBody CommentDo commentDo){
        commentDao.update(commentDo);
        return commentDo;
    }


    @GetMapping("/comment/del")
    public boolean delete(@RequestParam("id") Long id) {
        return commentDao.delete(id) > 0;
    }

    @GetMapping("/comment/findByRefId")
    @ResponseBody
    public List<Comment> findByRefId(@RequestParam("refId") String refId) {
        return commentDao.findByRefId(refId);
    }

    @GetMapping("/comment/findByUserIds")
    public List<CommentDo> findByUserIds(@RequestParam("UserIds") List<Long> ids){
        return commentDao.findByUserIds(ids);
    }

    @PostMapping("comment/post")
    public Result<Comment> post(@RequestParam String refID, @RequestParam long partentId,
                                @RequestParam String content, HttpServletRequest request){
        long userId = (long) request.getSession().getAttribute("userId");
        return commentService.post(refID,partentId,userId,content);
    }
    @GetMapping("comment/quer")
    public Result<List<Comment>> query(@RequestParam String refId){
        return commentService.query(refId);
    }
}
