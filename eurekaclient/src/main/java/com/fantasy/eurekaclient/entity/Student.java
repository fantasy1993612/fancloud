package com.fantasy.eurekaclient.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "student")
@Data
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增主键
    private Integer oid;

    @Column(name = "last_name", length = 50) //这是和数据表对应的一个列
    private String lastName;

    @Column
    private String email;


}
