package p3examtest.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import p3examtest.Dao.UserDao;
import p3examtest.Do.UserDo;
import p3examtest.Model.User;
import p3examtest.Service.UserService;

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
    public boolean checkUser(String name, String password) {
        if(name == null || !"".equals(name)){
            return false;
        }
        UserDo userDo = userDao.findByUserName(name);
        if(userDo==null){
            return false;
        }
        return true;
    }

    private UserDo packageUserDo(String name,String password){
        UserDo userDo = new UserDo();
        userDo.setUsername(name);
        userDo.setPassword(password);
        return userDo;
    }

}
