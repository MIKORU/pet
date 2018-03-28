package com.alice.pet.base.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * 用户表
 */
@Data
@NoArgsConstructor
public class User implements Serializable {

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

    private Set<String> roleIds;

    private Set<String> roleCodes;

    private List<Role> roles;

    public User(String account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + this.id + "," +
                "\"userId\":" + this.userId + "," +
                "\"name\":" + this.name + "," +
                "\"account\":" + this.account + "," +
                "\"password\":" + this.password + "," +
                "\"email\":" + this.email + "," +
                "\"state\":" + this.state + "," +
                "\"createBy\":" + this.createBy + "," +
                "\"updateBy\":" + this.updateBy + "," +
                "\"createTime\":" + this.createTime + "," +
                "\"updateTime\":" + this.updateTime + "," +
                "\"delFlag\":" + this.delFlag + "," +
                "}";
    }

}