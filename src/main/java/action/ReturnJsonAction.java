package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.Post;
import entity.User;
import org.apache.commons.collections.map.HashedMap;

import java.util.Map;

/**
 * Created by Administrator on 2017/7/22.
 */
public class ReturnJsonAction extends ActionSupport {
    private Map<String, Object> dataMap;

    public Map<String, Object> getDataMap() {
        return dataMap;
    }

    public void setDataMap(Map<String, Object> dataMap) {
        this.dataMap = dataMap;
    }

    public ReturnJsonAction() {
    }

    @Override
    public String execute() throws Exception {
        User user = new User();
        user.setName("sdongwan");
        user.setUsername("sdongwan");
        user.setUserPass("sdongwan");
        user.setSex("boy");
        user.setPost(new Post("java后台", 0, "", null));

        dataMap = new HashedMap();
        dataMap.put("user", user);
        dataMap.put("success", "true");

        return SUCCESS;
    }
}
