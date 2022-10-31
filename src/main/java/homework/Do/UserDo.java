package homework.Do;

import homework.Model.User;

import java.time.LocalDateTime;

public class UserDo {
    private long id;

    private String username;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(LocalDateTime gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public LocalDateTime getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
    }

    private String password;

    private LocalDateTime gmtCreated;

    private LocalDateTime gmtModified;

    public User convertToModel(UserDo userDo){
        User user = new User();
        user.setUsername(userDo.getUsername());
        user.setPassword(userDo.getPassword());
        user.setGmtCreated(userDo.getGmtCreated());
        user.setGmtModified(userDo.getGmtModified());
        return user;
    }
}
