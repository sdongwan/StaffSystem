package service.impl;

import dao.PostDao;
import entity.Post;
import entity.User;
import service.PostService;

import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/6/9.
 */
public class PostServiceImpl implements PostService {
    private PostDao postDao;

    public PostDao getPostDao() {
        return postDao;
    }

    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }


    public void addPost(Post post) {
        postDao.insertPost(post);
    }

    public void delPost(Post post) {
        postDao.delPost(post);
    }

    public void updatePost(Post post) {
        postDao.updatePost(post);
    }

    public Post showByPostId(Integer postId) {
        return postDao.finnByPostId(postId);
    }

    public List<Post> showPosts() {
        return postDao.findAllPost();
    }

    public List<Post> showByPostName(String postName) {
        return postDao.findByPostName(postName);
    }


    public boolean isExist(String postName) {
        boolean flag = false;
        if (showByPostName(postName).size() > 0) {
            flag = true;
        }


        return flag;
    }

    public boolean isUpdate(Post post) {
        boolean flag = false;
        List<Post> posts = showByPostName(post.getPostName());
        if (showByPostName(post.getPostName()).size() > 0) {
            for (Post p : showByPostName(post.getPostName())) {
                if (p.getPostId() == post.getPostId()) {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public boolean isDel(Integer postId) {
        boolean flag = true;
        if (showByPostId(postId).getPostNum() > 0) {
            flag = false;
        }

        return true;
    }

    public int getPostUserCount(Integer postId) {
        int count = 0;
        Set<User> set = postDao.finnByPostId(postId).getUsers();
        count = set.size();
        return count;
    }
}
