package service;

import entity.Post;

import java.util.List;

/**
 * Created by Administrator on 2017/6/9.
 */
public interface PostService {

    void addPost(Post post);

    void delPost(Post post);

    void updatePost(Post post);

    Post showByPostId(Integer postId);

    List<Post> showPosts();

    List<Post> showByPostName(String postName);

    boolean isExist(String postName);

    boolean isUpdate(Post post);

    boolean isDel(Integer postId);

    int getPostUserCount(Integer postId);
}
