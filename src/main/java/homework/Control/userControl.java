package homework.Control;

import homework.Dao.UserDao;
import homework.Do.UserDo;
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

        User user = userService.checkUser(username,password);

        if (user != null && user.getPassword().equals(password)) {
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
        User user = userService.checkUser(username,password);
        if (user != null && user.getUsername().equals(username)){
            log.info("注册失败 --- 用户名已经存在");
            return "register";
        }
        User addUser = userService.addUser(username, password);
        //test        UserDo userDo = new UserDo();
        //        userDo.setUsername(username);
        //        userDo.setPassword(password);
        //        int testcount = userDao.add(userDo);
        //        if (testcount ==0){
        //            log.info("注册失败 --- dao出现问题");
        //        }
        //        log.error(testcount+"");
        if (addUser == null){
            log.info("注册失败 --- service出现问题");
            return "register";
        }else {
            log.info("注册成功，加入用户");
        }
        return "login";
    }

}
