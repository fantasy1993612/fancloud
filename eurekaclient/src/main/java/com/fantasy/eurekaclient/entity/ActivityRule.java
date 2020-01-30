package com.fantasy.eurekaclient.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Auther: xiangming
 * @Date: 2020/1/31 01:19
 * @Description: 活动规则
 */
@Entity
@Data
public class ActivityRule {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String oid;

    //活动id
    private String activityId;
    //规则标题
    private String ruleTitle;
    //规则内容
    private String ruleContent;
}
