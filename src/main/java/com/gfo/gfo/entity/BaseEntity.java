package com.gfo.gfo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类基类
 */
@Getter
@Setter
@ToString
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = -8375499603601079379L;
    private String createdUser;
    private Date createdTime;
    private String modifiedUser;
    private Date modifiedTime;

}