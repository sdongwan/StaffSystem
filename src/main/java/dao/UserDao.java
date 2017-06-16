package dao;

import entity.User;

import java.util.List;

/**
 * Created by Administrator on 2017/6/9.
 */
public interface UserDao {

    void insertUser(User user);

    void delUser(User user);

    void updateUser(User user);

    User findByUserId(Integer userId);

    List<User> findByUserName(String UserName);

    List<User> findByPostId(Integer postId);

    List<User> findAllUser();

    List<User> findAllUserByPage(int pageNo, int pageSize);

    int getUserCount();

    int getPostUserCount(Integer postId);

}
