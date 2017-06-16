package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import service.PostService;

/**
 * Created by Administrator on 2017/6/10.
 */
public class UpdatePostAction extends ActionSupport {
    private static final long serialVersionUID = -8514959109601932787L;
    @Autowired
    private PostService postService;

    private Post post;


    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public PostService getPostService() {
        return postService;
    }

    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    @Override
    public String execute() throws Exception {
        boolean flag = postService.isUpdate(post);
        System.out.println(flag);
        System.out.println(post.getPostName());
        if (postService.isUpdate(post)) {
            Post p = postService.showByPostId(post.getPostId());
            p.setPostName(post.getPostName());
            p.setPostRemark(post.getPostRemark());
            postService.updatePost(p);
            System.out.println(post);
            return SUCCESS;

        } else {
            addActionError("修改失败");
            return INPUT;
        }


    }
}
