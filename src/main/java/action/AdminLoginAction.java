package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import service.AdminService;

/**
 * Created by Administrator on 2017/6/9.
 */
public class AdminLoginAction extends ActionSupport {
    private static final long serialVersionUID = 7710467279273396340L;
    private Admin admin;
    @Autowired
    private AdminService adminService;

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public AdminService getAdminService() {
        return adminService;
    }

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }


    public String adminLogin() {
        if (admin == null) {
            return INPUT;
        }
        System.out.println(admin.getAdminUserName() + "\\" + admin.getAdminPwd());
        if (adminService.isLogin(admin.getAdminUserName(), admin.getAdminPwd())) {

            Admin a = adminService.login(admin.getAdminUserName(), admin.getAdminPwd());
            System.out.println(a);

            adminService.addLoginCount(a.getAdminId());
            ActionContext.getContext().getSession().put("adminId", a.getAdminId());
            ActionContext.getContext().getSession().put("adminName", a.getAdminName());
            ActionContext.getContext().getSession().put("adminUserName", a.getAdminUserName());
            ActionContext.getContext().getSession().put("adminPwd", a.getAdminPwd());
            ActionContext.getContext().getSession().put("loginCount", a.getLoginCount());
            return SUCCESS;
        } else {

            this.addActionError("登录失败，用户名或密码错误");

            return INPUT;
        }
    }


    public void valideAdminLogin() {
        if (admin.getAdminUserName() == null || admin.getAdminUserName().trim().equals("")) {
            this.addFieldError("admin.adminUserName", "用户名不能为空");
        }
        if (admin.getAdminPwd() == null || admin.getAdminPwd().trim().equals("")) {
            this.addFieldError("admin.adminUserPwd", "密码不能为空");
        }
    }
}
