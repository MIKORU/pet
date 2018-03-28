package com.alice.pet.business.model.domain;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "pet_info")
public class Pet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String sex;

    private Integer weight;

    private Integer health;

    private String breed;

    private Date birthday;

}
