package com.fantasy.eurekaclient.model.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author: xiangming
 * @Date: 2020-02-01 - 17:03
 * @Describetion: 奖品时间段内限制
 */
@Entity
@Data
public class AwardTimePeriodLimit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 奖项id
     */
    @Column(nullable=false)
    private Integer awardPrizeId;
    /**
     * 时刻 12,13
     */
    @Column(nullable=false, length=2)
    private Integer startHour;
    /**
     * 结束时刻
     */
    @Column(nullable=false, length=2)
    private Integer endHour;
    /**
     * 奖品数量
     */
    @Column(nullable=false, length=11)
    private Integer awardItemNum;
    /**
     * 剩余奖品数量
     */
    @Column(nullable=false, length=11)
    private Integer remainAwardItemNum;
}
