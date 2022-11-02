package homework.Service;

import homework.Model.Result;
import homework.Model.User;


public interface UserService {
    /**
     * 添加用户
     * @param username
     * @param password
     * @return
     */
    User addUser(String username,String password);

    /**
     * 更新用户
     * @param username
     * @param password
     * @return
     */
    User updateUser(String username,String password);

    /**
     * 登录和注册校验
     * @param username
     * @param password
     * @return
     */
    Result<User> checkUser(String username, String password);

    /**
     * 删除用户
     * @param username
     * @return
     */
    boolean delUser(String username);
}
