package entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/6/9.
 */
public class Post implements Serializable {
    private static final long serialVersionUID = -7562888406588731432L;
    private Integer postId;
    private String postName;
    private Integer postNum;
    private String postRemark;
    private Set<User> users = new HashSet(0);

    public Post() {


    }

    public Post(String postName, Integer postNum, String postRemark, Set users) {
        this.postName = postName;
        this.postNum = postNum;
        this.postRemark = postRemark;
        this.users = users;
    }

    public Post(Integer postId, String postName, Integer postNum, String postRemark, Set users) {
        this.postId = postId;
        this.postName = postName;
        this.postNum = postNum;
        this.postRemark = postRemark;
        this.users = users;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public Integer getPostNum() {
        return postNum;
    }

    public void setPostNum(Integer postNum) {
        this.postNum = postNum;
    }

    public String getPostRemark() {
        return postRemark;
    }

    public void setPostRemark(String postRemark) {
        this.postRemark = postRemark;
    }

    public Set getUsers() {
        return users;
    }

    public void setUsers(Set users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", postName='" + postName + '\'' +
                ", postNum=" + postNum +
                ", postRemark='" + postRemark + '\'' +
                ", users=" + users +
                '}';
    }
}
