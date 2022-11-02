package homework.Control;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import homework.Dao.CommentDao;
import homework.Do.CommentDo;
import homework.Do.UserDo;
import homework.Model.Paging;
import homework.Model.Result;
import homework.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class commentControl {
    @Autowired
    private CommentDao commentDao;


    @GetMapping("comments")
    public Result<Paging<CommentDo>> getAll(@RequestParam(value = "pageNum" ,required = false) Integer pageNum,
                                            @RequestParam(value = "pageSize",required = false) Integer pageSize){
        Result<Paging<CommentDo>> result = new Result<>();
        if (pageNum == null){
            pageNum=1;
        }
        if (pageNum == null){
            pageSize = 15;
        }
        Page<CommentDo> page  = PageHelper.startPage(pageNum, pageSize).doSelectPage(() -> commentDao.findAll());
        result.setSuccess(true);
        result.setData(new Paging<>(page.getPageSize(),page.getPageNum(),page.getTotal(),page.getPageNum(),page.getResult()));

        return result;
    }
}
