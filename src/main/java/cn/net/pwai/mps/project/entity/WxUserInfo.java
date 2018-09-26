package cn.net.pwai.mps.project.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author toby9
 * 2018/9/21
 */
@Entity
@Table
@DynamicInsert
@DynamicUpdate
public class WxUserInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    @NotNull
    private String id;
    @Column(nullable = false, columnDefinition = "datetime default NOW()")
    private Date addTime = new Date();
    @Column
    private Date birthday;
    @Column
    private String gender;
    @Column
    private String headImgUrl;
    @Column
    private String nickName;
    @Column
    private String openId;
    @Column
    private String phone;
    @Column(nullable = false, columnDefinition = "int default 0")
    private Integer delStatus = 0;

    public WxUserInfo() {
    }

    @Override
    public String toString() {
        return "WxUserInfo{" +
                "id='" + id + '\'' +
                ", birthday=" + birthday +
                ", gender='" + gender + '\'' +
                ", headImgUrl='" + headImgUrl + '\'' +
                ", nickName='" + nickName + '\'' +
                ", openId='" + openId + '\'' +
                ", phone='" + phone + '\'' +
                ", delStatus=" + delStatus +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getDelStatus() {
        return delStatus;
    }

    public void setDelStatus(Integer delStatus) {
        this.delStatus = delStatus;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}
