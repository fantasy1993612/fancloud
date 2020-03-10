package com.fantasy.activity.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @Author: xiangming
 * @Date: 2020-02-01 - 17:03
 * @Describetion: 奖项下具体的礼品 一个奖项可有多个奖品
 */
@Data
public class Award extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 奖项ID
     */
    private Integer awardPrizeId;
    /**
     * 奖品id
     */
    @Column(nullable=false)
    private Integer awardItemId;
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
     * 奖品名称
     */
    @Column(nullable=false,length = 256)
    private String awardItemName;
    /**
     * 奖品价值
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
