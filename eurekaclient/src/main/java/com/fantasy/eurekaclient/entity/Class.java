package com.fantasy.eurekaclient.entity;

import lombok.Data;

import javax.persistence.*;


/**
 *
 */
//@Entity
@Table(name = "class")
@Data
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)//自增主键
    private Integer oid;

    @Column(nullable = false)
    private Integer studentId;

    @Column(length = 255) //这是和数据表对应的一个列
    private String className;

    @Column
    private String grade;


}
