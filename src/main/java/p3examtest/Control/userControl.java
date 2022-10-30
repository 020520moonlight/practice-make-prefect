package p3examtest.Control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import p3examtest.Do.UserDo;
import p3examtest.Model.User;
import p3examtest.Service.UserService;


@Controller
public class userControl {

    @Autowired(required = false)
    private UserService userService;
    @GetMapping("index")
    public String login(Model model){
        return "login";
    }
    @PostMapping("authenticate")
    //@ResponseBody
    public String authenticate(@RequestParam String name, @RequestParam String passwor){
        User user = userService.checkUser(name,passwor);
        if (user == null){
            return "login";
        }
        return "loginSuccess";
    }
}
