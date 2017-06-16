package dao.impl;

import dao.UserDao;
import entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/6/9.
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
    public void insertUser(User user) {
        this.getHibernateTemplate().save(user);
        getHibernateTemplate().flush();


    }

    public void delUser(User user) {
        this.getHibernateTemplate().delete(user);
        getHibernateTemplate().flush();

    }

    public void updateUser(User user) {
        this.getHibernateTemplate().update(user);
        getHibernateTemplate().flush();

    }


    public User findByUserId(Integer userId) {
        User user = this.getHibernateTemplate().get(User.class, userId);

        return user;
    }

    public List<User> findByUserName(String userName) {
        String hql = "from User user where username='" + userName + "' order by userId";

        return (List<User>) this.getHibernateTemplate().find(hql);
    }

    public List<User> findByPostId(Integer postId) {
        String hql = "from User user where postId='" + postId + "' order by userId";

        return (List<User>) this.getHibernateTemplate().find(hql);

    }

    public List<User> findAllUser() {
        String hql = "from User user  order by userId";

        return (List<User>) this.getHibernateTemplate().find(hql);
    }

    public List<User> findAllUserByPage(int pageNo, int pageSize) {
        Session session = this.getSession();
        session.beginTransaction();
        String hql = "from User user order by userId";
        Query query = session.createQuery(hql);
        query.setFirstResult((pageNo - 1) * pageSize);
        query.setMaxResults(pageSize);

        return query.list();
    }

    public int getUserCount() {
        Long count = null;
        String hql = "select count(userId) from User user";
        Iterator iterator = this.getHibernateTemplate().find(hql).iterator();
        if (iterator.hasNext()) {
            count = (Long) iterator.next();
        }
        return count.intValue();
    }


    public int getPostUserCount(Integer postId) {
        Long count = null;
        String hql = "select count(postId) from User user where postId='" + postId + "' ";
        Iterator iterator = this.getHibernateTemplate().find(hql).iterator();
        if (iterator.hasNext()) {
            count = (Long) iterator.next();
        }
        return count.intValue();
    }
}
