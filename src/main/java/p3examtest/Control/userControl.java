package p3examtest.Control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import p3examtest.Model.User;
import p3examtest.Service.UserService;


@Controller
public class userControl {
    //日志信息
    private static  final Logger log = LoggerFactory.getLogger(userControl.class);

    @Autowired(required = false)
    private UserService userService;

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
     * @param name
     * @param password
     * @return
     */
    @PostMapping("authenticate")
    public String authenticate(@RequestParam String name,
                               @RequestParam String password){

        User user = userService.checkUser(name,password);

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
    public String register(@RequestParam String name,
                           @RequestParam String password){
        User user = userService.checkUser(name,password);
        if (user == null || user.getUsername().equals(name)){
            return "register";
        }
        userService.addUser(name,password);
        log.info("注册成功，加入用户");
        return "login";
    }

}
