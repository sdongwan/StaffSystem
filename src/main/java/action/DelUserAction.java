package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.Post;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import service.PostService;
import service.UserService;

/**
 * Created by Administrator on 2017/6/10.
 */
public class DelUserAction extends ActionSupport {
    private static final long serialVersionUID = 3418107361969729048L;
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public PostService getPostService() {
        return postService;
    }

    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute() throws Exception {
        User user = userService.showByUserId(userId);
        System.out.println("delete user " + user);
        if (user != null) {
            Post post = postService.showByPostId(user.getPost().getPostId());
            Integer postNum = post.getPostNum() - 1;
            post.setPostNum(postNum);
            postService.updatePost(post);
            userService.delUser(user);

            return SUCCESS;
        } else {
            return INPUT;

        }
    }
}
