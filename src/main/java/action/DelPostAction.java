package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import service.PostService;

/**
 * Created by Administrator on 2017/6/10.
 */
public class DelPostAction extends ActionSupport {
    private static final long serialVersionUID = 8302033646040696111L;

    private Integer postId;
    @Autowired
    private PostService postService;

    public PostService getPostService() {
        return postService;
    }

    public Integer getPostId() {
        return postId;
    }


    public void setPostId(Integer postId) {
        this.postId = postId;
    }


    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    @Override
    public String execute() throws Exception {
        if (postService.isDel(postId)) {
            Post post = postService.showByPostId(postId);
            System.out.println("delete" + post);
            postService.delPost(post);

            return SUCCESS;

        } else {
            addActionError("该部门有员工，删除失败");
            return INPUT;
        }

    }
}
