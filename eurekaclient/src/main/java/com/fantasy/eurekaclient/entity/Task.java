package com.fantasy.eurekaclient.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Auther: xiangming
 * @Date: 2020/1/31 01:15
 * @Description: 任务类型
 */
@Entity
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false, length=256)
    private String taskName;

    @Column(nullable=false, length=256)
    private String taskDescribe;
}
