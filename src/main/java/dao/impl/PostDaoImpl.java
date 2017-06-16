package dao.impl;

import dao.PostDao;
import entity.Post;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by Administrator on 2017/6/9.
 */
public class PostDaoImpl extends HibernateDaoSupport implements PostDao {


    public void insertPost(Post post) {
        this.getHibernateTemplate().save(post);
        getHibernateTemplate().flush();

    }

    public void updatePost(Post post) {

        this.getHibernateTemplate().update(post);
        getHibernateTemplate().flush();
    }

    public void delPost(Post post) {
        this.getHibernateTemplate().delete(post);
        getHibernateTemplate().flush();

    }

    public List<Post> findAllPost() {
        String hql = "from Post post order by postId";

        return (List<Post>) getHibernateTemplate().find(hql);
    }

    public Post finnByPostId(Integer id) {

        Post post = getHibernateTemplate().get(Post.class, id);

        return post;
    }

    public List<Post> findByPostName(String postName) {
        String hql = "from Post post where postName ='" + postName + "' order by postId";

        return (List<Post>) getHibernateTemplate().find(hql);
    }
}
