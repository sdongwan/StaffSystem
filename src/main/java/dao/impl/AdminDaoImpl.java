package dao.impl;

import dao.AdminDao;
import entity.Admin;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by Administrator on 2017/6/9.
 */
public class AdminDaoImpl extends HibernateDaoSupport implements AdminDao {
    public List<Admin> findAllAdmin() {
        String hql = "from  Admin admin order by adminId";
        return (List<Admin>) this.getHibernateTemplate().find(hql);
    }

    public List<Admin> findByAdminUsernameAndPwd(String adminUserName, String adminUserPwd) {
        String hql = "from  Admin admin where adminUserName='" + adminUserName + "'" + " and adminPwd= '" + adminUserPwd + "' order by adminId";

        return (List<Admin>) this.getHibernateTemplate().find(hql);
    }

    public Admin findByAdminId(Integer adminId) {
        Admin admin = getHibernateTemplate().get(Admin.class, adminId);

        return admin;

    }

    public void addNewAdmin(Admin admin) {
        this.getHibernateTemplate().save(admin);
        this.getHibernateTemplate().flush();
    }

    public List<Admin> findByAdminName(String adminName) {
        String hql = "from  Admin admin where adminName= '" + adminName + "' order by adminId";

        return (List<Admin>) this.getHibernateTemplate().find(hql);
    }

    public List<Admin> findByAdminUserName(String adminUserName) {
        String hql = "from  Admin admin where adminUserName= '" + adminUserName + "' order by adminId";

        return (List<Admin>) this.getHibernateTemplate().find(hql);
    }


    public void updateAdmin(Admin admin) {
        this.getHibernateTemplate().update(admin);
        this.getHibernateTemplate().flush();
    }

    public void addOneCount(Integer adminId) {
        System.out.println("adminId " + adminId);
        Admin admin = this.getHibernateTemplate().get(Admin.class, adminId);

        Integer integer = admin.getLoginCount();
        System.out.println("integer " + integer);
        integer++;
        admin.setLoginCount(integer);
        this.getHibernateTemplate().update(admin);
        this.getHibernateTemplate().flush();
    }


}
