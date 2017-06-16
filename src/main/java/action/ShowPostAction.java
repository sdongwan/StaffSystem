package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import service.PostService;

/**
 * Created by Administrator on 2017/6/10.
 */
public class ShowPostAction extends ActionSupport {
    private static final long serialVersionUID = -928691827403846043L;
    private Integer postId;
    private Post post;
    @Autowired
    private PostService postService;

    public PostService getPostService() {
        return postService;
    }

    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String execute() throws Exception {
        post = postService.showByPostId(postId);
        System.out.println(post.getPostName() + "  name and remark " + post.getPostRemark());


        ActionContext.getContext().put("postName", post.getPostName());
        ActionContext.getContext().put("post", post);
        ActionContext.getContext().put("postRemark", post.getPostRemark());
        return SUCCESS;
    }
}
