package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import service.UserService;

import java.util.List;

/**
 * Created by Administrator on 2017/6/10.
 */
public class ShowUsersAction extends ActionSupport {
    private static final long serialVersionUID = 7967893979153555395L;
    @Autowired
    private UserService userService;
    private User user;
    private List<User> userList;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute() throws Exception {
        userList = userService.showUsers();


        return SUCCESS;
    }
}
