package com.fantasy.eurekaclient.entity;

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
     * 时刻 12,13
     */
    @Column(nullable=false, length=2)
    private Integer hour;
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
