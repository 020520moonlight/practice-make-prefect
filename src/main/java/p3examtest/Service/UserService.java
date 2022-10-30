package p3examtest.Service;

import p3examtest.Model.User;

public interface UserService {
    User addUser(String name,String password);
    User updateUser(String name,String password);

    boolean checkUser(String name,String password);
}
