package homework.Service.Impl;

import homework.Model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import homework.Dao.UserDao;
import homework.Do.UserDo;
import homework.Model.User;
import homework.Service.UserService;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    //这里语法有问题
    @Override
    public User addUser(String username, String password) {
        if (username.equals("")||username==null){
            return null;
        }
        UserDo userDo = packageUserDo(username,password);
        int count = userDao.add(userDo);
        if (count == 0){
            return null;
        }
        return userDo.convertToModel(userDo);

    }

    @Override
    public User updateUser(String username, String password) {
        if(username == null || !"".equals(username)){
            return null;
        }
        UserDo userDo = packageUserDo(username,password);
        int count = userDao.updateUser(userDo);
        if(count >0){
            return userDo.convertToModel(userDo);
        }
        return null;
    }

    @Override
    public Result<User> checkUser(String username, String password) {
        Result<User> result = new Result<>();
        if(username == null || "".equals(username)){
            result.setCode(600);
            result.setMessage("用户名未输入");
            return result;
        }
        UserDo userDo = userDao.findByUserName(username);
        if(userDo==null){
            //登陆时，不能在数据库找到用户名
            result.setCode(601);
            result.setMessage("用户名未注册");
            return result;
        }
        result.setSuccess(true);
        result.setCode(602);
        result.setMessage("登录成功");
        result.setData(userDo.convertToModel(userDo));
        return result;
    }

    @Override
    public boolean delUser(String username) {
        UserDo userDo = userDao.findByUserName(username);
        long id = userDo.getId();
        int count = userDao.delete(id);
        return count != 0 ;
    }


    private UserDo packageUserDo(String username,String password){
        UserDo userDo = new UserDo();
        userDo.setUsername(username);
        userDo.setPassword(password);
        return userDo;
    }

}
