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
    private Integer pageCount;
    private int pagination = 1;

    private int pageSize;

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public int getPagination() {
        return pagination;
    }

    public void setPagination(int pagination) {
        this.pagination = pagination;
    }

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
        pageSize = 5;
        System.out.println("pagination： " + pagination);
        userList = userService.showUsersByPage(pagination, pageSize);


        if (userService.getUserCount() % pageSize == 0) {
            pageCount = userService.getUserCount() / pageSize;
        } else {
            pageCount = userService.getUserCount() / pageSize + 1;
        }

        return SUCCESS;
    }
}
