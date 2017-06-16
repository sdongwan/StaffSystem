package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import service.AdminService;

/**
 * Created by Administrator on 2017/6/12.
 */
public class RegistAdminAction extends ActionSupport {
    private static final long serialVersionUID = 3572595931599582664L;
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
            return INPUT;
        }

        if (!adminService.isRegistConflict(admin)) {
            admin.setLoginCount(0);
            adminService.registAdmin(admin);
            return SUCCESS;
        } else {
            addActionError("管理员名字或用户名重复");
            return INPUT;
        }

    }
}
