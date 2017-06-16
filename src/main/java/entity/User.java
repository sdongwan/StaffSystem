package entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/6/9.
 */
public class User implements Serializable {
    private static final long serialVersionUID = -3363120264501521428L;
    private Integer userId;
    private String name;
    private String username;
    private String userPass;
    private String sex;
    private Date birthday;
    private Date entryDate;
    private String photo;
    private String remark;
    private Post post;

    public User() {

    }

    public User(String name, String username, String userPass, String sex, Date birthday, Date entryDate, String photo, String remark) {
        this.name = name;
        this.username = username;
        this.userPass = userPass;
        this.sex = sex;
        this.birthday = birthday;
        this.entryDate = entryDate;
        this.photo = photo;
        this.remark = remark;
    }

    public User(String name, String username, String userPass, String sex, Date birthday, Date entryDate, String photo, String remark, Post post) {
        this.name = name;
        this.username = username;
        this.userPass = userPass;
        this.sex = sex;
        this.birthday = birthday;
        this.entryDate = entryDate;
        this.photo = photo;
        this.remark = remark;
        this.post = post;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", userPass='" + userPass + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", entryDate=" + entryDate +
                ", photo='" + photo + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
