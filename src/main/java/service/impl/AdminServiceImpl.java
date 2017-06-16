package service.impl;

import dao.AdminDao;
import entity.Admin;
import service.AdminService;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/6/9.
 */
public class AdminServiceImpl implements AdminService {

    private AdminDao adminDao;

    public AdminDao getAdminDao() {
        return adminDao;
    }

    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }


    public boolean isLogin(String adminUserName, String adminUserPwd) {
        boolean flag = false;

        if (adminDao.findByAdminUsernameAndPwd(adminUserName, adminUserPwd).size() > 0) {
            flag = true;
        }

        return flag;
    }


    public List<Admin> showAdmins() {
        return adminDao.findAllAdmin();
    }

    public Admin showByAdminId(Integer id) {
        return adminDao.findByAdminId(id);
    }

    public Admin login(String adminUserName, String adminUserPwd) {
        Admin admin = null;
        if (isLogin(adminUserName, adminUserPwd)) {
            List<Admin> adminList = adminDao.findByAdminUsernameAndPwd(adminUserName, adminUserPwd);
            Iterator<Admin> iterator = adminList.iterator();
            if (iterator.hasNext()) {
                admin = iterator.next();
            }
        }

        return admin;
    }

    public boolean isRegistConflict(Admin admin) {
        boolean flag = true;
        if (adminDao.findByAdminName(admin.getAdminName()).size() == 0) {
            if (adminDao.findByAdminUserName(admin.getAdminUserName()).size() == 0) {
                flag = false;
            }
        }


        return flag;
    }

    public void registAdmin(Admin admin) {
        adminDao.addNewAdmin(admin);
    }

    public void updateAdmin(Admin admin) {
        adminDao.updateAdmin(admin);
    }

    public void addLoginCount(Integer adminId) {
        adminDao.addOneCount(adminId);
    }


}
