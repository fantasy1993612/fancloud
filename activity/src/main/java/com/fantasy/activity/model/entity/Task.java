package com.fantasy.activity.model.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author: xiangming
 * @date: 2020/1/30 8:17 PM
 * @describtion: 任务类
 */
@Entity
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer activityId;

    @Column(nullable=false, length=256)
    private String taskName;

    @Column(nullable=false, length=256)
    private String taskDescribe;
}
