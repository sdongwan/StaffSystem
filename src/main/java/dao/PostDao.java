package dao;

import entity.Post;

import java.util.List;

/**
 * Created by Administrator on 2017/6/9.
 */
public interface PostDao {
    void insertPost(Post post);

    void updatePost(Post post);

    void delPost(Post post);

    List<Post> findAllPost();

    Post finnByPostId(Integer id);

    List<Post> findByPostName(String postName);
}
