package com.mybatis3.domain;

import lombok.Data;

import java.util.Date;

/**
 * Created by 陈祥 on 2016/9/8.
 */
@Data
public class Student
{
    private Integer studId;
    private String name;
    private String email;
    private Date dob;
// setters and getters
}