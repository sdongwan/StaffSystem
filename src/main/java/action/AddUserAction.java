package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.Post;
import entity.User;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import service.PostService;
import service.UserService;
import util.MethodUtil;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/6/9.
 */
public class AddUserAction extends ActionSupport {
    private static final long serialVersionUID = 1276235902279193389L;
    @Autowired
    private UserService userService;

    private User user;

    private File file;
    private String fileFileName;

    @Autowired
    private PostService postService;
    private String postId;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public UserService getUserService() {
        return userService;
    }

    public PostService getPostService() {
        return postService;
    }

    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String execute() {


        System.out.println("user----" + user);

        if (user == null) {
            return INPUT;
        }

        if (userService.isExist(user.getUsername())) {

            addActionError("用户名已经存在");
            return INPUT;
        } else {


            if (postId.equals("0")) {
                return INPUT;
            } else {
                Integer postIdc = Integer.parseInt(postId);
                Post post = postService.showByPostId(postIdc);
                Integer postNum = post.getPostNum();
                postNum = postNum + 1;
                post.setPostNum(postNum);
                postService.updatePost(post);


                user.setPost(post);

                String uploadPath = ServletActionContext.getServletContext().getRealPath("/WEB-INF/upload");
                System.out.println("uploadPath" + uploadPath);

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmssSSS");
                String msg = simpleDateFormat.format(new Date(System.currentTimeMillis()));
                if (file == null || fileFileName == null) {
                    System.out.println("file=null----------------------");
                    user.setPhoto("default.jpg");
                } else {
                    System.out.println("filename " + fileFileName);
                    System.out.println("filesize " + file.getName());

                    String param = fileFileName.substring(fileFileName.lastIndexOf("."));
                    String saveName = msg + param;
                    MethodUtil.upload(uploadPath, saveName, file);
                    user.setPhoto(saveName);
                }

                if (user.getRemark().trim().equals("")) {
                    user.setRemark("无");
                } else {
                    user.setRemark(user.getRemark().trim());
                }


                userService.addUser(user);

                return SUCCESS;
            }


        }

    }

}
