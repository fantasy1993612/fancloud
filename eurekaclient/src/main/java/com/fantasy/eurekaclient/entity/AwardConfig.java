package com.fantasy.eurekaclient.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author: xiangming
 * @date: 2020/1/31 01:19
 * @description: 奖品配置实体类
 */
@Entity
@Data
public class AwardConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 奖品领取方式 0 领奖 1 抽奖
     */
    @Column(nullable=false,columnDefinition = "tinyint default 0")
    private Integer awardProvideWay;
    /**
     * 奖品领取限制：0 不限制 1 抽中1等奖则不能再得奖 1抽中过则不能
     */
    @Column(nullable=false,columnDefinition = "tinyint default 0")
    private Integer awardLevelLimit;
    /**
     * 领取开始时间
     */
    @Column(nullable=false)
    private LocalDateTime startTime;
    /**
     * 领取结束时间
     */
    @Column(nullable=false)
    private LocalDateTime endTime;

}
