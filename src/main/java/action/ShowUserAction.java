package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import service.UserService;

/**
 * Created by Administrator on 2017/6/10.
 */
public class ShowUserAction extends ActionSupport {
    private static final long serialVersionUID = -3261510161456871865L;
    @Autowired
    private UserService userService;

    private User user;

    private Integer userId;

    public UserService getUserService() {

        return userService;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    @Override
    public String execute() throws Exception {
        user = userService.showByUserId(userId);


        return SUCCESS;


    }
}
