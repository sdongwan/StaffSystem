package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import service.AdminService;

/**
 * Created by Administrator on 2017/6/12.
 */
public class UpdateAdminAction extends ActionSupport {
    private static final long serialVersionUID = 6010374243679078573L;
    private Admin admin;
    @Autowired
    private AdminService adminService;

    public AdminService getAdminService() {
        return adminService;
    }

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @Override
    public String execute() throws Exception {
        if (admin == null) {
            admin = new Admin();

            admin.setAdminName((String) ActionContext.getContext().getSession().get("adminName"));
            admin.setAdminPwd((String) ActionContext.getContext().getSession().get("adminPwd"));
            admin.setAdminUserName((String) ActionContext.getContext().getSession().get("adminUserName"));

            return INPUT;

        } else {
            admin.setLoginCount((Integer) ActionContext.getContext().getSession().get("loginCount"));
            admin.setAdminId((Integer) ActionContext.getContext().getSession().get("adminId"));
            adminService.updateAdmin(admin);

            ActionContext.getContext().getSession().put("adminName", admin.getAdminName());
            ActionContext.getContext().getSession().put("loginCount", admin.getLoginCount());
            ActionContext.getContext().getSession().put("adminUserName", admin.getAdminUserName());
            ActionContext.getContext().getSession().put("adminPwd", admin.getAdminPwd());
            System.out.println(admin);
            return SUCCESS;
        }

    }
}
