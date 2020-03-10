package com.fantasy.activity.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @Author: xiangming
 * @Date: 2020-02-01-16:53
 * @Describetion: 奖项表
 */
@Entity
@Data
public class AwardPrize extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 奖品限制id
     */
    @Column(nullable=false)
    private Integer awardTimePeriodLimitId;
    /**
     * 任务id
     */
    @Column(nullable=false)
    private Integer taskId;
    /**
     * 活动id
     */
    @Column(nullable=false)
    private Integer activityId;
    /**
     * 奖项序列
     */
    @Column(nullable = false)
    private Integer awardIndex;
    /**
     * 概率
     */
    @Column(nullable=false)
    private BigDecimal rate;
    /**
     * 奖项名称
     */
    @Column(nullable=false,length = 256)
    private String prizeName;
    /**
     * 奖品名称
     */
    @Column(nullable=false,length = 256)
    private String awardItemName;
    /**
     * 奖项价值
     */
    @Column(nullable=false)
    private BigDecimal awardItemPrice;
    /**
     * 奖品数量
     */
    @Column(nullable=false)
    private Integer num;
    /**
     * 奖品剩余数量
     */
    @Column(nullable=false)
    private Integer remainNum;

}
