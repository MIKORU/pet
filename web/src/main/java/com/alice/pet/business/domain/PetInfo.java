package com.alice.pet.business.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class PetInfo {
    private Integer id;

    private String name;

    private Boolean sex;

    private Integer weight;

    private Integer health;

    private String breed;

    private Date birthday;

    private Integer ownerid;

    private Integer age;

    private Date createtime;

    private Date updatetime;

}