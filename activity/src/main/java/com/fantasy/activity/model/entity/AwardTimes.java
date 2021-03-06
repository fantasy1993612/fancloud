package com.fantasy.activity.model.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author: xiangming
 * @Date: 2020-02-01 - 17:23
 * @Describetion: 奖品领取情况
 */
@Entity
@Data
public class AwardTimes extends BaseEntity {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 任务id
     */
    private Integer taskId;
    /**
     * 活动id
     */
    @Column(nullable=false,columnDefinition = "int comment '活动ID'")
    private Integer activityId;
    /**
     * 已经领取次数
     */
    @Column(nullable = false)
    private Integer awardTimes;
    /**
     * 用户id
     */
    @Column(nullable = false)
    private Integer userId;
    /**
     * 身份证号
     */
    @Column(nullable = false)
    private String idNo;
    /**
     * 一等奖抽中次数
     */
    @Column(nullable = false)
    private Integer firstPrizeCount;
    /**
     * 抽中过奖
     */
    @Column(nullable = false)
    private Integer drawPrizeCount;
}
