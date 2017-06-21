package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.Post;
import service.PostService;

/**
 * Created by Administrator on 2017/6/10.
 */
public class AddPostAction extends ActionSupport {
    private static final long serialVersionUID = -6388866696998939631L;

    //    @Autowired
    private PostService postService;

    private Post post;

    public PostService getPostService() {
        return postService;
    }

    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }


    @Override
    public String execute() throws Exception {


        if (postService.isExist(post.getPostName())) {
            this.addFieldError("post.postName", "该部门已经存在");
            return INPUT;
        } else {

            post.setPostNum(0);
            if (post.getPostRemark().trim().equals("")) {
                post.setPostRemark("暂无");
            }

            postService.addPost(post);

            return SUCCESS;
        }

    }


}
