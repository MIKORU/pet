package com.alice.pet.business.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
public class PetVaccination {
    private Integer id;

    private String type;

    private Integer petid;

    private String status;

    private String remark;

    private Date createtime;

    private Date updatetime;
}