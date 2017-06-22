package service;

import entity.User;

import java.util.List;

/**
 * Created by Administrator on 2017/6/9.
 */
public interface UserService {

    void addUser(User user);

    void delUser(User user);

    void updateUser(User user);

    User showByUserId(Integer userId);

    List<User> showUsers();

    boolean isExist(String userName);

    List<User> showByUserName(String userName);

    boolean isUpdate(User user);

    List<User> showUsersByPage(int pageNo, int pageSize);

    int getUserCount();

}
