package homework.Api;

import homework.Dao.UserDao;
import homework.Do.UserDo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class UserApi {
    private static final Logger log = LoggerFactory.getLogger(UserApi.class);

    @Autowired
    private UserDao userDao;

    @PostMapping("user/add")
    public UserDo add(@RequestBody UserDo userDo){
        userDao.add(userDo);
        return userDo;
    }
    @PostMapping("user/batchAdd")
    public List<UserDo> batchAdd(@RequestBody List<UserDo> userDos){
        userDao.batchadd(userDos);
        return userDos;
    }

    @PostMapping("user/update")
    public UserDo update(@RequestBody UserDo userDo){
        userDao.updateUser(userDo);
        return userDo;
    }

    @GetMapping("user/del")
    public boolean del(@RequestParam("id") long id){
        return userDao.delete(id) > 0;
    }

    @GetMapping("/user/findByUserName")
    public UserDo findByUserName(@RequestParam("userName") String userName) {
        return userDao.findByUserName(userName);
    }

    @GetMapping("/user/search")
    public List<UserDo> search(@RequestParam("keyword") String keyword,
                               @RequestParam("startTime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                               LocalDateTime startTime,
                               @RequestParam("endTime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                               LocalDateTime endTime){
        return userDao.search(keyword,startTime,endTime);
    }

    @GetMapping("/user/findByIds")
    public List<UserDo> findByIds(@RequestParam("ids") List<Long> ids) {
        return userDao.findByIds(ids);
    }
}
