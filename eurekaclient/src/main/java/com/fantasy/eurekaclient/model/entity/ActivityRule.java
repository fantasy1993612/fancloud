package com.fantasy.eurekaclient.model.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author: xiangming
 * @date: 2020/1/31 01:19
 * @description: 活动规则
 */
@Entity
@Data
public class ActivityRule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 活动id
     */
    @Column(nullable=false, length=256)
    private String activityId;
    /**
     * 规则标题
     */
    @Column(nullable=false, length=256)
    private String ruleTitle;
    /**
     * 规则内容
     */
    @Column(nullable=false,columnDefinition = "varchar(2047) default ''")
    private String ruleContent;
}
