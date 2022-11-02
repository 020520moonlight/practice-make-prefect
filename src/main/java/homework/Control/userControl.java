package homework.Control;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import homework.Dao.UserDao;
import homework.Do.UserDo;
import homework.Model.Paging;
import homework.Model.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import homework.Model.User;
import homework.Service.UserService;


@Controller
public class userControl {
    //日志信息
    private static  final Logger log = LoggerFactory.getLogger(userControl.class);
    //@Autowired(required = false)
    @Autowired
    private UserService userService;
    /**
     * 仅测试dao
     */
    @Autowired
    private UserDao userDao;

    /**
     * 登陆页面
     * @param model
     * @return
     */
    @GetMapping("index")
    public String login(Model model){
        return "login";
    }

    /**
     * 检验页面
     * @param username
     * @param password
     * @return
     */
    @PostMapping("authenticate")
    public String authenticate(@RequestParam String username,
                               @RequestParam String password){

        Result<User> user = userService.checkUser(username,password);

        if (user != null && user.getData().getPassword().equals(password)) {
            log.info("登陆成功");
            return "loginSuccess";
        }
        log.info("登录失败");

        return "login";
    }
    @GetMapping("test")
    public String test(Model model){
        return "loginSuccess";
    }

    /**
     * 注册页面
     * @param
     * @return
     */
    @GetMapping("sign")
    public String sign(Model model){
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username,
                           @RequestParam String password){
        Result<User> user = userService.checkUser(username,password);
        if (user != null && user.getData().getUsername().equals(username)){
            log.info("注册失败 --- 用户名已经存在");
            return "register";
        }
        User addUser = userService.addUser(username, password);
        if (addUser == null){
            log.info("注册失败 --- service出现问题");
            return "register";
        }else {
            log.info("注册成功，加入用户");
        }
        return "login";
    }
    @GetMapping("users")
    public Result<Paging<UserDo>> getAll(@RequestParam(value = "pageNum" ,required = false) Integer pageNum,
                                         @RequestParam(value = "pageSize",required = false) Integer pageSize){
        Result<Paging<UserDo>> result = new Result<>();
        if (pageNum == null){
            pageNum=1;
        }
        if (pageNum == null){
            pageSize = 15;
        }
        Page<UserDo> page  = PageHelper.startPage(pageNum, pageSize).doSelectPage(() -> userDao.findAll());
        result.setSuccess(true);
        result.setData(new Paging<>(page.getPageSize(),page.getPageNum(),page.getTotal(),page.getPageNum(),page.getResult()));

        return result;
    }

}
