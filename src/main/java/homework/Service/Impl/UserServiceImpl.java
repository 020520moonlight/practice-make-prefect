package homework.Service.Impl;

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
    public User checkUser(String username, String password) {
        if(username == null || "".equals(username)){
            return null;
        }
        UserDo userDo = userDao.findByUserName(username);
        if(userDo==null){
            return null;
        }
        return userDo.convertToModel(userDo);
    }


    private UserDo packageUserDo(String username,String password){
        UserDo userDo = new UserDo();
        userDo.setUsername(username);
        userDo.setPassword(password);
        return userDo;
    }

}
