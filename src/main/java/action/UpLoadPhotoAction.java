package action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by Administrator on 2017/6/12.
 */
public class UploadPhotoAction extends ActionSupport {
    private static final long serialVersionUID = 5484181688105435744L;
    private String photo;

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }


    @Override
    public String execute() throws Exception {


        return SUCCESS;
    }
}
