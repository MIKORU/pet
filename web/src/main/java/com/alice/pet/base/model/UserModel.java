package com.alice.pet.base.model;

import com.alice.pet.base.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表
 */
@Data
@NoArgsConstructor
public class UserModel implements Serializable {

    /**
     * 
     */
    private Long id;
    /**
     * 编号
     */
    private String userId;
    /**
     * 姓名
     */
    private String name;
    /**
     * 账号
     */
    private String account;
    /**
     * 密码
     */
    private String password;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 状态 0:禁用，1:正常
     */
    private Integer state;
    /**
     * 创建者
     */
    private String createBy;
    /**
     * 更新者
     */
    private String updateBy;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 删除标记 0:未删除，1:已删除
     */
    private Integer delFlag;

    public UserModel(User domain) {
        this.id = domain.getId();
        this.userId = domain.getUserId();
        this.name = domain.getName();
        this.account = domain.getAccount();
//        this.password = domain.getPassword();
        this.email = domain.getEmail();
        this.state = domain.getState();
        this.createBy = domain.getCreateBy();
        this.updateBy = domain.getUpdateBy();
        this.createTime = domain.getCreateTime();
        this.updateTime = domain.getUpdateTime();
        this.delFlag = domain.getDelFlag();
    }

    public static User convertDomain(UserModel model) {
        User domain = new User();
        domain.setId(model.getId());
        domain.setUserId(model.getUserId());
        domain.setName(model.getName());
        domain.setAccount(model.getAccount());
        domain.setPassword(model.getPassword());
        domain.setEmail(model.getEmail());
        domain.setState(model.getState());
        domain.setCreateBy(model.getCreateBy());
        domain.setUpdateBy(model.getUpdateBy());
        domain.setCreateTime(model.getCreateTime());
        domain.setUpdateTime(model.getUpdateTime());
        domain.setDelFlag(model.getDelFlag());
        return domain;
    }

}