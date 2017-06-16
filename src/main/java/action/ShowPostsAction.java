package action;


import com.opensymphony.xwork2.ActionSupport;
import entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import service.PostService;

import java.util.List;

/**
 * Created by Administrator on 2017/6/10.
 */

public class ShowPostsAction extends ActionSupport {
    private static final long serialVersionUID = -4702532320506572653L;
    @Autowired
    private PostService postService;
    private List<Post> posts;
    private Post post;


    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

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

        if (postService == null) {
            System.out.println("null++++++++++++++++++++++++++++++++++");

        }
        posts = postService.showPosts();


//        for (Post post : posts) {
//            System.out.println(post.getPostName());
//        }
//        ActionContext.getContext().put("posts", posts);
//        System.out.println(posts + "------------------------------------------------------------------------------------");
        return SUCCESS;
    }
}
