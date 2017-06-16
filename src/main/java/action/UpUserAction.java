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
public class UpUserAction extends ActionSupport {
    private static final long serialVersionUID = 1443386609614877397L;
    @Autowired
    private UserService userService;
    private User user;
    private File file;
    private String fileFileName;
    @Autowired
    private PostService postService;
    private String postId;

    //添加传输数据的setter和getter方法

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public PostService getPostService() {
        return postService;
    }

    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    public String execute() {

        System.out.println("fileFileName" + fileFileName);
        System.out.println("file" + file);
        System.out.println("postId " + postId);
        System.out.println("user " + user);
        User u;
        if (userService.isUpdate(user)) {
        if (postId.equals("0")) {
            addActionError("请选择部门");
            return INPUT;
        } else {
            Integer postIdc = Integer.parseInt(postId);
            Post post = postService.showByPostId(postIdc);
            u = userService.showByUserId(user.getUserId());
            if (!postIdc.equals(u.getPost().getPostId())) {
                Post post2 = u.getPost();
                Integer postNum = post.getPostNum() + 1;
                Integer postNum2 = post2.getPostNum() - 1;
                post.setPostNum(postNum);
                post2.setPostNum(postNum2);
                postService.updatePost(post);
                postService.updatePost(post2);

            }


            u.setPost(post);
            u.setRemark(user.getRemark());
            u.setBirthday(user.getBirthday());
            u.setEntryDate(user.getEntryDate());
            u.setName(user.getName());
            u.setSex(user.getSex());
            u.setUsername(user.getUsername());
            u.setUserPass(user.getUserPass());

            String uploadPath = ServletActionContext.getServletContext().getRealPath("/WEB-INF/upload");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmssSSS");
            String msg = simpleDateFormat.format(new Date(System.currentTimeMillis()));
            if (file == null || fileFileName == null) {

                u.setPhoto("default.jpg");

            } else {
                String param = fileFileName.substring(fileFileName.lastIndexOf("."));
                String saveName = msg + param;
                MethodUtil.upload(uploadPath, saveName, file);
//                user.setPhoto(saveName);
                u.setPhoto(saveName);
            }
            userService.updateUser(u);
            return SUCCESS;

        }

        } else {
            return INPUT;
        }


    }


}
