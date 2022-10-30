package p3examtest.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import p3examtest.Dao.UserDao;
import p3examtest.Do.UserDo;
import p3examtest.Model.User;
import p3examtest.Service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User addUser(String name, String password) {
        if(name == null || !"".equals(name)){
            return null;
        }
        UserDo userDo = packageUserDo(name,password);
        int count = userDao.addUser(userDo);
        if(count >0){
            return userDo.convertToModel(userDo);
        }
        return null;
    }

    @Override
    public User updateUser(String name, String password) {
        if(name == null || !"".equals(name)){
            return null;
        }
        UserDo userDo = packageUserDo(name,password);
        int count = userDao.updateUser(userDo);
        if(count >0){
            return userDo.convertToModel(userDo);
        }
        return null;
    }

    @Override
    public User checkUser(String name, String password) {
        if(name == null || !"".equals(name)){
            return null;
        }
        UserDo userDo = userDao.findByUserName(name);
        if(userDo==null){
            return null;
        }
        return userDo.convertToModel(userDo);
    }

    private UserDo packageUserDo(String name,String password){
        UserDo userDo = new UserDo();
        userDo.setUsername(name);
        userDo.setPassword(password);
        return userDo;
    }

}
