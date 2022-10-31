package homework.Service;

import homework.Model.User;


public interface UserService {
    User addUser(String username,String password);
    User updateUser(String username,String password);
    User checkUser(String username,String password);


}
