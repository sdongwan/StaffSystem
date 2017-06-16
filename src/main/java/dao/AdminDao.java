package dao;

import entity.Admin;

import java.util.List;

/**
 * Created by Administrator on 2017/6/9.
 */
public interface AdminDao {

    List<Admin> findAllAdmin();

    List<Admin> findByAdminUsernameAndPwd(String adminUserName, String adminUserPwd);


    Admin findByAdminId(Integer adminId);

    void addNewAdmin(Admin admin);

    List<Admin> findByAdminName(String adminName);

    List<Admin> findByAdminUserName(String adminUserName);

    void updateAdmin(Admin admin);

    void addOneCount(Integer adminId);

}
